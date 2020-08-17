import java.io.*;
import java.util.*;

public class LexicographicallyLeastSubstringHard {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		String s = readLine();
		char[] str = s.toCharArray(); int k = readInt();
		
		long[] hsh = new long[str.length + 1], pow = new long[str.length + 1]; int seed = 131; pow[0] = 1;
		for (int i = 1; i <= str.length; i ++) {
			hsh[i] = hsh[i - 1] * seed + str[i - 1];
			pow[i] = pow[i - 1] * seed;
		}
		char min = '{'; int ans = -1;
		for (int i = 0; i <= str.length - k; i ++) if (str[i] < min) min = str[i];
		for (int i = 1; i <= str.length - k + 1; i ++) {
			if (str[i - 1] != min) continue;
			if (ans == -1) { ans = i - 1; continue; }
			int low = i, high = i + k - 1; int mismatchIdx = 0;
			while (low < high) {
				int mid = (low + high) / 2;
				if (hsh[mid] - hsh[i - 1] * pow[mid - i + 1] == hsh[ans + mid - i + 1] - hsh[ans] * pow[mid - i + 1]) { mismatchIdx = mid + 1; low = mid + 1; }
				else { mismatchIdx = mid; high = mid; }
			}
			if (str[mismatchIdx - 1] < str[ans + mismatchIdx - i]) ans = i - 1;
		}
		System.out.println(s.substring(ans, ans + k));
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
