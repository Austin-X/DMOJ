import java.io.*;
import java.util.*;

public class Waterpark {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList[n + 1];
		for (int i = 0; i <= n; i ++) adj[i] = new ArrayList<Integer>();
		
		int[] dp = new int[n + 1];
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (x == 0 && y == 0) break;
			adj[y].add(x);
		}

		for (int x : adj[n]) {
			dp[x] = 1; 
		}
		
		for (int i = n - 1; i >= 1; i --) {
			for (int j : adj[i]) {
				dp[j] += dp[i];
			}
		}
		
		System.out.println(dp[1]);
	}
}
