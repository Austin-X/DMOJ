import java.io.*;
import java.util.*;

public class SketchleyPark {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		char[] str = readLine().toCharArray(); int len = str.length;
		if (len < 9) { System.out.println("KeyNotFoundError"); System.exit(0); }
		
		HashSet<String> possible = new HashSet<String>(); 
		for (int i = 0; i <= len - 9; i ++) {
			if (str[i] == str[i + 4] && str[i + 1] ==  str[i + 8] && str[i + 2] != str[i + 3] && str[i + 3] != str[i + 5] && str[i + 5] != str[i + 6] && str[i + 6] != str[i + 7]) {
				String s = ""; for (int j = i; j < i + 9; j ++) s += str[j];
				possible.add(s);
			}
		}

		char[] keys = new char[26];
		int n = readInt();
		for (int i = 0; i < n; i ++) {
			char[] temp = readLine().toCharArray();
			HashMap<Character, Character> map = new HashMap<Character, Character>();
			for (int j = 0; j < 26; j ++) {
				keys[j] = temp[j]; map.put(temp[j], (char)(j + 'A'));
			}
			String decryp = ""; decryp += keys[7]; decryp += keys[0]; 
			decryp += keys[8]; decryp += keys[11]; decryp += keys[7]; 
			decryp += keys[24]; decryp += keys[3]; decryp += keys[17]; decryp += keys[0];
			if (possible.contains(decryp)) {
				for (int j = 0; j < len; j ++) System.out.print(map.get(str[j]));
				System.exit(0);
			}
		}
		System.out.println("KeyNotFoundError");
	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong() throws IOException {
		return Long.parseLong(next());
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter() throws IOException {
		return next().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
