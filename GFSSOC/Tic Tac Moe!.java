import java.io.*;
	
public class TicTacMoe {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean oWon = false, xWon = false;
		char[][] grid = new char[3][3];
		
		for (int i = 0; i < 3; i ++) {
			grid[i] = br.readLine().toCharArray();
		}
		
		if ((grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X') || (grid[1][0] == 'X' && grid[1][1] == 'X' && grid[1][2] == 'X') || (grid[2][0] == 'X' && grid[2][1] == 'X' && grid[2][2] == 'X')) {
			xWon = true;
		} else if ((grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X') || (grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X') || (grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X'))  {
			xWon = true;
		} else if ((grid[0][0] == 'X' && grid[1][1] == 'X' & grid[2][2] == 'X') || (grid[0][2] == 'X' && grid[1][1] == 'X' && grid[2][0] == 'X')) {
			xWon = true;
		}
		if ((grid[0][0] == 'O' && grid[0][1] == 'O' && grid[0][2] == 'O') || (grid[1][0] == 'O' && grid[1][1] == 'O' && grid[1][2] == 'O') || (grid[2][0] == 'O' && grid[2][1] == 'O' && grid[2][2] == 'O')) {
			oWon = true;
		} else if ((grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O') || (grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O') || (grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O'))  {
			oWon = true;
		} else if ((grid[0][0] == 'O' && grid[1][1] == 'O' & grid[2][2] == 'O') || (grid[0][2] == 'O' && grid[1][1] == 'O' && grid[2][0] == 'O')) {
			oWon = true;
		}
		
		if (xWon && oWon) System.out.println("Error, redo");
		else if (xWon) System.out.println("Timothy");
		else if (oWon) System.out.println("Griffy");
		else System.out.println("Tie");
	}
}
