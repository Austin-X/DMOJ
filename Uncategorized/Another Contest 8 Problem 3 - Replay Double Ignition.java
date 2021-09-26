import java.io.*;
import java.util.*;

public class ReplayDoubleIgnition {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int m = readInt(), q = readInt();

		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(1); ans.add(1);
		
		int cur = 1, prev = 1;
		while (true) {
			int x = (cur + prev) % m;
			for (char c: String.valueOf(x).toCharArray()) ans.add(Character.getNumericValue(c));
			if (x == 0 && cur == 1) break;
			prev = cur;
			cur = x;
		}
		
		while (q-- > 0) {
			long n = readLong();
			int rem = (int) (n % ans.size());
			if (rem != 0) System.out.println(ans.get(rem - 1));
			else System.out.println(ans.get(ans.size() - 1));
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
