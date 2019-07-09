import java.io.*;
import java.util.TreeSet;

public class Rövarspråket {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		TreeSet<Character> lawl = new TreeSet<Character>();
		lawl.add('a'); lawl.add('e'); lawl.add('i'); lawl.add('o'); lawl.add('u');
		String[] letters = {"bc", "dfg", "hjkl", "mnpqr", "stvwxyz"};
		String newWord = "";
		
		for (int i = 0; i < word.length(); i ++) {
			newWord += word.charAt(i);
			outerloop: for (int j = 0; j < letters.length; j ++) {
				for (int k = 0; k < letters[j].length(); k ++) {
					if (word.charAt(i) == letters[j].charAt(k)) {
						if (j == 0) newWord += 'a'; 
						else if (j == 1) newWord += 'e'; 
						else if (j == 2) newWord += 'i'; 
						else if (j == 3) newWord += 'o';  
						else if (j == 4) newWord += 'u';
						break outerloop;
					}
				}
			}
			if (word.charAt(i) == 'z') newWord += 'z';
			else if (lawl.contains((char)(Integer.valueOf(word.charAt(i)) + 1))) newWord += (char)(Integer.valueOf(word.charAt(i)) + 2);
			else if (!lawl.contains(word.charAt(i))) newWord += (char)(Integer.valueOf(word.charAt(i)) + 1);
		}
		
		System.out.println(newWord);
	}
}
