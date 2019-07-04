import java.io.*;
import java.util.*;

public class CrossSpiral {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int rectWidth = Integer.parseInt(br.readLine());
		int rectHeight = Integer.parseInt(br.readLine());
		int cutoutWidth = Integer.parseInt(br.readLine());
		int cutoutHeight = Integer.parseInt(br.readLine());
		int steps = Integer.parseInt(br.readLine());
		
		int[][] cross = new int[rectHeight][rectWidth];
		for (int[] x : cross) Arrays.fill(x, 1);
		
		for (int i = 0; i < cutoutHeight; i ++) 
			for (int j = 0; j < cutoutWidth; j ++) 
				cross[i][j] = 0;
		for (int i = rectHeight - cutoutHeight; i < rectHeight; i ++) 
			for (int j = 0; j < cutoutWidth; j ++) 
				cross[i][j] = 0;
		for (int i = 0; i < cutoutHeight; i ++) 
			for (int j = rectWidth - cutoutWidth; j < rectWidth; j ++) 
				cross[i][j] = 0;
		for (int i = rectHeight - cutoutHeight; i < rectHeight; i ++) 
			for (int j = rectWidth - cutoutWidth; j < rectWidth; j ++) 
				cross[i][j] = 0;
		
		int row = 0, col = 0;
		outerloop : for (int i = 0; i < rectHeight; i ++) {
			for (int j = 0; j < rectWidth; j ++) {
				if (cross[i][j] == 1) {
					row = i; col = j; break outerloop;
				}
			}
		}
		
		char dir = 'r';
		while (steps > 0) {
			cross[row][col] = 0;
			
			if (row > 0 && row < rectHeight - 1 && col > 0 && col < rectWidth - 1 && cross[row - 1][col] == 0 && cross[row + 1][col] == 0 && cross[row][col - 1] == 0 && cross[row][col + 1] == 0) break; 
			
			if (dir == 'r') {
				if (row > 0 && cross[row - 1][col] == 1) {
					dir = 'u'; steps ++;
				}
				else if (col == rectWidth - 1 || cross[row][col + 1] == 0) {
					dir = 'd'; steps ++;
				} else {
					col ++;
				}
			} else if (dir == 'd') {
				if (col < rectWidth - 1 && cross[row][col + 1] == 1) {
					dir = 'r'; steps ++;
				}
				else if (row == rectHeight - 1 || cross[row + 1][col] == 0) {
					dir = 'l'; steps ++;
				} else {
					row ++; 
				}
			} else if (dir == 'l') {
				if (row < rectHeight - 1 && cross[row + 1][col] == 1) {
					dir = 'd'; steps ++;
				}
				else if (col == 0 || cross[row][col - 1] == 0) {
					dir = 'u'; steps ++;
				} else {
					col --; 
				}
			} else if (dir == 'u') {
				if (col > 0 && cross[row][col - 1] == 1) {
					dir = 'l'; steps ++;
				} else if (cross[row - 1][col] == 0) {
					dir = 'r'; steps ++;
				} else {
					row --;
				}
			}
			
			steps --;
		}
		System.out.println(col + 1);
		System.out.println(row + 1);
	}
}
