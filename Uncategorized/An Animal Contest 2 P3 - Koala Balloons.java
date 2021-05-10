import java.io.*;
import java.util.*;

public class KoalaBalloons {
	static class Pair {
		int r, c;
		Pair (int r, int c) { this.r = r; this.c = c; }
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		char[][] grid = new char[n + 1][m + 1];
		int[][] rowPfs = new int[n + 1][m + 1], colPfs = new int[n + 1][m + 1];

		int begin = Math.min(m, n);
		for (int i = 1; i <= n; i ++) {
			char[] ch = readLine().toCharArray();
			for (int j = 1; j <= m; j ++) {
				grid[i][j] = ch[j - 1];
				if (grid[i][j] == 'X') {
					if (j == 1 || i == n) begin = Math.min(begin, i - 1);
					else if (i == 1 || j == n) begin = Math.min(begin, j - 1);
					else begin = Math.min(begin, Math.max(i - 1, j - 1));
				}
				if (grid[i][j] == 'X') rowPfs[i][j] = rowPfs[i][j - 1] + 1;
				else rowPfs[i][j] = rowPfs[i][j - 1];
			}
		}
		
		for (int i = 1; i <= m; i ++) {
			for (int j = 1; j <= n; j ++) {
				if (grid[j][i] == 'X') colPfs[j][i] = colPfs[j - 1][i] + 1;
				else colPfs[j][i] = colPfs[j - 1][i];
			}
		}
		
		int low = 0, high = begin;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (mid == 0) {
				low = mid + 1; 
				continue; 
			}
			
			Queue<Pair> q = new LinkedList<Pair>();
			boolean works = false;
			q.add(new Pair(1, 1));
			
			boolean[][] vis = new boolean[n + 1][m + 1];
			vis[1][1] = true;
			while (!q.isEmpty()) {
				Pair p = q.poll();
				if (p.r + mid - 1 == n && p.c + mid - 1 == m) { works = true; break; }
				
				if (p.r + mid <= n && !vis[p.r + 1][p.c] && rowPfs[p.r + mid][p.c + mid - 1] - rowPfs[p.r + mid][p.c - 1] == 0) {
					q.add(new Pair(p.r + 1, p.c));
					vis[p.r + 1][p.c] = true;
				}
				if (p.c + mid <= m && !vis[p.r][p.c + 1] && colPfs[p.r + mid - 1][p.c + mid] - colPfs[p.r - 1][p.c + mid] == 0) {
					q.add(new Pair(p.r, p.c + 1));
					vis[p.r][p.c + 1] = true;
				}
				if (p.r - 1 >= 1 && !vis[p.r - 1][p.c] &&  rowPfs[p.r - 1][p.c + mid - 1] - rowPfs[p.r - 1][p.c - 1] == 0) {
					q.add(new Pair(p.r - 1, p.c));
					vis[p.r - 1][p.c] = true;
				}
				if (p.c - 1 >= 1 && !vis[p.r][p.c - 1] && colPfs[p.r + mid - 1][p.c - 1] - colPfs[p.r - 1][p.c - 1] == 0) {
					q.add(new Pair(p.r, p.c - 1));
					vis[p.r][p.c - 1] = true;
				}
			}
			
			if (works) low = mid + 1;
			else high = mid - 1;
		}
		System.out.println(low - 1);
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
