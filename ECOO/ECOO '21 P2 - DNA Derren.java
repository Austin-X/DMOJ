import java.io.*;
import java.util.*;

public class DNADerren {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		char[] ch = readLine().toCharArray();
		
		ArrayList<String> ans = new ArrayList<String>();
		String temp = "";
		
		// '0' denotes vowel, '1' denotes consonant.
		int flag = -1;
		for (int i = 0; i < ch.length; i ++) {
			if (flag == -1) {
				if (ch[i] == 'A') flag = 0;
				else flag = 1;
				temp += ch[i];
			} else if (flag == 0) {
				if (ch[i] == 'A') {
					flag = 0;
					ans.add(temp);
					temp = "";
					temp += ch[i];
				} else {
					flag = 1;
					temp += ch[i];
				}
			} else {
				if (ch[i] == 'A') {
					flag = 0;
					temp += ch[i];
				} else {
					flag = 1;
					ans.add(temp);
					temp = "";
					temp += ch[i];
				}
			}
		}
		
		if (!temp.equals("")) ans.add(temp);
		for (int i = 0; i < ans.size() - 1; i ++) System.out.print(ans.get(i) + " ");
		System.out.println(ans.get(ans.size() - 1));
	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong() throws IOException {
		return Long.parseLong(next());
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter() throws IOException {
		return next().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
