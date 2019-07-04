import java.io.*;
import java.util.*;

public class GG {
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String word = br.readLine();
		dp = new int[word.length() + 1];
		precompute(word);
		
		int q = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < q; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			System.out.println(dp[y + 1] - dp[x]);
		}
	}
	
	static void precompute(String word) {
		dp[0] = 0;
		for (int i = 1; i <= word.length(); i ++) {
			if (word.charAt(i - 1) == 'G') dp[i] = dp[i - 1] + 1;
			else dp[i] = dp[i - 1];
		}
	}
}
