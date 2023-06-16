//
//  Custom Back Button.swift
//  iosApp
//
//  Created by nevrozq on 16.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct NavigationBackButton: ViewModifier {

    @Environment(\.presentationMode) var presentationMode
    var color: Color
    var text: String?
    
    func body(content: Content) -> some View {
        return content
            .navigationBarBackButtonHidden(true)
            .navigationBarItems(
                leading: Button(action: {  presentationMode.wrappedValue.dismiss() }, label: {
                    HStack(spacing: 4) {
                        Image(systemName: "chevron.backward")
                            .foregroundColor(color)
                            .font(.system(size: 17, weight: .semibold))
                        if let text = text {
                            Text(text)
                                .foregroundColor(color)
                            
                        }
                    }
                })
            )
    }
}

extension View {
    func navigationBackButton(color: Color, text: String? = nil) -> some View {
        modifier(NavigationBackButton(color: color, text: text))
    }
}
