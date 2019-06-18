import java.io.*;

public class RollingEncryption {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		int cn = 0, top = k;
		char[] word = br.readLine().toCharArray();
		
		for (int i = 0; i < k; i ++) System.out.print(word[i]);
		
		int[] letters = new int[26];
		
		for (int j = 0; j < k; j ++) {
			letters[word[j] - 97] ++;
		}	
		
		for (int i = 0; i < word.length - k; i ++) {	
			int max = -1;
			int index = -1;
			
			for (int a = 0; a < 26; a ++) {
				if (letters[a] > max) {
					max = letters[a]; index = a;
				}
			}
			if ((char)(word[i + k] + (index + 1)) > 'z') {
				System.out.print((char)(word[i + k] + (index + 1) - 26));
			}
			else System.out.print((char)(word[i + k] + (index + 1)));
			
			letters[word[cn] - 97]--;
			cn ++;
			
			letters[word[top] - 97] ++;
			top ++;
		}
	}
}
