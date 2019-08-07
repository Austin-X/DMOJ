import java.io.*;
import java.util.*;

public class SnowCalls {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t ++) {
			String[] temp = br.readLine().split("-");
			String ans = "";
			
			for (int i = 0; i < temp.length; i ++) {
				for (int j = 0; j < temp[i].length(); j ++) {
					if (Character.isDigit(temp[i].charAt(j))) ans += temp[i].charAt(j);
					else {
						if (temp[i].charAt(j) >= 'A' && temp[i].charAt(j) <= 'C') ans += "2";
						else if (temp[i].charAt(j) >= 'D' && temp[i].charAt(j) <= 'F') ans += "3";
						else if (temp[i].charAt(j) >= 'G' && temp[i].charAt(j) <= 'I') ans += "4";
						else if (temp[i].charAt(j) >= 'J' && temp[i].charAt(j) <= 'L') ans += "5";
						else if (temp[i].charAt(j) >= 'M' && temp[i].charAt(j) <= 'O') ans += "6";
						else if (temp[i].charAt(j) >= 'P' && temp[i].charAt(j) <= 'S') ans += "7";
						else if (temp[i].charAt(j) >= 'T' && temp[i].charAt(j) <= 'V') ans += "8";
						else ans += "9";
					}
				}
			}
			for (int i = 0; i < 10; i ++) {
				if (i == 2 || i == 5) System.out.print(ans.charAt(i) + "-");
				else System.out.print(ans.charAt(i));
			}
			System.out.println();
		}
	}
}
