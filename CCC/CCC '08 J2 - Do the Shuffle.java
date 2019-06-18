import java.io.*;
import java.util.ArrayList;

public class DoTheShuffle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Character> playlist = new ArrayList<Character>();
		playlist.add('A'); playlist.add('B'); playlist.add('C'); playlist.add('D'); playlist.add('E');
		int b = 0, n = 0;
		char temp;
		
		while (b != 4 || n != 1) {
			b = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			
			if (b == 1) {
				for (int i = 0; i < n; i ++) {
					temp = playlist.get(0);
					playlist.remove(0);
					playlist.add(temp);
				}
			} else if (b == 2) {
				for (int i = 0; i < n; i++) {
					temp = playlist.get(4);
					playlist.remove(4);
					playlist.add(0, temp);
				}
			} else if (b == 3) {
				for (int i = 0; i < n; i++) {
					temp = playlist.get(0);
					playlist.set(0, playlist.get(1));
					playlist.set(1, temp);
				}
			} 
		}
		for (char x : playlist) System.out.print(x + " ");
	}
}
