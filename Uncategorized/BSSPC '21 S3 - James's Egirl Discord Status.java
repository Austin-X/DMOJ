import java.io.*;
import java.util.*;

public class JamesEgirlDiscordStatus {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		long[] arr = new long[n + 1], dp = new long[n + 1];
		long sum = 0, ans = 0;
		
		for (int i = 1; i <= n; i ++) {
			arr[i] = readInt();
			if (i >= k) {
				sum -= arr[i - k];
				sum += arr[i];
				dp[i] = Math.max(0, dp[i - k] + sum);
			} else sum += arr[i];
			ans = Math.max(ans, dp[i]);
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
