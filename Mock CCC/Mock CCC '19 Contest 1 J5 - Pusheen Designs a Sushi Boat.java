import java.io.*;
import java.util.*;

public class PusheenDesignsASushiBoat {
	static final int MOD = 998244353;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		long[][] dp = new long[n + 1][k + 1];
		
		int[] cn = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i ++) {
			cn[Integer.parseInt(st.nextToken())] ++;
		}
		
		dp[0][0] = 1;
		
		for (int i = 1; i <= n; i ++) {
			for (int j = 0; j <= k; j ++) {
				if (j == 0) dp[i][j] = 1;
				else dp[i][j] = (dp[i - 1][j] + cn[i] * dp[i - 1][j - 1]) % MOD;
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
