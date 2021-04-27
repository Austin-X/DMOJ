import java.io.*;
import java.util.*;

public class OnTheClock {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		
		double curN = 0; int curCol = 1;
		int ans = 0;
		
		ArrayList<Integer> row = new ArrayList<Integer>(), col = new ArrayList<Integer>();
		while (curCol != m + 1) {
			double newN = (long)n * (long)curCol / (double)m;
			int lower = (int) Math.floor(curN), upper = (int)Math.ceil(newN);
			ans += upper - lower;
			for (int i = lower + 1; i <= upper; i ++) {
				row.add(i);
				col.add(curCol);
			}
			curCol ++;
			curN = newN;
		}
		
		System.out.println(ans);
		for (int i = 0; i < row.size(); i ++) {
			System.out.println(row.get(i) + " " + col.get(i));
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
