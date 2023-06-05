//
//  ElevatedCard.swift
//  iosApp
//
//  Created by nevrozq on 05.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct ElevatedCard: View {
    let colors: ColorScheme
    @ViewBuilder let content: () -> AnyView
    
    
    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 10)
                .fill(colors.surface)
                .shadow(color: colors.scrim , radius: 2, x: 0, y: 1)
            
            content()
        }
    }
}


