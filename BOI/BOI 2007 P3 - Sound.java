import java.io.*;
import java.util.*;

/* Submit this code using Java11 instead of Java8 because of memory issues in Java 8. */
public class Sound {
	static class Pair {
		int val, idx;
		Pair (int val, int idx) { this.val = val; this.idx = idx; }
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), c = readInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) arr[i] = readInt();
		Deque<Pair> max = new ArrayDeque<Pair>(), min = new ArrayDeque<Pair>();
		boolean none = true;
		for (int i = 0; i < n; i ++) {
			if (i < m - 1) {
				while (!max.isEmpty() && arr[i] >= max.peekLast().val) max.pollLast();
				while (!min.isEmpty() && arr[i] <= min.peekLast().val) min.pollLast();
				max.add(new Pair(arr[i], i)); min.add(new Pair (arr[i], i));
			} else {
				if (max.peekFirst().idx == i - m) max.pollFirst();
				if (min.peekFirst().idx == i - m) min.pollFirst();
				while (!max.isEmpty() && arr[i] >= max.peekLast().val) max.pollLast();
				while (!min.isEmpty() && arr[i] <= min.peekLast().val) min.pollLast();
				max.add(new Pair(arr[i], i)); min.add(new Pair(arr[i], i));
				
				if (max.peekFirst().val - min.peekFirst().val <= c) { none = false; System.out.println(i - m + 2); }
			}
		}
		if (none) System.out.println("NONE");
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
