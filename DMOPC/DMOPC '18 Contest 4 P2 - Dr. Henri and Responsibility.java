import java.io.*;
import java.util.*;

public class DrHenriAndResponsibility {
	static int[] arr;
	static boolean[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		int maxSum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
			maxSum += arr[i];
		}
		dp = new boolean[maxSum + 1];
		dp[0] = true;

		System.out.println(solve(n, maxSum));
	}
	
	static int solve(int n, int maxSum) {	
		for (int i = 0; i < n; i ++) {
			for (int j = maxSum; j >= arr[i]; j --) {
				if (dp[j - arr[i]]) dp[j] = true;
			}
		}

		for (int i = maxSum / 2; i >= 0; i --) {
			if (dp[i]) return Math.abs(maxSum - 2 * i);
		}
		return 0;
	}
}
