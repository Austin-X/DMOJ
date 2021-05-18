import java.io.*;
import java.util.*;

public class Kompicl {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	private static final int MV = 1024;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		
		long ans = 0;
		int[] res = new int[MV];
		for (int i = 0; i < n; i ++) {
			long x = readLong();
			int mask = 0;
			while (x > 0) {
				int rem = (int) (x % 10);
				mask |= (1 << rem);
				x /= 10;
			}
			res[mask] ++;
 		}

		for (int i = 0; i < MV; i ++) {
			for (int j = i + 1; j < MV; j ++) {
				if ((i & j) > 0) ans += res[i] * res[j];
			}
		}
		
		for (int i = 0; i < MV; i ++) ans += (long)res[i] * (res[i] - 1) / 2;
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
