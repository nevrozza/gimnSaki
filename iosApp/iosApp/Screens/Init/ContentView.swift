import SwiftUI
import SharedSDK



struct ContentView: View {
    @Environment(\.colorScheme) var systemTint
    @EnvironmentObject var themeManager: ThemeManager
    
    var body: some View {
        StartFlow()
            .onAppear {
                if(systemTint == .dark) {themeManager.systemTint = .light} else { themeManager.systemTint = .dark}
            }
            .onChange(of: systemTint) { _ in
                    print(systemTint)
                    themeManager.systemTint = systemTint
                    themeManager.currentTheme.colorScheme = schemeChoser(isDark: themeManager.systemTint == .light, color: nil)
                
            }
            
            .background(themeManager.currentTheme.colorScheme.background)
            .background(ignoresSafeAreaEdges: [.top, .bottom, .leading, .trailing])
            .environmentObject(themeManager)
    }
}

//struct ContentView_Previews: PreviewProvider {
//	static var previews: some View {
//        ContentView()
//	}
//}
