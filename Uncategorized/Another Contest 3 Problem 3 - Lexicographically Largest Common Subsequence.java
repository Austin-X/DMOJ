import java.io.*;
import java.util.*;

public class LexicographicallyLargestCommonSubsequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		String[] arr = new String[n];
		for (int i = 0; i < n; i ++) arr[i] = readLine();
		int[] curIdx = new int[n]; boolean flag = false;
		for (int i = 25; i >= 0; i --) {
			boolean found = true;
			while (found) {
				int[] temp = new int[n];
				for (int j = 0; j < n; j ++) {
					found = false;
					for (int k = curIdx[j]; k < arr[j].length(); k ++) {
						if (arr[j].charAt(k) == (char)(i + 'a')) { temp[j] = k; found = true; break; }
					}
					if (!found) break;
				}
				if (found) {
					for (int j = 0; j < n; j ++) curIdx[j] = temp[j] + 1;
					System.out.print((char)(i + 'a'));  
					flag = true;
				}
			}
		}
		System.out.println(flag ? "" : -1);
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
