import java.io.*;
import java.util.*;

public class Candies {
	static final int MOD = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n + 1][k + 1];
		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i ++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		int sum = 0;
		for (int i = 1; i <= n; i ++) {
			sum += arr[i];
			for (int j = 0; j <= sum && j <= k; j ++) {
				if (j == 0) dp[i][j] = 1;
				else if (j <= arr[i]) dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
				else {
					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - arr[i] - 1]) % MOD;
					if (dp[i][j] < 0) dp[i][j] += MOD;
				}
			}
		}

		System.out.println(dp[n][k]);
	}
}
