import java.io.*;
import java.util.StringTokenizer;

public class Prva {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int r = readInt(), c = readInt();
		char[][] grid = new char[r][c];
		for (int i = 0; i < r; i ++) grid[i] = readLine().toCharArray();
		String ans = "{";
		for (int i = 0; i < r; i ++) {
			for (int j = 0; j < c; j ++) {
				String temp = "";
				if (j == 0 || grid[i][j - 1] == '#') {
					for (int k = j; k < c; k ++) {
						if (grid[i][k] == '#') break;
						else temp += grid[i][k];
					}
				}
				if (temp.length() >= 2 && temp.compareTo(ans) < 0) ans = temp;
				temp = "";
				
				if (i == 0 || grid[i - 1][j] == '#') {
					for (int k = i; k < r; k ++) {
						if (grid[k][j] == '#') break;
						else temp += grid[k][j];
					}
				}
				if (temp.length() >= 2 && temp.compareTo(ans) < 0) ans = temp;
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
