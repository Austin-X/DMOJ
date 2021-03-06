import java.io.*;
import java.util.*;

public class GoldenLily {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int l = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int[][] density = new int[d][l];
		
		for (int i = 0; i < d; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < l; j ++) density[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[d][l];
		dp[0] = Arrays.copyOf(density[0], l);
		for (int i = 1; i < l; i ++) dp[0][i] += dp[0][i - 1];
		
		for (int i = 1; i < d; i ++) {
			for (int j = l - 1; j >= 0; j --) {
				if (j == l - 1) dp[i][j] = dp[i - 1][j] + density[i][j];
				else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j + 1]) + density[i][j];
				}
			}
			
			for (int j = 1; j < l; j ++) {
				dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j], dp[i][j - 1]) + density[i][j]);
			}
		}
		
		System.out.println(dp[row][col]);
	}
}
