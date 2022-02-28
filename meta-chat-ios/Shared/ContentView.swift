//
//  ContentView.swift
//  Shared
//
//  Created by 郑国春 on 2022/2/19.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack(alignment: .leading){
            Text("MetaChat")
                .font(.title)
                .foregroundColor(.green)
            HStack{
                Text("a simple chat tool")
                    .font(.subheadline)
                Spacer()
                Text("hangzhou")
                    .font(.subheadline)
            }
        }.padding()
            
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
