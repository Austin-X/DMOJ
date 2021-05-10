import java.io.*;
import java.util.*;

public class KoalaGambling {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i ++) a[i] = readInt();
			Arrays.sort(a);
			
			if (n % 2 == 0 && a[0] == a[a.length - 1]) System.out.println(-1);
			else if (n % 2 == 1) {
				for (int i = 0; i < n - 1; i ++) System.out.print(a[i] + " ");
				System.out.println(a[n - 1]);
			} else {
				int idx = n - 1;
				int[] ans = new int[n];
				for (int i = 0; i < n; i += 2) {
					ans[i] = a[idx];
					idx --;
				}
				for (int i = 1; i < n; i += 2) {
					ans[i] = a[idx];
					idx --;
				}
				for (int i = 0; i < n - 1; i ++) System.out.print(ans[i] + " ");
				System.out.println(ans[n - 1]);
			}
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
