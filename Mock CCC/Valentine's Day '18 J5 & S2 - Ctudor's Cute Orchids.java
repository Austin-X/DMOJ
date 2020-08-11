import java.io.*;
import java.util.*;

public class CtudorsCuteOrchids {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int ans = Integer.MAX_VALUE, n, m;
	static int[] orchid, gift;
	static int[][] deals;
	public static void main(String[] args) throws IOException {
		n = readInt(); m = readInt();
		orchid = new int[n];
		for (int i = 0; i < n; i ++) orchid[i] = readInt();
		deals = new int[m][n + 1];
		for (int i = 0; i < m; i ++) 
			for (int j = 0; j < n + 1; j ++) deals[i][j] = readInt();
		
		gift = new int[n];
		for (int i = 0; i < n; i ++) gift[i] = readInt();
		int[] cn = new int[n];
		recurse(0, cn, 0);
		System.out.println(ans);
	}

	static void recurse(int bitmask, int[] cn, int cost) {
		int temp = cost;
		for (int i = 0; i < n; i ++) {
			if (cn[i] > gift[i]) return;
			else temp += (gift[i] - cn[i]) * orchid[i];
		}
		ans = Math.min(ans, temp);
		
		for (int i = 0; i < m; i ++) {
			int[] cnTemp = Arrays.copyOf(cn, n);
			boolean flag = true;
			for (int j = 0; j < n; j ++) {
				if (cn[j] + deals[i][j + 1] > gift[j]) { flag = false; break; }
				else cnTemp[j] += deals[i][j + 1];
			}
			if (flag && (bitmask | (1 << i)) != bitmask) recurse(bitmask | (1 << i), cnTemp, cost + deals[i][0]);
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
