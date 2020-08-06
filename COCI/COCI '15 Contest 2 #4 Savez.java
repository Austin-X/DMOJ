import java.io.*;
import java.util.*;

public class Savez {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Trie {
		HashMap<Character, Trie> children;
		int length;
		Trie () {
			children = new HashMap<Character, Trie>();
			length = 1;
		}
	}
	
	static int ans = 0, temp;
	static Trie root = new Trie();
	static boolean flag;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		
		Trie root = new Trie();
		for (int i = 0; i < n; i ++) {
			String str = readLine();
			flag = true; temp = 1;
			insert(root, str, 0);
			ans = Math.max(ans, temp);
		}

		System.out.println(ans);
	}
	
	static void insert(Trie cur, String str, int idx) {
		if (idx == str.length()) {
			cur.length = temp;
			cur.children.put('$', new Trie()); return;
		}
		
		if (cur.children.isEmpty() || !cur.children.containsKey(str.charAt(idx))) {
			flag = false;
			cur.children.put(str.charAt(idx), new Trie());
			insert(cur.children.get(str.charAt(idx)), str, idx + 1);
		} else {
			if (cur.children.get(str.charAt(idx)).children.containsKey('$') && str.substring(0, idx + 1).equals(str.substring(str.length() - idx - 1)) && flag) {
				temp = Math.max(temp, cur.children.get(str.charAt(idx)).length + 1);
			}
			insert(cur.children.get(str.charAt(idx)), str, idx + 1);
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
