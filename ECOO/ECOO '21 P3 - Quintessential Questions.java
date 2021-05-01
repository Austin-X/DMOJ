import java.io.*;
import java.util.*;

public class QuintessentialQuestions {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Pair {
		int score, prof;
		Pair (int s, int p) { score = s; prof = p; }
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), k = readInt();
		
		Pair[] question = new Pair[n + 1];
		for (int i = 1; i <= n; i ++) question[i] = new Pair(-1, -1);
		for (int i = 0; i < k; i ++) {
			int a = readInt(), b = readInt(), c = readInt();
			if (c > question[b].score) question[b] = new Pair(c, a);
		}
		for (int i = 1; i < n; i ++) System.out.print(question[i].prof + " ");
		System.out.println(question[n].prof);
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
