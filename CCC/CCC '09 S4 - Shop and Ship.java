import java.io.*;
import java.util.*;

public class ShopAndShip {
	static class node implements Comparable<node> {
		int num, cost;
		node (int num, int cost) { this.num = num; this.cost = cost; }
		
		public int compareTo(node n) {
			return Integer.compare(cost, n.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] adj = new int[n + 1][n + 1];
		for (int[] x : adj) Arrays.fill(x, -1);
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj[x][y] = cost;
			adj[y][x] = cost;
		}
		
		int k = Integer.parseInt(br.readLine());
		
		int[] pencils = new int[n + 1];
		boolean[] check = new boolean[n + 1];
		for (int i = 0; i < k; i ++) {
			st = new StringTokenizer(br.readLine());
			int z = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			pencils[z] = p;
			check[z] = true;
		}
		
		int d = Integer.parseInt(br.readLine());
		
		PriorityQueue<node> q = new PriorityQueue<node>();
		int[] dis = new int[n + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		int ans = Integer.MAX_VALUE;
		if (check[d]) ans = pencils[d];
		dis[d] = 0;
		
		q.add(new node(d, 0));
		
		while (!q.isEmpty()) {
			node cur = q.poll();
			for (int i = 1; i <= n; i ++) {
				if (adj[cur.num][i] != -1 && cur.cost + adj[cur.num][i] < dis[i]) {
					dis[i] = cur.cost + adj[cur.num][i];
					q.add(new node(i, dis[i]));
				}
			}
		}
		
		for (int i = 1; i <= n; i ++) {
			if (check[i]) ans = Math.min(ans, dis[i] + pencils[i]);
		}
		System.out.println(ans);
	}
}
