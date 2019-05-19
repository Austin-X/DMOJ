import java.util.*;
import java.io.*;

public class RotatingLetters {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] chars = br.readLine().toCharArray();
		
			for (int i = 0; i < chars.length; i ++) {
				if (chars[i] != 'I' && chars[i] != 'O' && chars[i] != 'S' && chars[i] != 'H' 
						&& chars[i] != 'Z' && chars[i] != 'X' && chars[i] != 'N') {
					System.out.println("NO");
					System.exit(0);
				}
			}
			System.out.println("YES");
	}
}
