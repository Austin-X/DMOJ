import java.io.*;
import java.util.*;

public class AQTAndMultiset {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long aXor = 0, bXor = 0;
		long[] a = new long[2 * n + 1], b = new long[2 * n + 1];
		for (int i = 0; i < 2 * n + 1; i ++) {
			a[i] = readLong();
			aXor ^= a[i];
		}
		for (int i = 0; i < 2 * n + 1; i ++) {
			b[i] = readLong();
			bXor ^= b[i];
		}
		Arrays.parallelSort(b);
		long c = bXor ^ aXor;
		for (int i = 0; i < 2 * n + 1; i ++) a[i] ^= c;
		Arrays.parallelSort(a);
		boolean flag = true;
		for (int i = 0; i < 2 * n + 1; i ++) {
			if (b[i] != a[i]) { flag = false; break; }
		}
		System.out.println(flag ? c : -1);
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
