import java.io.*;
import java.util.*;

public class NetworkConnections {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Edge implements Comparable<Edge> {
		int src, dest, weight;
		
		Edge (int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}
	}
	
	static int[] parent, rank;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		
		parent = new int[n + 1]; rank = new int[n + 1];
		for (int i = 1; i <= n; i ++) parent[i] = i;
		
		int[] f = new int[n + 1];
		
		ArrayList<Edge> arr = new ArrayList<Edge>();
		for (int i = 1; i <= n; i ++) {
			f[i] = readInt();
			if (i > 1) arr.add(new Edge(i - 1, i, Math.abs(f[i - 1] - f[i])));
		}
	
		for (int i = 0; i < m; i ++) {
			int x = readInt(), y = readInt();
			union(x, y);
		}
		
		Collections.sort(arr);
		
		int ans = 0;
		for (Edge e : arr) {
			int parentX = find(e.src), parentY = find(e.dest);
			if (parentX != parentY) {
				union(parentX, parentY);
				ans += e.weight;
			}
		}
		
		System.out.println(ans);
	}
	
	static int find(int x) {
		if (parent[x] == x) return parent[x];
		else return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		int parentX = find(x), parentY = find(y);
		if (rank[parentX] > rank[parentY]) {
			parent[parentY] = parentX;
		} else if (rank[parentX] < rank[parentY]) {
			parent[parentX] = parentY;
		} else {
			parent[parentX] = parentY;
			rank[parentY] ++;
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
