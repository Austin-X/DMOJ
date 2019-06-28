import java.io.*;

public class CellPhoneMessaging {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int seconds;
		while (true) {
			String word = br.readLine();		
			if (word.equals("halt")) break;
			
			seconds = 0;
			int[] categories = new int[8]; int curCategory = 0;
			for (int i = 0; i < word.length(); i ++) {
				if (word.charAt(i) == 'a' || word.charAt(i) == 'b' || word.charAt(i) == 'c') { categories[0] ++; curCategory = 0; }
				else if (word.charAt(i) == 'd' || word.charAt(i) == 'e' || word.charAt(i) == 'f') { categories[1] ++; curCategory = 1; }
				else if (word.charAt(i) == 'g' || word.charAt(i) == 'h' || word.charAt(i) == 'i') { categories[2] ++; curCategory = 2; }
				else if (word.charAt(i) == 'j' || word.charAt(i) == 'k' || word.charAt(i) == 'l') { categories[3] ++; curCategory = 3; }
				else if (word.charAt(i) == 'm' || word.charAt(i) == 'n' || word.charAt(i) == 'o') { categories[4] ++; curCategory = 4; }
				else if (word.charAt(i) == 'p' || word.charAt(i) == 'q' || word.charAt(i) == 'r' || word.charAt(i) == 's') { categories[5] ++; curCategory = 5; }
				else if (word.charAt(i) == 't' || word.charAt(i) == 'u' || word.charAt(i) == 'v') { categories[6] ++; curCategory = 6; }
				else if (word.charAt(i) == 'w' || word.charAt(i) == 'x' || word.charAt(i) == 'y' || word.charAt(i) == 'z') { categories[7] ++; curCategory = 7; }
				
				for (int j = 0; j < 8; j ++) {
					if (categories[j] == 2) {
						seconds += 2;  categories[j] = 1;
					} else if (j != curCategory) {
						categories[j] = 0;
					}
				}
					
				if (word.charAt(i) == 'a' || word.charAt(i) == 'd' || word.charAt(i) == 'g' || word.charAt(i) == 'j' || word.charAt(i) == 'm'
						|| word.charAt(i) == 'p' || word.charAt(i) == 't' || word.charAt(i) == 'w') {
					seconds ++; 
				} else if (word.charAt(i) == 'b' || word.charAt(i) == 'e' || word.charAt(i) == 'h' || word.charAt(i) == 'k' || word.charAt(i) == 'n'
						|| word.charAt(i) == 'q' || word.charAt(i) == 'u' || word.charAt(i) == 'x') {
					seconds += 2;
				} else if (word.charAt(i) == 'c' || word.charAt(i) == 'f' || word.charAt(i) == 'i' || word.charAt(i) == 'l' || word.charAt(i) == 'o'
						|| word.charAt(i) == 'r' || word.charAt(i) == 'v' || word.charAt(i) == 'y') {
					seconds += 3;
				} else seconds += 4;
			}
			
			System.out.println(seconds);
		}
	}
}
