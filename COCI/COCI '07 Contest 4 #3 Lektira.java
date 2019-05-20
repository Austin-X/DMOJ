import java.io.*;

public class Lektira {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		String bestWord = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		
		// Checking all the possible cases
		for (int i = 1; i < word.length() - 2; i ++) {
			for (int j = i + 1; j < word.length() - 1; j ++) {
				String part1 = new StringBuilder(word.substring(0, i)).reverse().toString();
				String part2 = new StringBuilder(word.substring(i, j + 1)).reverse().toString();
				String part3 = new StringBuilder(word.substring(j + 1)).reverse().toString();
				if ((part1 + part2 + part3).compareTo(bestWord) < 0) 
					bestWord = part1 + part2 + part3;
			}
		}
		System.out.println(bestWord);
	}
}
