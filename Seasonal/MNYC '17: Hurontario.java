import java.io.*;
import java.util.*;

public class Hurontario {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String a = next(), b = next();
		int base = 131, idx = 0;
		long hsh1 = 0, hsh2 = 0; long[] pow = new long[a.length()];
		for (int i = a.length() - 1; i >= 0; i --) pow[i] = i == a.length() - 1 ? 1 : pow[i + 1] * base;
	
		int best = a.length();
		for (int i = a.length() - 1; i >= 0; i --) {
			if (idx == b.length()) break;
			hsh1 += a.charAt(i) * pow[i]; hsh2 = hsh2 * base + b.charAt(idx); idx ++;
			if (hsh1 == hsh2) best = i;
		}
		System.out.print(a.substring(0, best)); System.out.println(b);
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
