import java.io.*;
import java.util.*;

public class JapanEasy {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		ArrayList<String> japaneasy = new ArrayList<String>();
		String[] temp = {"a", "e", "i", "o", "u"};
		for (int i = 0; i < 5; i ++) {
			japaneasy.add(temp[i]);
			japaneasy.add("k" + temp[i]);
			japaneasy.add("n" + temp[i]);
			japaneasy.add("h" + temp[i]);
			japaneasy.add("m" + temp[i]);
			japaneasy.add("r" + temp[i]);
		}
		japaneasy.remove("hu"); japaneasy.add("fu");
		
		while (t-- > 0) {
			String word = readLine();
			boolean flag = true;
			for (int i = 0; i < word.length();) {
				if (i == word.length() - 1) {
					if (!japaneasy.contains(word.substring(i, i + 1))) { flag = false; break; }
					i ++;
				} else {
					if (!japaneasy.contains(word.substring(i, i + 2)) && !japaneasy.contains(word.substring(i, i + 1))) { flag = false; break; }
					if (!japaneasy.contains(word.substring(i, i + 2)) && japaneasy.contains(word.substring(i, i + 1))) i ++;
					else i += 2;
				}
			}
			System.out.println(flag ? "YES" : "NO");
		}
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
