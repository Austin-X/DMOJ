import java.io.*;
import java.util.*;

public class AlpacaArrays {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static final int MV = 100000;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {		
		int n = readInt(), q = readInt();
		ArrayList<Integer>[] vals = new ArrayList[MV + 1];
		for (int i = 1; i <= MV; i ++) vals[i] = new ArrayList<Integer>();
		
		for (int i = 1; i <= n; i ++) vals[readInt()].add(i);
		for (int i = 0; i < q; i ++) {
			int l = readInt(), r = readInt(), x = readInt();
			
			boolean flag = false;
			for (int j = 1; j <= Math.sqrt(x); j ++) {
				if (x % j == 0 && x / j != j) {
					int lb = Collections.binarySearch(vals[j], l), rb = Collections.binarySearch(vals[j], r);
					int lb2 = Collections.binarySearch(vals[x / j], l), rb2 = Collections.binarySearch(vals[x / j], r);
					if ((lb >= 0 || rb >= 0 || lb != rb) && (lb2 >= 0 || rb2 >= 0 || lb2 != rb2)) {
						flag = true;
						break;
					}	
				}
			}
			System.out.println(flag ? "YES" : "NO");
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
