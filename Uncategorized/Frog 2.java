import java.io.*;
import java.util.*;

public class Frog2 {
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		dp = new int[n];
		int[] heights = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) heights[i] = Integer.parseInt(st.nextToken());
		
		dp[0] = 0;
		if (k > n) k = n;
		for (int i = 1; i < k; i ++) {
			dp[i] = Math.abs(heights[i] - heights[0]);
		}
		System.out.println(solve(heights, n, k));
	}
	
	static int solve(int[] h, int n, int k) {
		for (int i = k; i < n; i ++) {
			int min = Integer.MAX_VALUE;
			for (int j = i; j < i + k; j ++) {
				min = Math.min(dp[j - k] + Math.abs(h[i] - h[j - k]), min);
			}
			dp[i] = min;
		}
		
		return dp[n - 1];
	}
}
