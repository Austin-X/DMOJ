import java.io.*;
import java.util.*;

public class Vacation {
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n][3];
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j ++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(solve(n));
	}
	
	static int solve(int n) {
		for (int i = 1; i < n; i ++) {
			dp[i][0] += Math.max(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] += Math.max(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] += Math.max(dp[i - 1][0], dp[i - 1][1]);
		}
		
		int max = 0;
		for (int i = 0; i < 3; i ++) max = Math.max(max, dp[n - 1][i]);
		return max;
	}
}
