import java.io.*;

public class BoardGame {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String word = br.readLine().replaceAll(" ", "");
		char[] ch = word.toCharArray();
		
		int cn = 0, consec = 0;
		
		int temp = 0;
		for (int i = 0; i < ch.length; i ++) {
			if (ch[i] == 'L') {
				cn ++;
				temp ++;
			} else {
				consec = Math.max(consec, temp); temp = 0;
			}
		}
		consec = Math.max(consec, temp);
		System.out.println(cn + " " + consec);
	}
}
