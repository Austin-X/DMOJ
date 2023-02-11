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
		int[] d = new int[n];
		segTree = new Node[4 * n];
		for (int i = 0; i < 4 * n; i ++) segTree[i] = new Node(MX, MX, MX, MX);
		for (int i = 0; i < n; i ++) d[i] = readInt();
		constructTree(d, 0, n - 1, 0);
		
		while (q-- > 0) {
			char ch = readCharacter();
			int a = readInt(), b = readInt();
			
			if (ch == 'S') updateTree(a - 1, 0, n - 1, 0, b);
			else println(getBest(a - 1, b - 1, 0, n - 1, 0));
		}
	}
	
	static void constructTree(int[] arr, int low, int high, int pos) {
		if (low == high) {
			segTree[pos].update(arr[low], arr[low], arr[low], arr[low]);
			return;
		}
		
		int mid = (low + high) / 2;
		constructTree(arr, low, mid, 2 * pos + 1);
		constructTree(arr, mid + 1, high, 2 * pos + 2);
		Node c1 = segTree[2 * pos + 1], c2 = segTree[2 * pos + 2];
		segTree[pos].update(c1.sum + c2.sum, Math.max(c1.prefix, c1.sum + c2.prefix), Math.max(c2.suffix, c2.sum + c1.suffix), Math.max(c1.best, Math.max(c2.best, c1.suffix + c2.prefix)));
	}
	
	static void updateTree(int idx, int low, int high, int pos, int val) {	
		if (low == high) {
			segTree[pos].update(val, val, val, val);
			return;
		}
		
		int mid = (low + high) / 2;
		if (idx >= low && idx <= mid) updateTree(idx, low, mid, 2 * pos + 1, val);
		else updateTree(idx, mid + 1, high, 2 * pos + 2, val);
		Node c1 = segTree[2 * pos + 1], c2 = segTree[2 * pos + 2];
		segTree[pos].update(c1.sum + c2.sum, Math.max(c1.prefix, c1.sum + c2.prefix), Math.max(c2.suffix, c2.sum + c1.suffix), Math.max(c1.best, Math.max(c2.best, c1.suffix + c2.prefix)));
	}
	
	static long getBest(int l, int r, int low, int high, int pos) {
		if (l <= low && r >= high) return segTree[pos].best;
		else if (l > high || r < low) return MX;
		int mid = (low + high) / 2;
		
		long val1 = getBest(l, r, low, mid, 2 * pos + 1), val2 = getBest(l, r, mid + 1, high, 2 * pos + 2);
		if (r <= mid) return val1;
		else if (l > mid) return val2;
		else return Math.max(val1, Math.max(val2, getBestSuffix(l, r, low, mid, 2 * pos + 1) + getBestPrefix(l, r, mid + 1, high, 2 * pos + 2)));
	}
	
	static long getBestPrefix(int l, int r, int low, int high, int pos) {
		if (l <= low && r >= high) return segTree[pos].prefix;	
		int mid = (low + high) / 2;
		return r <= mid ? getBestPrefix(l, r, low, mid, 2 * pos + 1) : Math.max(getBestPrefix(l, r, low, mid, 2 * pos + 1), segTree[pos * 2 + 1].sum + getBestPrefix(l, r, mid + 1, high, 2 * pos + 2));
	}
	
	static long getBestSuffix(int l, int r, int low, int high, int pos) {
		if (l <= low && r >= high) return segTree[pos].suffix;
		int mid = (low + high) / 2;
		return l > mid ? getBestSuffix(l, r, mid + 1, high, 2 * pos + 2) : Math.max(getBestSuffix(l, r, mid + 1, high, 2 * pos + 2), segTree[pos * 2 + 2].sum + getBestSuffix(l, r, low, mid, 2 * pos + 1));
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
