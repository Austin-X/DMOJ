import java.io.*;
import java.util.*;

public class Hurontario {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String a = next(), b = next();
		int base = 131; long[] hsh1 = new long[a.length()], hsh2 = new long[b.length()];
		long[] pow = new long[a.length()];
		for (int i = a.length() - 1; i >= 0; i --) pow[i] = i == a.length() - 1 ? 1 : pow[i + 1] * base;
		for (int i = a.length() - 1; i >= 0; i --) hsh1[i] = i == a.length() - 1 ? a.charAt(i) : a.charAt(i) * pow[i] + hsh1[i + 1];
		for (int i = 0; i < b.length(); i ++) hsh2[i] = i == 0 ? b.charAt(i) : hsh2[i - 1] * base + b.charAt(i); 
		for (int i = 0; i < a.length(); i ++) {
			if (a.length() - i - 1 < b.length() && hsh1[i] == hsh2[a.length() - i - 1]) {
				System.out.print(a.substring(0, i)); System.out.println(b);
				System.exit(0);
			}
		}
		System.out.print(a); System.out.println(b);
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
