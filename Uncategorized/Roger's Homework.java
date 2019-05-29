import java.io.*;
import java.util.*;

public class RogersHomework {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt(), max = 0;
		PriorityQueue<Integer> points = new PriorityQueue<Integer>(20, Collections.reverseOrder());
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] d = new ArrayList[1000001];
		
		for (int i = 1; i <= 1000000; i ++) {
			d[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n; i ++) {
			int day = readInt();
			if (day > max) max = day;
			int point = readInt();
			d[day].add(point);
		}
		
		int ans = 0;
		for (int i = max; i >= 1; i --) {
			for (int j : d[i]) {
				points.add(j);
			}
			if (!points.isEmpty()) ans += points.poll();
		}
		System.out.println(ans);
	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine().trim());
		}
		return st.nextToken();
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
}
