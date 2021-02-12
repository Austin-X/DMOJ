import java.io.*;
import java.util.*;

public class LatinClass {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	private static final int MOD = (int) (1e9 + 7);
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] arr = new int[n];
		long[] dp = new long[n];
		
		for (int i = 0; i < n; i ++) arr[i] = readInt();
		
		dp[0] = 1;
		int max = arr[0], prevIdx = 0;
		long cnt = 0;
		
		boolean less = false;
		
		for (int i = 1; i < n; i ++) {
			if (arr[i] >= max) {
				if (less) {
					cnt ++;
					dp[i] = (dp[prevIdx] + cnt * dp[prevIdx]) % MOD;
					less = false;
					cnt = 0;
				} else {
					dp[i] = (dp[i - 1] * 2) % MOD;
				}
				
				max = arr[i];
			} else {
				dp[i] = dp[i - 1];
				
				if (!less) prevIdx = i - 1;
				cnt ++;
				
				less = true;
			}
		}
		
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
