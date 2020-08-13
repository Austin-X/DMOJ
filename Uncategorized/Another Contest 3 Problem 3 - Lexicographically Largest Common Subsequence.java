import java.io.*;
import java.util.*;

public class LexicographicallyLargestCommonSubsequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		String[] arr = new String[n];
		int[] cnAns = new int[26], cnTemp = new int[26];
		for (int i = 0; i < n; i ++) {
			arr[i] = readLine();
			if (i == 0) {
				for (int j = 0; j < arr[i].length(); j ++) cnAns[arr[i].charAt(j) - 'a'] ++;
			} else {
				for (int j = 0; j < arr[i].length(); j ++) cnTemp[arr[i].charAt(j) - 'a'] ++;
				for (int j = 0; j < 26; j ++) cnAns[j] = Math.min(cnAns[j], cnTemp[j]);
			}
			Arrays.fill(cnTemp, 0);
		}

		boolean pass = false; int[] curIdx = new int[n];
		for (int i = 25; i >= 0; i --) {
			if (cnAns[i] != 0) {
				int max = cnAns[i];
				for (int j = 0; j < n; j ++) {
					int temp = 0;
					for (int k = 0; k < arr[j].length(); k ++) if (arr[j].charAt(k) == (char)(i + 'a') && k >= curIdx[j]) temp ++; 
					max = Math.min(max, temp);
				}
				
				if (max > 0) {
					pass = true;
					for (int j = 0; j < n; j ++) {
						int temp = 0;
						for (int k = 0; k < arr[j].length(); k ++) {
							if (k >= curIdx[j] && arr[j].charAt(k) == (char)(i + 'a')) temp ++;
							if (temp == max) { curIdx[j] = k; break; }
						}
					}
					for (int j = 0; j < max; j ++) System.out.print((char)(i + 'a'));
				}
			}
		}
		
		if (!pass) System.out.print(-1);
		System.out.println();
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
