import java.io.*;
import java.util.*;

public class FourNations1Secret {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), idxAns = 0, length = 1; String s = readLine();
		char[] str = s.toCharArray();
		long[] prefixHsh = new long[n + 1], suffixHsh = new long[n + 2], pow = new long[n + 1]; int seed = 131; pow[0] = 1;
		for (int i = 1; i <= n; i ++) {
			prefixHsh[i] = prefixHsh[i - 1] * seed + str[i - 1];
			pow[i] = pow[i - 1] * seed;
		}
		for (int i = n; i >= 1; i --) suffixHsh[i] = suffixHsh[i + 1] * seed + str[i - 1];
		for (int i = 1; i <= n; i ++) {
			int diff = 2, best = 1;
			while (i - diff >= 0 && i + diff <= n + 1) {
				if (prefixHsh[i] - prefixHsh[i - diff] * pow[diff] == suffixHsh[i] - suffixHsh[i + diff] * pow[diff]) { best += 2; diff ++; }
				else break;
			}
			if (best > length) { length = best; idxAns = i - best / 2 - 1; }
			if (i != n && str[i - 1] == str[i]) {
				int low = i, high = i + 1; diff = 1; best = 0;
				while (low - diff >= 0 && high + diff <= n + 1) {
					if (prefixHsh[low] - prefixHsh[low - diff] * pow[diff] == suffixHsh[high] - suffixHsh[high + diff] * pow[diff]) { best += 2; diff ++; }
					else break;
				}
				if (best > length) { length = best; idxAns = i - best / 2; }
			}
		}
		System.out.println(s.substring(idxAns, idxAns + length));
		System.out.println(length);
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
