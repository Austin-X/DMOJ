import java.io.*;
import java.util.*;

public class Smarties {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		int[] cn = new int[1000001];
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) arr[i] = readInt();
		long ans = 0; int distinct = 0;
		for (int l = 0, r = 0; r < n; r ++) {
			if(cn[arr[r]] == 0) distinct ++;
			cn[arr[r]] ++;
			if (distinct == k) {
				ans += n - r;
				while (cn[arr[l]] != 1) {
					ans += n - r; cn[arr[l]] --; l ++;
				}
				cn[arr[l]] --; l ++;
				distinct --;
			}
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
