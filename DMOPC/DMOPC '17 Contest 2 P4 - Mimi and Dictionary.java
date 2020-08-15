import java.io.*;
import java.util.*;

public class MimiAndDictionary {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		char[] str = readLine().toCharArray();
		long[] prefixHsh = new long[str.length], suffixHsh = new long[str.length], pow = new long[str.length]; int base = 131;
		
		for (int i = 0; i < str.length; i ++) {
			prefixHsh[i] = i == 0 ? str[i] : prefixHsh[i - 1] * base + str[i];
			pow[i] = i == 0 ? 1 : pow[i - 1] * base;
		}
		for (int i = str.length - 1; i >= 0; i --) suffixHsh[i] = i == str.length - 1 ? str[i] : suffixHsh[i + 1] * base + str[i];
		
		TreeSet<Integer> indices = new TreeSet<Integer>();
		long hsh1, hsh2;
		for (int i = 0; i < str.length - 1; i ++) {
			int mid = i / 2; 
			if (i % 2 == 0) {
				if (i == 0) { indices.add(i); continue; }
				hsh1 = prefixHsh[mid - 1]; hsh2 = suffixHsh[mid + 1] - suffixHsh[i + 1] * pow[i - mid];
				if (hsh1 == hsh2) indices.add(i);
			} else {
				hsh1 = prefixHsh[mid]; hsh2 = suffixHsh[mid + 1] - suffixHsh[i + 1] * pow[i - mid];
				if (hsh1 == hsh2) indices.add(i);
			}
		}
		if (indices.isEmpty()) { System.out.println(0); System.exit(0); }
		boolean flag = false;
		for (int i = 1; i < str.length - indices.last(); i ++) {
			if (prefixHsh[i + indices.last()] - prefixHsh[i - 1] * pow[indices.last() + 1] == prefixHsh[indices.last()]) { flag = true; break; }
		}
		if (flag) System.out.println(indices.last() + 1);
		else {
			indices.pollLast();
			if (indices.isEmpty()) System.out.println(0);
			else System.out.println(indices.last() + 1);
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
