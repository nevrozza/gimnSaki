//
//  Theme.swift
//  iosApp
//
//  Created by nevrozq on 02.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SharedSDK
import SwiftUI

class ThemeManager: ObservableObject {
    @Published var orientation: CustomDeviceOrientation = .Vertical
    
    @Published var current: Theme = .redLight
}


class Theme: ObservableObject {
    let colorScheme: ColorScheme
    
    init(colorScheme: ColorScheme) {
        self.colorScheme = colorScheme
    }
}

extension Theme {
    static let defaultLight = Theme(colorScheme: defaultLightPallete)
    static let defaultDark  = Theme(colorScheme: defaultDarkPallete)
    static let greenLight = Theme(colorScheme: greenLightPallete)
    static let greenDark  = Theme(colorScheme: greenDarkPallete)
    static let redLight = Theme(colorScheme: redLightPallete)
    static let redDark  = Theme(colorScheme: redDarkPallete)
    static let yellowLight = Theme(colorScheme: yellowLightPallete)
    static let yellowDark  = Theme(colorScheme: yellowDarkPallete)
}

func themeInit(settingsRepository: SettingsRepositorySwift) {
    if(settingsRepository.fetchThemeTint().isEmpty
            && settingsRepository.fetchThemeColor().isEmpty) {
        settingsRepository.saveThemeColor(color: ThemeColors.default_.name)
        settingsRepository.saveThemeTint(tint: ThemeTint.auto_.name)
        }
}

