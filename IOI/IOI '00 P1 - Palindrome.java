import java.io.*;

// The Minimum number of insertions to make a string palindrome is equal to the length of the string minus the length of
// the longest palindromic subsequence.
public class Palindrome {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[] ch = br.readLine().toCharArray();
		
		int[] dp = new int[n];
		for (int i = n - 1; i >= 0; i --) {
			int prev = 0;
			for (int j = i; j < n; j ++) {
				int temp = dp[j];
				if (i == j) dp[j] = Math.max(dp[j], 1);
				else if (i == j - 1) {
					dp[j] = ch[i] == ch[j] ? Math.max(dp[j], 2) : Math.max(dp[j], 1);
				} else {
					if (ch[i] == ch[j]) dp[j] = 2 + prev;
					else dp[j] = Math.max(dp[j], dp[j - 1]);
				}
				prev = temp;
			}
		}
		System.out.println(n - dp[n - 1]);
	}
}
