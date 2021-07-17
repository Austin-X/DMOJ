import java.io.*;
import java.util.*;

public class FineArt {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Triple {
		int x, y, z, idx;
		Triple (int x, int y, int z, int idx) { this.x = x; this.y = y; this.z = z; this.idx = idx; }
	}
	static int[][] moves = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		int[][][] ans = new int[101][101][101];
		boolean[][][] vis = new boolean[101][101][101];
		
		Queue<Triple> queue = new LinkedList<Triple>();
		for (int i = 1; i <= n; i ++) {
			Triple t = new Triple(readInt(), readInt(), readInt(), i);
			vis[t.x][t.y][t.z] = true;
			ans[t.x][t.y][t.z] = i;
			queue.add(t);
		}
		while (!queue.isEmpty()) {
			Triple t = queue.poll();
			for (int i = 0; i < 6; i ++) {
				int dx = moves[i][0], dy = moves[i][1], dz = moves[i][2], x = t.x + dx, y = t.y + dy, z = t.z + dz;
				if (x >= 0 && y >= 0 && z >= 0 && x <= 100 && y <= 100 && z <= 100 && !vis[x][y][z]) {
					vis[x][y][z] = true;
					ans[x][y][z] = t.idx;
					queue.add(new Triple(x, y, z, t.idx));
				}
			}
		}
		while (q-- > 0) System.out.println(ans[readInt()][readInt()][readInt()]);
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
