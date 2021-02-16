import java.io.*;
import java.util.*;

public class WordBot {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), c = readInt(), v = readInt();
		
		char[] ch = readLine().toCharArray();
		
		int consonantCnt = 0, vowelCnt = 0;
		boolean flag = true;
		
		for (int i = 0; i < n; i ++) {
			if (ch[i] == 'y') {
				vowelCnt ++;
				consonantCnt ++;
			} else if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') {
				vowelCnt ++;
				consonantCnt = 0;
			} else {
				vowelCnt = 0;
				consonantCnt ++;
			}
			
			if (vowelCnt > v | consonantCnt > c) {
				flag = false;
				break;
			}
		}
		
		System.out.println(flag ? "YES" : "NO");
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
