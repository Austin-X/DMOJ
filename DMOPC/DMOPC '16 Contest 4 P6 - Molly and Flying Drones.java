import java.io.*;
import java.util.*;

public class MollyAndFlyingDrones {
	static class Pair {
		int val, idx;
		Pair (int val, int idx) { this.val = val; this.idx = idx; }
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int MV = (int)1e6;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		int[] heights = new int[n];
		for (int i = 0; i < n; i ++) heights[i] = readInt();

		long[] cn = new long[MV + 1];
		Stack<Pair> s = new Stack<Pair>();
		for (int i = 0; i < n; i ++) {
			while (!s.isEmpty() && heights[i] < s.peek().val) {
				int val = s.peek().val, idx = s.pop().idx;
				if (s.isEmpty()) cn[val] += (long)(idx + 1) * (i - idx);
				else cn[val] += (long)(idx - s.peek().idx) * (i - idx);
			}
			s.push(new Pair(heights[i], i));
		}
		while (!s.isEmpty()) {
			int val = s.peek().val, idx = s.pop().idx;
			if (s.isEmpty()) cn[val] += (long)(idx + 1) * (n - idx);
			else cn[val] += (long)(idx - s.peek().idx) * (n - idx);
		}
		for (int i = 1; i <= MV; i ++) cn[i] += cn[i - 1];
		
		for (int i = 0; i < q; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = readInt(), y = readInt();
			System.out.println(cn[y] - cn[x - 1]);
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
