import java.io.*;

public class Trener {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] letters = new int[26];
		String ans = "";
		
		for (int i = 0; i < n; i ++) {
			char temp = br.readLine().charAt(0);
			letters[temp - 'a'] ++;
		}
		
		for (int i = 0; i < 26; i ++ ) {
			if (letters[i] >= 5) ans += (char)('a' + i);
		}
		
		if (ans.length() > 0)
			System.out.println(ans);
		else System.out.println("PREDAJA");
	}
}
