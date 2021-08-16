import java.io.*;
import java.util.*;

public class Hurontario {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	private static final int MOD = (int)(1e9) + 7;
	public static void main(String[] args) throws IOException {
		String a = next(), b = next();
		int base = 31, best = 0, mx = Math.max(a.length(), b.length());
		long[] hshA = new long[a.length() + 1], hshB = new long[b.length() + 1], pow = new long[mx + 1];
		pow[0] = 1;
		for (int i = 1; i <= a.length(); i ++) hshA[i] = (hshA[i - 1] * base % MOD + a.charAt(i - 1) - 'A' + 1) % MOD;
		for (int i = 1; i <= b.length(); i ++) hshB[i] = (hshB[i - 1] * base % MOD + b.charAt(i - 1) - 'A' + 1) % MOD;
		for (int i = 1; i <= mx; i ++) pow[i] = pow[i - 1] * base % MOD;
	
		for (int i = 1; i <= b.length(); i ++) {
			if (i > a.length()) break;
			long hsh1 = calcHsh(hshA, pow, a.length() - i + 1, a.length()), hsh2 = calcHsh(hshB, pow, 1, i);
			if (hsh1 == hsh2) best = i;
		}
		System.out.print(a.substring(0, a.length() - best)); System.out.println(b);
	}
	
	static long calcHsh(long[] hsh, long[] pow, int x, int y) {
		return (hsh[y] - hsh[x - 1] * pow[y - x + 1] % MOD + MOD) % MOD;
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
