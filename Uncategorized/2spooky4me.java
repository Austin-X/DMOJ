import java.io.*;
import java.util.*;

public class TooSpooky4Me {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), l = readInt(), s = readInt();
		TreeSet<Integer> set = new TreeSet<Integer>();
		HashMap<Integer, Double> map = new HashMap<Integer, Double>();
		
		for (int i = 0; i < n; i ++) {
			int a = readInt(), b = readInt(), spook = readInt();
			if (set.contains(a)) {
				map.put(a, map.get(a) + spook);
			} else {
				set.add(a); map.put(a, (double)spook);
			}
			if (set.contains(b + 1)) {
				map.put(b + 1, map.get(b + 1) - spook);
			} else {
				set.add(b + 1); map.put(b + 1, -(double)spook);
			}
		}
		
		int ans = 0, cur = 0, curIdx = 1;
		for (int x : set) {
			if (x > l) break;
			if (cur < s) ans += x - curIdx;
			cur += map.get(x); curIdx = x;
		}
		if (cur < s) ans += l - curIdx + 1;
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
