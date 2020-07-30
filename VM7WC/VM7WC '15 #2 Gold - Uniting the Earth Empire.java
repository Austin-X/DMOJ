import java.io.*;
import java.util.*;

public class UnitingTheEarthEmpire {
	static class Pair {
		long val; int cnt;
		Pair (long val, int cnt) { this.val = val; this.cnt = cnt; }
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		
		Stack<Pair> s = new Stack<Pair>();
		long ans = 0;
		for (int i = 0; i < n; i ++) {
			long x = readLong();
			int cnt = 1;
			while (!s.isEmpty()) {
				if (s.peek().val == x) { cnt = s.peek().cnt + 1; ans += s.pop().cnt; }
				else if (x > s.peek().val) ans += s.pop().cnt; 
				else { ans ++; break; }
			}
			s.push(new Pair(x, cnt));
		}
		System.out.println(ans);
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
