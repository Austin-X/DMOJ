import java.io.*;
import java.util.*;

public class CrossingField {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); 
		int[][] field = new int[n + 1][n + 1];
		boolean[][] visited = new boolean[n + 1][n + 1];
		
		int h = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j ++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(1);
		
		while (!stack.empty()) {
			int y = stack.pop();
			int x = stack.pop();
			visited[x][y] = true;
			
			if (visited[n][n]) break;
			
			if (x > 1 && Math.abs(field[x][y] - field[x - 1][y]) <= h && !visited[x - 1][y]) { stack.push(x - 1); stack.push(y); } 
			if (x < n && Math.abs(field[x][y] - field[x + 1][y]) <= h && !visited[x + 1][y]) { stack.push(x + 1); stack.push(y); }
			if (y > 1 && Math.abs(field[x][y] - field[x][y - 1]) <= h && !visited[x][y - 1]) { stack.push(x); stack.push(y - 1); }
			if (y < n && Math.abs(field[x][y] - field[x][y + 1]) <= h && !visited[x][y + 1]) { stack.push(x); stack.push(y + 1); }
		}

		System.out.println(visited[n][n] ? "yes" : "no");
	}
}
