import java.io.*;
import java.util.*;

public class Slimes {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		long[] psa = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i == 0) psa[i] = arr[i];
			else psa[i] = psa[i - 1] + arr[i];
		}
		
		long[][] dp = new long[n][n];
		for (long[] x : dp) Arrays.fill(x, Long.MAX_VALUE);
		
		if (n == 2) { System.out.println(arr[0] + arr[1]); System.exit(0); }
		
		for (int i = 0; i < n; i ++) dp[i][i] = 0;
		
		for (int i = 1; i < n; i ++) {
			for (int j = 0; j < n - i; j ++) {
				long val = j == 0 ? 0 : psa[j - 1];
				if (i == 1) dp[j][j + 1] = arr[j] + arr[j + 1];
				else {
					long ans = Long.MAX_VALUE;
					for (int k = j; k < j + i; k ++) ans = Math.min(ans, dp[j][k] + dp[k + 1][j + i] + (psa[k] - val) + (psa[j + i] - psa[k]));
					dp[j][j + i] = ans;
				}
			}
		}
		
		System.out.println(dp[0][n - 1]);
	}
}
