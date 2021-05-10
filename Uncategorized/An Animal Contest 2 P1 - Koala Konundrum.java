import java.io.*;
import java.util.*;

public class KoalaKonumdrum {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		char[] ch = readLine().toCharArray();
		int[] freq = new int[26];
		for (int i = 0; i < n; i ++) freq[ch[i] - 97] ++;
		int singles = 0, doubles = 0;
		for (int i = 0; i < 26; i ++) {
			doubles += freq[i] / 2;
			singles += freq[i] % 2;
		}
		int ans = 0;
		if (singles > 0 && doubles > 0) {
			ans ++;
			doubles = 0;
			singles --;
		} else if (doubles > 0) {
			ans ++;
			doubles = 0;
		}
		ans += singles;
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
