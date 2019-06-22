import java.io.*;
import java.util.*;

public class BinaryCrash {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] string = br.readLine().toCharArray();
		
		int zeroCn = 0, oneCn = 0;
		for (int i = 0; i < string.length; i ++) {
			if (Character.getNumericValue(string[i]) == 0) zeroCn ++;
			else oneCn ++;
		}
		
		if (zeroCn >= oneCn) {
			System.out.println(oneCn * 2);
		} else {
			System.out.println(zeroCn * 2);
		}
	}
}
