import java.io.*;

public class MoMoney {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		
		int[] arr = new int[n + 1];
		temp = br.readLine().split(" ");
		
		for (int i = 1; i < n + 1; i ++) arr[i] = Integer.parseInt(temp[i - 1]);
		
		int[][] dp = new int[n + 1][k + 1];
		dp[0][0] = 1;
		
		for (int i = 1; i < n + 1; i ++) {
			for (int j = 0; j < k + 1; j ++) {
				if (j - arr[i] >= 0) {
					dp[i][j] = dp[i - 1][j - arr[i]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}
