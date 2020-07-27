import java.io.*;
import java.util.*;

public class BadNews {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		
		char[][] grid = new char[n][n];
		boolean[][] vis = new boolean[n][n];
		
		for (int i = 0; i < n; i ++) 
			for (int j = 0; j < n; j ++) 
				grid[i][j] = next().charAt(0);

		for (int i = 0; i < q; i ++) {
			String word = next();
			flag = false;
			recurse(vis, grid, word, 0, n, 0, 0);
			System.out.println(flag ? "good puzzle!" : "bad puzzle!");
		}
	}
	
	static void recurse(boolean[][] vis, char[][] grid, String word, int idx, int n, int r, int c) {
		if (idx == word.length()) { flag = true; return; }
		
		if (idx == 0) {
			for (int i = 0; i < n; i ++) {
				for (int j = 0; j < n; j ++) {
					if (grid[i][j] == word.charAt(idx)) {
						vis[i][j] = true; recurse(vis, grid, word, idx + 1, n, i, j); vis[i][j] = false;
					}
				}
			}
		} else {
			if (r - 1 >= 0) {
				if (c - 1 >= 0 && !vis[r - 1][c - 1] && grid[r - 1][c - 1] == word.charAt(idx)) { vis[r - 1][c - 1] = true; recurse(vis, grid, word, idx + 1, n, r - 1, c - 1); vis[r - 1][c - 1] = false; }
				if (!vis[r - 1][c] && grid[r - 1][c] == word.charAt(idx)) { vis[r - 1][c] = true; recurse(vis, grid, word, idx + 1, n, r - 1, c); vis[r - 1][c] = false; }
				if (c + 1 < n && !vis[r - 1][c + 1] && grid[r - 1][c + 1] == word.charAt(idx)) { vis[r - 1][c + 1] = true; recurse(vis, grid, word, idx + 1, n, r - 1, c + 1); vis[r - 1][c + 1] = false; }
			}
			if (c - 1 >= 0 && !vis[r][c - 1] && grid[r][c - 1] == word.charAt(idx)) { vis[r][c - 1] = true; recurse(vis, grid, word, idx + 1, n, r, c - 1); vis[r][c - 1] = false; }
			if (c + 1 < n && !vis[r][c + 1] && grid[r][c + 1] == word.charAt(idx)) { vis[r][c + 1] = true; recurse(vis, grid, word, idx + 1, n, r, c + 1); vis[r][c + 1] = false; }
			if (r + 1 < n) {
				if (c - 1 >= 0 && !vis[r + 1][c - 1] && grid[r + 1][c - 1] == word.charAt(idx)) { vis[r + 1][c - 1] = true; recurse(vis, grid, word, idx + 1, n, r + 1, c - 1); vis[r + 1][c - 1] = false; }
				if (!vis[r + 1][c] && grid[r + 1][c] == word.charAt(idx)) { vis[r + 1][c] = true; recurse(vis, grid, word, idx + 1, n, r + 1, c); vis[r + 1][c] = false; }
				if (c + 1 < n && !vis[r + 1][c + 1] && grid[r + 1][c + 1] == word.charAt(idx)) { vis[r + 1][c + 1] = true; recurse(vis, grid, word, idx + 1, n, r + 1, c + 1); vis[r + 1][c + 1] = false; }
			}
		}
	}
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong() throws IOException {
		return Long.parseLong(next());
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter() throws IOException {
		return next().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
