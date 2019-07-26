import java.io.*;
import java.util.*;

public class TriangleCount {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 5; t ++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] dp = new int[n][n];
			char[][] grid = new char[n][n];
			
			int ans = 0;
			for (int i = 0; i < n; i ++) {
				grid[i] = br.readLine().toCharArray();
				for (int j = 0; j < n; j ++) {
					if (grid[i][j] == '#') {
						dp[i][j] = 1;
					}
				}
			}
			
			for (int i = 0; i < n; i ++) {
				int temp = 0;
				for (int j = 0; j < n; j ++) {
					if (grid[i][j] == '#') temp ++;
					else temp = 0;
					
					if (i > 0 && j > 1 && grid[i][j] == '#' && grid[i - 1][j - 1] == '#' && grid[i][j - 1] == '#' && grid[i][j - 2] == '#') {
						dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 2]) + 1, temp);
					}
					
					ans += dp[i][j];
				}
			}
			
			System.out.println(ans);
		}
	}
}
