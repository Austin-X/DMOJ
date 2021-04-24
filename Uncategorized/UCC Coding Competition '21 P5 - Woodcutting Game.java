import java.io.*;
import java.util.*;

public class WoodcuttingGame {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][][][] dp;
	public static void main(String[] args) throws IOException {
		int h1 = readInt(), w1 = readInt(), h2 = readInt(), w2 = readInt();
		dp = new int[3][301][3][301];
		System.out.println(recurse(h1, w1, h2, w2) ? "W" : "L");
	}
	
	static boolean recurse(int h1, int w1, int h2, int w2) {
		if (dp[h1][w1][h2][w2] == 1 || dp[h2][w2][h1][w1] == 1) return true;
		else if (dp[h1][w1][h2][w2] == 2 || dp[h2][w2][h1][w1] == 2) return false;
		
		if (h1 == 1 && w1 == 1 && h2 == 1 && w2 == 1) {
			dp[h1][w1][h2][w2] = 2;
			dp[h2][w2][h1][w1] = 2;
			return false;
		}
		
		for (int i = 1; i <= w1 - 1; i ++) {
			if (!recurse(h1, i, h1, w1 - i)) {
				dp[h1][w1][h2][w2] = 1;
				dp[h2][w2][h1][w1] = 1;
				return true;
			}
		}
		if (h1 == 2 && !recurse(h1 - 1, w1, h1 - 1, w1)) {
			dp[h1][w1][h2][w2] = 1;
			dp[h2][w2][h1][w1] = 1;
			return true;
		}
		for (int i = 1; i <= w2 - 1; i ++) {
			if (!recurse(h2, i, h2, w2 - i)) {
				dp[h1][w1][h2][w2] = 1;
				dp[h2][w2][h1][w1] = 1;
				return true;
			}
		}
		if (h2 == 2 && !recurse(h2 - 1, w2, h2 - 1, w2)) {
			dp[h1][w1][h2][w2] = 1;
			dp[h2][w2][h1][w1] = 1;
			return true;
		}
		
		for (int i = 1; i <= Math.min(10, w1 - 1); i ++) {
			if (!recurse(h1, w1 - i, h2, w2)) {
				dp[h1][w1][h2][w2] = 1;
				dp[h2][w2][h1][w1] = 1;
				return true;
			}
		}
		if (h1 == 2 && !recurse(h1 - 1, w1, h2, w2)) {
			dp[h1][w1][h2][w2] = 1;
			dp[h2][w2][h1][w1] = 1;
			return true;
		}
		
		for (int i = 1; i <= Math.min(10, w2 - 1); i ++) {
			if (!recurse(h1, w1, h2, w2 - i)) {
				dp[h1][w1][h2][w2] = 1;
				dp[h2][w2][h1][w1] = 1;
				return true;
			}
		}
		if (h2 == 2 && !recurse(h1, w1, h2 - 1, w2)) {
			dp[h1][w1][h2][w2] = 1;
			dp[h2][w2][h1][w1] = 1;
			return true;
		}
		
		dp[h1][w1][h2][w2] = 2;
		dp[h2][w2][h1][w1] = 2;
		return false;
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
