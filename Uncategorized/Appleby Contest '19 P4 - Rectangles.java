import java.io.*;
import java.util.*;

public class Rectangles {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		@SuppressWarnings("unchecked")
		HashSet<Integer>[] xCoors = new HashSet[40002], yCoors = new HashSet[40002];
		for (int i = 0; i <= 40001; i ++) {
			xCoors[i] = new HashSet<Integer>(); yCoors[i] = new HashSet<Integer>();
		}

		int[] x = new int[n], y = new int[n];
		for (int i = 0; i < n; i ++) {
			x[i] = readInt() + 20000; y[i] = readInt() + 20000;
			xCoors[y[i]].add(x[i]); 
			yCoors[x[i]].add(y[i]);
		}
		
		int ans = 0;
		for (int i = 0; i < n; i ++) {
			for (int num : xCoors[y[i]]) {
				if (num > x[i]) {
					for (int yPos : yCoors[x[i]]) {
						if (xCoors[yPos].contains(num)) ans = Math.max(ans, (num - x[i]) * (yPos - y[i]));
					}
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
