import java.io.*;
import java.util.*;

public class FourNations1Secret {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), idxAns = 1, length = 1; String s = readLine();
		char[] str = s.toCharArray();
		long[] prefixHsh = new long[n + 1], suffixHsh = new long[n + 2], pow = new long[n + 1]; int seed = 131; pow[0] = 1;
		for (int i = 1; i <= n; i ++) {
			prefixHsh[i] = prefixHsh[i - 1] * seed + str[i - 1];
			pow[i] = pow[i - 1] * seed;
		}
		for (int i = n; i >= 1; i --) suffixHsh[i] = suffixHsh[i + 1] * seed + str[i - 1];

		for (int i = 1; i <= n; i ++) {
			int low = i, high = n + 1;
			while (low != high) {
				int mid = (low + high) / 2;
				if (i - (mid - i) < 0) high = mid;
				else if (prefixHsh[i] - prefixHsh[i - (mid - i)] * pow[mid - i] == suffixHsh[i] - suffixHsh[mid] * pow[mid - i]) low = mid + 1;
				else high = mid;
			}
			if (i - (low - i) >= 0 && prefixHsh[i] - prefixHsh[i - (low - i)] * pow[low - i] == suffixHsh[i] - suffixHsh[low] * pow[low - i]) {
				if ((low - i - 1) * 2 + 1 > length) { length = (low - i - 1) * 2 + 1; idxAns = low - 1; }
			}
			else if ((low - i - 2) * 2 + 1 > length) { length = (low - i - 2) * 2 + 1; idxAns = low - 2; }
			
			if (i != n && str[i - 1] == str[i]) {
				low = i; high = n + 1;
				while (low != high) {
					int mid = (low + high) / 2;
					if (i - (mid - i) < 0 || mid + 1 > n + 1) high = mid;
					else if (prefixHsh[i] - prefixHsh[i - (mid - i)] * pow[mid - i] == suffixHsh[i + 1] - suffixHsh[mid + 1] * pow[mid - i]) low = mid + 1;
					else high = mid;
				}
				if ((low - 1 - i) * 2 > length) { length = (low - 1 - i) * 2 ; idxAns = low - 1; }
			}
		}
		System.out.println(s.substring(idxAns - length, idxAns));
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
