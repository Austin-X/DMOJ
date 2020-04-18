import java.io.*;
import java.util.*;

public class RestoringReputation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken()), I = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		String a = st.nextToken(), b = st.nextToken();
		
		int[][] dp = new int[b.length() + 1][a.length() + 1];
		for (int i = 1; i <= a.length(); i ++) dp[0][i] = i * D;
		for (int i = 1; i <= b.length(); i ++) dp[i][0] = i * I;

		for (int i = 1; i <= b.length(); i ++) {
			for (int j = 1; j <= a.length(); j ++) {
				if (a.charAt(j - 1) == b.charAt(i - 1)) dp[i][j] = dp[i - 1][j - 1];
				else dp[i][j] = Math.min(dp[i][j - 1] + D, Math.min(dp[i - 1][j] + I, dp[i - 1][j - 1] + R));
			}
		}
		
		System.out.println(dp[b.length()][a.length()]);
	}
}
