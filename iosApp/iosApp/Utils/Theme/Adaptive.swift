//
//  Adaptive.swift
//  iosApp
//
//  Created by nevrozq on 02.06.2023.
//  Copyright © 2023 orgName. All rights reserved.

import SwiftUI
import SharedSDK

func calculateFromScreen(size: CGSize) -> WindowScreen {
    let windowWidthSizeClass = fromWidth(width: size.width)
    let windowHeightSizeClass = fromHeight(height: size.height)
    let windowSizeClass = WindowSizeClass(height: windowHeightSizeClass, width: windowWidthSizeClass)
    
    if isExpanded(size: windowSizeClass) {
        return .Expanded()
    } else if isVertical(size: windowSizeClass) {
        return .Vertical()
    } else {
        return .Horizontal()
    }
}

func isVertical(size: WindowSizeClass) -> Bool {
    return ((size.height == .Expanded() &&
             (size.width == .Medium()
                     || size.width == .Compact())) ||
             (size.height == .Medium() && size.width == .Compact())
             )
}

func isExpanded(size: WindowSizeClass) -> Bool {
    return ((size.width == .Expanded() &&
             (size.height == .Medium()
                     || size.height == .Expanded())))
}

func fromWidth(width: CGFloat) -> WindowSize {
     switch true {
        case (width < CGFloat(600)):
         return .Compact()
        case (width < CGFloat(900)):
         return .Medium()
        default:
         return .Expanded()
    }
}

func fromHeight(height: CGFloat) -> WindowSize {
     switch true {
        case (height  < CGFloat(480)):
         return .Compact()
        case (height  < CGFloat(840)):
         return .Medium()
        default:
         return .Expanded()
    }
}

struct WindowSizeClass {
    var height: WindowSize
    var width: WindowSize
}

