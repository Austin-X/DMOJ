import java.io.*;
import java.util.*;

public class GeeseVsHawks {
	static class pair {
		boolean won;
		int score;
		
		pair (boolean w, int s) {
			won = w;
			score = s;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		char[] chars = br.readLine().toCharArray();
		boolean[] bool = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (chars[i] == 'W') bool[i] = true;
			else bool[i] = false;
		}
		
		pair[] geese = new pair[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i ++) geese[i] = new pair(bool[i - 1], Integer.parseInt(st.nextToken()));
		
		chars = br.readLine().toCharArray();
		bool = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (chars[i] == 'W') bool[i] = true;
			else bool[i] = false;
		}
		
		pair[] hawks = new pair[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i ++) hawks[i] = new pair(bool[i - 1], Integer.parseInt(st.nextToken()));

		long[][] dp = new long[n + 1][n + 1];
		
		for (int i = 1; i <= n; i ++) {
			if (geese[i].won) {
				for (int j = 1; j <= n; j ++) {
					if (!hawks[j].won && geese[i].score > hawks[j].score) {
						dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1] + geese[i].score + hawks[j].score));
					} else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			} else {
				for (int j = 1; j <= n; j ++) {
					if (hawks[j].won && hawks[j].score > geese[i].score) {
						dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1] + geese[i].score + hawks[j].score));
					} else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		
		System.out.println(dp[n][n]);
	}
}
