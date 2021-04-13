import java.io.*;
import java.util.*;

public class BeautifulGrids {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		long n = readLong(), m = readLong();
		int k = readInt();
		
		HashSet<Long> rows = new HashSet<Long>(), cols = new HashSet<Long>();
		
		for (int i = 0; i < k; i ++) {
			long x = readLong(), y = readLong();
			
			if (rows.contains(x)) rows.remove(x);
			else rows.add(x);
			if (cols.contains(y)) cols.remove(y);
			else cols.add(y);
		}
		
		System.out.println(Math.max(rows.size(), cols.size()));
		Queue<Long> r = new LinkedList<Long>(), c = new LinkedList<Long>();
		for (long x : rows) r.add(x);
		for (long x : cols) c.add(x);

		while (!r.isEmpty() && !c.isEmpty()) System.out.println(r.poll() + " " + c.poll());
		for (long x: r) System.out.println(x + " " + 1);
		for (long x: c) System.out.println(1 + " " + x);
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
