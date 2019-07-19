import java.io.*;
import java.util.*;

public class TimeForChange {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 5; t ++) {
			int m = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[] coins = new int[n];
			int[] dp = new int[m + 1];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;
			
			for (int i = 0; i < n; i ++) coins[i] = Integer.parseInt(br.readLine());
			Arrays.sort(coins);
			
			for (int i = 0; i < n; i ++) {
				for (int j = 0; j <= m; j ++) {
					if (dp[j] != Integer.MAX_VALUE && j + coins[i] <= m) {
						dp[j + coins[i]] = Math.min(dp[j + coins[i]], dp[j] + 1);
					}
				}
			}
			
			System.out.println(dp[m] != -1 ? dp[m] : 0);
		}
	}
}
