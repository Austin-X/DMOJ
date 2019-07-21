import java.io.*;

public class Bananas {
	static int bCn = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = "";
		
		while (!word.equals("X")) {
			word = br.readLine();
			if(word.equals("X")) break;
			
			char[] letters = word.toCharArray();
			int max = letters.length;
			int min = 0;
			bCn = 0;
			
			System.out.println(recurse(letters, min, max, 0) ? "YES" : "NO");
		}
	}
	
	// For the 'choice' parameter, 0 represents that a monkey letter follows, 1 represents that an 'N' or 'S' must follow.
	static boolean recurse(char[] letters, int min, int max, int choice) {
		if (min == max) {
			if (bCn == 0 && letters[min - 1] != 'N') return true;
			else return false;
		}
		
		if (choice == 0) {
			if (letters[min] == 'A') {
				if (!recurse(letters, min + 1, max, 1)) return false;
			} else if (letters[min] == 'B') {
				bCn ++;
				if (!recurse(letters, min + 1, max, 0)) return false;
			} else return false;
		} else if (choice == 1) {
			if (letters[min] == 'S' && bCn > 0) {
				bCn --;
				if (!recurse(letters, min + 1, max, 1)) return false;
			} else if (letters[min] == 'N') {
				if(!recurse(letters, min + 1, max, 0)) return false;
			} else return false;
		}
		
		return true;
	}
}
