//
//  StartView.swift
//  iosApp
//
//  Created by nevrozq on 03.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct StartView: View {
    @EnvironmentObject var themeManager: ThemeManager
   
    
    let state: StartViewState
    let eventHandler: (StartEvent) -> Void
    
    var body: some View {
        Text(state.text).background(themeManager.current.colorScheme.background)
    }
}

//struct StartView_Previews: PreviewProvider {
//    static var previews: some View {
//        StartView()
//    }
//}
