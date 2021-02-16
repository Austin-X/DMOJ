import java.io.*;
import java.util.*;

public class TerrificTriangles {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			long l1 = readInt(), l2 = readInt(), l3 = readInt();
			
			if (Math.sqrt(l1 * l1 + l2 * l2) == l3 || Math.sqrt(l1 * l1 + l3 * l3) == l2 || Math.sqrt(l2 * l2 + l3 * l3) == l1)
				System.out.println("R");
			else if (Math.sqrt(l1 * l1 + l2 * l2) < l3 || Math.sqrt(l1 * l1 + l3 * l3) < l2 || Math.sqrt(l2 * l2 + l3 * l3) < l1)
				System.out.println("O");
			else System.out.println("A");
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
