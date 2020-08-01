import java.io.*;
import java.util.*;

public class DiverseArrays {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k  = readInt();
	
		long ans = 0;
		int distinct = 0;
		int[] cn = new int[(int)1e6 + 1];
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) arr[i] = readInt();
		for (int l = 0, r = 0; r < n; r ++) {
			if (cn[arr[r]] == 0) distinct ++;
			cn[arr[r]] ++;
			if (distinct == k) {
				ans += n - r; 
				while (cn[arr[l]] != 1) {
					cn[arr[l]] --; l ++; ans += n - r;
				}
				distinct --;
				cn[arr[l]] --; l ++;
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
