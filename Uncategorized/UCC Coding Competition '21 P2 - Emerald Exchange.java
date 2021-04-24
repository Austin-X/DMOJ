import java.io.*;
import java.util.*;

public class EmeraldExchange {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int best = 0, temp = 0;
		for (int i = 0; i < n; i ++) {
			int x = readInt();
			if (x % 2 == 0) temp += x;
			else {
				best = Math.max(best, temp);
				temp = 0;
			}
		}	
		best = Math.max(best, temp);
		
		System.out.println(best);
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
