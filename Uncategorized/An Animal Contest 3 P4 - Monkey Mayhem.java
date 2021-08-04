import java.io.*;
import java.util.*;

public class MonkeyMayhem {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), ans = 0;
		
		HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i ++) {
			int x = readInt();
			if (x != -1) {
				freq.putIfAbsent(x - i, 0);
				freq.put(x - i, freq.get(x - i) + 1);
			}
		}
		for (int i = 0; i < m; i ++) {
			int val = readInt() - i;
			if (val + i != -1 && freq.containsKey(val)) {
				freq.put(val, freq.get(val) - 1);
				if (freq.get(val) == 0) freq.remove(val);
				ans ++;
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
