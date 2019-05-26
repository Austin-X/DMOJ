import java.io.*;

public class EnglishOrFrench {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int tCn = 0, sCn = 0;
		for (int i = 0; i < n; i ++) {
			String word = br.readLine();
			for (int j = 0; j < word.length(); j ++) {
				if (word.charAt(j) == 't' || word.charAt(j) == 'T') tCn ++;
				else if (word.charAt(j) == 's' || word.charAt(j) == 'S') sCn ++;
			}
		}
		
		if (tCn > sCn) System.out.println("English");
		else System.out.println("French");	
	}
}
