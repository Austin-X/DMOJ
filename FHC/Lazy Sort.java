import java.io.*;
import java.util.*;

public class LazySort {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 1; t <= T; t ++) {
			int n = readInt();
			flag = false;
			Deque<Integer> original = new ArrayDeque<Integer>();
			for (int i = 0; i < n; i ++) original.addLast(readInt());
			Deque<Integer> q = new ArrayDeque<Integer>();
			
			recurse(n, original, q);
			System.out.print("Case #" + t + ": ");
			System.out.println(flag ? "yes" : "no");
		}
	}
	static void recurse(int n, Deque<Integer> original, Deque<Integer> q) {
		if (q.size() == n || n == 1) { flag = true; return; }
		
		int x;
		if (q.isEmpty()) {
			x = original.pollFirst();
			q.addFirst(x);
			recurse(n, original, q);
			q.pollFirst();
			original.addFirst(x);
			q.addFirst(original.pollLast());
			recurse(n, original, q);
		} else {
			if (original.peekFirst() + 1 == q.peekFirst()) { x = original.pollFirst(); q.addFirst(x); recurse(n, original, q); original.addFirst(x); q.pollFirst(); }
			else if (original.peekLast() + 1 == q.peekFirst()) { x = original.pollLast(); q.addFirst(x); recurse(n, original, q); original.addLast(x); q.pollFirst(); }	
			else if (original.peekFirst() == q.peekLast() + 1) { x = original.pollFirst(); q.addLast(x); recurse(n, original, q); original.addFirst(x); q.pollLast(); }
			else if (original.peekLast() == q.peekLast() + 1) { x = original.pollLast(); q.addLast(x); recurse(n, original, q); original.addLast(x); q.pollLast(); }
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
