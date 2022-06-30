import java.io.*;
import java.util.*;

public class HomeworkQuestions {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n * n; i ++) {
			int x = readInt();
			map.putIfAbsent(x, 0);
			map.put(x, map.get(x) + 1);
		}

		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int key: map.keySet()) if (map.get(key) % 2 == 1) ans.add(key / 2);
		Collections.sort(ans);
		for (int i = 0; i < n - 1; i ++) System.out.print(ans.get(i) + " ");
		System.out.println(ans.get(n - 1));
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
