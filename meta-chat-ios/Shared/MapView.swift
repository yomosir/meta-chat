//
//  MapView.swift
//  meta-chat-ios
//
//  Created by 郑国春 on 2022/3/2.
//

import SwiftUI
import MapKit

struct MapView: View {
    @State private var region = MKCoordinateRegion(
        center: CLLocationCoordinate2D(latitude: 30.014_045, longitude: 120.008_030), span: MKCoordinateSpan(latitudeDelta: 1.0, longitudeDelta: 1.0)
    )
/**
 关于latitudeDelta，longitudeDelta标识当前地图的size，当值越大是，地图展示的区域会越大，如果值越小，展示的区域会越小，类似于一个比例尺
 */
    
    var body: some View {
        Map(coordinateRegion: $region)
    }
}

struct MapView_Previews: PreviewProvider {
    static var previews: some View {
        MapView()
.previewInterfaceOrientation(.portrait)
    }
}
