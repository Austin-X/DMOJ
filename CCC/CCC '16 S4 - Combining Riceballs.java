import java.io.*;
import java.util.*;

public class CombiningRiceballs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n][n];
		
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n - i; j ++) {
				if (i == 0) dp[j][j] = arr[j];
				else if (i == 1) {
					if (arr[j] == arr[j + 1]) dp[j][j + 1] = arr[j] * 2;
				} else {
					for (int k = j; k <= j + i - 1; k ++) {
						if (dp[j][k] != 0 && dp[j][k] == dp[k + 1][j + i]) dp[j][j + i] = dp[j][k] + dp[k + 1][j + i];
					}
					if (dp[j][j + i] != 0) continue;
					
					int low = j, high = j + i;
					while (low <= high - 2) {
						if (dp[j][low] < dp[high][j + i]) low ++;
						else if (dp[j][low] > dp[high][j + i]) high --;
						else {
							if (dp[low + 1][high - 1] != 0) { dp[j][j + i] = dp[j][low] * 2 + dp[low + 1][high - 1]; break; }
							else { low ++; high --; }
						}
					}
				}
			}
		}
		
		for (int i = 0; i < n; i ++) {
			for (int j = i; j < n; j ++) {
				ans = Math.max(ans, dp[i][j]);
			}
		}
		System.out.println(ans);
	}
}
