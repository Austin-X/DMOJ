import java.io.*;
import java.util.*;

public class Alphabet {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] s = br.readLine().toCharArray();
		int n = s.length;
		String str = "abcdefghijklmnopqrstuvwxyz";
		char[] alp = str.toCharArray();
		int len = alp.length;
		
		int[][] dp = new int[n + 1][len + 1];
		
		for (int i = 1; i <= n; i ++) {
			for (int j = 1; j <= len; j ++) {
				if (s[i - 1] == alp[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
				else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		
		System.out.println(26 - dp[n][len]);
	}
}
