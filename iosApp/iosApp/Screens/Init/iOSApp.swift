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
                    
                    
                    //delete AppStorages...
                    @AppStorage("isAnimating") var isAnimating: Bool = false
                    isAnimating = false
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
                .onChange(of: themeManager.color) { color in
                    themeManager.color = color
                    let isDark = (themeManager.tint == ThemeTint.auto_.name) ? (themeManager.systemTint == .light) : (themeManager.tint == ThemeTint.dark.name)
                    
                    themeManager.currentTheme.colorScheme = schemeChoser(isDark: isDark, color: themeManager.color)
                }
                .environmentObject(themeManager)
            }
        
        }
    
    
    private func setupThemeManager() {
        let settingsRepository = FuckSwift().settingsRepository()
        themeInit(settingsRepository: settingsRepository)
        
        themeManager.tint = settingsRepository.fetchThemeTint()
        themeManager.color = settingsRepository.fetchThemeColor()
        
        let isDark = (themeManager.tint == ThemeTint.auto_.name) ? (themeManager.systemTint == .light) : (themeManager.tint == ThemeTint.dark.name)
        let colorScheme = schemeChoser(isDark: isDark, color: themeManager.color)
        
        themeManager.currentTheme = Theme(colorScheme: colorScheme)
    }
}

