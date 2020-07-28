import java.io.*;
import java.util.*;

public class DamageOutput {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main (String[] args) throws IOException {
		int n = readInt(); long m = readLong();
		Deque<Integer> q = new ArrayDeque<Integer>();
		long sum = 0, ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i ++) {
			int x = readInt();	
			sum += x;
			q.addLast(x);
			
			while (true) {
				if (sum - q.peekFirst() < m) break;
				else sum -= q.pollFirst();
			}
			if (sum >= m) ans = Math.min(ans, q.size());
			if (ans == 1) break;
		}

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
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
