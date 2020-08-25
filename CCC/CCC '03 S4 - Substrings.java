import java.util.*;
import java.io.*;

public class Substrings {
	static class Pair implements Comparable<Pair> {
		int x, y, idx;
		Pair (int x, int y, int idx) { this.x = x; this.y = y; this.idx = idx; }

		public int compareTo(Pair p) {
			if (x == p.x) return Integer.compare(y, p.y);
			else return Integer.compare(x, p.x);
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();

		for (int t = 0; t < n; t ++) {
			char[] str = readLine().toCharArray(); int l = str.length;
			
			Pair[] p = new Pair[l];
			for (int i = 0; i < l; i ++) {
				if (i == l - 1) p[i] = new Pair(str[i], -1, i);
				else p[i] = new Pair(str[i], str[i + 1], i);
			}
			
			boolean flag = true; int mult = 2; int[] suffixArr = new int[l];
			while (flag) {
				Arrays.sort(p);	
				int idx = 0; flag = false;

				for (int i = 0; i < l; i ++) {
					if (i == 0) suffixArr[p[i].idx] = idx;
					else {
						if (p[i].x == p[i - 1].x && p[i].y == p[i - 1].y) { suffixArr[p[i].idx] = idx; flag = true; }
						else { idx ++; suffixArr[p[i].idx] = idx; }
					}
				}

				if (!flag) break;
				for (int i = 0; i < l; i ++) {
					if (i + mult >= l) p[i] = new Pair(suffixArr[i], -1, i);
					else p[i] = new Pair(suffixArr[i], suffixArr[i + mult], i);
				}
				mult *= 2;
			}
			
			long[] hsh = new long[l + 1], pow = new long[l + 1]; int seed = 131; pow[0] = 1;
			for (int i = 1; i <= l; i ++) {
				hsh[i] = hsh[i - 1] * seed + str[i - 1];
				pow[i] = pow[i - 1] * seed;
			}
			int[] ansArr = new int[l];
			for (int i = 0; i < l; i ++) ansArr[suffixArr[i]] = i;
			
			int ans = l - ansArr[0];
			for (int i = 1; i < l; i ++) {
				int idx = ansArr[i] + 1, prevIdx = ansArr[i - 1] + 1;
				int low = idx, high = l;
				while (low != high) {
					int mid = (low + high) / 2;
					if (prevIdx + (mid - idx) > l) high = mid;
					else if (hsh[mid] - hsh[idx - 1] * pow[mid - idx + 1] == hsh[prevIdx + (mid - idx)] - hsh[prevIdx - 1] * pow[mid - idx + 1]) low = mid + 1;
					else high = mid;
				}
				ans += l - low + 1;
			}
			System.out.println(ans + 1);
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
