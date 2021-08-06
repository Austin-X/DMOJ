import java.io.*;
import java.util.*;

public class MonkeyCanoe {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, m;
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static char[][] grid;
	static boolean[] vis;
	static int[] parent, dis;
	
	static class River implements Comparable<River> {
		int p1, p2, l;
		River (int p1, int p2, int l) { this.p1= p1; this.p2 = p2; this.l = l; }
		public int compareTo(River r) { return -Integer.compare(l, r.l); }
	}

	public static void main(String[] args) throws IOException {
		n = readInt(); m = readInt();
		grid = new char[n][m];
		vis = new boolean[n * m];
		parent = new int[n * m]; 
		for (int i = 0; i < n * m; i ++) parent[i] = i;
		dis = new int[m];
		
		Arrays.fill(dis, -1);
		for (int i = 0; i < n; i ++) grid[i] = readLine().toCharArray();
		for (int i = 0; i < m; i ++) if (!vis[i] && grid[0][i] == '#') dfs(i);
		for (int i = 0; i < m; i ++) if (vis[(n - 1) * m + i]) dis[i] = Integer.MAX_VALUE;

		PriorityQueue<River> pq = new PriorityQueue<River>();
		for (int i = 0; i < n; i ++) {
			int cnt = 0;
			boolean bool = false;
			for (int j = 0; j < m; j ++) {
				if (grid[i][j] == '#') bool = true;
				if (bool && grid[i][j] == '.') cnt ++;
				if (cnt > 0 && grid[i][j] == '#') {
					int hsh1 = i * m + j - cnt - 1, hsh2 = i * m + j;
					pq.add(new River(hsh1, hsh2, cnt));
					cnt = 0;
				}
			}
		}
		for (int i = 0; i < m; i ++) {
			int cnt = 0;
			boolean bool = false;
			for (int j = 0; j < n; j ++) {
				if (grid[j][i] == '#') bool = true;
				if (bool && grid[j][i] == '.') cnt ++;
				if (cnt > 0 && grid[j][i] == '#') {
					int hsh1 = (j - cnt - 1) * m + i, hsh2 = j * m + i;
					pq.add(new River(hsh1, hsh2, cnt));
					cnt = 0;
				}
			}
		}
		
		HashSet<Integer> set;
		int prev = -1;
		while (!pq.isEmpty()) {
			River r = pq.poll();
			if (r.l != prev) {
				if (prev != -1) {
					set = new HashSet<Integer>();
					for (int i = 0; i < m; i ++) set.add(find(i));
					for (int i = 0; i < m; i ++) if (set.contains(find((n - 1) * m + i))) dis[i] = Math.max(dis[i], prev);
				}
				prev = r.l;
			}
			union(r.p1, r.p2);
			if (!vis[r.p1]) dfs(r.p1);
			if (!vis[r.p2]) dfs(r.p2);
		}
		set = new HashSet<Integer>();
		for (int i = 0; i < m; i ++) set.add(find(i));
		for (int i = 0; i < m; i ++) if (set.contains(find((n - 1) * m + i))) dis[i] = Math.max(dis[i], prev);
		
		for (int i = 0; i < m; i ++) {
			int val = dis[i] == Integer.MAX_VALUE ? 0 : dis[i];
			System.out.print(i == m - 1 ? val + "\n" : val + " ");
		}
	}
	
	static void dfs(int start) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(start);

		while (!s.isEmpty()) {
			int p = s.pop();
			vis[p] = true;
			int x = p / m, y = p % m;
			for (int i = 0; i < 4; i ++) {
				x += dir[i][0]; y += dir[i][1];
				int hsh = x * m + y;
				if (x < n && y < m && x >= 0 && y >= 0 && !vis[hsh] && grid[x][y] == '#') {
					union(p, hsh);
					s.push(hsh);
				}
				x -= dir[i][0]; y -= dir[i][1];
			}
		}
	}
	
	static int find(int p) {
		return parent[p] = parent[p] == p ? p : find(parent[p]);
	}
	
	static void union(int p1, int p2) {
		int parent1 = find(p1), parent2 = find(p2);
		parent[parent2] = parent1;
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
