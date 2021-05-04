import java.io.*;
import java.util.*;

public class HappyAlpacas {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), x = readInt();
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (n % 2 == 1) {
			if (x % 2 == 0) System.out.println(-1);
			else {
				for (int i = 0; i <= x; i ++) ans.add(1);
				int flag = 1;
				for (int i = x + 1; i < n; i ++) {
					ans.add(flag == 1 ? 2 : 1);
					flag = -flag;
				}
				if (n == x) ans.remove(ans.size() - 1);
			}
		} else {
			if (x % 2 == 1) System.out.println(-1);
			else {
				for (int i = 0; i <= x; i ++) ans.add(1);
				int flag = 1;
				for (int i = x + 1; i < n; i ++) {
					ans.add(flag == 1 ? 2 : 1);
					flag = -flag;
				}
				if (n == x) ans.remove(ans.size() - 1);
			}
		}
		
		for (int i = 0; i < ans.size() - 1; i ++) System.out.print(ans.get(i) + " ");
		if (!ans.isEmpty()) System.out.println(ans.get(ans.size() - 1));
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
