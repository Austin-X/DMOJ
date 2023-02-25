package ecna;

import java.io.*;
import java.util.*;

public class B {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Pair implements Comparable<Pair> {
		int disk1, disk2;
		
		Pair(int disk1, int disk2) { this.disk1 = disk1; this.disk2 = disk2; }
		
		@Override
		public int compareTo(Pair p) {
			if (disk1 + disk2 == p.disk1 + p.disk2) {
				return -Integer.compare(disk1 - disk2, p.disk1 - p.disk2);
			} else {
				return Integer.compare(disk1 + disk2, p.disk1 + p.disk2);
			}
		}
		public String toString() { return "(" + disk1 + ", " + disk2 + ")"; }
		@Override
		public int hashCode() {
			return Objects.hash(disk1, disk2);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			return disk1 == other.disk1 && disk2 == other.disk2;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int c = readInt(), n = readInt();
		int[] w = new int[n + 1];
		for (int i = 1; i <= n; i ++) w[i] = readInt();
		
		HashSet<Pair>[] dp = new HashSet[2 * c + 1];
		for (int i = 0; i <= n; i ++) for (int j = 0; j <= 2 * c; j ++) dp[i] = new HashSet<Pair>();
		dp[0].add(new Pair(0, 0));
		
		for (int i = 1; i <= n; i ++) {
			for (int j = 0; j <= 2 * c; j ++) {
				if (j - w[i] >= 0 && !dp[j - w[i]].isEmpty()) {
					for (Pair p: dp[j - w[i]]) {
						int val1 = p.disk1, val2 = p.disk2;
						val2 += w[i];
						if (val2 <= c) dp[j].add(new Pair(Math.max(val1, val2), Math.min(val1, val2)));
						val2 -= w[i];
						val1 += w[i];
						if (val1 <= c) dp[j].add(new Pair(Math.max(val1, val2), Math.min(val1, val2)));
					}
				}
			}
		}

		Pair ans = null;
		for (int i = 2 * c; i >= 0; i --) {
			if (!dp[i].isEmpty()) {
				for (Pair p: dp[i]) ans = max(ans, p);
			}
		}
		println(ans.disk1 + " " + ans.disk2);
	}
	
	static Pair max(Pair p1, Pair p2) {
		if (p1 != null && p2 != null) {
			if (p1.compareTo(p2) >= 0) return p1;
			else return p2;
		} else if (p1 != null) return p1;
		else if (p2 != null) return p2;
		else return null;
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
	static void print(Object x) {
		System.out.print(x);
	}
	static void println(Object x) {
		System.out.println(x);
	}
}

