//
//  StartView.swift
//  iosApp
//
//  Created by nevrozq on 03.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct HelloView: View {
    @EnvironmentObject var themeManager: ThemeManager
   
    
    let state: HelloViewState
    let eventHandler: (HelloEvent) -> Void
    
    var body: some View {
        Text(themeManager.orientation.description)
//        Text(state.text).background(themeManager.currentTheme.colorScheme.background)
    }
}

//struct StartView_Previews: PreviewProvider {
//    static var previews: some View {
//        StartView()
//    }
//}
