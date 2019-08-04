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
			
			int[] pins = new int[n + 1];
			for (int i = 1; i <= n; i ++) pins[i] = Integer.parseInt(br.readLine());
			
			int[][] dp = new int[k + 1][n + 1];
			for (int i = 1; i <= k; i ++) {
				for (int j = 1; j <= n; j ++) {
					int score = 0;
					for (int x = j; x > j - w; x --) {
						if (x == -1) break;
						score += pins[x];
					}
					
					dp[i][j] = j >= w ? Math.max(dp[i][j - 1], dp[i - 1][j - w] + score) : score;
				}
			}
			
			System.out.println(dp[k][n]);
		}
	}
}
