import java.io.*;
import java.util.*;

public class TheTriangle {
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n][n];
		for (int[] x : dp) Arrays.fill(x, -1);
		
		int cn = 1;
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cn; j ++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
			cn ++;
		}
		
		System.out.println(solve(n));
	}
	
	static int solve(int n) {
		int max = 0, cn = 1;
		
		for (int i = 1; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				if (j == 0) dp[i][j] += dp[i - 1][j];
				else if (j == cn) dp[i][j] += dp[i - 1][j - 1];
				else {
					dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
				}
			}
			cn ++;
		}
		
		for (int i = 0; i < n; i ++) {
			max = Math.max(dp[n - 1][i], max);
		}
		
		return max;
	}
}
