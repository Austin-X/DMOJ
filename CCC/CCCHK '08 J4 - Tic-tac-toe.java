import java.io.*;

public class Tic_Tac_Toe {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		boolean isValid;
		int xCounter, oCounter;
		
		for (int i = 0; i < t; i ++) {
			isValid = true; xCounter = 0; oCounter = 0;
			
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < 9; j ++) {
				if (temp[j] == 'X') xCounter ++;
				else if (temp[j] == 'O') oCounter ++;
			}
			
			if (xCounter == oCounter) {
				if ((temp[0] == 'X' && temp[1] == 'X' && temp[2] == 'X') || (temp[3] == 'X' && temp[4] == 'X' && temp[5] == 'X') || (temp[6] == 'X' && temp[7] == 'X' && temp[8] == 'X')) {
					isValid = false;
				} else if ((temp[0] == 'X' && temp[3] == 'X' && temp[6] == 'X') || (temp[1] == 'X' && temp[4] == 'X' && temp[7] == 'X') || (temp[2] == 'X' && temp[5] == 'X' && temp[8] == 'X')) {
					isValid = false;
				} else if ((temp[0] == 'X' && temp[4] == 'X' && temp[8] == 'X') || (temp[2] == 'X' && temp[4] == 'X' && temp[6] == 'X')) {
					isValid = false;
				} else isValid = true;
			} else if (xCounter == oCounter + 1) {
				if ((temp[0] == 'O' && temp[1] == 'O' && temp[2] == 'O') || (temp[3] == 'O' && temp[4] == 'O' && temp[5] == 'O') || (temp[6] == 'O' && temp[7] == 'O' && temp[8] == 'O')) {
					isValid = false;
				} else if ((temp[0] == 'O' && temp[3] == 'O' && temp[6] == 'O') || (temp[1] == 'O' && temp[4] == 'O' && temp[7] == 'O') || (temp[2] == 'O' && temp[5] == 'O' && temp[8] == 'O')) {
					isValid = false;
				} else if ((temp[0] == 'O' && temp[4] == 'O' && temp[8] == 'O') || (temp[2] == 'O' && temp[4] == 'O' && temp[6] == 'O')) {
					isValid = false;
				} else isValid = true;
			} else {
				isValid = false;
			}
			
			if (isValid) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
