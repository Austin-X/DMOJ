import java.io.*;

public class PieDay {
	
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1][n + 1][n + 1];
		int k = Integer.parseInt(br.readLine());
		
		System.out.println(k == n ? 1 : compute(n, k, 1));
	}
	
	static int compute(int n, int k, int min) {
		if (k == 1) return 1;
		if (dp[n][k][min] == 0) {
			for (int i = min; i <= n / k; i ++) {
				dp[n][k][min] += compute(n - i, k - 1, i);
			}
		}
		return dp[n][k][min];
	}
}
