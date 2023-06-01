import SwiftUI
import SharedSDK



struct ContentView: View {
    
	var body: some View {
        Text("sad")
        RoundedRectangle(cornerRadius: 10).foregroundColor(SwiftUI.Color(SwiftUI.Color.textPrimary))
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
	}
}
