import java.io.*;
import java.util.*;

public class Etopika {
	static int[] euler, heights, first;
	static int[][] sparseTable;
	static boolean[] vis;
	static class Pair implements Comparable<Pair>{
		int dest, weight;
		Pair (int dest, int weight) { this.dest = dest; this.weight = weight; }
		public int compareTo(Pair p) {
			return Integer.compare(weight, p.weight);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
		
		@SuppressWarnings("unchecked")
		ArrayList<Pair>[] adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Pair>();
		for (int i = 0; i < n - 1; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), z = Integer.parseInt(st.nextToken());
			adj[x].add(new Pair(y, z));
			adj[y].add(new Pair(x, z));
		}
		
		euler = new int[2 * n - 1]; heights = new int[2 * n - 1]; first = new int[n + 1]; vis = new boolean[n + 1];
		vis[1] = true; first[1] = 0;
		preprocessDfs(0, 1, adj);
		buildSparseTable(heights, 2 * n - 1);
		
		int[][] bananas = new int[d][2];
		for (int i = 0; i < d; i ++) {
			st = new StringTokenizer(br.readLine());
			bananas[i][0] = Integer.parseInt(st.nextToken());
			bananas[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] minDis = new int[n + 1];
		Arrays.fill(minDis, Integer.MAX_VALUE);
		minDis[1] = 0;
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		q.add(new Pair(1, 0));
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			for (Pair x : adj[cur.dest]) {
				if (minDis[cur.dest] + x.weight < minDis[x.dest]) {
					minDis[x.dest] = minDis[cur.dest] + x.weight;
					q.add(new Pair(x.dest, minDis[x.dest]));
				}
			}
		}
		
		long[][] dp = new long[d][2]; 
		for (int i = 0; i < d; i ++) {
			int lca = euler[query(first[bananas[i][0]], first[bananas[i][1]])];
			int dis = Math.abs(minDis[bananas[i][1]] - minDis[lca]) + Math.abs(minDis[bananas[i][0]] - minDis[lca]);
			if (i == 0) {
				dp[i][0] = minDis[bananas[i][1]] + dis;
				dp[i][1] = minDis[bananas[i][0]] + dis;
			} else {
				int lca0 = euler[query(first[bananas[i - 1][0]], first[bananas[i][1]])];
				int lca1 = euler[query(first[bananas[i - 1][1]], first[bananas[i][1]])];
				int lca2 = euler[query(first[bananas[i - 1][0]], first[bananas[i][0]])];
				int lca3 = euler[query(first[bananas[i - 1][1]], first[bananas[i][0]])];
				dp[i][0] = Math.min(dp[i - 1][0] + Math.abs(minDis[bananas[i - 1][0]] - minDis[lca0]) + Math.abs(minDis[bananas[i][1]] - minDis[lca0]), dp[i - 1][1] + Math.abs(minDis[bananas[i - 1][1]] - minDis[lca1]) + Math.abs(minDis[bananas[i][1]] - minDis[lca1])) + dis;
				dp[i][1] = Math.min(dp[i - 1][0] + Math.abs(minDis[bananas[i - 1][0]] - minDis[lca2]) + Math.abs(minDis[bananas[i][0]] - minDis[lca2]), dp[i - 1][1] + Math.abs(minDis[bananas[i - 1][1]] - minDis[lca3]) + Math.abs(minDis[bananas[i][0]] - minDis[lca3])) + dis;
			}
		}
		System.out.println(Math.min(dp[d - 1][0], dp[d - 1][1]));
	}

	static void buildSparseTable (int[] heights, int size) {
		int width = (int)(Math.floor(Math.log(size) / Math.log(2))) + 1;
		sparseTable = new int[size][width];
		for (int i = 0; i < size; i ++) sparseTable[i][0] = i;
		for (int j = 1; j < width; j ++) {
			for (int i = 0; i <= size - (1 << j); i ++) {
				if (heights[sparseTable[i][j - 1]] <= heights[sparseTable[i + (1 << j - 1)][j - 1]]) {
					sparseTable[i][j] = sparseTable[i][j - 1];
				} else sparseTable[i][j] = sparseTable[i + (1 << j - 1)][j - 1];
			}
		}
	}
	
	static int query(int l, int r) {
		if (l > r) {
			int temp = l;
			l = r;
			r = temp;
		}
		
		int length = r - l + 1;
		int log = (int)(Math.floor(Math.log(length) / Math.log(2)));
		if (heights[sparseTable[l][log]] <= heights[sparseTable[r - (1 << log) + 1][log]]) return sparseTable[l][log];
		else return sparseTable[r - (1 << log) + 1][log];
	}
	static int idx = 0;
	static void preprocessDfs(int parentIdx, int cur, ArrayList<Pair>[] adj) {
		euler[idx] = cur;
		for (Pair x: adj[cur]) {
			if (!vis[x.dest]) {
				vis[x.dest] = true;
				idx ++;
				first[x.dest] = idx;
				heights[idx] = heights[parentIdx] + 1;
				preprocessDfs(idx, x.dest, adj);
				idx ++;
				heights[idx] = heights[parentIdx];
				euler[idx] = cur;
			}
		}
	}
}
