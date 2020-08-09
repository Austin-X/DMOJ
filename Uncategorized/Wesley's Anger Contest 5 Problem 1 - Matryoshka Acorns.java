import java.io.*;
import java.util.*;

public class MatryoshkaAcorns {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(); ArrayList<Integer> acorns = new ArrayList<Integer>();
		for (int i = 0; i < n; i ++) acorns.add(readInt());
		Collections.sort(acorns);
		int ans = 0;
		while (!acorns.isEmpty()) {
			ans += acorns.get(acorns.size() - 1);
			int prev = acorns.remove(acorns.size() - 1);
			for (int i = acorns.size() - 1; i >= 0; i --) {
				if (acorns.get(i) != prev) {
					prev = acorns.remove(i);
				}
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
