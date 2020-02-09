import java.io.*;
import java.util.*;

public class Maternity {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String mother = br.readLine();
		String father = br.readLine();
		
		int[] possible = new int[5];
		for (int i = 0; i < 10; i += 2) {
			int cn1 = 0, cn2 = 0;
			if (Character.isUpperCase(mother.charAt(i))) cn1 ++;
			if (Character.isUpperCase(mother.charAt(i + 1))) cn1 ++;
			if (Character.isUpperCase(father.charAt(i))) cn2 ++;
			if (Character.isUpperCase(father.charAt(i + 1))) cn2 ++;
			
			if (cn1 == 2 || cn2 == 2) possible[i / 2] = 1; // '1' denotes that it can only be uppercase
			else if (cn1 == 1 && cn2 == 1 || cn1 == 0 && cn2 == 1 || cn1 == 1 && cn2 == 0) possible[i / 2] = 2; // '2' denotes that it can be uppercase or lowercase
			// if it can't be 1 or 2, it must be 0, which denotes that it can only be lowercase
		}
		
		int x = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < x ; t ++) {
			char[] ch = br.readLine().toCharArray();	
			boolean pass = true;
			for (int i = 0; i < 5; i ++) {
				if (Character.isUpperCase(ch[i]) && possible[i] == 0 || Character.isLowerCase(ch[i]) && possible[i] == 1) {
					pass = false; break;
				} 	
			}
			
			System.out.println(pass ? "Possible baby." : "Not their baby!");
		}
	}
}
