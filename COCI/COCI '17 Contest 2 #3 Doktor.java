import java.io.*;
import java.util.*;

public class Doktor {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] arr = new int[n + 1], psa = new int[n + 1];
		@SuppressWarnings("unchecked")
		ArrayList<Double>[] adj = new ArrayList[2 * n + 1];
		int[] cnt = new int[2 * n + 1];
		for (int i = 1; i <= 2 * n; i ++) adj[i] = new ArrayList<Double>();
		for (int i = 1; i <= n; i ++) {
			arr[i] = readInt();
			psa[i] = arr[i] == i ? psa[i - 1] + 1 : psa[i - 1];
			if (arr[i] != i) {
				double x = (arr[i] + i) / (double)2;
				adj[arr[i] + i].add(Math.abs(x - i));
				cnt[arr[i] + i] ++;
			}
		}
		for (ArrayList<Double> x : adj) {
			if (x != null) Collections.sort(x, Collections.reverseOrder());
		}
		
		int ans = psa[n], ll = 1, rr = 1;
		for (int i = 2; i <= 2 * n; i ++) {
			int temp = cnt[i];
			for (double x : adj[i]) {
				double val = i / (double)2;
				int best = temp + psa[n] - psa[(int)(val + x)] + psa[(int)(val - x) - 1];
				if (val % 1 == 0) best += psa[(int)val] - psa[(int)(val - 1)];
				if (best > ans) { ans = best; ll = (int)(val - x); rr = (int)(val + x); }
				if (arr[(int)(val + x)] + (int)(val + x) == i && arr[(int)(val - x)] + (int)(val - x) == i) temp -= 2;
				else temp --;
			}
		}
		System.out.println(arr[ll] + " "  + arr[rr]);
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
