import java.io.*;
import java.util.*;

public class SharingCrayons {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		long[] psa = new long[n];
		for (int i = 0; i < n; i ++) psa[i] = i == 0 ? readInt() : psa[i - 1] + readInt();;
		long ans = 0;
		HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();
		cnt.put(0, 1);
		for (int i = 0; i < n; i ++) {
			int diff = (int) (psa[i] % m);
			ans += cnt.getOrDefault(diff, 0);
			cnt.putIfAbsent(diff, 0);
			cnt.put(diff, cnt.get(diff) + 1);
		}
		System.out.println(ans);
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
