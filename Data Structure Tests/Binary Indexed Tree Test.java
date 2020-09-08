import java.io.*;
import java.util.*;

public class BinaryIndexedTreeTest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int MV = 100000;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		long[] sum = new long[n + 1], freq = new long[MV + 1]; int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i ++) { int x = readInt(); arr[i] = x; updateBITree(i, x, n, sum); updateBITree(x, 1, MV, freq); }
		for (int i = 0; i < m; i ++) {
			char c = readCharacter();
			if (c == 'C') {
				int x = readInt(), v = readInt();
				updateBITree(x, v - arr[x], n, sum);
				updateBITree(arr[x], -1, MV, freq);
				updateBITree(v, 1, MV, freq);
				arr[x] = v;
			} else if (c == 'S') System.out.println(-solve(readInt() - 1, sum) + solve(readInt(), sum));
			else System.out.println(solve(readInt(), freq));
		}
	}
	
	static void updateBITree(int idx, int val, int max, long[] BITree) {
		while (idx <= max) {
			BITree[idx] += val;
			idx += idx & (-idx);
		}
	}
	
	static long solve(int idx, long[] BITree) {
		long ans = 0;
		while (idx != 0) {
			ans += BITree[idx];
			idx -= idx & (-idx);
		}
		return ans;
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
