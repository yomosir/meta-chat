//
//  ModelData.swift
//  meta-chat-ios
//
//  Created by 郑国春 on 2022/3/14.
//

import Foundation

var landmarks: [Landmark] = load("landmarkData.jsn")

//声明一个方法，加载landmarkData.json中的数据
//_（表示不是用别名） filename: String，返回一个Decodable对象
func load<T: Decodable>(_ filename: String) -> T {
    let data: Data
    
    guard let file = Bundle.main.url(forResource: filename, withExtension: nil)
    else{
        fatalError("Couldn't find \(filename) in main bundle. ")
    }
    // 读取数据到data中
    do {
        data = try Data(contentsOf: file)
    }catch{
        fatalError("Couldn't load \(filename) from main bundle: \n \(error)")
    }
    // 进行decode
    do {
        let decoder = JSONDecoder()
        return try decoder.decode(T.self, from: data)
    }catch{
        fatalError("Couldn't parse \(filename) as \(T.self):\n\(error)")
    }
}
