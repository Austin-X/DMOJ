import java.io.*;
import java.util.*;

public class Zeros {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {	
		int a = readInt() - 1, b = readInt();
		System.out.println(fun(b) - fun(a));
	}
	
	static long fun(int max) {
		if (max == -1) return 0;
		
		long low = 1, high = 5000000000L;
		while (low != high) {
			long mid = (low + high) / 2, zeroes = 0;

			long cur = 5;
			while (mid >= cur) { zeroes += mid / cur; cur *= 5; }
			if (zeroes > max) high = mid;
			else low = mid + 1;
		}
		return low - 1;
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
