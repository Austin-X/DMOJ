import java.io.*;
import java.util.*;

public class AQTAndFractions {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			long a = readLong(), b = readLong(), gcd = gcd(a, b);
			a /= gcd; b /= gcd;
			
			long tempB = b;
			while (tempB % 2 == 0 || tempB % 5 == 0) {
				if (tempB % 2 == 0) tempB /= 2;
				else tempB /= 5;
			}
			if (tempB != 1) System.out.println(-1);
			else {
				int twoCnt = 0, fiveCnt = 0;
				while (b % 2 == 0 || b % 5 == 0) {
					if (b % 2 == 0) { b /= 2; twoCnt ++; }
					else { b /= 5; fiveCnt ++; }
				}
				System.out.println(Math.max(twoCnt, fiveCnt));
			}
		}
	}
	
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
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
