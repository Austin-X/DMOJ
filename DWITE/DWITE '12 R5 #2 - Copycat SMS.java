import java.io.*;
import java.util.*;

public class CopycatSMS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 5; t ++) {
			String str = br.readLine();
			char[] ch = str.toCharArray();
			
			String newWord = str;
			for (int i = 1; i < str.length(); i ++) {
				int idx = i;
				int cn = 0;
				boolean bool = true;
				
				for (int j = i; j < str.length(); j ++) {
					if (ch[j] != ch[cn]) { bool = false; break; }
					cn ++;
				}
				
				if (bool) {
					String temp = str;
					for (int j = str.length() - idx; j < str.length(); j ++) temp += ch[j];
					if (temp.length() + str.length() < newWord.length() || newWord.equals(str)) newWord = temp;
				}
			}
			
			if (newWord.equals(str)) System.out.println(str + str);
			else System.out.println(newWord);
		}
	}
}
