//
//  Color + Custom.swift
//  iosApp
//
//  Created by nevrozq on 01.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SharedSDK
import SwiftUI


extension SwiftUI.Color {
    

    static let textPrimary = DMRColors().redDarkPrimary.getUIColor()
    
    init(hex: UInt, alpha: Double = 1) {
        self.init(
            .sRGB,
            red: Double((hex >> 16) & 0xff) / 255,
            green: Double((hex >> 08) & 0xff) / 255,
            blue: Double((hex >> 00) & 0xff) / 255,
            opacity: alpha)
        
    }
}
