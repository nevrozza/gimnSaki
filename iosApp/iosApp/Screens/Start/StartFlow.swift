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
        

            if(currentScreen.value == NavigationTree.Start.helloscreen.name) {
                
                    
                    HelloScreen()
                        .frame(maxWidth: .infinity, maxHeight: .infinity)
                        .environmentObject(themeManager)
                        .environmentObject(currentScreen)
                        .transition(.move(edge: .top))
            } else {
                
                NavigationView {
                    ZStack {
                        themeManager.currentTheme.colorScheme.background.edgesIgnoringSafeArea(.all)
                        
                        ThemeChangerScreen(isStart: true, colorStr: themeManager.currentTheme.colorScheme.colorStr, tint: themeManager.tint)
                            .environmentObject(themeManager)
                    }
                    .navigationBarHidden(true)
                    .navigationTitle("Тема")
                    .navigationBarTitleDisplayMode(.inline)
                }
                .accentColor(themeManager.currentTheme.colorScheme.primary)
                .navigationViewStyle(.stack)
                
                

            }

    }
}



