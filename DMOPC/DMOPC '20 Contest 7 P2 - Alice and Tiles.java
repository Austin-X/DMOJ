import java.io.*;
import java.util.*;

public class AliceAndTiles {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static class Point {
		int x, y;
		Point (int x, int y) { this.x = x; this.y = y; }
		public boolean equals(Object o) {
			Point p = (Point)o;
			return x == p.x && y == p.y;
		}
		public int hashCode() { return Objects.hash(x, y); }
	}
	
	public static void main(String[] args) throws IOException {
		int n = readInt();

		HashMap<Point, Point> map = new HashMap<Point, Point>();
		for (int i = 0; i < n; i ++) {
			int x = readInt(), y = readInt();

			if (y % 2 == 0 && (y / 2) % 2 == 0 && x % 4 == 0 || y % 2 == 0 && Math.abs((y / 2) % 2) == 1 && (x - 2) % 4 == 0) {
				Point[] temp = new Point[4];
				temp[0] = new Point(x, y); temp[1] = new Point(x, y + 1); temp[2] = new Point(x + 1, y + 1); temp[3] = new Point(x + 1, y);
				
				boolean[] b = new boolean[4];
				for (int j = 0; j < 4; j ++) {
					int idx1 = j, idx2 = j == 3 ? 0 : j + 1;
					if (!map.containsKey(temp[idx2]) || map.containsKey(temp[idx2]) && !map.get(temp[idx2]).equals(temp[idx1])) b[j] = true;
				}
				for (int j = 0; j < 4; j ++) {
					int idx1 = j, idx2 = j == 3 ? 0 : j + 1;
					if (b[j]) map.put(temp[idx1], temp[idx2]);
				}
			} else {
				Point[] temp = new Point[8];
				boolean[] b = new boolean[8];

				temp[0] = new Point(x - 1, y); temp[1] = new Point(x - 1, y + 1); temp[2] = new Point(x, y + 2); temp[3] = new Point(x + 1, y + 2);
				temp[4] = new Point(x + 2, y + 1); temp[5] = new Point(x + 2, y); temp[6] = new Point(x + 1, y - 1); temp[7] = new Point(x, y - 1);
				for (int j = 0; j < 8; j ++) {
					int idx1 = j, idx2 = j == 7 ? 0 : j + 1;
					if (!map.containsKey(temp[idx2]) || map.containsKey(temp[idx2]) && !map.get(temp[idx2]).equals(temp[idx1])) b[j] = true;
				}
				for (int j = 0; j < 8; j ++) {
					int idx1 = j, idx2 = j == 7 ? 0 : j + 1;
					if (b[j]) map.put(temp[idx1], temp[idx2]);
				}
			}
		}

		ArrayList<Point> res = new ArrayList<Point>();
		int ans = 1;
		Point begin = null;
		int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
		for (Point p: map.keySet()) {
			if (p.x < minX || p.x == minX && p.y < minY) {
				minX = p.x; minY = p.y;
				begin = p;
			}
		}
		
		Point cur = map.get(begin);
		res.add(begin);
		while (!cur.equals(begin)) {
			res.add(cur);
			cur = map.get(cur);
			ans ++;
		}
		System.out.println(ans);
		for (Point p: res) System.out.println(p.x + " " + p.y);
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
