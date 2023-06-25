//
//  Theme.swift
//  iosApp
//
//  Created by nevrozq on 02.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SharedSDK
import SwiftUI

class ThemeManager: ObservableObject {
    @Published var orientation: WindowScreen = calculateFromScreen(size: UIScreen.main.bounds.size)
    @Published var size: CGSize = UIScreen.main.bounds.size
    @Published var systemTint: SwiftUI.ColorScheme = .dark
    @Published var colorScheme: ColorScheme = greenLightPallete
    @Published var tint: String = ThemeTint.auto_.name
    @Published var color: String = ThemeColors.default_.name
//    @Published var currentScreen: String = NavigationTree.Start.helloscreen.name
}

class Theme: ObservableObject {
    var colorScheme: ColorScheme
    
    init(colorScheme: ColorScheme) {
        self.colorScheme = colorScheme
    }
}

func themeInit(settingsRepository: SettingsRepository) {
    let tint = settingsRepository.fetchThemeTint()
    let color = settingsRepository.fetchThemeColor()
    
    if(tint.isEmpty && color.isEmpty) {
        settingsRepository.saveThemeColor(color: ThemeColors.default_.name)
        settingsRepository.saveThemeTint(tint: ThemeTint.auto_.name)
    }
}



func schemeChoser(isDark: Bool, color: String?) -> ColorScheme {
    if (isDark) {
        switch (color) {
        case ThemeColors.yellow.name:
            return yellowDarkPallete
        case ThemeColors.green.name:
            return greenDarkPallete
        case ThemeColors.red.name:
            return redDarkPallete
        default:
            return defaultDarkPallete
        }
    } else {
        switch (color) {
        case ThemeColors.yellow.name:
            return yellowLightPallete
        case ThemeColors.green.name:
            return greenLightPallete
        case ThemeColors.red.name:
            return redLightPallete
        default:
            return defaultLightPallete
        }
    }
}

