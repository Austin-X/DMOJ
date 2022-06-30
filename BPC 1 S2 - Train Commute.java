import java.io.*;
import java.util.*;

public class TrainCommute {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[] ans;
	static int idx;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		int n = readInt(), c = readInt(), q = readInt();
		
		System.out.println("? " + 0 + " " + c);
		System.out.flush();
		int length = c - readInt();
		
		int min, max;
		int l = 0, r = c - length;
		while (l <= r) {
			int mid = (l + r) >> 1;
			System.out.println("? " + mid + " " + c);
			System.out.flush();
			int x = readInt();
			if (c - mid - x == length) l = mid + 1;
			else r = mid - 1;
		}
		min = l - 1;
		max = min + length;
		ans = new int[n];
		idx = 2;
		ans[0] = min; ans[1] = max;
		
		recurse(min, max);
		
		System.out.print("! ");
		for (int i = 0; i < n; i ++) System.out.print(i != n - 1 ? ans[i] + " " : ans[i] + "\n");
		System.out.flush();
	}
	
	static void recurse(int min, int max) throws IOException {
		if (max - min <= 3) return;
		
		int mid = (min + max) >> 1;
		
		System.out.println("? " + min + " " + mid);
		System.out.flush();
		int x = readInt();
		
		if (x == mid - min) return;
		
		System.out.println("? " + min + " " + (mid - x));
		System.out.flush();
		int res = readInt();

		if (res == 0) { ans[idx++] = mid - x; recurse(min, mid - x); recurse(mid - x, max); }
		else { ans[idx++] = mid + x; recurse(min, mid + x); recurse(mid + x, max); }
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
