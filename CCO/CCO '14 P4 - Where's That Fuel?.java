import java.io.*;
import java.util.*;

public class WheresThatFuel {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static class Pair implements Comparable<Pair> {
		int a, b, idx;
		Pair (int a, int b, int idx) { this.a = a; this.b = b; this.idx = idx; }
		public int compareTo (Pair p) {
			if (b == p.b) return 1;
			else return Integer.compare(b, p.b);
		}
	}
	public static void main(String[] args) throws IOException {
		int n = readInt(), p = readInt();
		int[] arr1 = new int[n], arr2 = new int[n];
		for (int i = 0; i < n; i ++) {
			arr1[i] = readInt(); arr2[i] = readInt();
		}
		TreeSet<Pair> set = new TreeSet<Pair>();
		for (int i = 0; i < n; i ++) {
			if (i != p - 1 && arr1[i] >= arr2[i]) set.add(new Pair(arr1[i], arr2[i], i));
		}

		int ans = arr1[p - 1], cn = 1;
		while (!set.isEmpty()) {
			if (set.first().b > ans) break;
			ans -= set.first().b; ans += set.pollFirst().a; cn ++;
		}
		System.out.println(ans);
		System.out.println(cn);
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
