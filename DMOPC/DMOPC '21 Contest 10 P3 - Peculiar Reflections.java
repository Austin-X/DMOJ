import java.io.*;
import java.util.*;

public class PeculiarReflections {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Node implements Comparable<Node> {
		int r, c, dir, weight;
		Node (int r, int c, int dir, int weight) { this.r = r; this.c = c; this.dir = dir; this.weight =  weight; }
		public int compareTo(Node n) { return Integer.compare(weight, n.weight); }
	}
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		char[][] grid = new char[n][m];
		for (int i = 0; i < n; i ++) grid[i] = readLine().toCharArray();
		
		// '0' indicates "coming from top", '1' indicates "coming from right", '2' indicates "coming from down", '3' indicates "coming from left"
		boolean[][][] vis = new boolean[n][m][4];
		int ans = Integer.MAX_VALUE;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(0, 0, 0, 0));
		
		int[][] dir1 = {{0, 1, 3}, {-1, 0, 2}, {0, -1, 1}, {1, 0, 0}}, dir2 = {{0, -1, 1}, {1, 0, 0}, {0, 1, 3}, {-1, 0, 2}};
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int newR = cur.r, newC = cur.c, newDir = -1;
			if (vis[cur.r][cur.c][cur.dir]) continue;
			vis[cur.r][cur.c][cur.dir] = true;
			
			newR += dir1[cur.dir][0]; newC += dir1[cur.dir][1]; newDir = dir1[cur.dir][2];

			if (newR >= 0 && newR < n && newC >= 0 && newC < m) pq.add(grid[cur.r][cur.c] == '\\' ? new Node(newR, newC, newDir, cur.weight) : new Node(newR, newC, newDir, cur.weight + 1));
			if (newR == n && newC == m - 1) ans = grid[cur.r][cur.c] == '\\' ? Math.min(ans, cur.weight) : Math.min(ans, cur.weight + 1);
			
			newR = cur.r; newC = cur.c; newDir = -1;
			newR += dir2[cur.dir][0]; newC += dir2[cur.dir][1]; newDir = dir2[cur.dir][2];
			
			if (newR >= 0 && newR < n && newC >= 0 && newC < m) pq.add(grid[cur.r][cur.c] == '/' ? new Node(newR, newC, newDir, cur.weight) : new Node(newR, newC, newDir, cur.weight + 1));
			if (newR == n && newC == m - 1) ans = grid[cur.r][cur.c] == '/' ? Math.min(ans, cur.weight) : Math.min(ans, cur.weight + 1);
		}
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
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
