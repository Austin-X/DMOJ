import java.io.*;
import java.util.*;

public class PlayfulPlaydoughs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		
		long[] freq = new long[(int) (1e5 + 1)];
		for (int i = 0; i < n; i ++) freq[readInt()] ++;
		
		for (int t = 0; t < q; t ++) {
			int choice = readInt();
			
			if (choice == 1) {
				int x = readInt();
				int ceil = (int) Math.ceil((double)x / 2), floor = (int) Math.floor((double)x / 2);
				freq[ceil] += freq[x];
				freq[floor] += freq[x];
				freq[x] = 0;
			} else {
				System.out.println(freq[readInt()]);
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
