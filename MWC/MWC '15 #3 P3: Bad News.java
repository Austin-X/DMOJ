import java.io.*;
import java.util.*;

public class BadNews {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean flag;
	static char[][] grid;
	static boolean[][] vis;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt(); int q = readInt();
		
		grid = new char[n][n];
		vis = new boolean[n][n];
		
		for (int i = 0; i < n; i ++) 
			for (int j = 0; j < n; j ++) 
				grid[i][j] = next().charAt(0);

		for (int i = 0; i < q; i ++) {
			String word = readLine();
			flag = false;
			recurse(word, 0, 0, 0);
			System.out.println(flag ? "good puzzle!" : "bad puzzle!");
		}
	}
	
	static void recurse(String word, int idx, int r, int c) {
		if (flag) return;
		if (idx == word.length()) { flag = true; return; }
		
		if (idx == 0) {
			for (int i = 0; i < n; i ++) {
				for (int j = 0; j < n; j ++) {
					if (grid[i][j] == word.charAt(idx)) {
						vis[i][j] = true; recurse(word, idx + 1, i, j); vis[i][j] = false;
					}
				}
			}
		} else {
			if (r - 1 >= 0) {
				if (c - 1 >= 0 && !vis[r - 1][c - 1] && grid[r - 1][c - 1] == word.charAt(idx)) { vis[r - 1][c - 1] = true; recurse(word, idx + 1, r - 1, c - 1); vis[r - 1][c - 1] = false; }
				if (!vis[r - 1][c] && grid[r - 1][c] == word.charAt(idx)) { vis[r - 1][c] = true; recurse(word, idx + 1, r - 1, c); vis[r - 1][c] = false; }
				if (c + 1 < n && !vis[r - 1][c + 1] && grid[r - 1][c + 1] == word.charAt(idx)) { vis[r - 1][c + 1] = true; recurse(word, idx + 1, r - 1, c + 1); vis[r - 1][c + 1] = false; }
			}
			if (c - 1 >= 0 && !vis[r][c - 1] && grid[r][c - 1] == word.charAt(idx)) { vis[r][c - 1] = true; recurse(word, idx + 1, r, c - 1); vis[r][c - 1] = false; }
			if (c + 1 < n && !vis[r][c + 1] && grid[r][c + 1] == word.charAt(idx)) { vis[r][c + 1] = true; recurse(word, idx + 1, r, c + 1); vis[r][c + 1] = false; }
			if (r + 1 < n) {
				if (c - 1 >= 0 && !vis[r + 1][c - 1] && grid[r + 1][c - 1] == word.charAt(idx)) { vis[r + 1][c - 1] = true; recurse(word, idx + 1, r + 1, c - 1); vis[r + 1][c - 1] = false; }
				if (!vis[r + 1][c] && grid[r + 1][c] == word.charAt(idx)) { vis[r + 1][c] = true; recurse(word, idx + 1, r + 1, c); vis[r + 1][c] = false; }
				if (c + 1 < n && !vis[r + 1][c + 1] && grid[r + 1][c + 1] == word.charAt(idx)) { vis[r + 1][c + 1] = true; recurse(word, idx + 1, r + 1, c + 1); vis[r + 1][c + 1] = false; }
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
