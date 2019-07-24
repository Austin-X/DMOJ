import java.io.*;
import java.util.*;

public class AttackOfTheCipherTexts {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String plainText = br.readLine();
		String cipherText = br.readLine();
		
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < plainText.length(); i ++) {
			if (!map.containsKey(cipherText.charAt(i))) {
				map.put(cipherText.charAt(i), plainText.charAt(i));
			}
		}
		
		String translate = br.readLine();
		for (int i = 0; i < translate.length(); i ++) {
			if (map.containsKey(translate.charAt(i))) {
				System.out.print(map.get(translate.charAt(i)));
			} else System.out.print(".");
		}
	}
}
