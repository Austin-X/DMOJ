import java.io.*;
import java.util.*;

public class MagicalBribery {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i ++) arr[i] = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i ++) {
			for (int j = 1; j <= n; j ++) {
				if (j >= i) {
					if (j % i == 0) dp[i][j] = Math.max(Math.max((j / i) * arr[i], Math.max(dp[i][j - i] + arr[i], Math.max(dp[i - 1][j - i] + arr[i], dp[i - 1][j]))), dp[i][j - 1]);
					else dp[i][j] = Math.max(Math.max(dp[i][j - i] + arr[i], Math.max(dp[i - 1][j - i] + arr[i], dp[i - 1][j])), dp[i][j - 1]);
				} else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		
		System.out.println(dp[n][n]);
	}
}
