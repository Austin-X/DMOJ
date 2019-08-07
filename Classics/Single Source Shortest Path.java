import java.io.*;
import java.util.*;

public class SingleSourceShortestPath {
	static class Node {
		int vertex, weight;
		
		Node(int v, int w) {
			vertex = v;
			weight = w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		@SuppressWarnings("unchecked")
		ArrayList<Node>[] adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Node>();
		
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Node(v, w));
			adj[v].add(new Node(u, w));
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(1, 0));
		int[] dis = new int[n + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[1] = 0;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (Node x : adj[cur.vertex]) {
				if (dis[cur.vertex] + x.weight < dis[x.vertex]) {
					dis[x.vertex] = dis[cur.vertex] + x.weight;
					q.add(x);
				}
			}
		}
		
		for (int i = 1; i <= n; i ++) System.out.println(dis[i] != Integer.MAX_VALUE ? dis[i] : -1);
	}
}
