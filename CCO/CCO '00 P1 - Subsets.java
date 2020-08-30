import java.io.*;
import java.util.*;

public class Subsets {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt();
		HashSet<Integer>[] sets = new HashSet[26]; HashSet<Character>[] adj = new HashSet[26]; boolean[] ans = new boolean[26];
		for (int i = 0; i < 26; i ++) { sets[i] = new HashSet<Integer>(); adj[i] = new HashSet<Character>(); }
		for (int i = 0; i < n; i ++) {
			String[] ch = readLine().split(" ");
			int x = ch[0].charAt(0) - 'A'; char y = ch[2].charAt(0); ans[x] = true;
			if (Character.isUpperCase(y)) { sets[x].add(y - 'A'); ans[y - 'A'] = true; }
			else adj[x].add(y);
		}
		
		for (int i = 0; i < 26; i ++) {
			if (ans[i]) {
				Queue<Integer> q = new LinkedList<Integer>();
				boolean[] vis = new boolean[26];
				vis[i] = true; q.add(i);
				while (!q.isEmpty()) {
					int cur = q.poll();
					for (int x : sets[cur]) {
						if (!vis[x]) {
							for (char c : adj[x]) adj[i].add(c);
							q.add(x); vis[x] = true;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < 26; i ++) {
			if (ans[i]) {
				System.out.print((char)(i + 'A') + " = {");
				ArrayList<Character> arr = new ArrayList<Character>();
				for (char c : adj[i]) arr.add(c);
				Collections.sort(arr);
				int size = arr.size(), cnt = 1;
				for (char c : arr) {
					if (cnt == size) System.out.print(c);
					else { System.out.print(c + ","); cnt ++; }
				}
				System.out.println("}");
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
