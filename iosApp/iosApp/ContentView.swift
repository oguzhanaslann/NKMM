import SwiftUI
import shared

struct ContentView: View {
    private let greeter = Greeting()
    @State private var greet = ""
    
    init() {
        self.greet = greeter.greet()
    }
    
	var body: some View {
        VStack {
            Text(greet)
            Button {
                greet = greeter.nkmmGreet()
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
