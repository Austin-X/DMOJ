import java.io.*;
import java.util.*;

public class Stones {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] dp = new int[k + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(st.nextToken());
		
		dp[0] = 1;
		for (int i = 1; i <= k; i ++) {
			boolean flag = false;
			for (int j = 0; j < n; j ++) {
				if (i - arr[j] >= 0 && dp[i - arr[j]] == 1) {
					flag = true; break;
				}
			}
			dp[i] = flag ? 2 : 1;
		}
		
		System.out.println(dp[k] == 2 ? "First" : "Second");
	}
}
