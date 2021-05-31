import java.io.*;
import java.util.*;

public class TugOfWar {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] s = new int[n];
		long mid = 0;
		for (int i = 0; i < n; i ++) { s[i] = readInt(); mid += s[i]; }
		mid /= 2;
		
		TreeSet<Long> set = new TreeSet<Long>();
		long sum = 0;
		for (int i = 0; i < n; i ++) {
			sum += s[i];
			set.add(sum);
		}
		long cnt = 0;
		for (int i = 0; i < n; i ++) {
			long low = Integer.MAX_VALUE, high = Integer.MAX_VALUE;
			if (set.floor(mid + cnt) != null) low = Math.abs(sum - 2 * (set.floor(mid + cnt) - cnt));
			if (set.ceiling(mid + cnt) != null) high = Math.abs(sum - 2 * (set.ceiling(mid + cnt) - cnt));
			pw.print(Math.min(low, high));
			if (i == n - 1) pw.println();
			else pw.print(" ");
			set.add(s[i] + set.last());
			cnt += s[i];
			set.remove(set.first());
		}
		pw.close();
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
