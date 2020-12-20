import java.io.*;
import java.util.*;

public class DynamicRangeMinimumTest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[] segTree;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) arr[i] = readInt();
		segTree = new int[4 * n];
		
		constructSegTree(arr, 0, n - 1, 0);
		
		for (int i = 0; i < m; i ++) {
			char ch = readCharacter();
			int x = readInt(), y = readInt();
			if (ch == 'M') updateSegTree(arr, x, y, 0, n - 1, 0);
			else System.out.println(rmq(x, y, 0, n - 1, 0));
		}
	}
	
	static int constructSegTree(int[] arr, int low, int high, int pos) {
		if (low == high) return segTree[pos] = arr[low];
		
		int mid = (low + high) / 2;
		segTree[pos] = Math.min(constructSegTree(arr, low, mid, pos * 2 + 1), constructSegTree(arr, mid + 1, high, pos * 2 + 2));
		return segTree[pos];
	}
	
	static int updateSegTree(int[] arr, int idx, int val, int low, int high, int pos) {
		if (low == high) return segTree[pos] = val;
		
		int mid = (low + high) / 2;
		if (idx <= mid) segTree[pos] = Math.min(segTree[pos * 2 + 2], updateSegTree(arr, idx, val, low, mid, pos * 2 + 1));
		else segTree[pos] = Math.min(segTree[pos * 2 + 1], updateSegTree(arr, idx, val, mid + 1, high, pos * 2 + 2));
		
		return segTree[pos];
	}
	
	static int rmq(int userLow, int userHigh, int low, int high, int pos) {
		int mid = (low + high) / 2;
		if (userLow <= low && userHigh >= high) return segTree[pos];
		if (userLow > mid) return rmq(userLow, userHigh, mid + 1, high, pos * 2 + 2);
		else if (userHigh <= mid) return rmq(userLow, userHigh, low, mid, pos * 2 + 1);
		else return Math.min(rmq(userLow, userHigh, low, mid, pos * 2 + 1), rmq(userLow, userHigh, mid + 1, high, pos * 2 + 2));
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
