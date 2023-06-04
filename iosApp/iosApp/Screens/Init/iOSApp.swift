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
                                themeManager.orientation = calculateFromScreen(size: proxy.size)
                                setupThemeManager()
                            }
                            
                                        
                            
                            .onReceive(NotificationCenter.default.publisher(for: UIDevice.orientationDidChangeNotification)) { _ in
                                DispatchQueue.main.async {
                                                themeManager.orientation = calculateFromScreen(size: proxy.size)
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
        themeManager.tint = tint
        let color = settingsRepository.fetchThemeColor()
        let isSystemInDarkTheme = themeManager.systemTint == .light
        let isDark = (tint == ThemeTint.auto_.name) ? (isSystemInDarkTheme) : (tint == ThemeTint.dark.name)
        let colorScheme = schemeChoser(isDark: isDark, color: color)
        themeManager.currentTheme = Theme(colorScheme: colorScheme)
    }
	
}

