//
//  StartScreen.swift
//  iosApp
//
//  Created by nevrozq on 03.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK



struct HelloScreen: View {
    @EnvironmentObject var themeManager: ThemeManager
    @EnvironmentObject var currentScreen: CurrentScreen
    @State private var helloViewModel = HelloViewModel()
    

    
   
    var body: some View {
        
        ObservingView(
            statePublisher: statePublisher(helloViewModel.viewStates())
        ) { viewState in
            HelloView(state: viewState) { event in
                helloViewModel.obtainEvent(viewEvent: event)
            }.environmentObject(themeManager)
                
        }
        .onReceive(sharePublisher(helloViewModel.viewActions())) { action in
            switch action {
            case HelloAction.OpenStartColor():
    
                withAnimation {
                    currentScreen.value = NavigationTree.Start.startcolorscreen.name
                }
            default:
                break
            }
        }

        
        
    }
}

//struct StartScreen_Previews: PreviewProvider {
//    static var previews: some View {
//        StartScreen()
//    }
//}
