import java.io.*;
import java.util.*;

public class RidiculousString {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int lenS = readInt(), lenT = readInt();
		String s = readLine(), t = readLine();
		
		@SuppressWarnings("unchecked")
		TreeSet<Integer>[] firstPos = new TreeSet[26];
		for (int i = 0; i < 26; i ++) firstPos[i] = new TreeSet<Integer>();
		
		for (int i = 0; i < lenS; i ++) {
			firstPos[s.charAt(i) - 97].add(i);
		}
		
		long ans = 0;
		int curPos = -1;
		for (int i = 0; i < lenT; i ++) {
			if (firstPos[t.charAt(i) - 97].higher(curPos) == null) {
				ans += lenS - curPos - 1;
				curPos = -1;
			}
			
			if (curPos == -1 && firstPos[t.charAt(i) - 97].higher(curPos) == null) {
				System.out.println(-1);
				System.exit(0);
			}
			
			ans += firstPos[t.charAt(i) - 97].higher(curPos) - curPos;
			curPos = firstPos[t.charAt(i) - 97].higher(curPos);
		}
		
		System.out.println(ans);
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
