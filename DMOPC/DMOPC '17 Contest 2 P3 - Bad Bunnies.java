import java.io.*;
import java.util.*;
 
public class BadBunnies {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[] adj;
	static boolean[] rabbits, vis;
	static int[] dis, parent;
	static int y;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt(), r = readInt();

		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Integer>();
		for (int i = 0; i < n - 1; i ++) {
			int a = readInt(), b = readInt();
			adj[a].add(b); adj[b].add(a);
		}
		rabbits = new boolean[n + 1]; dis = new int[n + 1]; Arrays.fill(dis, 200001); parent = new int[n + 1];
		for (int i = 0; i < r; i ++) rabbits[readInt()] = true;
		
		int x = readInt(); y = readInt();
		parent[x] = x;
		vis = new boolean[n + 1];
		dfs(x); 
		int cur = parent[y], ans = dis[y];
		while (cur != x) {
			ans = Math.min(ans, dis[cur]);
			cur = parent[cur];
		}
		ans = Math.min(ans, dis[x]);
		System.out.println(ans);
 	}

	static void dfs(int u) {
		vis[u] = true;
		for (int x : adj[u]) {
			if (!vis[x]) {
				parent[x] = u;
				dfs(x);
				dis[u] = Math.min(dis[u], dis[x] + 1);
			}
		}
		if (rabbits[u]) dis[u] = 0;
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
