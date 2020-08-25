import java.io.*;
import java.util.*;

public class BobsStringSearch {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		char[] s = readLine().toCharArray(), t = readLine().toCharArray();
		int max = Math.max(s.length, t.length);
		long[] hshS = new long[s.length + 1], pow = new long[max + 1]; int seed = 131; pow[0] = 1;
		for (int i = 1; i <= s.length; i ++) hshS[i] = hshS[i - 1] * seed + s[i - 1];
		long hshT = 0;
		for (int i = 1; i <= t.length; i ++) hshT = hshT * seed + t[i - 1];
		for (int i = 1; i <= max; i ++) pow[i] = pow[i - 1] * seed;
		
		int ans = 0;
		for (int i = t.length; i <= s.length; i ++) {
			if (hshS[i] - hshS[i - t.length] * pow[t.length] == hshT) ans ++;
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
