import java.util.*;
import java.io.*;

public class WordScrambler {
	public static void main(String[] args ) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 5; i ++) {
			char[] chars = br.readLine().toCharArray();
			Arrays.sort(chars);
			getPermutation(new String(chars), "");
		}
	}
	public static void getPermutation(String a, String perm) {
		if (a.length() == 0) {
			System.out.println(perm); return;
		}
		for (int i = 0; i < a.length(); i ++) {
			getPermutation(a.substring(0, i) + a.substring(i + 1), perm + a.charAt(i));
		}
	}
}
