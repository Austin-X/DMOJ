import java.io.*;
import java.util.*;

public class MightyCactus {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), k = readInt();
		int[] t = new int[k], a = new int[k], psa = new int[200001];
		for (int i = 0; i < k; i ++) {
			t[i] = readInt(); a[i] = readInt();
		}
		double h = n; int maxTime = 0;
		for (int i = 0; i < m; i ++) {
			int s = readInt(), l = readInt(), x = readInt();
			psa[s] += x; psa[s + l] -= x; maxTime = Math.max(maxTime, s + l - 1);
		} 
		for (int i = 1; i <= maxTime; i ++) psa[i] += psa[i - 1];

		for (int i = 0; i <= maxTime; i ++) {
			int damage = i == 0 ? psa[0] : psa[i];
			double reduced = damage;
			for (int j = 0; j < k; j ++) {
				reduced = Math.min(reduced, Math.max(0, (damage - t[j]) - (double)(damage - t[j]) / 100 * a[j]));
			}
			h -= reduced; if (h < 0) { System.out.println("Act Like A Cactus."); System.exit(0); }
		}
		System.out.format("%.2f %n", h);
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
