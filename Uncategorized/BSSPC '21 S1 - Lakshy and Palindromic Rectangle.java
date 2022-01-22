import java.io.*;
import java.util.*;

public class LakshyAndPalindromicRectangle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		
		char[][] grid = new char[n][m];
		for (int i = 0; i < n; i ++) 
			grid[i] = readLine().toCharArray();
		
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				if (grid[i][j] != '.') {
					if (grid[i][j] != grid[i][m - j - 1]) {
						if (grid[i][m - j - 1] != '.') {
							System.out.println(-1);
							return;
						} else grid[i][m - j - 1] = grid[i][j];
					}
				}
			}
		}
		
		for (int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j ++) {
				if (grid[j][i] != '.') {
					if (grid[j][i] != grid[n - j - 1][i]) {
						if (grid[n - j - 1][i] != '.') {
							System.out.println(-1);
							return;
						} else grid[n - j - 1][i] = grid[j][i];
					}
				}
			}
		}
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				System.out.print(grid[i][j] == '.' ? 'z' : grid[i][j]);
			}
			System.out.println();
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
