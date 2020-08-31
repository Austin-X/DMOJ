import java.io.*;
import java.util.*;

public class Bernard {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		long[] dp = new long[n]; dp[0] = readInt();
		for (int i = 1; i < n; i ++) dp[i] = i <= k ? Math.max(readInt(), dp[i - 1]) : Math.max(readInt() + dp[i - k - 1], dp[i - 1]);
		System.out.println(dp[n - 1]);
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
