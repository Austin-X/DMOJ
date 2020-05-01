import java.io.*;
import java.util.*;

public class Bond {
	static int n;
	static double[][] jimmy;
	static double[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		jimmy = new double[n][n];
		
		dp = new double[1 << n];
		Arrays.fill(dp, -1);
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j ++) {
				jimmy[i][j] = Integer.parseInt(st.nextToken()) / (double)100;
			}
		}
		
		System.out.format("%.6f %n", recurse(0, (1 << n) - 1) * 100);
	}
	
	static double recurse(int idx, int bitmask) {
		if (idx == n) return 1; 
		if (dp[bitmask] != -1) return dp[bitmask]; 
		
		double max = 0;
		for (int i = 0; i < n; i ++) {
			int x = bitmask & (1 << i);
			double cur;
			if (x > 0) {
				cur = jimmy[idx][i] * recurse(idx + 1, bitmask ^ (1 << i));
				max = Math.max(max, cur);
			}
		}
		
		return dp[bitmask] = max;
	}
}
