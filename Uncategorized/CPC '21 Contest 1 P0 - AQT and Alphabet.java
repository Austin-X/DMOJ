import java.io.*;
import java.util.*;

public class AQTAndAlphabet {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		String s = readLine();
		boolean[] b = new boolean[26];
		for (int i = 0; i < s.length(); i ++) b[s.charAt(i) - 'a'] = true;
		for (int i = 0; i < 26; i ++) {
			if (!b[i]) {
				System.out.println((char)(i + 'a'));
				break;
			}
		}
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
