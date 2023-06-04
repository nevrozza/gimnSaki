//
//  ThemeChangerScreen.swift
//  iosApp
//
//  Created by nevrozq on 04.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct ThemeChangerScreen: View {
    
    let isStart: Bool
    let colorStr: String
    let tint: String
    @EnvironmentObject var themeManager: ThemeManager
    @State private var isStartDescriptionPresented = false
    @State var themeChangerViewModel: ThemeChangerViewModel
    init(isStart: Bool, colorStr: String, tint: String) {
        self.isStart = isStart
        self.colorStr = colorStr
        self.tint = tint
        self.themeChangerViewModel = ThemeChangerViewModel(color: colorStr, tint: tint)
    }
    var body: some View {
        
        ObservingView(
            statePublisher: statePublisher(themeChangerViewModel.viewStates())
        ) { viewState in
            ThemeChangerView(state: viewState) { event in
                themeChangerViewModel.obtainEvent(viewEvent: event)
            }.environmentObject(themeManager)
                
        }
        
        .onReceive(sharePublisher(themeChangerViewModel.viewActions())) { action in
            switch action {
            case ThemeChangerAction.OpenStartDescription():
                isStartDescriptionPresented = true
            case ThemeChangerAction.UpdateColor():
                break
            case ThemeChangerAction.UpdateTint():
                break
            default:
                break
            }
        }
    }
    
}

