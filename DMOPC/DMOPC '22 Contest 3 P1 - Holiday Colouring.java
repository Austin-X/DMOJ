import java.io.*;
import java.util.*;

public class HolidayColouring {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		long n = readLong(), m = readLong();
		long min = Math.min(m, n), max = Math.max(m, n);
		if (n == 1) System.out.println((int)Math.ceil((double)m/2) + " " + (int)Math.floor((double)m/2));
		else if (m == 1) System.out.println((int)Math.ceil((double)n/2) + " " + (int)Math.floor((double)n/2));
		else if (n % 2 == 1 && m % 2 == 1) System.out.println(min * (max + 1) / 2 + " " + min * (max - 1) / 2);
		else System.out.println(m * n / 2 + " " + m * n / 2);
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
