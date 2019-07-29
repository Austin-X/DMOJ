import java.io.*;
import java.util.*;
	
public class LoveGuru {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine().toUpperCase();
		String b = br.readLine().toUpperCase();
		
		String temp;
		int sum1 = 0, cn = 1;
		for (int i = 0; i < a.length(); i ++) {
			int rem = cn % 4  != 0 ? cn % 4 : 4;	
			temp = String.valueOf((int)(Math.pow(Integer.valueOf(a.charAt(i)) - 64, rem)));
			sum1 += Character.getNumericValue(temp.charAt(temp.length() - 1));
			cn ++;
		}
		
		int sum2 = 0; cn = 1;
		for (int i = 0; i < b.length(); i ++) {
			int rem = cn % 4  != 0 ? cn % 4 : 4;	
			temp = String.valueOf((int)(Math.pow(Integer.valueOf(b.charAt(i)) - 64, rem)));
			sum2 += Character.getNumericValue(temp.charAt(temp.length() - 1));
			cn ++;
		}

		String temp1 = String.valueOf(sum1);
		String temp2 = String.valueOf(sum2);
		
		int mod1 = Character.getNumericValue(temp1.charAt(temp1.length() - 1)) == 0 ? 10 : Character.getNumericValue(temp1.charAt(temp1.length() - 1));
		int mod2 = Character.getNumericValue(temp2.charAt(temp2.length() - 1)) == 0 ? 10 : Character.getNumericValue(temp2.charAt(temp2.length() - 1));

		System.out.println(mod1 + mod2);
	}
}
