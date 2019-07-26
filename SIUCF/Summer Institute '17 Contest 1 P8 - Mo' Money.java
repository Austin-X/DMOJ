import java.io.*;
import java.util.*;

public class MoMoney {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());		
		int[] dp = new int[t + 1];
		dp[0] = 1;
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		for (int i = 0; i < n; i ++) {
			for (int j = t; j >= arr[i]; j --) {
				if (dp[j - arr[i]] != 0) {
					dp[j] += dp[j - arr[i]];
				}
			}
		}

		System.out.println(dp[t]);
	}
}
