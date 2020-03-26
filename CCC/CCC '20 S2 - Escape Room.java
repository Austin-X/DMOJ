import java.io.*;
import java.util.*;

public class EscapeRoom {
	static int[][] grid;
	static boolean[][] vis;
	static int m, n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		m = Integer.parseInt(br.readLine()); n = Integer.parseInt(br.readLine());
		grid = new int[m][n];
		vis = new boolean[m][n];
		
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j ++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		vis[0][0] = true;
		recurse(0, 0);
		System.out.println("no");
	}
	
	static void recurse(int a, int b) {
		if (a == m - 1 && b == n - 1) { System.out.println("yes"); System.exit(0); }
		
		int x = grid[a][b];
		for (int i = 1; i <= Math.sqrt(x); i ++) {
			if (x % i == 0) {
				if (i - 1 < m && x / i - 1 < n && !vis[i - 1][x / i - 1]) { vis[i - 1][x / i - 1] = true; recurse(i - 1, x / i - 1); }
				if (x / i - 1 < m && i - 1 < n && !vis[x / i - 1][i - 1]) { vis[x / i - 1][i - 1] = true; recurse (x / i - 1, i - 1); }
			}
		}
	}
}
