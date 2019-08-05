import java.io.*;
import java.util.*;

public class WordScrambler {
	static ArrayList<String> res = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		permute(str, "");	
		Collections.sort(res);
		for (String x : res) System.out.println(x);
	}

	static void permute(String str, String ans) {
		if (str.length() == 0) { 
			res.add(ans); return; 
		}
		
		for (int i = 0; i < str.length(); i ++) {
			char ch = str.charAt(i);
			String cur = str.substring(0, i) + str.substring(i + 1);
			permute(cur, ans + ch);
		}
	}
}	
