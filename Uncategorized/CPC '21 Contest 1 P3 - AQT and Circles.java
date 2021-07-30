import java.io.*;
import java.util.*;

public class AQTAndCircles {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int r1 = readInt(), r2 = readInt(), r3 = readInt();
			int val = (r2 - r3) * (r2 - r3) - (r1 + r3) * (r1 + r3), diff = val > 0 ? val : 0;
			
			double ans;
			if (r3 < r1) ans = (double)((r1 - r3) * (r1 - r3) + diff) / ((r2 - r3) * (r2 - r3));
			else if (r1 == r3) ans = (double)diff / ((r2 - r3) * (r2 - r3));
			else ans = (double)(Math.min((r2 - r3) * (r2 - r3), (r3 - r1) * (r3 - r1)) + diff) / ((r2 - r3) * (r2 - r3));
			System.out.printf("%.3f %n", ans);
		}
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
