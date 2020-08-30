import java.io.*;
import java.util.*;

public class MarciaAndMaze {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		char[][] grid = new char[n][n];
		for (int i = 0; i < n; i ++) grid[i] = readLine().toCharArray();
		
		int[][] psaRow = new int[n][n], psaCol = new int[n][n];
		for (int i = 0; i < n; i ++) {
			for (int j = n - 1; j >= 0; j --) {
				if (grid[i][j] == '#') psaCol[i][j] = 0;
				else psaCol[i][j] = j == n - 1 ? 1 : psaCol[i][j + 1] + 1;
				if (grid[j][i] == '#') psaRow[j][i] = 0;
				else psaRow[j][i] = j == n - 1 ? 1 : psaRow[j + 1][i] + 1;
			}
		}
		
		int ans = 0;
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				int vert = psaRow[i][j], hori = psaCol[i][j]; int max = Math.min(vert, hori);
				for (int k = 1; k < max; k ++) {
					if (psaCol[i + k][j] > k && psaRow[i][j + k] > k) ans = Math.max(ans, k);
				}
			}
		}
		System.out.println(ans);
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
