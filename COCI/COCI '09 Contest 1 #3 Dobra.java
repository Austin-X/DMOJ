import java.io.*;
import java.util.*;

public class Dobra {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long ans = 0; 
	static int n;
	static boolean[] works;
	public static void main(String[] args) throws IOException {
		char[] str = readLine().toCharArray(); n = str.length;
		boolean visL = false;
		works = new boolean[n];
		for (int i = 0; i < n; i ++) if (str[i] == 'L') { visL = true;  break; } 

		if (visL) {		
			if (!checkString(str)) { System.out.println(0); System.exit(0); }
			recurse(str, 0, 1);
		} else {
			for (int a = 0; a < n; a ++) {
				if (str[a] == '_') {
					str[a] = 'L'; 
					if (!checkString(str)) { works[a] = false; str[a] = '_'; continue; }
					char[] temp = Arrays.copyOf(str, n);
					recurse(temp, 0, 1);
					str[a] = '_';
					works[a] = true;
				}
			}
		}
		System.out.println(ans);
	}

	static boolean checkString(char[] str) {
		for (int i = 2; i < n; i ++) {
			int vowCnt = 0, conCnt = 0;
			for (int j = i - 2; j <= i; j ++) {
				if (str[j] == 'A' || str[j] == 'I' | str[j] == 'E' || str[j] == 'O' || str[j] == 'U') vowCnt ++;
				else if (str[j] != '_') conCnt ++;
			}
			if (vowCnt == 3 || conCnt == 3) return false;
		}
		return true;
	}
	static void recurse(char[] str, int idx, long cur) {
		if (idx == n) {
			ans += cur;
			return; 
		}
		if (str[idx] == '_') {
			str[idx] = 'A';
			if (checkString(str)) recurse(str, idx + 1, cur * 5);
			str[idx] = 'B';
			if (checkString(str)) {
				if (!works[idx]) recurse(str, idx + 1, cur * 21);
				else recurse(str, idx + 1, cur * 20);
			}
			str[idx] = '_';
		} else recurse(str, idx + 1, cur);
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
