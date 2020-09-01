import java.io.*;
import java.util.*;

public class Coins {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		double[] heads = new double[n + 1], tails = new double[n + 1];
		for (int i = 1; i <= n; i ++) {
			double x = readDouble();
			heads[i] = x; tails[i] = 1 - x;
		}
		
		double[][] dp = new double[n + 1][n + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= n; i ++) {
			for (int j = 0; j <= i; j ++) {
				if (j == 0) dp[i][j] = dp[i - 1][j] * tails[i];
				else dp[i][j] = dp[i - 1][j - 1] * heads[i] + dp[i - 1][j] * tails[i];
			}
		}
		double ans = 0;
		for (int i = n / 2 + 1; i <= n; i ++) ans += dp[n][i];
		System.out.format("%.9f %n", ans);
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
