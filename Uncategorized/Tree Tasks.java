import java.io.*;
import java.util.*;

public class TreeTasks {
	static class Pair {
		int dest, weight;
		Pair (int dest, int weight) { this.dest = dest; this.weight = weight; }
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Pair>[] adj;
	static boolean[] vis; 
	static int[] dis;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt();
		adj = new ArrayList[n + 1]; vis = new boolean[n + 1]; dis = new int[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Pair>();
		for (int i = 0; i < n - 1; i ++) {
			int u = readInt(), v = readInt(), w = readInt();
			adj[u].add(new Pair(v, w)); adj[v].add(new Pair(u, w));
		}
		
		vis[1] = true;
		dfs(1, 0);
		int max = 0, v1 = 0;
		for (int i = 1; i <= n; i ++) if (dis[i] > max) { max = dis[i]; v1 = i; }
		Arrays.fill(vis, false); Arrays.fill(dis, 0); vis[v1] = true;
		dfs(v1, 0);
		int diameter = 0, v2 = 0, radius = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i ++) if (dis[i] > diameter) { diameter = dis[i]; v2 = i; }
		System.out.println(diameter);
		ArrayList<Integer> path = new ArrayList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		int[] parent = new int[n + 1], w = new int[n + 1];
		s.push(v1); Arrays.fill(vis, false); vis[v1] = true;

		while (!s.isEmpty()) {
			int cur = s.pop();
			if (cur == v2) {
				while (parent[cur] != 0) { path.add(w[cur]); cur = parent[cur]; } 
				break;
			}
			for (Pair x : adj[cur]) { 
				if (!vis[x.dest]) {
					vis[x.dest] = true;
					parent[x.dest] = cur; w[x.dest] = x.weight;
					s.push(x.dest);
				}
			}
		}
		int sum = 0, temp = 0;
		for (int i = 0; i < path.size(); i ++) sum += path.get(i);
		for (int i = 0; i < path.size(); i ++) {
			radius = Math.min(radius, Math.max(sum - temp, temp));
			temp += path.get(i);
		}
		System.out.println(radius);
	}
	
	static void dfs(int cur, int weight) {
		for (Pair x : adj[cur]) {
			if (!vis[x.dest]) {
				dis[x.dest] = dis[cur] + x.weight;
				vis[x.dest] = true;
				dfs(x.dest, dis[x.dest]);
			}
		}
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
