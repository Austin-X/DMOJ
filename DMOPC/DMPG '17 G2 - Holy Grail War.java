import java.io.*;
import java.util.*;

public class HolyGrailWar {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static Node segTree[];
	public static final long MX = (long) -1e16;
	static class Node {
		long sum, prefix, suffix, best;
		Node (long sum, long prefix, long suffix, long best) { this.sum = sum; this.prefix = prefix; this.suffix = suffix; this.best = best; }
		void update (long sum, long prefix, long suffix, long best) { this.sum = sum; this.prefix = prefix; this.suffix = suffix; this.best = best; }
	}
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		int[] d = new int[n + 1];
		segTree = new Node[4 * n];
		for (int i = 0; i < 4 * n; i ++) segTree[i] = new Node(MX, MX, MX, MX);
		for (int i = 1; i <= n; i ++) { 
			d[i] = readInt();
			updateTree(i, 1, n, 1, d[i]);
		}
		
		while (q-- > 0) {
			char ch = readCharacter();
			int a = readInt(), b = readInt();
			
			if (ch == 'S') updateTree(a, 1, n, 1, b);
			else println(getBest(a, b, 1, n, 1));
		}
	}
	
	static void updateTree(int idx, int low, int high, int pos, int val) {	
		if (low == high) {
			segTree[pos].update(val, val, val, val);
			return;
		}
		
		int mid = (low + high) / 2;
		if (idx >= low && idx <= mid) updateTree(idx, low, mid, pos<<1, val);
		else updateTree(idx, mid + 1, high, pos<<1|1, val);
		Node c1 = segTree[pos<<1], c2 = segTree[pos<<1|1];
		segTree[pos].update(c1.sum + c2.sum, Math.max(c1.prefix, c1.sum + c2.prefix), Math.max(c2.suffix, c2.sum + c1.suffix), Math.max(c1.best, Math.max(c2.best, c1.suffix + c2.prefix)));
	}
	
	static long getBest(int l, int r, int low, int high, int pos) {
		if (l <= low && r >= high) return segTree[pos].best;
		else if (l > high || r < low) return MX;
		int mid = (low + high) / 2;
		
		long val1 = getBest(l, r, low, mid, pos<<1), val2 = getBest(l, r, mid + 1, high, pos<<1|1);
		if (r <= mid) return val1;
		else if (l > mid) return val2;
		else return Math.max(val1, Math.max(val2, getBestSuffix(l, r, low, mid, pos<<1) + getBestPrefix(l, r, mid + 1, high, pos<<1|1)));
	}
	
	static long getBestPrefix(int l, int r, int low, int high, int pos) {
		if (l <= low && r >= high) return segTree[pos].prefix;	
		int mid = (low + high) / 2;
		return r <= mid ? getBestPrefix(l, r, low, mid, pos<<1) : Math.max(getBestPrefix(l, r, low, mid, pos<<1), segTree[pos<<1].sum + getBestPrefix(l, r, mid + 1, high, pos<<1|1));
	}
	
	static long getBestSuffix(int l, int r, int low, int high, int pos) {
		if (l <= low && r >= high) return segTree[pos].suffix;
		int mid = (low + high) / 2;
		return l > mid ? getBestSuffix(l, r, mid + 1, high, pos<<1|1) : Math.max(getBestSuffix(l, r, mid + 1, high, pos<<1|1), segTree[pos<<1|1].sum + getBestSuffix(l, r, low, mid, pos<<1));
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
	static void print(Object x) {
		System.out.print(x);
	}
	static void println(Object x) {
		System.out.println(x);
	}
}
