import java.io.*;
import java.util.*;

public class BreadthFirstNotQuiteTree {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int a = 0; a < 5; a ++) {
			int n = Integer.parseInt(br.readLine());
			
			@SuppressWarnings("unchecked")
			ArrayList<Integer>[] adj = new ArrayList[101];
			
			for (int i = 0; i < 101; i ++) adj[i] = new ArrayList<Integer>();
			
			for (int i = 0; i < n; i ++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				adj[x].add(y);
				adj[y].add(x);
			}
			
			int[] dis = new int[101]; 
			dis[1] = 0;
			boolean[] visited = new boolean[101];
			visited[1] = true;
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(1);
			
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				for (int x : adj[cur]) {
					if (!visited[x]) {
						visited[x] = true;
						dis[x] = dis[cur] + 1;
						queue.add(x);
					}
				}
			}
			
			int sameLevelEdges = 0;
			for (int i = 1; i < 101; i ++) {
				for (int x : adj[i]) {
					if (dis[i] == dis[x]) sameLevelEdges ++;
				}
			}
			
			// The 'divided by 2' comes from the fact that this graph is undirected
			System.out.println(sameLevelEdges / 2);
		}
	}
}
