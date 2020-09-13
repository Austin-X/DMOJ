import java.io.*;
import java.util.*;

public class AnimalFarm {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int MV = 1000;
	static int[][] graph, cost = new int[MV + 1][MV + 1], pens = new int[MV + 1][MV + 1];

	public static void main(String[] args) throws IOException {
		int m = readInt();
		graph = new int[m + 1][m + 1]; 
		for (int i = 1; i <= MV; i ++) Arrays.fill(pens[i], -1);
		
		for (int i = 0; i <= m; i ++) Arrays.fill(graph[i], 4000001);
		for (int i = 0; i < m; i ++) {
			int e = readInt();
			int[] edges = new int[e], c = new int[e];
			for (int j = 0; j < e; j ++) edges[j] = readInt();
			for (int j = 0; j < e; j ++) c[j] = readInt();
			for (int j = 0; j < e; j ++) {
				int v1 = edges[j], v2 = edges[(j + 1) % e];
				if (pens[v1][v2] == -1) {
					cost[v1][v2] = c[j]; cost[v2][v1] = c[j]; pens[v1][v2] = i; pens[v2][v1] = i;
				}
				else {
					if (c[j] < graph[i][pens[v1][v2]]) { graph[i][pens[v1][v2]] = c[j]; graph[pens[v1][v2]][i] = c[j]; }
					pens[v1][v2] = -1; pens[v2][v1] = -1;
				}
			}
		}
		
		for (int i = 1; i <= MV; i ++) {
			for (int j = 1; j <= MV; j ++) {
				if (pens[i][j] != -1 && cost[i][j] < graph[pens[i][j]][m]) graph[pens[i][j]][m] = cost[i][j];
			}
		}	
		
		System.out.println(Math.min(kruskalMST(m - 1), kruskalMST(m)));
	}
	
	static int[] parent, rank;
	static int find (int x) {
		if (parent[x] != x) return parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union(int x, int y) {
		int parentX = find(x), parentY = find(y);
		if (parentX == parentY) return;
		if (rank[parentX] > rank[parentY]) parent[parentY] = parentX;
		else if (rank[parentX] < rank[parentY]) parent[parentX] = parentY;
		else {
			parent[parentX] = parentY;
			rank[parentY] ++;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int src, dest, weight;
		Edge (int src, int dest, int weight) { this.src = src; this.dest = dest; this.weight = weight; }
		public int compareTo(Edge e) { return Integer.compare(weight, e.weight); }
	}
	
	static long kruskalMST(int max) {
		long ans = 0;
		parent = new int[max + 1]; rank = new int[max + 1];
		for (int i = 0; i <= max; i ++) parent[i] = i;
		
		ArrayList<Edge> arr = new ArrayList<Edge>();
		for (int i = 0; i <= max; i ++) {
			for (int j = 0; j <= max; j ++) {
				if (i != j) arr.add(new Edge(i, j, graph[i][j]));
			}
		}
		Collections.sort(arr);

		for (Edge e : arr) {
			int u = find(e.src), v = find(e.dest);
			if (u != v) {
				union(u, v);
				ans += e.weight;
			}
		}
		return ans;
	}
	
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong() throws IOException {
		return Long.parseLong(next());
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter() throws IOException {
		return next().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
