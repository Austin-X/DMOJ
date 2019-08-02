import java.io.*;
import java.util.*;

public class PursuitOfKnowledge {
	static int n, t;
	static int[][] dis = new int[1001][1001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList[n + 1];
		for (int i = 0; i <= n; i ++) adj[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[x].add(y);
		}
		
		calculate(adj);
		
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(dis[a][b] != 0 ? dis[a][b] : "Not enough hallways!");
		}
	}
	
	static void calculate(ArrayList<Integer>[] adj) {
		for (int i = 1; i <= n; i ++) {
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(i);
			boolean[] visited = new boolean[1001];
			visited[i] = true;
			
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int x : adj[cur]) {
					if (!visited[x]) {
						visited[x] = true;
						q.add(x);
						dis[i][x] = dis[i][cur] + 1;
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i ++) {
			for (int j = 1; j <= n; j ++) {
				dis[i][j] *= t;
			}
		}
	}
}
