import java.io.*;
import java.util.*;

public class Dimethylbenzene {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		@SuppressWarnings("unchecked")
		HashSet<Integer>[] adj = new HashSet[n + 1];
		for (int i = 0; i <= n; i ++) adj[i] = new HashSet<Integer>();
		
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[x].add(y);
		}
		
		boolean[] visited = new boolean[n + 1];
		int[] dis = new int[n + 1];
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visited[1] = true;
		dis[1] = 0;
		
		boolean cycle = false;
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int x : adj[cur]) {
				if (visited[x] && dis[cur] + 1 - dis[x] == 6) {
					cycle = true; q.clear(); break;
				}
				else if (!visited[x]) {
					visited[x] = true;
					q.add(x);
					dis[x] = dis[cur] + 1;
				}
			}
		}
		
		System.out.println(cycle ? "YES" : "NO");
	}
}
