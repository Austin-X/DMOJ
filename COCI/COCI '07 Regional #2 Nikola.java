import java.io.*;
import java.util.*;

public class Nikola {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i ++) arr[i] = readInt();
		int[][] dp = new int[n + 1][n + 1];
		dp[1][2] = arr[2]; dp[1][1] = arr[2] + arr[1];
		for (int i = 2; i <= n; i ++) {
			for (int j = i + 1; j <= n; j ++) {
				if (dp[i - 1][j - i] != 0) {
					dp[i][j] = dp[i - 1][j - i] + arr[j];
					for (int k = j - i; k >= 1; k -= i) {
						if (dp[i][k] == 0) dp[i][k] = dp[i][k + i] + arr[k];
						else if (dp[i][k + i] + arr[k] < dp[i][k]) dp[i][k] = dp[i][k + i] + arr[k];
					}
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i ++) if (dp[i][n] != 0) ans = Math.min(ans, dp[i][n]);
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
