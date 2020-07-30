import java.io.*;
import java.util.*;

public class PickIt2 {
	static class Pair implements Comparable<Pair> {
		long val; int idx;
		Pair (long val, int idx) { this.val = val; this.idx = idx; }
		public int compareTo(Pair p) {
			if (val == p.val) return -Integer.compare(idx, p.idx);
			else return -Long.compare(val, p.val);
		}	
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		long[] dp = new long[n + 1];
		long[] psa = new long[n + 1];
		for (int i = 1; i <= n; i ++) psa[i] = psa[i - 1] + readInt();
		
		TreeSet<Pair> set = new TreeSet<Pair>();
		Deque<Pair> q = new ArrayDeque<Pair>();
		for (int i = 1; i <= n; i ++) {
			if (i <= k) {
				dp[i] = psa[i];
				set.add(new Pair(dp[i - 1] + psa[k] - psa[i], k));
				q.addLast(new Pair(dp[i - 1] + psa[k] - psa[i], k));
			}
			else {
				dp[i] = set.first().val + psa[i] - psa[k];
				set.remove(q.pollFirst());
				q.addLast(new Pair(dp[i - 1] - psa[i] + psa[k], i));
				set.add(q.peekLast());
			}
		}

		System.out.println(dp[n]);
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
