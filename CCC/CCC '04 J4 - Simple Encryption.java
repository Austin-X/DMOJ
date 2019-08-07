import java.io.*;

public class SimpleEncryption {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String keyWord = br.readLine();
		String temp = br.readLine();
		String message = "";
		for (int i = 0; i < temp.length(); i ++) if (Character.isLetter(temp.charAt(i))) message += temp.charAt(i);
		String ans = "";
		
		int keyWordIdx = 0;
		for (int i = 0; i < message.length(); i ++) {
			if (keyWordIdx == keyWord.length()) keyWordIdx = 0;
			int value = Integer.valueOf(keyWord.charAt(keyWordIdx)) - 65;
			char ch = message.charAt(i);
			while (value > 0) {
				ch += (char)1;
				if (ch > 'Z') ch = 'A';
				value --;
			}
			
			keyWordIdx ++;
			ans += ch;
		}
		System.out.println(ans);
	}
}
