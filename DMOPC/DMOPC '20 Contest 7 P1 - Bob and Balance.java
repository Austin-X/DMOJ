import java.io.*;
import java.util.*;

public class BobAndBalance {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	static class Pair implements Comparable<Pair> {
		int val, idx;
		Pair (int val, int idx) { this.val = val; this.idx = idx; }
		public int compareTo (Pair p) { return Integer.compare(val, p.val); }
	}
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), ans = 0;
		Pair[] w = new Pair[2 * n + 1];
		for (int i = 1; i <= 2 * n; i ++) w[i] = new Pair(readInt(), i);
		w[0] = new Pair(0, 0);
		Arrays.sort(w);
		int[][] res = new int[n + 1][2];
		for (int i = 1; i <= n; i ++) {
			if (w[i].val < w[i + n].val) ans ++;
			res[i][0] = w[i].idx;
			res[i][1] = w[i + n].idx;
		}
		pw.println(ans);
		for (int i = 1; i <= n; i ++) pw.println(res[i][0] + " " + res[i][1]);
		pw.close();
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
