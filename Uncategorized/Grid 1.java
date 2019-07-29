import java.io.*;
import java.util.*;

public class Grid1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		char[][] grid = new char[h][w];
		for (int i = 0; i < h; i ++) grid[i] = br.readLine().toCharArray();

		int[][] dp = new int[h][w];
		dp[0][0] = 1;
		
		for (int i = 0; i < h; i ++) {
			for (int j = 0; j < w; j ++) {
				if (grid[i][j] != '#') {
					if (i > 0 && j > 0) {
						dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
					} else if (i > 0) {
						dp[i][j] = dp[i - 1][j] % 1000000007;
					} else if (j > 0) {
						dp[i][j] = dp[i][j - 1] % 1000000007;
					}
				}
			}
		}
		
		System.out.println(dp[h - 1][w - 1] % 1000000007);
	}
}
