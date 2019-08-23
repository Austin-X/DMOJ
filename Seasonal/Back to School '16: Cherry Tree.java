import java.io.*;
import java.util.*;

public class CherryTree {
	static class Node {
		int dest, cherries, weight;
		Node (int dest, int cherries, int weight) {
			this.dest = dest;
			this.cherries = cherries;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] cherries = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i ++) cherries[i] = Integer.parseInt(st.nextToken());
		
		@SuppressWarnings("unchecked")
		ArrayList<Node>[] adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Node>();
		for (int i = 0; i < n - 1; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[a].add(new Node(b, cherries[b], w));
		}

		Queue<Node> q = new LinkedList<Node>();
		
		int ans = 0;
		for (int i = 1; i <= n; i ++) {
			for (int j = 0; j < adj[i].size(); j ++) {
				q.add(adj[i].get(j));
				
				int cherryCn = 0, weightCn = 0;
				while (!q.isEmpty()) {
					Node cur = q.poll();
					cherryCn += cur.cherries;
					weightCn += cur.weight;
					for (Node x : adj[cur.dest]) q.add(x);
				}
				if (cherryCn >= c && weightCn <= k) ans ++;
			}
		}
		
		System.out.println(ans);
	}
}
