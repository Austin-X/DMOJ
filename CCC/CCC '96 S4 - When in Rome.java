import java.io.*;
import java.util.*;

public class WhenInRome {
	final static int I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000;
	static boolean valid;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t ++) {
			String line = br.readLine();
			String[] temp = line.split("\\+|=");

			String part1 = temp[0];
			String part2 = temp[1];
		
			int num1 = calculate(part1);
			int num2 = calculate(part2);
			
			valid = true;
			int res = num1 + num2;
			String ans = convert(res);	
			
			System.out.println(valid ? line + ans : line + "CONCORDIA CUM VERITATE");
		}
	}
	
	static int calculate(String part) {
		int num = 0;
		
		if (part.charAt(0) == 'I') num += I;
		else if (part.charAt(0) == 'V') num += V;
		else if (part.charAt(0) == 'X') num += X;
		else if (part.charAt(0) == 'L') num += L;
		else if (part.charAt(0) == 'C') num += C;
		else if (part.charAt(0) == 'D') num += D;
		else num += M;
		
		for (int i = 1; i < part.length(); i ++) {
			if (part.charAt(i) == 'I') num += I;
			else if (part.charAt(i) == 'V') num += part.charAt(i - 1) == 'I' ? 3 : V;
			else if (part.charAt(i) == 'X') num += part.charAt(i - 1) == 'I' ? 8 : X;
			else if (part.charAt(i) == 'L') num += part.charAt(i - 1) == 'X' ? 30 : L;
			else if (part.charAt(i) == 'C') num += part.charAt(i - 1) == 'X' ? 80 : C;
			else if (part.charAt(i) == 'D') num += part.charAt(i - 1) == 'C' ? 300 : D;
			else num += part.charAt(i - 1) == 'C' ? 800 : M;
		}
		return num;
	}
	
	static String convert(int res) {
		String ans = "";
		
		while (res != 0) {
			if (res >= 1 && res < 10) {
				if (res == 4) { res = 0; ans += "IV"; break; } 
				else if (res == 9) { res = 0; ans += "IX"; break; }
				else if (res < 5) { res --; ans += "I"; }
				else { res -= 5; ans += "V"; }
			} else if (res >= 10 && res < 100) {
				if (res >= 40 && res < 50) { res -= 40; ans += "XL"; } 
				else if (res >= 90) { res -= 90; ans += "XC"; }	
				else if (res < 50) { res -= 10; ans += "X"; }
				else { res -= 50; ans += "L"; }
			} else if (res >= 100 && res < 1000) {
				if (res >= 400 && res < 500) { res -= 400; ans += "CD"; } 
				else if (res >= 900) { res -= 900; ans += "CM"; }
				else if (res < 500) { res -= 100; ans += "C"; } 
				else { res -= 500; ans += "D"; }
			} else if (res == 1000) {
				res = 0; ans = "M";
			} else {
				valid = false; break;
			}
		}
		
		return ans;
	}
}
