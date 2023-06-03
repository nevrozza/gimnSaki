import SwiftUI
import SharedSDK

@main
struct iOSApp: App {
    
    init() {
        PlatformSDK().doInit(configuration: PlatformConfiguration())

    }
    
    @StateObject var themeManager: ThemeManager = ThemeManager()
    @StateObject var isSystemDark: IsSystemDark = IsSystemDark()

    
	var body: some Scene {
        
       
            WindowGroup {
                
                
                    
                
                
                
                ZStack {
                    GeometryReader { proxy in
                        Color.clear // we just want the reader to get triggered, so let's use an empty color
                        
                            .onAppear {
                                setupThemeManager()
                            }
                            .onChange(of: isSystemDark.colorScheme) { _ in
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
                        .environmentObject(isSystemDark)
                }
            }
        }
    

    private func setupThemeManager() {
        let settingsRepository = SettingsRepositorySwift()
        themeInit(settingsRepository: settingsRepository)
        let tint = settingsRepository.fetchThemeTint()
        let color = settingsRepository.fetchThemeColor()
        let isSystemInDarkTheme = isSystemDark.colorScheme == .light
        let darkTheme = (tint == ThemeTint.auto_.name) ? (isSystemInDarkTheme) : (tint == ThemeTint.dark.name)
        let colorScheme = schemeChoser(isDark: darkTheme, color: color)
        themeManager.current = Theme(colorScheme: colorScheme)
    }
	
}


//LEN'
class IsSystemDark: ObservableObject {
    @Published var colorScheme: SwiftUI.ColorScheme = .dark
}
class SettingsRepositorySwift {
    let settingsRepository: SettingsRepository = KostilForSettingsInstanceSwift().settingsRepositorySwift()
    
    func fetchThemeTint() -> String {
        print(settingsRepository.fetchThemeTint())
        return settingsRepository.fetchThemeTint()
    }
    
    func fetchThemeColor() -> String {
        return settingsRepository.fetchThemeColor()
    }
    
    func saveThemeTint(tint: String) {
        settingsRepository.saveThemeTint(tint: tint)
    }
    
    func saveThemeColor(color: String) {
        settingsRepository.saveThemeColor(color: color)
    }
}

func schemeChoser(isDark: Bool, color: String) -> ColorScheme {
    if (isDark) {
        switch (color) {
        case ThemeColors.default_.name:
            return defaultDarkPallete
        case ThemeColors.green.name:
            return greenDarkPallete
        case ThemeColors.red.name:
            return redDarkPallete
        default:
            return yellowDarkPallete
        }
    } else {
        switch (color) {
        case ThemeColors.default_.name:
            return defaultLightPallete
        case ThemeColors.green.name:
            return greenLightPallete
        case ThemeColors.red.name:
            return redLightPallete
        default:
            return yellowLightPallete
        }
    }
}
