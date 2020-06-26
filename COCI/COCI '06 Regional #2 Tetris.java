import java.io.*;
import java.util.*;

public class RegionalTetris {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken());
		boolean[][] grid = new boolean[c][105];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i ++) {
			int x = Integer.parseInt(st.nextToken());
			for (int j = 0; j <= x; j ++) grid[i][j] = true;
		}
		
		int ans = 0;
		for (int i = 0; i < c; i ++) {
			if (p == 1) {
				for (int j = 1; j <= 101; j ++) {
					if (grid[i][j - 1] && !grid[i][j]) ans ++;
					if (i <= c - 4 && !grid[i][j] && grid[i][j - 1] && !grid[i + 1][j] && grid[i + 1][j - 1] && !grid[i + 2][j] && grid[i + 2][j - 1] && !grid[i + 3][j] && grid[i + 3][j - 1]) ans ++;
				}
			} else if (p == 2) {
				for (int j = 1; j <= 101; j ++) {
					if (i <= c - 2 && grid[i][j - 1] && !grid[i][j] && !grid[i][j + 1] && !grid[i + 1][j] && !grid[i + 1][j + 1] && grid[i + 1][j - 1]) ans ++;
				}
			} else if (p == 3) {
				for (int j = 1; j <= 101; j ++) {
					if (i <= c - 3 && grid[i][j - 1] && !grid[i][j] && !grid[i + 1][j] && !grid[i + 1][j + 1] && grid[i + 1][j - 1] && !grid[i + 2][j + 1] && grid[i + 2][j]) ans ++;
					if (i >= 1 && grid[i][j - 1] && !grid[i][j] && !grid[i][j + 1] && !grid[i - 1][j + 1] && !grid[i - 1][j + 2] && grid[i - 1][j]) ans ++;
				}
			} else if (p == 4) {
				for (int j = 1; j <= 101; j ++) {
					if (i <= c - 3 && j >= 2 && !grid[i][j] && grid[i][j - 1] && !grid[i + 1][j] && !grid[i + 1][j - 1] && grid[i + 1][j - 2] && !grid[i + 2][j - 1] && grid[i + 2][j - 2]) ans ++;
					if (i <= c - 2 && grid[i][j - 1] && !grid[i][j] && !grid[i][j + 1] && !grid[i + 1][j + 1] && !grid[i + 1][j + 2] && grid[i + 1][j]) ans ++;
				}
			} else if (p == 5) {
				for (int j = 1; j <= 101; j ++) {
					if (i <= c - 3 && !grid[i][j] && grid[i][j - 1] && !grid[i + 1][j] && grid[i + 1][j - 1] && !grid[i + 2][j] && grid[i + 2][j - 1]) ans ++;
					if (i >= 1 && !grid[i][j] && grid[i][j - 1] && !grid[i - 1][j + 1] && grid[i - 1][j]) ans ++;
					if (i >= 1 && i <= c - 2 && !grid[i][j] && grid[i][j - 1] && !grid[i - 1][j + 1] && grid[i - 1][j] && !grid[i + 1][j + 1] && grid[i + 1][j]) ans ++;
					if (i <= c - 2 && !grid[i][j] && grid[i][j - 1] && !grid[i + 1][j + 1] && grid[i + 1][j]) ans ++;
				}
			} else if (p == 6) {
				for (int j = 1; j <= 101; j ++) {
					if (i <= c - 3 && !grid[i][j] && grid[i][j - 1] && !grid[i + 1][j] && grid[i + 1][j - 1] && !grid[i + 2][j] && grid[i + 2][j - 1]) ans ++;
					if (i <= c - 2 && !grid[i][j] && grid[i][j - 1] && !grid[i + 1][j] && grid[i + 1][j - 1]) ans ++;
					if (i <= c - 3 && !grid[i][j] && grid[i][j - 1] && !grid[i + 1][j + 1] && grid[i + 1][j] && !grid[i + 2][j + 1] && grid[i + 2][j]) ans ++;
					if (j >= 3 && i <= c - 2 && !grid[i][j] && grid[i][j - 1] && !grid[i + 1][j] && !grid[i + 1][j - 1] && !grid[i + 1][j - 2] && grid[i + 1][j - 3]) ans ++;
				}
			} else if (p == 7) {
				for (int j = 1; j <= 101; j ++) {
					if (i <= c - 3 && !grid[i][j] && grid[i][j - 1] && !grid[i + 1][j] && grid[i + 1][j - 1] && !grid[i + 2][j] && grid[i + 2][j - 1]) ans ++;
					if (i <= c - 2 && !grid[i][j] && grid[i][j - 1] && !grid[i + 1][j + 2] && grid[i + 1][j + 1]) ans ++;
					if (i <= c - 3 && j >= 2 && !grid[i][j] && grid[i][j - 1] && !grid[i + 1][j] && grid[i + 1][j - 1] && !grid[i + 2][j - 1] && grid[i + 2][j - 2]) ans ++;
					if (i <= c - 2 && !grid[i][j] && grid[i][j - 1] && !grid[i + 1][j] && grid[i + 1][j - 1]) ans ++;
				}
			}
		}
		
		System.out.println(ans);
	}
}
