import java.io.*;
import java.util.*;

public class SquirrelElection {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
	    int[] v = new int[n + 1], p = new int[n + 1];
	    int sum = 0;
		
		for (int i = 1; i <= n; i ++) {
			st = new StringTokenizer(br.readLine());
			v[i] = Integer.parseInt(st.nextToken()) / 2 + 1;
			p[i] = Integer.parseInt(st.nextToken());
			sum += p[i];
		}
		
		long[][] dp = new long[n + 1][sum + 1];
		for (long[] x : dp) Arrays.fill(x, Long.MAX_VALUE);
		
		int cur = 0;
		for (int i = 1; i <= n; i ++) {
			cur += p[i];
			for (int j = 0; j <= cur; j ++) {
				if (j > p[i]) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - p[i]] + v[i]);
				}
				else {
					dp[i][j] = Math.min(dp[i - 1][j], v[i]);
				}
			}
		}
		
		System.out.println(dp[n][sum / 2 + 1]);
	}
}
