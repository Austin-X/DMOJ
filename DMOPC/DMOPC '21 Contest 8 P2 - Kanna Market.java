import java.io.*;
import java.util.*;

public class KannaMarket {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int MOD = (int) (1e9 + 7);
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int[][] arr = new int[2][n];
		
		for (int i = 0; i < 2; i ++) for (int j = 0; j < n; j ++) arr[i][j] = readInt();
		
		int empty = 0, l = 0, r = 2 * m + 1;
		for (int i = 0; i < n; i += 2) {
			if (arr[0][i] == 0 && arr[1][i] == 0) empty ++;
			if (arr[0][i] == 0 && arr[1][i] == 0) {
				l = Math.max(l, 2);
				r = Math.min(r, 2 * m);
			} else if (arr[0][i] == 0) {
				l = Math.max(l, arr[1][i] + 1);
				r = Math.min(r, arr[1][i] + m);
			} else if (arr[1][i] == 0) {
				l = Math.max(l, arr[0][i] + 1);
				r = Math.min(r, arr[0][i] + m);
			} else {
				l = Math.max(l, arr[0][i] + arr[1][i]);
				r = Math.min(r, arr[0][i] + arr[1][i]);
			}
		}
		
		long ans = 0, oddCols = 0, evenCols = 0;
		for (int i = l; i <= r; i ++) { 
			if (i <= m + 1) oddCols += fast_pow(i - 1, empty);
			else oddCols += fast_pow(m - (i - m) + 1, empty);
			oddCols %= MOD; 
		}
		
		empty = 0; l = 0; r = 2 * m + 1;
		for (int i = 1; i < n; i += 2) {
			if (arr[0][i] == 0 && arr[1][i] == 0) empty ++;
			if (arr[0][i] == 0 && arr[1][i] == 0) {
				l = Math.max(l, 2);
				r = Math.min(r, 2 * m);
			} else if (arr[0][i] == 0) {
				l = Math.max(l, arr[1][i] + 1);
				r = Math.min(r, arr[1][i] + m);
			} else if (arr[1][i] == 0) {
				l = Math.max(l, arr[0][i] + 1);
				r = Math.min(r, arr[0][i] + m);
			} else {
				l = Math.max(l, arr[0][i] + arr[1][i]);
				r = Math.min(r, arr[0][i] + arr[1][i]);
			}
		}
		
		for (int i = l; i <= r; i ++) { 
			if (i <= m + 1) evenCols += fast_pow(i - 1, empty);
			else evenCols += fast_pow(m - (i - m) + 1, empty);
			evenCols %= MOD; 
		}
		
		ans = oddCols * evenCols;
		ans %= MOD;
		System.out.println(ans);
	}

	public static long fast_pow (long b, long x) {
		if (x == 0) return 1;
		if (x == 1) return b;
		if (x % 2 == 0) return fast_pow (b * b % MOD, x / 2) % MOD;

		return b * fast_pow (b * b % MOD, x / 2) % MOD;
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
