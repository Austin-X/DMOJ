import java.io.*;
import java.util.*;

public class RovingRoombas {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Pair implements Comparable<Pair> {
		int x, y;
		Pair (int x, int y) { this.x = x; this.y = y; }
		public int compareTo (Pair p) { return Integer.compare(x, p.x); }
	}
	static class Pair2 implements Comparable<Pair2> {
		int x, y;
		Pair2 (int x, int y) { this.x = x; this.y = y; }
		public int compareTo(Pair2 p) { return Integer.compare(y, p.y); }
	}

	static int[] BITree;
	static int n;
	
	public static void main(String[] args) throws IOException {
		n = readInt(); int m = readInt();
		Pair[] roombas = new Pair[n + 1], cords = new Pair[m + 1];
		Pair2[] roombasY = new Pair2[n + 1];
		
		roombas[0] = new Pair(0, 0); cords[0] = new Pair(0, 0); roombasY[0] = new Pair2(0, 0);
		for (int i = 1; i <= n; i ++) {
			int x = readInt(), y = readInt();
			roombas[i] = new Pair(x, y);
			roombasY[i] = new Pair2(x, y);
		}
		for (int i = 1; i <= m; i ++) cords[i] = new Pair(readInt(), readInt());
		Arrays.sort(roombas); Arrays.sort(cords); Arrays.sort(roombasY);
		
		BITree = new int[n + 1]; 
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 1; i <= n; i ++) {
			update(i, 1);
			map.put(roombasY[i].y, i);
		}
		
		long ans = 0;
		int index = 1;
		for (int i = 1; i <= m; i ++) {
			while (index != n + 1 && roombas[index].x < cords[i].x) {
				update(map.get(roombas[index].y), -1);
				index ++;
			}
			
			if (map.floorKey(cords[i].y) == null) continue;
			int high = map.get(map.floorKey(cords[i].y));
			ans += query(high);
		}

		System.out.println(ans);
	}
	
	static void update (int x, int val) {
		while (x <= n) {
			BITree[x] += val;
			x += x & (-x);
		}
	}
	
	static int query (int idx) {
		int sum = 0;
		while (idx > 0) {
			sum += BITree[idx];
			idx -= idx & (-idx);
		}
		return sum;
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
