import java.io.*;
import java.util.*;

public class BridgesInAGraph {
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static Stack<Integer> stack;
	static int[][] connections;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 0; t < 5; t ++) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());

			adj = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) adj[i] = new ArrayList<Integer>();
			
			connections = new int[m + 1][2];
			
			for (int i = 1; i <= m; i ++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				adj[x].add(y);
				adj[y].add(x);
				connections[i][0] = x;
				connections[i][1] = y;
			}
			
			int cn = 0;
			stack = new Stack<Integer>();
			visited = new boolean[n + 1];
			
			for (int i = 1; i <= m; i ++) {
				if (dfs(i, n)) cn ++;
			}
			
			System.out.println(cn);
		} 
	}
	
	static boolean dfs(int i, int n) {
		Arrays.fill(visited, false);
		stack.push(1);
		visited[1] = true;
		
		int tempX = connections[i][0];
		int tempY = connections[i][1];
		adj[tempX].remove(adj[tempX].indexOf(tempY));
		adj[tempY].remove(adj[tempY].indexOf(tempX));
		
		while (!stack.empty()) {
			int cur = stack.pop();
			for (int x : adj[cur]) {
				if (!visited[x]) {
					stack.push(x);
					visited[x] = true;
				}
			}
		}
		
		boolean bool = true;
		for (int j = 1; j <= n; j ++) {
			if (!visited[j]) {
				bool = false; break;
			}
		}
		
		adj[tempX].add(tempY);
		adj[tempY].add(tempX);
		
		if (!bool) return true;
		return false;
	}
}
