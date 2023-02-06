import SwiftUI
import shared

struct ContentView: View {
    var body: some View {
        VStack {
            Text("greet")
            Button {
        
            } label: {
                Text("Greet me !")
            }

        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
