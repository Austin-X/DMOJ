import java.io.*;
import java.util.*;

public class CycleSort {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] a = new int[n];
		int oneIdx = 0, twoIdx = -1;
		for (int i = 0; i < n; i ++) {
			a[i] = readInt();
			if (a[i] == 1) oneIdx = i;
			if (a[i] == 2) twoIdx = i;
		}
		
		int[] b = new int[n]; int idx = 0;
		for (int i = oneIdx; i < n; i ++)  b[idx++] = a[i];
		for (int i = 0; i < oneIdx; i ++) b[idx++] = a[i];
		int min = -1, swapIdx = -1;
		for (idx = 0; idx < n; idx ++) if (b[idx] != idx + 1) { min = idx + 1; swapIdx = idx; break; }
		for (; idx < n; idx ++) if (b[idx] == min) { b[idx] = b[swapIdx]; b[swapIdx] = min; break; }
		if (lexLess(a, b, n)) b = Arrays.copyOf(a, n);

		if (twoIdx != -1) {
			idx = twoIdx == 0 ? n - 1 : twoIdx - 1;
			int temp = a[idx];
			a[idx] = 1; a[oneIdx] = temp;
			int[] c = new int[n];
			for (int j = 0; j < n; j ++) { c[j] = a[idx++]; idx %= n; }
			if (lexLess(c, b, n)) b = Arrays.copyOf(c, n);
			a[idx] = temp; a[oneIdx] = 1;
			a[oneIdx] = 2; a[twoIdx] = 1; idx = twoIdx;
			c = new int[n];
			for (int j = 0; j < n; j ++) { c[j] = a[idx++]; idx %= n; }
			if (lexLess(c, b, n)) b = Arrays.copyOf(c, n);
		}
		
		for (int i = 0; i < n; i ++) System.out.print(i != n - 1 ? b[i] + " " : b[i] + "\n");
	}
	
	public static boolean lexLess(int[] a, int[] b, int n) {
		for (int i = 0; i < n; i ++) {
			if (a[i] < b[i]) return true;
			else if (a[i] > b[i]) return false;
		}
		return false;
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
