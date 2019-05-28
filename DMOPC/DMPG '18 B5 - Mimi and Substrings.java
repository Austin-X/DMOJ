import java.io.*;

public class MimiAndSubstrings {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int k = Integer.parseInt(br.readLine());
		char cur = ' ';
		long temp = 0, cn = 0;
		
		for (int i = 0; i < s.length(); i ++) {
			if (i == 0) cur = s.charAt(0);
			if (cur == s.charAt(i)) temp ++;
			else if (temp < k) temp = 1;
			else {
				cn += temp - k + 1;
				temp = 1;
			}
			cur = s.charAt(i);
		}
		System.out.println(temp >= k ? cn + temp - k + 1 : cn);
	}
}
