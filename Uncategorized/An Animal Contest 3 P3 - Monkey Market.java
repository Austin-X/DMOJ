import java.io.*;
import java.util.*;

public class MonkeyMarket {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i ++) a[i] = readInt();
		Arrays.parallelSort(a);
		
		for (int i = 0; i < n / 2; i ++) {
			System.out.print(a[i] + " " + a[n - i - 1]);
			if (i + 1 < n / 2) System.out.print(" " );
		}
		if (n % 2 == 1) System.out.print(" " + a[n / 2]);
		System.out.println();
		for (int i = 0; i < n / 2; i ++) System.out.print("BS");
		if (n % 2 == 1) System.out.print("E");
		System.out.println();
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
