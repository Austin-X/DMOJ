import java.io.*;

public class StringFindingHard {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] s = br.readLine().toCharArray();
		char[] t = br.readLine().toCharArray();
		int sLen = s.length;
		int tLen = t.length;
		
		int cn = 0;
		for (int i = 0; i < sLen; i ++) {
			if (s[i] == t[cn]) { 
				cn ++; 
				if (cn == tLen) { System.out.println(i - tLen + 1); System.exit(0); }
			}
			else { 
				if (cn > 0 && s[i] == t[cn - 1]) continue;
				else cn = 0; 
			}
		}
		System.out.println(-1);
	}
}
