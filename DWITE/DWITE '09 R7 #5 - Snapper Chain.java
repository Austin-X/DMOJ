import java.io.*;
import java.util.*;

public class SnapperChain {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 5; i ++) {
			int n = readInt(), k = readInt();
			int pw = (int) Math.pow(2, n);
			if (k < pw) println(k == pw - 1 ? "ON" : "OFF");
			else println(k % 2 == 0 ? "OFF" : "ON");
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
	static void print(Object x) {
		System.out.print(x);
	}
	static void println(Object x) {
		System.out.println(x);
	}
}
