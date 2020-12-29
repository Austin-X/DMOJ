import java.io.*;
import java.util.*;

public class CodingSpree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt();
		int[] v = new int[n], h = new int[n];
		for (int i = 0; i < n; i ++) {
			v[i] = readInt(); h[i] = readInt();
		}
		
		int[] dp = new int[t + 1];
		Arrays.fill(dp, -1); dp[0] = 0;
		for (int i = 0; i < n; i ++) {
			for (int j = t; j >= 0; j --) {
				if (dp[j] != -1 && j + h[i] <= t) {
					dp[j + h[i]] = Math.max(dp[j + h[i]], dp[j] + v[i]);
				}
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= t; i ++) ans = Math.max(ans, dp[i]);
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
