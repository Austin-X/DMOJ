import java.io.*;

public class Ship {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] letters = new int[26];
		char[] parts = br.readLine().toCharArray();
		for (int i = 0; i < parts.length; i ++) {
			letters[parts[i] - 65] ++;
		}
		if (letters[1] > 0 && letters[5] > 0 && letters[19] > 0 && letters[11] > 0 && letters[2] > 0)
			System.out.println("NO MISSING PARTS");
		else {
			if (letters[1] == 0) System.out.print("B");
			if (letters[5] == 0) System.out.print("F");
			if (letters[19] == 0) System.out.print("T");
			if (letters[11] == 0) System.out.print("L");
			if (letters[2] == 0) System.out.print("C");
		}
	}
}
