import java.io.*;
import java.util.*;

public class Deque {
	static class Node {
		long first, second;
		Node (long first, long second) {
			this.first = first;
			this.second = second;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n]; 
		Node[][] dp = new Node[n][n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(st.nextToken());

		
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n - i; j ++) {
				if (i == 0) {
					dp[j][j] = new Node(arr[j], 0);
				}
				else {
					if (arr[j] + dp[j + 1][j + i].second >= arr[j + i] + dp[j][j + i - 1].second) {
						dp[j][j + i] = new Node(arr[j] + dp[j + 1][j + i].second, dp[j + 1][j + i].first);
					} else {
						dp[j][j + i] = new Node(arr[j + i] + dp[j][j + i - 1].second, dp[j][j + i - 1].first);
					}		
				}
			}
		}
		
		System.out.println(dp[0][n - 1].first - dp[0][n - 1].second);
	}
}
