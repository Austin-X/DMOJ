import java.io.*;
import java.util.*;

public class Matching {
	static final int MOD = 1000000007;
	static int[][] arr;
	static int n;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[1 << n];
		Arrays.fill(dp, -1);
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j ++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(compute(0, (1 << n) - 1));
	}
	
	static int compute(int idx, int bitmask) {
		if (idx == n) return 1;
		if (dp[bitmask] != -1) return dp[bitmask];
		
		int cn = 0;
		for (int i = 0; i < n; i ++) {
			int x = bitmask & (1 << i);
			if (x > 0 && arr[idx][i] == 1) {
				cn += compute(idx + 1, bitmask ^ (1 << i));
				cn %= MOD;
			}
		}
		
		return dp[bitmask] = cn;
	}
}
