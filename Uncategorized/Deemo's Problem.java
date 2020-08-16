import java.io.*;
import java.util.*;

public class DeemosProblem {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), seed = 131;
		long sum = 0;
		long[] w = new long[m + 1]; w[0] = 1;
		for (int i = 1; i <= m; i ++) {
			w[i] = w[i - 1] * seed;
			sum += w[i];
		}
		long psa = 0, ans = 0; 
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		map.put(0L, 1);
		int[] freq1 = new int[m + 1], freq2 = new int[n + 1];
		for (int i = 1; i <= n; i ++) {
			int x = readInt();
			psa += w[x];
			freq1[x] ++; freq2[freq1[x]] ++;
			if (freq2[freq1[x]] == m) psa -= sum;
			
			ans += map.getOrDefault(psa, 0);
			map.putIfAbsent(psa, 0);
			map.put(psa, map.get(psa) + 1);
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
