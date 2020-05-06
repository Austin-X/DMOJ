import java.io.*;
import java.util.*;

public class ValidStrings {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for (int t = 0; t < n; t ++) {
			char[] ch = br.readLine().toCharArray();
			
			int cn = 0;
			boolean pass = true;
			
			for (int i = 0; i < ch.length; i ++) {
				if (ch[i] == '(') cn ++;
				else if (ch[i] == ')') cn --;
				if (cn < 0) { pass = false; break; }
			}
			
			if (cn > 0) pass = false;
			System.out.println(pass ? "YES" : "NO");
		}
	}
}
