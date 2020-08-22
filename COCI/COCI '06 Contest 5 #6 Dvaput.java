import java.io.*;
import java.util.*;

public class Dvaput {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static final int MOD = 200003, seed = 31;
	public static void main(String[] args) throws IOException {
		int l = readInt();
		String s = readLine();
		char[] str = s.toCharArray();
		
		int[] hsh = new int[l + 1], pow = new int[l + 1]; pow[0] = 1;
		for (int i = 1; i <= l; i ++) {
			hsh[i] = (hsh[i - 1] * seed + str[i - 1]) % MOD;
			pow[i] = (pow[i - 1] * seed) % MOD;
		}

		int low = 1, high = l;
		while (low != high) {
			int mid = (low + high) / 2;
			
			boolean flag = false;
			@SuppressWarnings("unchecked")
			ArrayList<Integer>[] hshTable = new ArrayList[MOD];
			for (int i = 0; i < MOD; i ++) hshTable[i] = new ArrayList<Integer>();

			for (int i = mid; i <= l; i ++) {
				int val = (int) ((hsh[i] - ((long)hsh[i - mid] * pow[mid]) % MOD));
				if (val < 0) val += MOD;
				
				if (hshTable[val].isEmpty()) hshTable[val].add(i);
				else {
					for (int x : hshTable[val]) {
						flag = true;
						for (int j = x - mid, k = mid; j < x; j ++, k --) {
							if (str[j] != str[i - k]) { flag = false; break; }
						}
						if (flag) break;
					}
					hshTable[val].add(i);
				}
				if (flag) break;
			}
			if (flag) low = mid + 1;
			else high = mid;
		}
		System.out.println(low - 1);
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
