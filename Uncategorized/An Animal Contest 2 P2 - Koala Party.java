import java.io.*;
import java.util.*;

public class KoalaParty {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), ans = 1;

		HashSet<Integer> set = new HashSet<Integer>();
		int[] a = new int[n];
		for (int i = 0; i < n; i ++) {
			a[i] = readInt();
			set.add(a[i]);
		}
		
		if (n > 2) ans = 2;
		else if (n == 2 && (a[0] + a[1]) % 2 == 0) ans = 2;
		
		outerloop: for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				if (i == j) continue;
				if (a[i] > a[j] && set.contains(2 * a[j] - a[i])) { ans = 3; break outerloop; }
			}
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
