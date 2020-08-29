import java.io.*;
import java.util.*;

public class ChainRule {
	static class Pair implements Comparable<Pair> {
		int dest, weight;
		Pair (int dest, int weight) { this.dest = dest; this.weight = weight; }
		public int compareTo(Pair p) { return Integer.compare(weight, p.weight); }
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static ArrayList<Pair>[] adj;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		n = readInt(); int m = readInt();

		adj = new ArrayList[n];
		for (int i = 0; i < n; i ++) adj[i] = new ArrayList<Pair>();
		for (int i = 0; i < m; i ++) {
			int x = readInt(), y = readInt(), w = readInt();
			adj[x].add(new Pair(y, w)); adj[y].add(new Pair(x, w));
		}
		
		int[] dis1 = dijkstras(0), dis2 = dijkstras(n - 1); int max = 0;
		for (int i = 0; i < n; i ++) max = Math.max(max, dis1[i] + dis2[i]);
		System.out.println(max);
	}
	
	static int[] dijkstras(int source) {
		int[] dis = new int[n]; Arrays.fill(dis, Integer.MAX_VALUE); dis[source] = 0;
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		q.add(new Pair(source, 0));
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			for (Pair x : adj[cur.dest]) {
				if (dis[cur.dest] + x.weight < dis[x.dest]) {
					dis[x.dest] = dis[cur.dest] + x.weight;
					q.add(new Pair(x.dest, dis[x.dest]));
				}
			}
		}
		return dis;
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
