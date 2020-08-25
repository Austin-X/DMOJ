import java.io.*;
import java.util.*;

public class Wireless {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int m = readInt(), n = readInt(), k = readInt();
		int[][] psa = new int[m + 1][n + 1];
		for (int i = 0; i < k; i ++) {
			int x = readInt(), y = readInt(), r = readInt(), b = readInt();
			int low = x - r < 1 ? 1 : x - r, high = x + r > n ? n : x + r;
			for (int j = low; j <= high; j ++) {
				int diff = (int) Math.sqrt(r * r - (j - x) * (j - x));
				int lowUpdate, highUpdate;
				if (y - diff < 1) lowUpdate = 1;
				else lowUpdate = y - diff;
				psa[lowUpdate][j] += b;
				highUpdate = y + diff + 1;
				if (highUpdate <= m) psa[highUpdate][j] -= b;
			}
		}
		
		int max = 0, maxCnt = 0;
		for (int i = 1; i <= n; i ++) {
			for (int j = 1; j <= m; j ++) {
				psa[j][i] += psa[j - 1][i];
				if (psa[j][i] > max) { max = psa[j][i]; maxCnt = 1; }
				else if (psa[j][i] == max) maxCnt ++;
			}
		}
		System.out.println(max);
		System.out.println(maxCnt);
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
