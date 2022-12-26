import java.io.*;
import java.util.*;

public class AnExtraordinarilyCoordinatedChristmas {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Pair {
		int dest, weight;
		Pair (int dest, int weight) { this.dest = dest; this.weight = weight; }
	}
	
	static ArrayList<Pair>[] adj;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Pair>();
		for (int i = 0; i < n - 1; i ++) {
			int u = readInt(), v = readInt(), w = readInt();
			adj[u].add(new Pair(v, w));
			adj[v].add(new Pair(u, w));
		}
		
		int[] dist1 = new int[n + 1], dist2 = new int[n + 1];
		Arrays.fill(dist1, Integer.MAX_VALUE); dist1[1] = 0;
		dfs(1, dist1);
		
		int mx = dist1[1], start = 1, end = 0;
		for (int i = 2; i <= n; i ++) if (dist1[i] > mx) { mx = dist1[i]; start = i; }
		
		Arrays.fill(dist1, Integer.MAX_VALUE); dist1[start] = 0;
		dfs(start, dist1);
		
		mx = dist1[start];
		for (int i = 1; i <= n; i ++) if (dist1[i] > mx) { mx = dist1[i]; end = i; }
		
		Arrays.fill(dist2, Integer.MAX_VALUE); dist2[end] = 0;
		dfs(end, dist2);
		
		while (q-- > 0) { int x = readInt(); System.out.println(Math.max(dist1[x], dist2[x])); }
	}

	static void dfs(int u, int dist[]) {
		for (Pair p: adj[u]) {
			if (dist[p.dest] == Integer.MAX_VALUE) { dist[p.dest] = dist[u] + p.weight; dfs(p.dest, dist); }
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
