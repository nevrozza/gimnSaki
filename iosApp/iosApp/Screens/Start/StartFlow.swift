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
    @Published var value: String = NavigationTree.Start.startscreen.name
}

struct StartFlow: View {
    @StateObject var currentScreen: CurrentScreen = CurrentScreen()

    @EnvironmentObject var themeManager: ThemeManager

    var body: some View {
        let colors = themeManager.current.colorScheme

            if(currentScreen.value == NavigationTree.Start.startscreen.name) {
                    StartScreen()
                        .frame(maxWidth: .infinity, maxHeight: .infinity)
                        .background(colors.background)
                        .background(ignoresSafeAreaEdges: [.top, .bottom, .leading, .trailing])
                        .environmentObject(themeManager)
                        .environmentObject(currentScreen)
                        .transition(.move(edge: .top))
            } else {
                Text("asdaasda")
                    .frame(maxWidth: .infinity, maxHeight: .infinity)
                    .background(colors.background)
                    .background(ignoresSafeAreaEdges: [.top, .bottom, .leading, .trailing])
                    .transition(.move(edge: .bottom))
                    .onAppear {
                        withAnimation{}
                    }

            }

    }
}



