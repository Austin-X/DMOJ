import java.io.*;
import java.util.*;

public class Coins {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), x = readInt();
		
		int best = 0;
		for (int i = 0; i < n; i ++) {
			int a = readInt(), v = readInt();
			a = Math.min(a, x);
			best = Math.max(best, a * v);
		}
		
		System.out.println(best);
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
