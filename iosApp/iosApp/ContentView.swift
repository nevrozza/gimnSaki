import SwiftUI
import SharedSDK



struct ContentView: View {
    @Environment(\.colorScheme) var currentSystemScheme
        
    
    @EnvironmentObject var themeManager: ThemeManager
    @EnvironmentObject var isSystemDark: IsSystemDark
    var body: some View {
        let theme = themeManager.current.colorScheme
        let orientation = themeManager.orientation
        
        
        RoundedRectangle(cornerRadius: 10).foregroundColor(theme.primary)
            .onAppear {
                if(currentSystemScheme == .dark) {
                    isSystemDark.colorScheme = .light
                } else {
                    isSystemDark.colorScheme = .dark
                }
            
            }
            .onChange(of: currentSystemScheme) { _ in
            isSystemDark.colorScheme = currentSystemScheme
        }
            
        
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
	}
}
