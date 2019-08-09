import java.io.*;
import java.util.*;

public class P4HEIGHT {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n + 1];
		for (int i = 1; i <= n; i ++) nums[i] = Integer.parseInt(br.readLine());
		
		int[] dp = Arrays.copyOf(nums, n + 1);
		
		int ans = dp[1];
		for (int i = 2; i <= n; i ++) {
			for (int j = 1; j < i; j ++) {
				if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + nums[i]);
			}
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
	}
}
