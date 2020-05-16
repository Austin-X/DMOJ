import java.io.*;

public class LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine(), b = br.readLine();
		int n = a.length(), m = b.length();
		
		int[][] dp = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i ++) {
			for (int j = 1; j <= m; j ++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
				else {
					if (dp[i - 1][j] >= dp[i][j - 1]) dp[i][j] = dp[i - 1][j]; 
					else dp[i][j] = dp[i][j - 1]; 
				}
			}
		}
		
		String ans = "";
		int first = n, second = m;
		while (ans.length() != dp[n][m]) {
			if (dp[first][second] == dp[first - 1][second]) first --;
			else if (dp[first][second] == dp[first][second - 1]) second --;
			else if (dp[first][second] == dp[first - 1][second - 1] + 1) {
					ans += a.charAt(first - 1); first--; second --;
			}
		}
		for (int i = ans.length() - 1; i >= 0; i --) System.out.print(ans.charAt(i));
		System.out.println();
	}
}
