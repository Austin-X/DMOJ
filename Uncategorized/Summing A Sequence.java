import java.io.*;
import java.util.*;

public class SummingASequence {
	static int[] nums;
	static long[] dp;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		dp = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) nums[i] = Integer.parseInt(st.nextToken());
		

		if (nums[0] > 0) dp[0] = nums[0];	
		if (n > 1) dp[1] = Math.max(nums[1], dp[0]); 
		for (int i = 2; i < n; i ++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
	
		System.out.println(dp[n - 1]);
	}
}
