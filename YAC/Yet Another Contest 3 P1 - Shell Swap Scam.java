import java.io.*;
import java.util.*;

public class ShellSwapScam {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), a = readInt(), b = readInt();
		int[][] ans = new int[m][2];
		for (int i = 0; i < m; i ++) {
			int x = readInt();
			if (x == -1) ans[i][0] = -1;
			else {
				ans[i][0] = x;
				ans[i][1] = readInt();
			}
		}
		
		int idx = 0;
		for (int i = 0; i < m; i ++) {
			if (ans[i][0] == -1) { idx = i; break; }
			if (a == ans[i][0]) a = ans[i][1];
			else if (a == ans[i][1]) a = ans[i][0];
		}
		
		for (int i = m - 1; i >= idx + 1; i --) {
			if (ans[i][0] == -1) {
				ans[i][0] = b - 1;
				ans[i][1] = b + 1;
				if (ans[i][0] == 0) ans[i][0] = n;
				if (ans[i][1] == n + 1) ans[i][1] = 1;
			} else {
				if (b == ans[i][0]) b = ans[i][1];
				else if (b == ans[i][1]) b = ans[i][0];
			}
		}
		
		if (a == b) {
			ans[idx][0] = b - 1;
			ans[idx][1] = b + 1;
			if (ans[idx][0] == 0) ans[idx][0] = n;
			if (ans[idx][1] == n + 1) ans[idx][1] = 1;
		} else {
			ans[idx][0] = b;
			ans[idx][1] = a;
		}
		
		for (int i = 0; i < m; i ++) System.out.println(ans[i][0] + " " + ans[i][1]);
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
