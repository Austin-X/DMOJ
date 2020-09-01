import java.io.*;
import java.util.*;

public class RaysTrickyConnectivity {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[] adj;
	static boolean[] vis;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), q = readInt();
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Integer>();
		vis = new boolean[n + 1]; vis[1] = true;
		for (int i = 0; i < m; i ++) {
			int a = readInt(), b = readInt();
			if (vis[a]) { adj[a].add(b); vis[b] = true; dfs(b); }
			else adj[a].add(b);
		}
		
		for (int i = 0; i < q; i ++) {
			char c = readCharacter();
			if (c == '?') System.out.println(vis[readInt()] ? "YES" : "NO");
			else {
				int x = readInt(), y = readInt();
				if (vis[x]) { adj[x].add(y); vis[y] = true; dfs(y); }
				else adj[x].add(y);
			}
		}
	}
	
	static void dfs(int u) {
		for (int x : adj[u]) {
			if (!vis[x]) {
				vis[x] = true; dfs(x);
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
