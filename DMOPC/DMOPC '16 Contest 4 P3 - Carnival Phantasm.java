import java.io.*;
import java.util.*;

public class CarnivalPhantasm {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparable<Pair> {
		int shop, dis;
		Pair (int shop, int dis) { this.shop = shop; this.dis = dis; }
		public int compareTo (Pair p) { 
			if (dis == p.dis) return Integer.compare(shop, p.shop);
			else return Integer.compare(dis, p.dis); 
		}
	}

	@SuppressWarnings("unchecked")
	public static void main (String[] args) throws IOException {
		int n = readInt(), s = readInt();
		
		int[] dis = new int[n + 1];

		TreeSet<Pair>[] flavours = new TreeSet[101];
		Stack<Integer>[] shops = new Stack[n + 1];
		
		for (int i = 0; i <= 100; i ++) flavours[i] = new TreeSet<Pair>();
		for (int i = 1; i <= n; i ++) { dis[i] = readInt(); shops[i] = new Stack<Integer>(); }
		for (int i = 0; i < s; i ++) {
			int sh = readInt(), a = readInt(); shops[sh].add(a); flavours[a].add(new Pair(sh, dis[sh]));
		}
		
		int q = readInt();
		for (int i = 0; i < q; i ++) {
			char op = readCharacter();
			int x, k;
			if (op == 'A') {
				x = readInt(); k = readInt();
				flavours[k].add(new Pair(x, dis[x]));
				shops[x].push(k);
			} else if (op == 'S') {
				x = readInt(); k = readInt();
				if (flavours[k].contains(new Pair(x, dis[x]))) flavours[k].remove(new Pair(x, dis[x]));
			} else if (op == 'E') {
				x = readInt(); k = readInt();
				while (!shops[x].isEmpty()) {
					int cur = shops[x].pop();
					flavours[cur].remove(new Pair(x, dis[x]));
				}
				dis[x] = k;
			} else {
				k = readInt();
				System.out.println(!flavours[k].isEmpty() ? flavours[k].first().shop : -1);
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
