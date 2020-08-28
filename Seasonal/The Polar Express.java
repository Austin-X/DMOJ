import java.io.*;
import java.util.*;

public class ThePolarExpress {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		long l = readLong() - 1; String tempR = next(); String tempL = String.valueOf(l); 
		int lenL = tempL.length(), lenR = tempR.length();
		int[] chL = new int[lenL + 1], chR = new int[lenR + 1];
		for (int i = 1; i <= lenL; i ++) chL[i] = Character.getNumericValue(tempL.charAt(i - 1));
		for (int i = 1; i <= lenR; i ++) chR[i] = Character.getNumericValue(tempR.charAt(i - 1));
		
		long[] dp1 = solve(lenR, chR), dp2 = solve(lenL, chL);	
		HashSet<Integer> sums = new HashSet<Integer>();
		for (int i = 1; i <= 162; i ++) if (dp1[i] - dp2[i] > 0) sums.add(i);
		System.out.println(sums.size());
	}
	
	static long[] solve (int length, int[] arr) {
		long[] dp = new long[163]; dp[0] = 1;
		boolean[] possible = new boolean[163]; 
		for (int i = 1; i <= length; i ++) {
			for (int j = 162; j >= 0; j --) {
				if (dp[j] > 0) {
					if (!possible[j]) {
						for (int k = j + 1; k < j + arr[i]; k ++) {
							possible[k] = true;
							dp[k] += dp[j]; 
						}
						dp[j + arr[i]] += dp[j]; 
					} else {
						for (int k = j + 1; k <= j + 9; k ++) {
							possible[k] = true;
							dp[k] += dp[j];
						}
					}
				}
			}
			if (i == 1) possible[0] = true;
		}
		
		return dp;
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
