import java.io.*;
import java.util.*;

public class BubbleTea {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1], dp = new int[n + 1];
		
		for (int i = 1; i <= n; i ++) arr[i] = Integer.parseInt(br.readLine());
		
		int min;
		for (int i = 1; i <= n; i ++) {
			if (i == 1) dp[i] = arr[i];
			else if (i == 2) {
				min = Math.min(arr[2], arr[1]);
				dp[i] = arr[1] + arr[2] - (min / 4);
			} else {
				min = Math.min(arr[i], Math.min(arr[i - 1], arr[i - 2]));
				int val1 = dp[i - 3] + arr[i] + arr[i - 1] + arr[i - 2] - (min / 2);
				min = Math.min(arr[i], arr[i - 1]);
				int val2 = dp[i - 2] + arr[i] + arr[i - 1] - (min / 4);
				dp[i] = Math.min(val1, Math.min(val2, dp[i - 1] + arr[i]));
			}
		}
		
		System.out.println(dp[n]);
	}
}
