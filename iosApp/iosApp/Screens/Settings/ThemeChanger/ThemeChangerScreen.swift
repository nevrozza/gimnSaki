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
    @State private var progress: Double = 0.0
    var body: some View {
        
        
        ObservingView(
            statePublisher: statePublisher(themeChangerViewModel.viewStates())
        ) { viewState in
                ThemeChangerView(state: viewState, isStart: isStart) { event in
                    themeChangerViewModel.obtainEvent(viewEvent: event)
                }
                .environmentObject(themeManager)
        }
        
        NavigationLink(
            destination:
                ZStack (alignment: .top) {
                    
                    themeManager.currentTheme.colorScheme.background.edgesIgnoringSafeArea(.all)
                    Text("hello")
                        .navigationTitle("Описание")
//                        .navigationBackButton(color: themeManager.currentTheme.colorScheme.primary)
                },
            isActive: $isStartDescriptionPresented) {
                
            }
        
        .onReceive(sharePublisher(themeChangerViewModel.viewActions())) { action in
            switch action {
            case ThemeChangerAction.OpenStartDescription():
                isStartDescriptionPresented = true
                themeChangerViewModel.viewAction = nil
            case ThemeChangerAction.UpdateColor():
                if let window = UIApplication.shared.keyWindow {
                    UIView.transition (with: window, duration: 0.5, options: .transitionCrossDissolve, animations: {
                        themeManager.color = themeChangerViewModel.viewState.color
                    }, completion: nil)
                }
                themeChangerViewModel.viewAction = nil
            case ThemeChangerAction.UpdateTint():
                themeManager.tint = themeChangerViewModel.viewState.tint
                themeChangerViewModel.viewAction = nil
            default:
                break
            }
        }
        
        
    }
    
}

