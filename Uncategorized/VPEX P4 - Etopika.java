import java.io.*;
import java.util.*;

public class Etopika {
	static int[] euler, heights, first;
	static Node[] segTree;
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

		segTree = new Node[2 * n * 4];
		constructSegtree(heights, 0, 2 * n - 2, 0);
		
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
			int lca = euler[rangeMinimumQuery(first[bananas[i][0]], first[bananas[i][1]], 0, 2 * n - 2, 0).idx];
			if (i == 0) {
				dp[i][0] = minDis[bananas[i][1]] + Math.abs(minDis[bananas[i][1]] - minDis[lca]) + Math.abs(minDis[bananas[i][0]] - minDis[lca]);
				dp[i][1] = minDis[bananas[i][0]] + Math.abs(minDis[bananas[i][1]] - minDis[lca]) + Math.abs(minDis[bananas[i][0]] - minDis[lca]);
			} else {
				int lca0 = euler[rangeMinimumQuery(first[bananas[i - 1][0]], first[bananas[i][1]], 0, 2 * n - 2, 0).idx];
				int lca1 = euler[rangeMinimumQuery(first[bananas[i - 1][1]], first[bananas[i][1]], 0, 2 * n - 2, 0).idx];
				int lca2 = euler[rangeMinimumQuery(first[bananas[i - 1][0]], first[bananas[i][0]], 0, 2 * n - 2, 0).idx];
				int lca3 = euler[rangeMinimumQuery(first[bananas[i - 1][1]], first[bananas[i][0]], 0, 2 * n - 2, 0).idx];
				dp[i][0] = Math.min(dp[i - 1][0] + Math.abs(minDis[bananas[i - 1][0]] - minDis[lca0]) + Math.abs(minDis[bananas[i][1]] - minDis[lca0]), dp[i - 1][1] + Math.abs(minDis[bananas[i - 1][1]] - minDis[lca1]) + Math.abs(minDis[bananas[i][1]] - minDis[lca1])) + Math.abs(minDis[bananas[i][1]] - minDis[lca]) + Math.abs(minDis[bananas[i][0]] - minDis[lca]);
				dp[i][1] = Math.min(dp[i - 1][0] + Math.abs(minDis[bananas[i - 1][0]] - minDis[lca2]) + Math.abs(minDis[bananas[i][0]] - minDis[lca2]), dp[i - 1][1] + Math.abs(minDis[bananas[i - 1][1]] - minDis[lca3]) + Math.abs(minDis[bananas[i][0]] - minDis[lca3])) + Math.abs(minDis[bananas[i][1]] - minDis[lca]) + Math.abs(minDis[bananas[i][0]] - minDis[lca]);
			}
		}
		System.out.println(Math.min(dp[d - 1][0], dp[d - 1][1]));
	}
	static class Node {
		int idx, height;
		Node (int idx, int height) { this.idx = idx; this.height = height; }
	}
	static Node rangeMinimumQuery (int l, int r, int low, int high, int pos) {
		if (l > r) return rangeMinimumQuery(r, l, low, high, pos);
		
		int mid = (low + high) / 2;
		if (l <= low && r >= high) return segTree[pos];
		else if (l > mid) return rangeMinimumQuery(l, r, mid + 1, high, pos * 2 + 2);
		else if (r <= mid) return rangeMinimumQuery(l, r, low, mid, pos * 2 + 1);
		else {
			Node x = rangeMinimumQuery(l, r, low, mid, pos * 2 + 1), y = rangeMinimumQuery(l, r, mid + 1, high, pos * 2 + 2);
			if (x.height <= y.height) return x;
			else return y;
		}
	}
	static Node constructSegtree (int[] heights, int low, int high, int pos) {
		if (low == high) {
			segTree[pos] = new Node(low, heights[low]);
			return segTree[pos];
		}
		int mid = (low + high) / 2;
		Node x = constructSegtree(heights, low, mid, 2 * pos + 1), y = constructSegtree(heights, mid + 1, high, 2 * pos + 2);
		if (x.height <= y.height) segTree[pos] = x;
		else segTree[pos] = y;
		return segTree[pos];
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
