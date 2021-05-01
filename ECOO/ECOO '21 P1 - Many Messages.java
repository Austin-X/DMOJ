import java.io.*;
import java.util.*;

public class ManyMessages {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int start = readInt(), interval = readInt(), larry = readInt();
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = start + interval; i <= start + interval * 3; i += interval) set.add(i);
		if (set.ceiling(larry) == null) System.out.println("Who knows...");
		else System.out.println(set.ceiling(larry));
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
