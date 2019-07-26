import java.io.*;
import java.util.*;

public class Troyangles {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[][] grid = new char[n][n];
		int[][] dp = new int[n][n];
		
		for (int i = 0; i < n; i ++) {
			grid[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				if (grid[i][j] == '#') dp[i][j] = 1;
			}
		}
		
		int ans = 0;
		for (int i = 0; i < n; i ++) {
			int temp = 0;
			for (int j = 0; j < n; j ++) {		
				if (i == 0) {
					ans += dp[i][j];
				} else {
					if (grid[i][j] == '#') temp ++;
					else temp = 0;
					
					if (j > 1 && grid[i][j] == '#' && grid[i - 1][j - 1] == '#' && grid[i][j - 1] == '#' && grid[i][j - 2] == '#') {
						dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 2]) + 1, temp);
					}
					ans += dp[i][j];
				}
			}
		}
		
		System.out.println(ans);
	}
}
