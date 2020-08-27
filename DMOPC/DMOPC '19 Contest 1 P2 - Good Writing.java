import java.io.*;
import java.util.*;

public class GoodWriting {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int k; static final String STR = "Good writing is good writing is good writing.";
	static final String PART1 = "Good writing is good ", PART2 = " writing is good ", PART3 = " is good writing.";
	static long[] arr;
	public static void main(String[] args) throws IOException {
		int l = STR.length(), q = readInt();
		for (int t = 0; t < q; t ++) {
			int n = readInt(); k = readInt();
			arr = new long[n + 1]; arr[0] = l;
			for (int i = 1; i <= n; i ++) arr[i] = 55 + arr[i - 1] * 2;
			System.out.println(recurse(1, n));
		}
	}
	
	static char recurse(long cur, int idx) {
		if (idx == 0) return(STR.charAt((int)(k - cur)));
		if (k <= cur + 20) return(PART1.charAt((int)(k - cur)));

		cur += 21;
		if (k <= cur + arr[idx - 1] - 1) return(recurse(cur, idx - 1));
		else {
			cur += arr[idx - 1];
			if (k <= cur + 16) return(PART2.charAt((int)(k - cur))); 
			cur += 17;
			if (k <= cur + arr[idx - 1] - 1) return(recurse(cur, idx - 1));
			cur += arr[idx - 1];
			if (k <= cur + 16) return(PART3.charAt((int)(k - cur))); 
		}
		return '.';
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
