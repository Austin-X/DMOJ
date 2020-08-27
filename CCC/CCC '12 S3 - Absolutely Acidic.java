import java.io.*;
import java.util.*;

public class AbsolutelyAcidic {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main (String[] args) throws IOException {
		int n = readInt();
		int[] freq = new int[1001];
		for (int i = 0; i < n; i ++) freq[readInt()] ++;
		
		int max = 0, maxCnt = 0;
		for (int i = 1; i <= 1000; i ++) {
			if (freq[i] > max) { max = freq[i]; maxCnt = 1; }
			else if (freq[i] == max) maxCnt ++;
		}
		if (maxCnt > 1) {
			int lower = -1, upper = 0;
			for (int i = 1; i <= 1000; i ++) {
				if (lower == -1 && freq[i] == max) lower = i;
				if (freq[i] == max) upper = i;
			}
			System.out.println(upper - lower);
		} else {
			int max2 = 0, ans = 0;
			for (int i = 1; i <= 1000; i ++) if (freq[i] != max) max2 = Math.max(max2, freq[i]);
			ArrayList<Integer> arr2 = new ArrayList<Integer>();
			for (int i = 1; i <= 1000; i ++) if (freq[i] == max2) arr2.add(i);
			for (int i = 1; i <= 1000; i ++) {
				if (freq[i] == max) {
					for (int j = 0; j < arr2.size(); j ++) ans = Math.max(ans, Math.abs(i - arr2.get(j)));
				}
			}
			System.out.println(ans);
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
