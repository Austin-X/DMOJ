import java.io.*;
import java.util.*;

public class MATH137AtSquirreloo {
	static class Pair implements Comparable<Pair> {
		int val, idx;
		Pair (int val, int idx) { this.val = val; this.idx = idx; }
		public int compareTo(Pair p) {
			return Integer.compare(val, p.val);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt(); 
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) arr[i] = readInt();
		TreeSet<Pair> max = new TreeSet<Pair>(), min = new TreeSet<Pair>();
		int curMax = -Integer.MAX_VALUE, curMin = Integer.MAX_VALUE;
		for (int i = n - 1; i >= 0; i --) {
			if (arr[i] > curMax) { max.add(new Pair(arr[i], n - 1 - i)); curMax = arr[i]; }
			if (arr[i] < curMin) { min.add(new Pair(arr[i], n - 1 - i)); curMin = arr[i]; }
		}

		for (int i = 0; i < q; i ++ ) {
			int l = readInt(), e = readInt();
			Pair high = max.higher(new Pair(l + e, i)), low = min.lower(new Pair(l - e, i));
			
			if (high == null && low == null) System.out.println(n);
			else if (high == null) System.out.println(low.idx);
			else if (low == null) System.out.println(high.idx);
			else System.out.println(Math.min(low.idx, high.idx));
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
