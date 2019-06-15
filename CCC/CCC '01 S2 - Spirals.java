import java.io.*;

public class Spirals {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int start = Integer.parseInt(br.readLine());
		int end = Integer.parseInt(br.readLine());
		
		int rowsReq = 1, colsReq = 1, rowCn = 0, colCn = 0, rowCnCheck = 1, colCnCheck = 1;
		
		for (int i = start; i <= end; i ++) {
			rowCn ++;
			colCn ++;
			if (rowCn == rowCnCheck) {
				rowsReq ++;
				rowCn = 0;
				rowCnCheck += 2;
			}
			if (colCn == colCnCheck) {
				colsReq ++;
				colCn = 0;
				colCnCheck += 2;
			}
		}
		
		int[][] spiral = new int[rowsReq][colsReq];
		spiral[(rowsReq - 1) / 2][(colsReq - 1) / 2] = start;
		int tempRow = (rowsReq - 1) / 2, tempCol = (colsReq - 1) / 2;
		int maxDown = 1, maxRight = 1, maxUp = 2, maxLeft = 2;
		
		outerloop: while (start != end) {
			for (int i = 0; i < maxDown; i ++) {
				start ++;
				tempRow ++;
				spiral[tempRow][tempCol] = start;
				if (start == end || tempRow > rowsReq) break outerloop;
			}
			maxDown += 2;
			
			for (int i = 0; i < maxRight; i ++) {
				start ++;
				tempCol ++;
				spiral[tempRow][tempCol] = start;
				if (start == end || tempCol > colsReq) break outerloop;
			}
			maxRight += 2;
			
			for (int i = 0; i < maxUp; i ++) {
				start ++;
				tempRow --;
				spiral[tempRow][tempCol] = start;
				if (start == end || tempRow < 0) break outerloop;
			}
			maxUp += 2;
			
			for (int i = 0; i < maxLeft; i ++) {
				start ++;
				tempCol --;
				spiral[tempRow][tempCol] = start;
				if (start == end || tempCol < 0) break outerloop;
			}
			maxLeft += 2;
		}
		
		for (int i = 0; i < spiral.length; i++) {
			for (int j = 0; j < spiral[0].length; j++) {
				if (spiral[i][j] != 0) 
					System.out.print(spiral[i][j] + " ");
				else System.out.print(" ");
			}
			System.out.println();
		}
	}
}
