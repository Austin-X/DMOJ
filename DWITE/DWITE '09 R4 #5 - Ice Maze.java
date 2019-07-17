import java.io.*;
import java.util.*;

public class IceMaze {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] maze = new char[10][10];
		for (int i = 0; i < 10; i ++) {
			maze[i] = br.readLine().toCharArray();
		}
		
		int[][] positions = new int[6][2];
		for (int i = 0; i < 10; i ++) {
			for (int j = 0; j < 10; j ++) {
				if (maze[i][j] == 'A') {
					positions[0][0] = i; positions[0][1] = j;
				} else if (maze[i][j] == 'B') {
					positions[1][0] = i; positions[1][1] = j;
				} else if (maze[i][j] == 'C') {
					positions[2][0] = i; positions[2][1] = j;
				} else if (maze[i][j] == 'D') {
					positions[3][0] = i; positions[3][1] = j;
				} else if (maze[i][j] == 'E') {
					positions[4][0] = i; positions[4][1] = j;
				} else if (maze[i][j] == 'F') {
					positions[5][0] = i; positions[5][1] = j;
				}
			}
		}
		
		char[][] direction = new char[10][10];
		int[][] dis = new int[10][10];
		int index = 1;
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F'};	
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(positions[0][0]);
		q.add(positions[0][1]);
		int row = positions[0][0];
		int col = positions[0][1];
		
		if (col < 9) { q.add(row); q.add(col + 1); direction[row][col + 1] = 'r'; }
		if (col > 0) { q.add(row); q.add(col - 1); direction[row][col - 1] = 'l'; }
		if (row < 9) { q.add(row + 1); q.add(col); direction[row + 1][col] = 'd'; }
		if (row > 0) { q.add(row - 1); q.add(col); direction[row - 1][col] = 'u'; }	
		
		while (!q.isEmpty() && index <= 5) {
			row = q.poll();
			col = q.poll();
			
			boolean bool = false;
			
			if (direction[row][col] == 'r' && col < 9 && maze[row][col + 1] == '#') {
				bool = true;
				if (row > 0) { q.add(row - 1); q.add(col); direction[row - 1][col] = 'u'; dis[row - 1][col] = dis[row][col] + 1; }
				if (row < 9) { q.add(row + 1); q.add(col); direction[row + 1][col] = 'd'; dis[row + 1][col] = dis[row][col] + 1; }
			} else if (direction[row][col] == 'l' && col > 0 && maze[row][col - 1] == '#'){
				bool = true;
				if (row > 0) { q.add(row - 1); q.add(col); direction[row - 1][col] = 'u'; dis[row - 1][col] = dis[row][col] + 1; }
				if (row < 9) { q.add(row + 1); q.add(col); direction[row + 1][col] = 'd'; dis[row + 1][col] = dis[row][col] + 1; }
			} else if (direction[row][col] == 'd' && row < 9 && maze[row + 1][col] == '#') {
				bool = true;
				if (col > 0) { q.add(row); q.add(col - 1); direction[row][col - 1] = 'l'; dis[row][col - 1] = dis[row][col] + 1; }
				if (col < 9) { q.add(row); q.add(col + 1); direction[row][col + 1] = 'r'; dis[row][col + 1] = dis[row][col] + 1; }
			} else if (direction[row][col] == 'u' && row > 0 && maze[row - 1][col] == '#') {
				bool = true;
				if (col > 0) { q.add(row); q.add(col - 1); direction[row][col - 1] = 'l'; dis[row][col - 1] = dis[row][col] + 1; }
				if (col < 9) { q.add(row); q.add(col + 1); direction[row][col + 1] = 'r'; dis[row][col + 1] = dis[row][col] + 1; }
			} else if (row == 0 && col == 0) {
				bool = true;
				if (direction[row][col] == 'l') { q.add(row + 1); q.add(col); direction[row + 1][col] = 'd'; dis[row + 1][col] = dis[row][col] + 1; }
				else { q.add(row); q.add(col + 1); direction[row][col + 1] = 'r'; dis[row][col + 1] = dis[row][col] + 1; }
			} else if (row == 0 && col == 9) {
				bool = true;
				if (direction[row][col] == 'r') { q.add(row + 1); q.add(col); direction[row + 1][col] = 'd'; dis[row + 1][col] = dis[row][col] + 1; }
				else { q.add(row); q.add(col - 1); direction[row][col - 1] = 'l'; dis[row][col - 1] = dis[row][col] + 1; }
			} else if (row == 9 && col == 0) {
				bool = true;
				if (direction[row][col] == 'd') { q.add(row); q.add(col + 1); direction[row][col + 1] = 'r'; dis[row][col + 1] = dis[row][col] + 1; }
				else { q.add(row - 1); q.add(col); direction[row - 1][col] = 'u'; dis[row - 1][col] = dis[row][col] + 1; }
			} else if (row == 9 && col == 9) {
				bool = true;
				if (direction[row][col] == 'r') { q.add(row - 1); q.add(col); direction[row - 1][col] = 'u'; dis[row - 1][col] = dis[row][col] + 1; }
				else { q.add(row); q.add(col - 1); direction[row][col - 1] = 'l'; dis[row][col - 1] = dis[row][col] + 1; }
			} else if (direction[row][col] == 'd' && row == 9) {
				bool = true;
				q.add(row - 1); q.add(col); direction[row - 1][col] = 'u';  dis[row - 1][col] = dis[row][col] + 1; 
				q.add(row); q.add(col + 1); direction[row][col + 1] = 'r'; dis[row][col + 1] = dis[row][col] + 1; 
				q.add(row); q.add(col - 1); direction[row][col - 1] = 'l'; dis[row][col - 1] = dis[row][col] + 1; 
			} else if (direction[row][col] == 'u' && row == 0) {
				bool = true; 
				q.add(row); q.add(col - 1); direction[row][col - 1] = 'l'; dis[row][col - 1] = dis[row][col] + 1; 
				q.add(row); q.add(col + 1); direction[row][col + 1] = 'r'; dis[row][col + 1] = dis[row][col] + 1; 
			} else if (direction[row][col] == 'r' && col == 9) {
				bool = true;
				q.add(row - 1); q.add(col); direction[row - 1][col] = 'u'; dis[row - 1][col] = dis[row][col] + 1; 
				q.add(row + 1); q.add(col); direction[row + 1][col] = 'd';  dis[row + 1][col] = dis[row][col] + 1; 
			} else if (direction[row][col] == 'l' && col == 0) {
				bool = true;
				q.add(row - 1); q.add(col); direction[row - 1][col] = 'u'; dis[row - 1][col] = dis[row][col] + 1; 
				q.add(row + 1); q.add(col); direction[row + 1][col] = 'd'; dis[row + 1][col] = dis[row][col] + 1; 
			}
			
			if(bool) {
				if (maze[row][col] == letters[index]) {
					q.clear();
					q.add(row); q.add(col);
					index ++;
					System.out.println(dis[row][col]);
					for (int[] x : dis) Arrays.fill(x, 0);
				}
			} else if (direction[row][col] == 'r') {
				q.add(row); q.add(col + 1); direction[row][col + 1] = 'r'; dis[row][col + 1] = dis[row][col] + 1; 
			} else if (direction[row][col] == 'd') {
				q.add(row + 1); q.add(col); direction[row + 1][col] = 'd'; dis[row + 1][col] = dis[row][col] + 1; 
			} else if (direction[row][col] == 'l') {
				q.add(row); q.add(col - 1); direction[row][col - 1] = 'l'; dis[row][col - 1] = dis[row][col] + 1; 
			} else if (direction[row][col] == 'u') {
				q.add(row - 1); q.add(col); direction[row - 1][col] = 'u'; dis[row - 1][col] = dis[row][col] + 1; 
			}
		}
	}
}
