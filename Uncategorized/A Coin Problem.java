import java.io.*;
import java.util.*;

public class ACoinProblem {
	static class Triple implements Comparable<Triple> {
		int c, l, idx;
		Triple (int c, int l, int idx) { this.c = c; this.l = l; this.idx = idx; }
		public int compareTo(Triple p) { return Integer.compare(l, p.l); }
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int MV = 10000;
	public static void main(String[] args) throws IOException {
		int n = readInt(), v = readInt();
		int[] arr = new int[n]; 
		for (int i = 0; i < n; i ++) arr[i] = readInt();
		Triple[] stores = new Triple[v];
		for (int i = 0; i < v; i ++) stores[i] = new Triple(readInt(), readInt(), i);
		Arrays.sort(stores); int maxL = 0;
		int[] dp = new int[MV + 1]; Arrays.fill(dp, Integer.MAX_VALUE); dp[0] = 0;
		int[] ans = new int[v];
		for (int i = 0; i < v; i ++) {
			int c = stores[i].c, l = stores[i].l;
			if (l > maxL) {
				for (int j = maxL; j < l; j ++) {
					for (int k = 0; k <= MV; k ++) {
						if (dp[k] != Integer.MAX_VALUE && k + arr[j] <= MV) dp[k + arr[j]] = Math.min(dp[k + arr[j]], dp[k] + 1);
					}
				}
				maxL = l;
			}
			ans[stores[i].idx] = dp[c] == Integer.MAX_VALUE ? -1 : dp[c];
		}
		for (int i = 0; i < v; i ++) System.out.println(ans[i]);
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
