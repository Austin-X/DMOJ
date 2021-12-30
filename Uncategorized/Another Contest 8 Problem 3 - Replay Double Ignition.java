import java.io.*;
import java.util.*;

public class ReplayDoubleIgnition {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int m = readInt(), q = readInt();

		int cur = 1, prev = 1;
		ArrayList<Character> arr = new ArrayList<Character>();
		arr.add('1'); arr.add('1');
		
		@SuppressWarnings("unchecked")
		HashSet<Integer>[] vis = new HashSet[m + 1];
		for (int i = 0; i <= m; i ++) vis[i] = new HashSet<Integer>();
		vis[1].add(1);
		
		while (true) {
			int next = (cur + prev) % m;
			if (vis[cur].contains(next)) {
				for (int i = 0; i < String.valueOf(cur).length(); i ++) arr.remove(arr.size() - 1);
				break;
			}
			
			char[] temp = String.valueOf(next).toCharArray();
			for (char c: temp) arr.add(c);
			vis[cur].add(next);
			prev = cur;
			cur = next;
		}
		
		while (q-- > 0) {
			long n = readLong() - 1;
			n %= arr.size();
			System.out.println(arr.get((int)n));
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
