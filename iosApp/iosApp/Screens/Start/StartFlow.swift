//
//  StartFlow.swift
//  iosApp
//
//  Created by nevrozq on 04.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

class CurrentScreen: ObservableObject {
    @Published var value: String = NavigationTree.Start.helloscreen.name
}

struct StartFlow: View {
    @StateObject var currentScreen: CurrentScreen = CurrentScreen()

    @EnvironmentObject var themeManager: ThemeManager

    var body: some View {
        let colors = themeManager.currentTheme.colorScheme

            if(currentScreen.value == NavigationTree.Start.helloscreen.name) {
                    HelloScreen()
                
                        .frame(maxWidth: .infinity, maxHeight: .infinity)
                
                        .environmentObject(themeManager)
                        .environmentObject(currentScreen)
                        .transition(.move(edge: .top))
            } else {
                VStack {
                    ThemeChangerScreen(isStart: true, colorStr: themeManager.currentTheme.colorScheme.colorStr, tint: themeManager.tint)
                        .environmentObject(themeManager)
                        .frame(maxWidth: .infinity, maxHeight: .infinity)
                        
                        
                }
                .frame(maxWidth: .infinity, maxHeight: .infinity)
                .transition(.move(edge: .bottom))
                    .onAppear {
                        withAnimation{}
                    }

            }

    }
}



