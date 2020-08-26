import java.io.*;
import java.util.*;

public class BobsShortestNonSubsequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) arr[i] = readInt();
		int ans = 0; HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 1; i <= m; i ++) set.add(i);
		for (int i = 0; i < n; i ++) {
			set.remove(arr[i]);
			if (set.isEmpty()) {
				ans ++;
				for (int j = 1; j <= m; j ++) set.add(j);
			}
		}
		System.out.println(ans + 1);
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
