import java.io.*;
import java.util.*;

public class PhantomFight {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static final int MV = 5000;
	public static void main(String[] args) throws IOException {
		int n = readInt(), M = readInt();
		int[] s = new int[n + 1], m = new int[n + 1];
		for (int i = 1; i <= n; i ++) { s[i] = readInt(); m[i] = readInt(); }
		int[] dp = new int[MV + 1]; Arrays.fill(dp, -1); dp[0] = M;
		
		for (int i = 1; i <= n; i ++) {
			for (int j = MV; j >= 0; j --) {
				if (dp[j] != -1 && dp[j] - s[i] >= 0) dp[j + 1] = Math.max(dp[j + 1], dp[j] - s[i] + m[i]);
			}
		}

		int ghost = -1, magic = -1;
		for (int i = 0; i <= MV; i ++) {
			if (i > ghost && dp[i] != -1) {
				ghost = i;
				magic = dp[i];
			}
		}
		System.out.println(ghost + " " + magic);
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
