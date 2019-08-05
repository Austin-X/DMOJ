import java.io.*;
import java.util.*;

public class WordScrambler {
	static ArrayList<String> res = new ArrayList<String>();
	static char[] chars;
	static int len;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		chars = br.readLine().toCharArray();
		len = chars.length;
		permute();
		
		Collections.sort(res);
		for (String x : res) System.out.println(x);
	}
	
	static ArrayList<Character> temp = new ArrayList<Character>();
	static void permute() {
		if (temp.size() == len) {
			String str = "";
			for (char x : temp) str += x;
			res.add(str);
		}
		
		for (int i = 0; i < len; i ++) {
			if (!temp.contains(chars[i])) {
				temp.add(chars[i]);
				permute();
				temp.remove(temp.get(temp.size() - 1));
			}
		}
	}
}	
