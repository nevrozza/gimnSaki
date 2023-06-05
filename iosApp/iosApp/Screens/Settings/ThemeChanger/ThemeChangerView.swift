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
                .environmentObject(themeManager)
        }
        
    }
}

private struct ThemePreview: View {
    @EnvironmentObject var themeManager: ThemeManager
    
    let colors: ColorScheme
    
    var body: some View {
        ElevatedCard(colors: colors) {
            AnyView(
                Text("Hello")
            )
        }.padding()
    }
}
