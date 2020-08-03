import java.io.*;
import java.util.StringTokenizer;

public class Lektira {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String word = readLine();
		String best = "{";
		for (int i = 1; i < word.length() - 1; i ++) {
			for (int l = i + 1; l < word.length(); l ++) {
				String part1 = word.substring(0, i), part2 = word.substring(i, l), part3 = word.substring(l);
				String temp1 = "", temp2 = "", temp3 = "";
				for (int j = part1.length() - 1; j >= 0; j --) temp1 += part1.charAt(j);
				for (int j = part2.length() - 1; j >= 0; j --) temp2 += part2.charAt(j);
				for (int j = part3.length() - 1; j >= 0; j --) temp3 += part3.charAt(j);
				String str = temp1 + temp2 + temp3;
				if (str.compareTo(best) < 0) best = str;
			}
		}
		System.out.println(best);
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
