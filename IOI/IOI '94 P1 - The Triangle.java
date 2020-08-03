import java.io.*;
import java.util.*;

public class TheTriangle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		
		int cn = 1; int[][] dp = new int[n][n];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < cn; j ++) {
				if (cn == 1) dp[i][j] = readInt();
				else if (j == 0) dp[i][j] = dp[i - 1][j] + readInt();
				else if (j == cn - 1) dp[i][j] = dp[i - 1][j - 1] + readInt();
				else dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + readInt();
			}
			cn ++;
		}

		int max = 0;
		for (int i = 0; i < n; i ++) max = Math.max(max, dp[n - 1][i]);
		System.out.println(max);
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
