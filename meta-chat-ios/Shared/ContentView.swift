//
//  ContentView.swift
//  Shared
//
//  Created by 郑国春 on 2022/2/19.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
    
        VStack(){
            MapView()
                .frame(height: 300)
            
            CircleImage()
                .offset(y: -130)
                .padding(.bottom, -130)
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
                Divider()
                Text("About Turtle Rock")
                                    .font(.title2)
                Text("Descriptive text goes here.")
            }.padding()
            
            Spacer()
        }
            
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
