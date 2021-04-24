import java.io.*;
import java.util.*;

public class CounterfeitDetection {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		char[] ch = readLine().toCharArray();
		
		int ans = 0;
		for (int i = 0; i < ch.length; i ++) {
			if (i != ch.length - 1) {
				if (ch[i] == '2' && ch[i + 1] != '5') ans ++;
			} else if (ch[i] == '2') ans ++;
		}
		
		System.out.println(ans);
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
