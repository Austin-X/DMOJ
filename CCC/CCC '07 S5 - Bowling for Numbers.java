import java.io.*;
import java.util.*;

public class BowlingForNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t ++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			int[] pins = new int[n];
			for (int i = 0; i < n; i ++) pins[i] = Integer.parseInt(br.readLine());
			int[][] dp = new int[k + 1][n];
			
			for (int i = 1; i <= k; i ++) {
				for (int j = 0; j < n; j ++) {
					int score = 0;
					for (int x = j; x > j - w; x --) {
						if (x == -1) break;
						score += pins[x];
					}
					
					if (i > 1 && j >= w) dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - w] + score);
					else if (j > 0) dp[i][j] = Math.max(score, dp[i][j - 1]);
					else dp[i][j] = score;
				}
			}
			
			System.out.println(dp[k][n - 1]);
		}
	}
}
