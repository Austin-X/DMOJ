import java.io.*;
import java.util.*;

public class AQTAndDirectedGraph {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int ansX = 0, ansY = 0;
	static ArrayList<Integer>[] adj;
	static boolean[] vis;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		
		vis = new boolean[n + 1];
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < m; i ++) {
			int x = readInt(), y = readInt();
			adj[y].add(x);
		}
		for (int i = n; i >= 1; i --) if (!vis[i]) dfs(i, i);
		
		if (ansX == 0) System.out.println(-1);
		else System.out.println(ansX + " " + ansY);
	}
	
	static void dfs(int u, int mx) {
		vis[u] = true;
		
		for (int x: adj[u]) {
			if (!vis[x]) {
				if (x > ansX || x == ansX && mx > ansY) { ansX = x; ansY = mx; }
				dfs(x, mx);
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
