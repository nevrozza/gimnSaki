import SwiftUI
import SharedSDK



struct ContentView: View {

    @EnvironmentObject var themeManager: ThemeManager
	var body: some View {
        let theme = themeManager.current.colorScheme
        let orientation = themeManager.orientation
        
            
            RoundedRectangle(cornerRadius: 10).foregroundColor(theme.primary)
            Text(orientation.description)
        
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
	}
}
