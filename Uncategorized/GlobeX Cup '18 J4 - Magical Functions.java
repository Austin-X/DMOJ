import java.io.*;
import java.util.*;

public class MagicalFunctions {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int a, b, c, d, e, n;
	static final int MOD = (int)1e9 + 7;
	public static void main(String[] args) throws IOException {
		a = readInt(); b = readInt(); c = readInt(); d= readInt(); e = readInt(); n = readInt();
		System.out.println(fun(n));
	}
	
	static int fun(int x) {
		if (x == 0) return e;
		return (int)(((long)a * fun((int)((double)x / b)) % MOD + (long)c * fun((int)((double)x / d))) % MOD) % MOD;
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
