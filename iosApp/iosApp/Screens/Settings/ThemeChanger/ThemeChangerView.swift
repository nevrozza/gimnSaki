//
//  ThemeChangerView.swift
//  iosApp
//
//  Created by nevrozq on 04.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

class CircleAnimation: ObservableObject {
    @Published var value: CGFloat = 1
    @Published var isFinished: Bool = true
    
}

struct ThemeChangerView: View {
    @EnvironmentObject var themeManager: ThemeManager
    @StateObject var circleAnimation = CircleAnimation()
    @AppStorage("isAnimating") private var isAnimating: Bool = false
    
    let state: ThemeChangerViewState
    let isStart: Bool
    let eventHandler: (ThemeChangerEvent) -> Void
    
    
    var body: some View {
        let colors = themeManager.currentTheme.colorScheme
        let screenSize = themeManager.size
        let divider: CGFloat = 3 * (50 * 50)
        let maxSize = (screenSize.width * screenSize.height) / divider
        
        ZStack (alignment: .top) {
            switch themeManager.orientation {
            case WindowScreen.Vertical():
                VerticalView(state: state, colors: colors, isStart: isStart) { event in
                    eventHandler(event)
                }
                .environmentObject(themeManager)
                .environmentObject(circleAnimation)
            default:
                Text("null")
            }
        }
        .onChange(of: state.isColorChanging) { newState in
            isAnimating = true
            circleAnimation.isFinished = false
            withAnimation(.linear(duration: 0.5)) {
                circleAnimation.value =
                (newState) ? maxSize : 1
                
            }
            
                DispatchQueue.main.asyncAfter(deadline: .now() + 0.5) {
                    eventHandler(.ColorChanged())
                    
                }
        }
        .onAppear {
            if(isAnimating) {
                circleAnimation.value = maxSize
                
                withAnimation(.linear(duration: 0.5)) {
                    
                    circleAnimation.value = 1
                    
                }
                
                DispatchQueue.main.asyncAfter(deadline: .now() + 0.5) {
                    circleAnimation.isFinished = true
                    isAnimating = false
                }
            }
        }
        
        
    }
    
}

private struct VerticalView: View {
    @EnvironmentObject var themeManager: ThemeManager
    @EnvironmentObject var circleAnimation: CircleAnimation
    
    let state: ThemeChangerViewState
    let colors: ColorScheme
    let isStart: Bool
    let eventHandler: (ThemeChangerEvent) -> Void
    
    var body: some View {
        
        VStack {
            if(isStart) {
                Text(MRStrings.chooseTheme.desc().localized())
                    .font(.system(size: 24))
                    .padding(.top, themeManager.size.height * 0.01)
                Text(MRStrings.chooseThemeUnder.desc().localized())
                    .padding(.bottom, themeManager.size.height * 0.03)
            }
            
            ThemePreview(colors: colors)
                .frame( width: themeManager.size.width * 0.77, height: themeManager.size.height * 0.5)
            ColorPickerTab(colors: colors, segmentationSelection: themeManager.tint, state: state) { event in
                eventHandler(event)
            }
            .environmentObject(themeManager)
            .environmentObject(circleAnimation)
            
            Spacer()
                .frame(height: 20)
            
            Button(action: {eventHandler(.NextPressed())}) {
                Text("Готово!")
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(colors.secondaryContainer)
                    .foregroundColor(colors.onSecondaryContainer)
                    .cornerRadius(12)
            }
            .frame(width: 150)
            
            
            
        }
        
    }
}

private struct ColorPickerTab: View {
    
    @EnvironmentObject var themeManager: ThemeManager
    @EnvironmentObject var circleAnimation: CircleAnimation
    let colors: ColorScheme
    @State var segmentationSelection: String
    let state: ThemeChangerViewState
    let eventHandler: (ThemeChangerEvent) -> Void
    
    
    
    //PICKER VARS
    let items = [
        ThemeTint.dark.name,
        ThemeTint.light.name,
        ThemeTint.auto_.name
    ]
    let names = [
        MRStrings.darkTheme.desc().localized(),
        MRStrings.lightTheme.desc().localized(),
        MRStrings.autoTheme.desc().localized()
    ]
    
    let colorsBut = [
        ThemeColors.default_.name,
        ThemeColors.green.name,
        ThemeColors.red.name,
        ThemeColors.yellow.name
    ]
    
    var body: some View {
        
        Spacer()
            .frame(height: 40)
        ZStack (alignment: .top) {
            VStack {
                Spacer()
                Picker("", selection: $segmentationSelection) {
                    ForEach(items, id: \.self) { item in
                        Text(names[items.firstIndex(of: item) ?? 2])
                    }
                }
                .pickerStyle(.segmented)
                .onAppear {
                    let appearance = UISegmentedControl.appearance()
                    appearance.selectedSegmentTintColor = UIColor(colors.secondaryContainer)
                    appearance.setTitleTextAttributes([.foregroundColor : UIColor(colors.primary)], for: .selected)
                }
                .onChange(of: segmentationSelection) { newValue in
                    eventHandler(.TintChangeOn(tint: newValue))
                }
                .frame(width: 300)
            }
            VStack {
                HStack {
                    ForEach(colorsBut, id: \.self) { colorBut in
                        ColorPickButton(colors: colors, state: state, color: colorBut) { event in
                            eventHandler(event)
                        }
                        .environmentObject(circleAnimation)
                    }
                }
                Spacer()
            }
            
        }
        .frame(width: 300, height: 115)
        
        
        
       
        
    }
    
}

private struct ColorPickButton: View {
    @Environment(\.colorScheme) var systemTint
    @EnvironmentObject var circleAnimation: CircleAnimation
    let buttonSize: CGFloat = 50
    let colors: ColorScheme
    let state: ThemeChangerViewState
    let color: String
    @State var opacity: Double = 1
    @AppStorage("isAnimating") private var isAnimating: Bool = false
    
    let eventHandler: (ThemeChangerEvent) -> Void
    var body: some View {
        let colorScheme = schemeChoser(isDark: systemTint == .light, color: color)
        ZStack {
            let cardBackgroundColor = (state.color == color) ? colors.secondaryContainer : colors.surface
            ElevatedCard(colors: colors) {
                cardBackgroundColor
            }
            .frame(width: buttonSize + 10, height: buttonSize + 10)
            .onChange(of: circleAnimation.isFinished) { isFinished in
                if(!isFinished && state.color != color) {
                    withAnimation (.easeOut(duration: 0.2)) {
                        opacity = 0
                    }
                }
            }
            .onAppear {
                if(isAnimating && state.color != color) {
                    opacity = 0
                    withAnimation(.easeIn(duration: 1)) {
                        opacity = 1
                    }
                }
            }
            Button(action: {
                eventHandler(.ColorChangeOn(color: color))
            }) {
                Circle()
                    .frame(width: buttonSize, height: buttonSize)
                    .foregroundColor(colorScheme.primary)
                    .scaleEffect(x: (state.color == color) ? circleAnimation.value: 1, y: (state.color == color) ? circleAnimation.value: 1)
            }
        }
        .opacity(opacity)
    }
}

private struct ThemePreview: View {
    let colors: ColorScheme
    var body: some View {
        
        ElevatedCard(colors: colors) {
            GeometryReader { g in
                HStack (alignment: .top) {
                    VStack (alignment: .leading) {
                        HStack (alignment: .top) {
                            RoundedRectangle(cornerRadius: 12)
                                .frame(width: (g.size.width * 0.2), height: (g.size.height * 0.088))
                                .foregroundColor(colors.secondary)
                            Spacer()
                            RoundedRectangle(cornerRadius: 12)
                                .frame(width: g.size.width * 0.8 * 0.67 * 0.8, height: g.size.height * 0.088)
                                .foregroundColor(colors.secondaryContainer)
                        }
                        
                        
                        HStack (alignment: .top) {
                            VStack (alignment: .leading) {
                                Spacer()
                                RoundedRectangle(cornerRadius: 12)
                                    .frame(width: g.size.width * 0.13, height: g.size.height * 0.5 * 0.912)
                                    .foregroundColor(colors.secondary)
                                RoundedRectangle(cornerRadius: 12)
                                    .frame(width: g.size.width * 0.13, height: g.size.height * 0.6 * 0.5 * 0.912)
                                    .foregroundColor(colors.primaryContainer)
                            }
                            
                            VStack (alignment: .leading) {
                                HStack (alignment: .top) {
                                    RoundedRectangle(cornerRadius: 12)
                                        .frame(width: g.size.width * 0.5 * 0.87, height: g.size.height * 0.33 * 0.912)
                                        .foregroundColor(colors.primary)
                                    VStack (alignment: .leading) {
                                        
                                        RoundedRectangle(cornerRadius: 12)
                                            .frame(height: g.size.height * 0.19 * 0.912)
                                            .foregroundColor(colors.primaryContainer)
                                        RoundedRectangle(cornerRadius: 12)
                                            .frame(height: g.size.height * 0.13 * 0.912 * 0.87)
                                            .foregroundColor(colors.secondaryContainer)
                                    }
                                }.padding(.top, 3)
                                
                                HStack (alignment: .top) {
                                    RoundedRectangle(cornerRadius: 12)
                                        .frame(width: g.size.width * 0.24 * 0.87 , height: g.size.height * 0.45 * 0.67 * 0.912)
                                        .foregroundColor(colors.primaryContainer)
                                    VStack (alignment: .leading) {
                                        RoundedRectangle(cornerRadius: 12)
                                            .frame(width: g.size.width * 0.24 * 0.87 , height: g.size.height * 0.225 * 0.67 * 0.912)
                                            .foregroundColor(colors.secondaryContainer)
                                        RoundedRectangle(cornerRadius: 12)
                                            .frame(width: g.size.width * 0.24 * 0.87 , height: (g.size.height * 0.225 * 0.67 * 0.912)-10)
                                            .foregroundColor(colors.primary)
                                    }
                                    RoundedRectangle(cornerRadius: 12)
                                        .frame(height: g.size.height * 0.34 * 0.67 * 0.912)
                                        .foregroundColor(colors.primary)
                                }
                                
                                
                                HStack (alignment: .top) {
                                    VStack (alignment: .leading) {
                                        RoundedRectangle(cornerRadius: 10)
                                            .frame(width: g.size.width * 0.5 * 0.87, height: g.size.height * 0.3 * 0.55 * 0.67 * 0.912)
                                            .foregroundColor(colors.secondaryContainer)
                                        RoundedRectangle(cornerRadius: 10)
                                            .frame(width: g.size.width * 0.5 * 0.87)
                                            .foregroundColor(colors.primary)
                                    }
                                    VStack (alignment: .leading) {
                                        RoundedRectangle(cornerRadius: 10)
                                            .frame(height: g.size.height * 0.66 * 0.55 * 0.67 * 0.912)
                                            .foregroundColor(colors.primaryContainer)
                                        RoundedRectangle(cornerRadius: 10)
                                            .foregroundColor(colors.secondaryContainer)
                                    }
                                }
                            }
                        }
                    }
                    
                    VStack (alignment: .leading) {
                        RoundedRectangle(cornerRadius: 10)
                            .frame(width: g.size.width * 0.8 * 0.16 * 0.67 * 0.8, height: g.size.height * 0.45)
                            .foregroundColor(colors.primary)
                        Spacer().frame(width: g.size.width * 0.8 * 0.16 * 0.67 * 0.8, height: g.size.height * 0.2)
                        RoundedRectangle(cornerRadius: 10)
                            .frame(width: g.size.width * 0.8 * 0.16 * 0.67 * 0.8)
                            .foregroundColor(colors.secondary)
                    }
                    
                    
                }
                
                
                
            }
            
        }
        
    }
}
