import java.io.*;
import java.util.*;

public class HackerSoup {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt(), q = readInt();

		int[][] rot = new int[k][4];
		for (int i = 0; i < k; i ++) {
			int a = readInt(), b = readInt(), c = readInt(), d = readInt();
			rot[i][0] = a; rot[i][1] = b; rot[i][2] = c; rot[i][3] = d;			
		}
		
		while (q-- > 0) {
			int r = readInt(), c = readInt();
			for (int i = k - 1; i >= 0; i --) {
				if (r < rot[i][0] || r > rot[i][2] || c < rot[i][1] || c > rot[i][3]) continue;
				int newRow = rot[i][0] + rot[i][3] - c;
				int newCol = rot[i][1] + r - rot[i][0];
				r = newRow;
				c = newCol;
			}
			System.out.println((long)(r - 1) * n + c);
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
