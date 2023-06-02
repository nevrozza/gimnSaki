//
//  Adaptive.swift
//  iosApp
//
//  Created by nevrozq on 02.06.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI

func calculateFromScreen(size: CGSize) -> CustomDeviceOrientation {
    var windowWidthSizeClass = fromWidth(width: size.width)
    var windowHeightSizeClass = fromHeight(height: size.height)
    var windowSizeClass = WindowSizeClass(height: windowHeightSizeClass, width: windowWidthSizeClass)
    
    if isExpanded(size: windowSizeClass) {
        return CustomDeviceOrientation.Expanded
    } else if isVertical(size: windowSizeClass) {
        return CustomDeviceOrientation.Vertical
    } else {
        return CustomDeviceOrientation.Horizontal
    }
}

func isVertical(size: WindowSizeClass) -> Bool {
    return ((size.height == WindowHeight.Expanded &&
             (size.width == WindowWidth.Medium
                     || size.width == WindowWidth.Compact)) ||
             (size.height == WindowHeight.Medium && size.width == WindowWidth.Compact)
             )
}

func isExpanded(size: WindowSizeClass) -> Bool {
    return ((size.width == WindowWidth.Expanded &&
             (size.height == WindowHeight.Medium
                     || size.height == WindowHeight.Expanded)))
}

func fromWidth(width: CGFloat) -> WindowWidth {
     switch true {
        case (width < CGFloat(600)):
         return WindowWidth.Compact
        case (width < CGFloat(900)):
         return WindowWidth.Medium
        default:
         return WindowWidth.Expanded
    }
}

func fromHeight(height: CGFloat) -> WindowHeight {
     switch true {
        case (height  < CGFloat(480)):
         return WindowHeight.Compact
        case (height  < CGFloat(840)):
         return WindowHeight.Medium
        default:
         return WindowHeight.Expanded
    }
}

struct WindowSizeClass {
    var height: WindowHeight
    var width: WindowWidth
}

enum WindowWidth {
    case Compact
    case Medium
    case Expanded
}

enum WindowHeight {
    case Compact
    case Medium
    case Expanded
}

enum CustomDeviceOrientation {
    case Vertical
    case Horizontal
    case Expanded
    
    var description: String {
        if(self == .Vertical) { return "Vertical" }
        else if(self == .Horizontal) { return "Horizontal" }
        else { return "Expanded" }
    }
}
