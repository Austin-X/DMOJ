import java.io.*;
import java.util.*;

public class CourseRequirements {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt();
		
		int[] freq = new int[n + 1];
		ArrayList<Integer>[] adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Integer>();

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i ++) {
			freq[i] = readInt();
			if (freq[i] == 0) q.add(i); 
			for (int j = 0; j < freq[i]; j ++) adj[readInt()].add(i);
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for (int x: adj[cur]) {
				freq[x] --;
				if (freq[x] == 0) q.add(x); 
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
