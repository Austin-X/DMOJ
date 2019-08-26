import java.io.*;
import java.util.*;

public class NeanderthalNumbers {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> possible = new ArrayList<String>(Arrays.asList("ook", "ookook", "oog", "ooga", "ug", "mook", "mookmook", "oogam", "oogum", "ugug"));
		
		for (int t = 0; t < 10; t ++) {
			String word = br.readLine();
			int n = word.length();
			int[] dp = new int[n];
			
			String str = "";
			for (int i = 0; i < n; i ++) {
				str += word.charAt(i);
				
				for (int j = 0; j < n; j ++) {
					if (dp[j] != 0 && possible.contains(str.substring(j + 1, str.length()))) dp[i] += dp[j];
				}
				if (str.length() <= 8) {
					if (possible.contains(str)) dp[i] ++;
				}
			}
			
			System.out.println(dp[n - 1]);
		}
	}
}
