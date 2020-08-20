import java.io.*;
import java.util.*;

public class SuperSquirrelSisters {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), ans = 0, size = (int)Math.sqrt(n);
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) arr[i] = readInt();
		
		int[] cnt = new int[n + 1], freq = new int[n + 1];
		for (int i = 1; i <= size; i ++) {
			int val = (int)Math.pow(i, 2);
			for (int j = 0; j < val; j ++) { 
				cnt[arr[j]] ++; 
				freq[cnt[arr[j]]] ++;
			}
			if (freq[i] == i) ans ++;
			for (int j = val; j < n; j ++) {
				freq[cnt[arr[j - val]]] --;
				cnt[arr[j - val]] --;
				cnt[arr[j]] ++;
				freq[cnt[arr[j]]] ++;
				if (freq[i] == i) ans ++;
			}
			for (int j = 0; j <= n; j ++) { freq[j] = 0; cnt[j] = 0; }
		}
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
