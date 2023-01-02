import java.io.*;
import java.util.*;

public class NoMoreSeparation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		for (int i = 2; i <= n; i ++) System.out.println(1 + " " + i);
		if (m > n - 1) {
			m -= n - 1;
			for (int i = 2; i <= n; i ++) for (int j = i + 1; j <= n && m > 0; j ++, m --) System.out.println(i + " " + j);
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
