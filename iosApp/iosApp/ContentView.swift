import SwiftUI
import shared

struct ContentView: View {
	var body: some View {
        ZStack {
            ZStack(alignment: .bottomTrailing) {
                Button(action: {
                             // action for button tap
                }) {
                    Image(systemName: "plus")
                        .font(.system(size: 24, weight: .bold))
                        .foregroundColor(.white)
                        .frame(width: 56, height: 56)
                        .background(Color.blue)
                        .cornerRadius(28)
                }
                .padding(.trailing, 16)
                .padding(.bottom, 16)
            } .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .bottomTrailing)
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
