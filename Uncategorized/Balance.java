import java.io.*;
import java.util.*;

public class Balance {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int min = Integer.MAX_VALUE;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		int n = readInt(); arr = new int[n];
		for (int i = 0; i < n; i ++) arr[i] = readInt();
		recurse(new HashSet<Integer>());
		System.out.println(min);
	}
	
	static void recurse(HashSet<Integer> set) {
		if (!set.isEmpty()) {
			int sum1 = 0, sum2 = 0;
			for (int i = 0; i < arr.length; i ++) {
				if (set.contains(i)) sum1 += arr[i];
				else sum2 += arr[i];
			}
			min = Math.min(min, Math.abs(sum1 - sum2));
		}
		for (int i = 0; i < arr.length; i ++) {
			if (!set.contains(i)) {
				set.add(i);
				recurse(set);
				set.remove(i);
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
