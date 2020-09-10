import java.io.*;
import java.util.*;

public class AliceThroughTheLookingGlass {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int m = readInt(), x = readInt(), y = readInt();
			System.out.println(recurse(m, x, y) ? "crystal" : "empty");
		}
	}
	
	static boolean recurse(int m, int x, int y) {
		if (m == 0) return false;
		
		int section = (int) Math.pow(5, m - 1);
		int quadrantX = x / section + 1, quadrantY = y / section + 1;
		if (quadrantX == 2 && quadrantY == 1 || quadrantX == 3 && quadrantY == 1 || quadrantX == 3 && quadrantY == 2 || quadrantX == 4 && quadrantY == 1) return true;
		else if (quadrantX == 2 && quadrantY == 2 || quadrantX == 3 && quadrantY == 3 || quadrantX == 4 && quadrantY == 2) return recurse(m - 1, x - section * (quadrantX - 1), y - section * (quadrantY - 1));
		else return false;
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
