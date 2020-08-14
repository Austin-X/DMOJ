import java.io.*;
import java.util.*;

public class Microwaves {
	static class Pair implements Comparable<Pair>{
		int t, f;
		Pair (int t, int f) { this.t = t; this.f = f; }
		public int compareTo(Pair p) { return Integer.compare(t, p.t); }
	}
	
	static class MyLong implements Comparable<MyLong> {
		long val; int idx;
		MyLong(long val, int idx) { this.val = val; this.idx = idx; }
		public int compareTo (MyLong m) {
			if (val == m.val) return Integer.compare(idx, m.idx);
			else return Long.compare(val, m.val);
		}
	} 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), t = readInt();
		TreeSet<Pair> people = new TreeSet<Pair>(); 
		for (int i = 0; i < m; i ++) people.add(new Pair(readInt(), readInt()));

		TreeSet<MyLong> microwave = new TreeSet<MyLong>();
		for (int i = 0; i < n; i ++) microwave.add(new MyLong((long)0, i));
		
		MyLong temp;
		for (int i = 0; i < m; i ++) {
			if (people.first().t - microwave.first().val >= t) { System.out.println(microwave.first().val); System.exit(0); }
			temp = microwave.floor(new MyLong((long) people.first().t, Integer.MAX_VALUE));
			if (temp != null) {
				microwave.remove(temp);
				microwave.add(new MyLong(Math.max(temp.val, people.first().t) + people.pollFirst().f, i + n));
			} else {
				temp = microwave.first();
				microwave.remove(temp);
				microwave.add(new MyLong(temp.val + people.pollFirst().f, i + n));
			}
		}	
		System.out.println(microwave.first().val);
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
