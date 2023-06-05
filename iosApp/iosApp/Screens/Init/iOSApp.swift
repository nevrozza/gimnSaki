import SwiftUI
import SharedSDK

@main
struct iOSApp: App {
    init() { PlatformSDK().doInit(configuration: PlatformConfiguration()) }
    
    @StateObject var themeManager: ThemeManager = ThemeManager()

    
	var body: some Scene {
        WindowGroup {
            ContentView()
                .onAppear {
                    setupThemeManager()
                }
                .onReceive(NotificationCenter.default.publisher(for: UIDevice.orientationDidChangeNotification)) { _ in
                    DispatchQueue.main.async {
                        themeManager.orientation = calculateFromScreen(size: UIScreen.main.bounds.size)
                    }
                }
                .environmentObject(themeManager)
            }
        }
    
    private func setupThemeManager() {
        let settingsRepository = FuckSwift().settingsRepository()
        themeInit(settingsRepository: settingsRepository)
        
        let tint = settingsRepository.fetchThemeTint()
        let color = settingsRepository.fetchThemeColor()
        
        themeManager.tint = tint
        
        let isSystemInDarkTheme = themeManager.systemTint == .light
        let isDark = (tint == ThemeTint.auto_.name) ? (isSystemInDarkTheme) : (tint == ThemeTint.dark.name)
        let colorScheme = schemeChoser(isDark: isDark, color: color)
        
        themeManager.currentTheme = Theme(colorScheme: colorScheme)
    }
}

