import java.io.*;
import java.util.*;

public class BobAndCanada {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt(), ans = 0;
			char[] ch = readLine().toCharArray();
	
			if (ch[0] == 'W') ans ++;
			if (ch[n - 1] == 'W') ans ++;
			
			int temp = 0, totalWCnt = 0, best = Integer.MAX_VALUE;
			for (int i = 1; i < n - 1; i ++) if (ch[i] == 'W') totalWCnt ++;
			
			for (int i = 1; i < n - 1; i ++) {
				if (temp == 0) {
					if (ch[i] == 'W') {
						temp ++;
						best = Math.min(best, totalWCnt - temp);
					}
				} else {
					if (ch[i] == 'R') temp --;
					else {
						temp ++;
						best = Math.min(best, totalWCnt - temp);
					}
				}
			}
			if (best == Integer.MAX_VALUE) ans ++;
			else ans += best;
			System.out.println(ans);
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
