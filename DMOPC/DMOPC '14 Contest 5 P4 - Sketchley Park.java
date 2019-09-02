import java.io.*;
import java.util.*;

public class SketchleyPark {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] message = br.readLine().toCharArray();
		int len = message.length;
		
		int n = Integer.parseInt(br.readLine());
		
		HashSet<String> possible = new HashSet<String>();
		
		String str;
		for (int i = 0; i <= len - 9; i ++) {
			if (message[i] == message[i + 4] && message[i + 1] == message[i + 8]) {
				str = "";
				str += message[i]; str += message[i + 1]; str += message[i + 2]; str += message[i + 3];
				str += message[i + 5]; str += message[i + 6]; str += message[i + 7];
				possible.add(str);
			}
		}
		
		if (!possible.isEmpty()) {
			for (int t = 0; t < n; t ++) {
				char[] key = br.readLine().toCharArray();
				
				str = "";
				str += key[7]; str += key[0]; str += key[8]; str += key[11]; str +=key[24]; str += key[3]; str += key[17];
				
				if (possible.contains(str)) {
					HashMap<Character, Character> map = new HashMap<Character, Character>();
					for (int k = 0; k < 26; k ++) map.put(key[k], (char)(k + 65));
					for (int k = 0; k < len; k ++) System.out.print(map.get(message[k]));
					System.exit(0);
				}
			}
		}
		System.out.println("KeyNotFoundError");
	}
}
