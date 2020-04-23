import java.io.*;

public class Palindrome {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[] ch = br.readLine().toCharArray();
		
		int[] dp = new int[n];
		for (int i = n - 1; i >= 0; i --) {
			int prev = 0;
			for (int j = i + 1; j < n; j ++) {
				int temp = dp[j];
				if (ch[i] == ch[j]) dp[j] = prev;
				else dp[j] = Math.min(dp[j - 1], dp[j]) + 1;
				prev = temp;
			}
		}
		System.out.println(dp[n - 1]);
	}
}
