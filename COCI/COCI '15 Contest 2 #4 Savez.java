import java.io.*;
import java.util.*;

public class Savez {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		for (int t = 0; t < n; t ++) {
			String str = readLine();
			int l = str.length(); long[] hsh = new long[l + 1], pow = new long[l + 1]; int seed = 131;
			pow[0] = 1;
			int temp = 1;
			for (int i = 1; i <= l; i ++) {
				hsh[i] = hsh[i - 1] * seed + str.charAt(i - 1);
				pow[i] = pow[i - 1] * seed;
			}
			for (int i = 1; i <= l; i ++) {
				long prefixHash = hsh[i], suffixHash = hsh[l] - hsh[l - i] * pow[i]; 
				if (prefixHash == suffixHash && map.containsKey(prefixHash)) temp = Math.max(temp, map.get(prefixHash) + 1);
			}
			map.put(hsh[l], temp);
		}
		int ans = 0;
		for (long x : map.keySet()) ans = Math.max(ans, map.get(x));
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
