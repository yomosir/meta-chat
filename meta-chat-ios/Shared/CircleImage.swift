//
//  CircleImage.swift
//  meta-chat-ios
//
//  Created by 郑国春 on 2022/3/1.
//

import SwiftUI

struct CircleImage: View {
    var body: some View {
        Image("pic")
            .clipShape(Circle())
            .overlay(Circle().stroke(.gray, lineWidth: 4))
            .shadow(radius: 7)
    }
}

struct CircleImage_Previews: PreviewProvider {
    static var previews: some View {
        CircleImage()
    }
}
