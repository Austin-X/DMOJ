import java.io.*;

public class Encode {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		String newWord = "";
		
		for (int i = 0; i < s.length(); i ++) {
			if (s.charAt(i) == ' ') newWord += " ";
			else {
				char cur = s.charAt(i);
				for (int j = 0; j < Math.abs(n); j ++) {
					if (n > 0) {
						cur = (char)(Integer.valueOf(cur) - 1);
						if ((s.charAt(i) <= 'Z' && cur < 'A') || (s.charAt(i) >= 'a' && cur < 'a')) cur = (char)(Integer.valueOf(cur) + 26);
					}
					else if (n < 0) {
						cur = (char)(Integer.valueOf(cur) + 1);
						if ((s.charAt(i) <= 'Z' && cur > 'Z') || (s.charAt(i) >= 'a' && cur > 'z')) cur = (char)(Integer.valueOf(cur) - 26);
					}
				}
				newWord += cur;
			}
		}
		System.out.println(newWord);
	}
}
