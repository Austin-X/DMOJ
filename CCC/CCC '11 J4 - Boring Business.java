import java.io.*;
import java.util.*;

public class BoringBusiness {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] hole = new int[420][420];
		hole[200][203] = 1; hole[201][203] = 1; hole[202][203] = 1; hole[202][204] = 1; hole[202][205] = 1; hole[202][206] = 1;
		hole[203][206] = 1; hole[204][202] = 1; hole[204][206] = 1; hole[204][207] = 1; hole[204][208] = 1; hole[203][208] = 1; hole[202][208] = 1;
		hole[202][209] = 1; hole[202][210] = 1; hole[203][210] = 1; hole[204][210] = 1; hole[205][202] = 1; hole[205][210] = 1;
		hole[206][202] = 1; hole[206][203] = 1; hole[206][204] = 1; hole[206][205] = 1; hole[206][206] = 1; hole[206][207] = 1; hole[206][208] = 1; 
		hole[206][209] = 1; hole[206][210] = 1;
		
		char dir; 
		int units, curRow = 204, curCol = 202;
		boolean safe = true;
		while (true) {
			st = new StringTokenizer(br.readLine());
			dir = st.nextToken().charAt(0);
			units = Integer.parseInt(st.nextToken());
			
			if (dir == 'q' || !safe) break;
			else if (dir == 'd') {
				safe = true;
				for (int i = 0; i < units; i ++) {
					curRow ++; 
					if (hole[curRow][curCol] == 1) safe = false;
					hole[curRow][curCol] = 1;
				}
				System.out.print((curCol - 203) + " " + (0 - curRow + 199) + " ");
				System.out.println(safe ? "safe" : "DANGER");
			} else if (dir == 'u') {
				safe = true;
				for (int i = 0; i < units; i ++) {
					curRow --; 
					if (hole[curRow][curCol] == 1) safe = false;
					hole[curRow][curCol] = 1;
				}
				System.out.print((curCol - 203) + " " + (0 - curRow + 199) + " ");
				System.out.println(safe ? "safe" : "DANGER");
			} else if (dir == 'l') {
				safe = true;
				for (int i = 0; i < units; i ++) {
					curCol --; 
					if (hole[curRow][curCol] == 1) safe = false;
					hole[curRow][curCol] = 1;
				}
				System.out.print((curCol - 203) + " " + (0 - curRow + 199) + " ");
				System.out.println(safe ? "safe" : "DANGER");
			} else if (dir == 'r') {
				safe = true;
				for (int i = 0; i < units; i ++) {
					curCol ++; 
					if (hole[curRow][curCol] == 1) safe = false;
					hole[curRow][curCol] = 1;
				}
				System.out.print((curCol - 203) + " " + (0 - curRow + 199) + " ");
				System.out.println(safe ? "safe" : "DANGER");
			}
		}
	}
}
