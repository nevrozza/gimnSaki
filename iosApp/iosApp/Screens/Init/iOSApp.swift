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
                .onChange(of: themeManager.tint) { isDark in
                    if let window = UIApplication.shared.keyWindow {
                        UIView.transition (with: window, duration: 0.5, options: .transitionCrossDissolve, animations: {
                            window.overrideUserInterfaceStyle = (themeManager.tint == ThemeTint.dark.name) ? .dark :
                                                               (themeManager.tint == ThemeTint.light.name) ? .light :
                                                               (themeManager.tint == ThemeTint.auto_.name) ? .unspecified :
                                                               .unspecified
                        }, completion: nil)
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

