//
//  Landmark.swift
//  meta-chat-ios
//
//  Created by 郑国春 on 2022/3/8.
//

import Foundation
import SwiftUI

struct Landmark: Hashable, Codable{
    var id:Int
    var name:String
    var park:String
    var state:String
    var description:String
    
    private var imageName: String
    var image: Image{
        Image(imageName)
    }
}
