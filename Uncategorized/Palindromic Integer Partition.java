import java.io.*;

public class PalindromicIntegerPartition {
	static long[] dp;
	static long cn;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		dp = new long[n + 1]; dp[0] = 1;
		
		for (int i = 1; i <= n; i ++) {
			cn = 0;
			recurse(i, 0);
			dp[i] = cn;
		}
		
		System.out.println(dp[n]);
	}
	
	static void recurse(int x, int cur) {
		if (dp[x - cur] != 0) { cn += dp[x - cur]; return; }
		if (cur <= x) cn ++;
		
		for (int i = 1; i <= x; i ++) {
			if (cur + 2 * i <= x) recurse(x, cur + 2 * i);
			else break;
		}
	}
}
