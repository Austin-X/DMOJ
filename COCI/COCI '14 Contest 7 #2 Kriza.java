import java.io.*;
import java.util.*;

public class Kriza {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt(), curIdx = 1;
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i ++) arr[readInt()] = i;
		long ans = 0;
		int temp = 0;
		if (arr[1] < curIdx) { temp = (n - curIdx) + arr[1]; curIdx = arr[1]; }
		else { temp = arr[1] - curIdx; curIdx = arr[1]; }
		for (int i = 2; i <= n && i <= k; i ++) {
			if (arr[i] < curIdx) { ans += (n - curIdx) + arr[i]; curIdx = arr[i]; }
			else { ans += arr[i] - curIdx; curIdx = arr[i]; }
		}

		if (k > n) {
			ans *= (k / n);
			int add;
			if (arr[1] < curIdx) { add = (n - curIdx) + arr[1]; curIdx = arr[1]; }
			else { add = arr[1] - curIdx; curIdx = arr[1]; }
			add *= ((k - 1) / n);
			ans += add;

			for (int i = 2; i <= k % n; i ++) {
				if (arr[i] < curIdx) { ans += (n - curIdx) + arr[i]; curIdx = arr[i]; }
				else { ans += arr[i] - curIdx; curIdx = arr[i]; }
			}
		}
		System.out.println(ans + temp);
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
