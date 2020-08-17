import java.io.*;
import java.util.*;

public class PowerTiles {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		TreeSet<Integer> arr = new TreeSet<Integer>();
		int idx = 0; 
		while (Math.pow(2, idx) * Math.pow(2, idx) <= 100000000) {
			arr.add((int) Math.pow(2, idx)); idx ++;
		}
		for (int t = 0; t < 5; t ++) {
			int n = readInt(), m = readInt();
			int ans = 0;
			for (int i = 0; i < m;) {
				int val = arr.floor(m - i);
				if (val > n) val = arr.floor(n);
				ans ++;
				int prev = val;
				i += val;
				while (val != n) { ans += (prev / Math.min(prev, arr.floor(n - val))); val += Math.min(prev, arr.floor(n - val));  }	
			}
			System.out.println(ans);
		}
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
