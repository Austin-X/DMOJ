import java.io.*;
import java.util.*;

public class FujoNeko {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int rows = Integer.parseInt(st.nextToken());
		int cols = Integer.parseInt(st.nextToken());
		char[][] field = new char[rows][cols];
		
		for (int i = 0; i < rows; i ++) {
			field[i] = br.readLine().toCharArray();
		}
		boolean[] rowCheck = new boolean[rows + 1];
		boolean[] colCheck = new boolean[cols + 1];
		for (int i = 0; i < rows; i ++) {
			for (int j = 0; j < cols; j ++) {
				if (field[i][j] == 'X') {
					rowCheck[i + 1] = true;
					colCheck[j + 1] = true;
				}
			}
		}
		
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (!rowCheck[y] && !colCheck[x]) System.out.println("N");
			else System.out.println("Y");
		}
	}
}
