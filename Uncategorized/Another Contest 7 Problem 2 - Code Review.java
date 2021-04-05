import java.io.*;
import java.util.*;

public class CodeReview {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		int[] cur = new int[n + 1], location = new int[n + 1];
		for (int i = 1; i <= n; i ++) {
			set.add(i);
			cur[i] = i;
			location[i] = i;
		}
		
		while (true) {
			for (int i = 1; i < n; i ++) System.out.print(cur[i] + " ");
			System.out.println(cur[n]);
			System.out.flush();
			int x = readInt();
			
			if (x == 0) System.exit(0);
			else {
				set.remove(cur[x]);
				int val = set.first();
				
				int temp = cur[location[val]];
				cur[location[val]] = x;
				cur[x] = temp;
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
