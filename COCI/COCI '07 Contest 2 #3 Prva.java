import java.util.*;
import java.io.*;

public class Prva {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String smallestWord = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		String[] temp = br.readLine().split(" ");
		int rows = Integer.parseInt(temp[0]);
		int cols = Integer.parseInt(temp[1]);
		char[][] chars = new char[rows][cols];
		
		for (int i = 0; i < rows; i ++) {
			chars[i] = br.readLine().toCharArray();
		}
		
		String word;
		for (int i = 0; i < rows; i ++) {
			word = "";
			for (int j = 0; j < cols; j ++) {
				if (chars[i][j] == '#') {
					if (word.compareTo(smallestWord) < 0 && word.length() >= 2) smallestWord = word;
					word = "";
				}
				else {
					word += chars[i][j];
				}
			}
			if (word.compareTo(smallestWord) < 0  && word.length() >= 2) smallestWord = word;
		}
		
		for (int i = 0; i < cols; i ++) {
			word = "";
			for (int j = 0; j < rows; j ++) {
				if (chars[j][i] == '#') {
					if (word.compareTo(smallestWord) < 0 && word.length() >= 2) smallestWord = word;
					word = "";
				}
				else {
					word += chars[j][i];
				}
			}
			if (word.compareTo(smallestWord) < 0  && word.length() >= 2) smallestWord = word;
		}
		
		System.out.println(smallestWord);
	}
}
