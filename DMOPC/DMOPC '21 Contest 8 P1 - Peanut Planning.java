import java.io.*;
import java.util.*;

public class PeanutPlanning {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i ++) {
			int x = readInt();
			map.putIfAbsent(x, 0);
			map.put(x, map.get(x) + 1);
		}

		int[] ans = new int[n];
		int k = map.firstKey();
		ans[0] = k;
		map.put(k, map.get(k) - 1);
		if (map.get(k) == 0) map.remove(k);
		
		for (int i = 1; i < n; i ++){
			if (map.ceilingKey(m - ans[i - 1]) == null) { System.out.println(-1); return; }
			k = map.ceilingKey(m - ans[i - 1]);
			ans[i] = k;
			map.put(k, map.get(k) - 1);
			if (map.get(k) == 0) map.remove(k);
		}
		
		for (int i = 0; i < n; i ++) System.out.print(i == n - 1 ? ans[i] + "\n" : ans[i] + " ");
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
