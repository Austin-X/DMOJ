import java.io.*;
import java.util.*;

public class Stones {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		boolean[] dp = new boolean[k + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(st.nextToken());
		
		dp[0] = false;
		for (int i = 1; i <= k; i ++) {
			for (int j = 0; j < n; j ++) {
				if (i - arr[j] >= 0 && !dp[i - arr[j]]) {
					dp[i] = true; break;
				}
			}
		}
		
		System.out.println(dp[k] ? "First" : "Second");
	}
}
