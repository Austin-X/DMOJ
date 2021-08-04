import java.io.*;
import java.util.*;

public class MonkeyPotato {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int k = readInt(), d = readInt();
		int[] a = new int[d];
		for (int i = 0; i < d; i ++) a[i] = readInt();
		int min = 10, min2 = 10;
		for (int i = 0; i < d; i ++) min = Math.min(min, a[i]);
		for (int i = 0; i < d; i ++) if (a[i] != min) min2 = Math.min(min2, a[i]);

		if (min == 0 && d == 1) System.out.println(-1);
		else {
			if (min == 0) {
				if (k >= 2) {
					System.out.print(min2);
					k -= 2;
					while (k-- > 0) System.out.print(min);
					System.out.print(min2);
				} else System.out.print(min2);
			}
			else while (k-- > 0) System.out.print(min);
			System.out.println();
		}
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
