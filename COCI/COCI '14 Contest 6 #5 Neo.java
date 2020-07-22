import java.io.*;
import java.util.*;

public class Neo {
	static class Pair {
		int val, idx;
		Pair (int val, int idx) { this.val = val; this.idx = idx; }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[r + 1][s + 1];
		for (int i = 1; i <= r; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= s; j ++) matrix[i][j] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] pass = new boolean[r + 1][s + 1];

		for (int i = 2; i <= r; i ++) {
			for (int j = 2; j <= s; j ++) {
				if (matrix[i - 1][j - 1] + matrix[i][j] <= matrix[i][j - 1] + matrix[i - 1][j]) pass[i][j] = true;
			}
		}

		int ans = 0;
		int[] psaCol = new int[s + 1];
		
		Stack<Pair> stack = new Stack<Pair>();
		for (int i = 2; i <= r; i ++) {
			for (int j = 2; j <= s; j ++) {
				if (pass[i][j]) { 
					psaCol[j] ++;
					while (!stack.isEmpty() && psaCol[j] <= stack.peek().val) {
						if (psaCol[j] == stack.peek().val) stack.pop();
						else {
							int height = stack.pop().val + 1, width = stack.isEmpty() ? j - 1 : j - stack.peek().idx;
							ans = Math.max(ans, width * height);
						}	
					}
					stack.push(new Pair(psaCol[j], j));
				} else {
					while (!stack.isEmpty() && 0 <= stack.peek().val) {
						if (0 == stack.peek().val) stack.pop();
						else {
							int height = stack.pop().val + 1, width = stack.isEmpty() ? j - 1 : j - stack.peek().idx;
							ans = Math.max(ans, width * height);
						}
					}
					stack.push(new Pair(0, j)); 
					psaCol[j] = 0;
				}
			}

			while (!stack.isEmpty() && 0 <= stack.peek().val) {
				if (0 == stack.peek().val) stack.pop();
				else {
					int height = stack.pop().val + 1, width = stack.isEmpty() ? s : s - stack.peek().idx + 1;
					ans = Math.max(ans, width * height);
				}
			}
		}
		
		System.out.println(ans);
	}
}
