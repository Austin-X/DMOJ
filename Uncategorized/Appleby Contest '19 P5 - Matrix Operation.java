import java.io.*;
import java.util.*;

public class MatrixOperation {
	static class Triple implements Comparable<Triple> {
		int x, y, val;
		Triple (int x, int y, int val) { this.x = x; this.y = y; this.val = val; }
		public int compareTo (Triple p) { return Integer.compare(val, p.val); }
		public String toString() {
			return String.format(x + ", " + y + ", " + val);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] moves = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		ArrayList<Triple> arr = new ArrayList<Triple>();
		for (int i = 0; i < n; i ++) 
			for (int j = 0; j < n; j ++) 
				arr.add(new Triple(i, j, readInt()));
		Collections.sort(arr);
		int prev = 0; int[][] dp = new int[n][n]; Stack<Triple> s = new Stack<Triple>();
		for (int i = 0; i < arr.size(); i ++) {
			int max = 1, x = arr.get(i).x, y = arr.get(i).y, val = arr.get(i).val;
			if (val > prev) { 
				while (!s.isEmpty()) dp[s.peek().x][s.peek().y] = s.pop().val;	
				prev = val;
			}
			for (int j = 0; j < 4; j ++) {
				int xCoor = x + moves[j][0], yCoor = y + moves[j][1]; 
				if (xCoor >= 0 && xCoor < n && yCoor >= 0 && yCoor < n && dp[xCoor][yCoor] != 0) max = Math.max(max, dp[xCoor][yCoor] + 1);
			}
			s.push(new Triple(x, y, max));
		}
		while (!s.isEmpty()) dp[s.peek().x][s.peek().y] = s.pop().val;	
		int ans = 0;
		for (int i = 0; i < n; i ++)
			for (int j = 0; j < n; j ++) 
				ans = Math.max(ans, dp[i][j]);
		System.out.println(ans - 1);
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
