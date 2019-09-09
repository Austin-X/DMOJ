import java.io.*;
import java.util.*;

public class LongestPath {
	static Stack<Integer> arr = new Stack<Integer>();
	static boolean[] visited;
	static ArrayList<Integer>[] adj;
	
	static void topologicalSort(int x) {
		visited[x] = true;
		for (int u : adj[x]) {
			if (!visited[u]) topologicalSort(u);
		}
		arr.push(x);
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n + 1];
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[x].add(y);
		}
		
		for (int i = 1; i <= n; i ++) {
			if (!visited[i]) topologicalSort(i);
		}
		
		int[] dp = new int[n + 1];
		int max = 0;
		while (!arr.empty()) {
			int cur = arr.pop();
			for (int x : adj[cur]) {
				dp[x] = Math.max(dp[x], dp[cur] + 1);
			}
		}
		
		for (int i = 1; i <= n; i ++) max = Math.max(max, dp[i]);
		System.out.println(max);
	}
}
