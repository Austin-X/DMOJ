import java.io.*;
import java.util.*;

public class TheDMOJDriveway {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt(), m = readInt();
		Deque<String> driveway = new ArrayDeque<String>();
		for (int i = 0; i < t; i ++ ) {
			String x = next(), c = next();
			if (c.equals("in")) driveway.addLast(x);
			else if (m > 0) {
				if (driveway.peekFirst().equals(x)) { driveway.pollFirst(); m --; }
				else if (driveway.peekLast().equals(x)) driveway.pollLast();
			}
		}
		for (String x : driveway) System.out.println(x);
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
