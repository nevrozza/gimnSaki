import SwiftUI
import SharedSDK



struct ContentView: View {
    @Environment(\.colorScheme) var currentSystemScheme
    
    
    @EnvironmentObject var themeManager: ThemeManager
    var body: some View {
        
        Color.clear.onAppear {
            if(currentSystemScheme == .dark) {themeManager.system = .light} else { themeManager.system = .dark}
        }
        .onChange(of: currentSystemScheme) { _ in
            themeManager.system = currentSystemScheme
            themeManager.current.colorScheme = schemeChoser(isDark: themeManager.system == .light, color: nil)
            
        }
        
        let colors = themeManager.current.colorScheme
        StartFlow()

            .environmentObject(themeManager)
        
    }
}

//struct ContentView_Previews: PreviewProvider {
//	static var previews: some View {
//        ContentView()
//	}
//}
