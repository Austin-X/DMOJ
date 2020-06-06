import java.io.*;
import java.util.*;

public class PickIt {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = 1;
		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			
			int[] arr = new int[n];
			for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[n][n];
			for (int i = 2; i < n; i ++) {
				for (int j = 0; j < n - i; j ++) {
					if (i == 2) dp[j][j + i] = arr[j] + arr[j + 1] + arr[j + 2];
					else {
						int max = 0;
						for (int k = j + 1; k <= j + i - 1; k ++) {
							max = Math.max(max, dp[j][k] + dp[k][j + i] + arr[j] + arr[j + i] + arr[k]);
						}
						dp[j][j + i] = max;
					}
				}
			}
			
			System.out.println(dp[0][n - 1]);
		}
	}
}
