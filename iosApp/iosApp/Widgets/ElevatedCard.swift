//
//  ElevatedCard.swift
//  iosApp
//
//  Created by nevrozq on 05.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct ElevatedCard<Accessory: View>: View {
    let colors: ColorScheme
   
    let content: () -> Accessory
    var body: some View {
        ZStack {
            colors.surface
            
                
                
            content()
                
        }
        .cornerRadius(12)
        .shadow(color: colors.scrim , radius: 2, x: 0, y: 1)
        
        
    }
}


