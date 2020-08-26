import java.io.*;
import java.util.*;

public class BobAndFrenchClass {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] a = new int[n], b = new int[n];
		for (int i = 0; i < n; i ++) a[i] = readInt();
		for (int i = 0; i < n; i ++) b[i] = readInt();
		
		int[][][] dp = new int[n][2][2];
		for (int i = 0; i < n; i ++) {
			if (i == 0) {
				dp[i][0][0] = a[i];
				dp[i][1][0] = b[i];
			} else {
				if (i == 1) dp[i][1][0] = Math.max(dp[i - 1][0][0], dp[i - 1][1][0]) + b[i];
				else dp[i][1][0] = Math.max(dp[i - 1][0][0], Math.max(dp[i - 1][0][1], dp[i - 1][1][0])) + b[i];
				dp[i][0][0] = dp[i - 1][1][0] + a[i];
				dp[i][0][1] = dp[i - 1][0][0] + a[i];
			}
		}
		if (n == 1) System.out.println(Math.max(dp[0][0][0], dp[0][1][0]));
		else System.out.println(Math.max(dp[n - 1][0][0], Math.max(dp[n - 1][0][1], dp[n - 1][1][0])));
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
