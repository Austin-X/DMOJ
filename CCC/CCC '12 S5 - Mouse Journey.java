import java.io.*;
import java.util.*;

public class MouseJourney {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[][] dp = new int[r][c];
		boolean[][] visited = new boolean[r][c];
		
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			dp[x - 1][y - 1] = Integer.MAX_VALUE;
		}
		
		dp[0][0] = 1;
		for (int i = 0; i < r; i ++) {
			for (int j = 0; j < c; j ++) {
				if (!visited[i][j] && dp[i][j] != Integer.MAX_VALUE) {
					if (i > 0 && dp[i - 1][j] != Integer.MAX_VALUE) { dp[i][j] += dp[i - 1][j]; }
					if (j > 0 && dp[i][j - 1] != Integer.MAX_VALUE) { dp[i][j] += dp[i][j - 1]; visited[i][j - 1] = true; }
				}
			}
		}
		
		System.out.println(dp[r - 1][c - 1]);
	}
}
