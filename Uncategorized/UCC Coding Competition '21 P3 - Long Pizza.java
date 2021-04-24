import java.io.*;
import java.util.*;

public class LongPizza {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("unused")
		int n = readInt(), x = readInt(), y = readInt(), r = readInt();
		long ans = 0;
		for (int i = 0; i < r; i ++) {
			int low = Math.max(readInt(), x), high = Math.min(y, readInt());
			if (high - low + 1 > 0) ans += high - low + 1;
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
