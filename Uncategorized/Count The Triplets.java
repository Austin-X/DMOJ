import java.io.*;
import java.util.*;

public class CountTheTriplets {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] arr = new int[n]; boolean[] flag = new boolean[2000001];
		for (int i = 0; i < n; i ++) { arr[i] = readInt(); flag[arr[i]] = true; }
		Arrays.sort(arr);
		int ans = 0;
		for (int i = 0; i < n; i ++) {
			if (i > 0 && arr[i] == arr[i - 1]) continue;
			for (int j = i + 1; j < n; j ++) {
				if (j - i > 1) {
					if (arr[j] == arr[j - 1]) continue;
					else if (flag[arr[i] + arr[j]]) ans ++;
				} else if (flag[arr[i] + arr[j]]) ans ++;
			}
		}
		System.out.println(ans == 0 ? -1 : ans);
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
