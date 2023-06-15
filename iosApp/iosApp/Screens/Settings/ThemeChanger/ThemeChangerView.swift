//
//  ThemeChangerView.swift
//  iosApp
//
//  Created by nevrozq on 04.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct ThemeChangerView: View {
    @EnvironmentObject var themeManager: ThemeManager
    
    
    let state: ThemeChangerViewState
    let isStart: Bool
    let eventHandler: (ThemeChangerEvent) -> Void
    
    var body: some View {
        let colors = themeManager.currentTheme.colorScheme
        switch themeManager.orientation {
        case WindowScreen.Vertical():
            VerticalView(state: state, colors: colors, isStart: isStart) { event in
                eventHandler(event)
            }
            .environmentObject(themeManager)
            .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top).border(Color.red)
        default:
            Text("null")
        }
        
        
    }
    
}

private struct VerticalView: View {
    @EnvironmentObject var themeManager: ThemeManager
    
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
            ColorPickerTab(colors: colors, segmentationSelection: themeManager.tint) { event in
                eventHandler(event)
            }
                .environmentObject(themeManager)
            
            
        }
        
    }
}

private struct ColorPickerTab: View {
    
    @EnvironmentObject var themeManager: ThemeManager
    let colors: ColorScheme
    @State var segmentationSelection: String
    let eventHandler: (ThemeChangerEvent) -> Void
    var items = [
        ThemeTint.dark.name,
        ThemeTint.light.name,
        ThemeTint.auto_.name
    ]
    var names = [
        MRStrings.darkTheme.desc().localized(),
        MRStrings.lightTheme.desc().localized(),
        MRStrings.autoTheme.desc().localized()
    ]
    

    
    
    var body: some View {
        
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
