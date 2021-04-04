import java.io.*;
import java.util.*;

public class KeenKeenerSequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) arr[i] = readInt();
		
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		
		int[][] freq = new int[n][n];

		for (int i = 0; i < n; i ++) {
			ArrayList<Long> temp = new ArrayList<Long>();
			HashMap<Long, Integer> h = new HashMap<Long, Integer>();
			
			for (int j = 0; j < n; j ++) {
				if (j != i) temp.add((long)arr[i] * arr[j]);
			}
			
			for (int j = i + 1; j < n; j ++) {
				long prod = (long)arr[i] * arr[j];
				map.putIfAbsent(prod, 0);
				map.put(prod, map.get(prod) + 1);
			}
			
			Collections.sort(temp);
			int cnt = 0; long cur = -1;
			for (long x : temp) {
				if (cur == -1) { cur = x; cnt = 1; }
				else if (x == cur) cnt ++;
				else {
					h.put(cur, cnt);
					cur = x;
					cnt = 1;
				}
			}
			if (cnt > 0) {
				h.put(temp.get(temp.size() - 1), cnt);
			}
			
			for (int j = 0; j < n; j ++) {
				if (j != i) {
					long prod = (long)arr[i] * arr[j];
					freq[i][j] = h.get(prod);
				}
			}
		}
		
		long ans = 0;
		for (int i = 0; i < n; i ++) {
			for (int j = i + 1; j < n; j ++) {
				long prod = (long)arr[i] * arr[j];
				int unique = map.get(prod) - freq[i][j] - freq[j][i] + 1;

				ans += unique * 4;
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
