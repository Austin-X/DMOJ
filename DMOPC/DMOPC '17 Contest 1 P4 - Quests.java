import java.io.*;
import java.util.*;

public class Quests {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken());
		int[] g = new int[N], h = new int[N], q = new int[N], t = new int[N];
		for (int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			g[i] = Integer.parseInt(st.nextToken()); h[i] = Integer.parseInt(st.nextToken()); q[i] = Integer.parseInt(st.nextToken()); t[i] = Integer.parseInt(st.nextToken());		
		}
		
		long[][] dp = new long[2][H + 1];
		Arrays.fill(dp[0], -1);
		dp[0][0] = 0;
		
		for (int i = 0; i < N; i ++) {
			for (int j = H - h[i]; j >= 0; j --) {
				if (dp[0][j] != -1) dp[1][j + h[i]] = dp[0][j] + g[i]; 
			}
			for (int j = h[i] + t[i]; j <= H; j ++) {
				if (dp[1][j - t[i]] != 0) dp[1][j] = Math.max(dp[1][j], dp[1][j - t[i]] + q[i]);
			}
			for (int j = 0; j <= H; j ++) {
				dp[0][j] = Math.max(dp[0][j], dp[1][j]);
				if (dp[1][j] > 0) dp[1][j] = 0;
			}
		}

		long max = 0;
		for (long x : dp[0]) max = Math.max(max, x);
		System.out.println(max);
	}
}
