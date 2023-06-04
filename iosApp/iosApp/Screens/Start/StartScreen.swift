//
//  StartScreen.swift
//  iosApp
//
//  Created by nevrozq on 03.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK



struct StartScreen: View {
    @EnvironmentObject var themeManager: ThemeManager
    @EnvironmentObject var currentScreen: CurrentScreen
    @State private  var startViewModel = StartViewModel()
    

    
   
    var body: some View {
        
        ObservingView(
            statePublisher: statePublisher(startViewModel.viewStates())
        ) { viewState in
            StartView(state: viewState) { event in
                startViewModel.obtainEvent(viewEvent: event)
            }.environmentObject(themeManager)
                
        }
        .onReceive(sharePublisher(startViewModel.viewActions())) { action in
            switch action {
            case StartAction.OpenStartColor():
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
