import java.io.*;
import java.util.StringTokenizer;

public class JaydenEatsChocolate {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int z = Integer.parseInt(st.nextToken());
		dp[x] = 1;
		dp[y] = 1;
		dp[z] = 1;
		
		for (int i = 0; i < n; i ++) {
			if (dp[i] != 0) {
				if (x + i <= n) dp[i + x] = Math.max(dp[i + x], dp[i] + 1);
				if (y + i <= n) dp[i + y] = Math.max(dp[i + y], dp[i] + 1);
				if (z + i <= n) dp[i + z] = Math.max(dp[i + z], dp[i] + 1);
			}
		}
		
		System.out.println(dp[n]);
	}
}
