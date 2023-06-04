import SwiftUI
import SharedSDK

@main
struct iOSApp: App {
    
    init() {
        PlatformSDK().doInit(configuration: PlatformConfiguration())

    }
    
    @StateObject var themeManager: ThemeManager = ThemeManager()

    
	var body: some Scene {
        
       
            WindowGroup {
            
                ZStack {
                    GeometryReader { proxy in
                        Color.clear // we just want the reader to get triggered, so let's use an empty color
                        
                            .onAppear {
                            
                                setupThemeManager()
                            }
                            
                                        
                            
                            .onReceive(NotificationCenter.default.publisher(for: UIDevice.orientationDidChangeNotification)) { _ in
                                DispatchQueue.main.async {
                                                let size = proxy.size
                                                themeManager.orientation = calculateFromScreen(size: size)
                                            }
                            }
                            
                    }
                    ContentView()
                        .environmentObject(themeManager)


                }

            }
            
        }
    

    private func setupThemeManager() {
        let settingsRepository = FuckSwift().settingsRepository()
        themeInit(settingsRepository: settingsRepository)
        let tint = settingsRepository.fetchThemeTint()
        let color = settingsRepository.fetchThemeColor()
        let isSystemInDarkTheme = themeManager.system == .light
        let isDark = (tint == ThemeTint.auto_.name) ? (isSystemInDarkTheme) : (tint == ThemeTint.dark.name)
        let colorScheme = schemeChoser(isDark: isDark, color: color)
        themeManager.current = Theme(colorScheme: colorScheme)
    }
	
}

