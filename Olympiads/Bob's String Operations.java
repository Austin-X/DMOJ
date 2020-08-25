import java.io.*;
import java.util.*;

public class BobsStringOperations {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String s = readLine(), t = readLine();
		HashMap<Character, Character> map = new HashMap<Character, Character>(), map2 = new HashMap<Character, Character>();
		
		for (int i = 0; i < s.length(); i ++) {
			if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) { System.out.println("No"); System.exit(0); }
			else if (map2.containsKey(t.charAt(i)) && map2.get(t.charAt(i)) != s.charAt(i)) { System.out.println("No"); System.exit(0); }
			map.put(s.charAt(i), t.charAt(i));
			map2.put(t.charAt(i), s.charAt(i));
		}
		System.out.println("Yes");
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
