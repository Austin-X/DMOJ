import java.io.*;
import java.util.*;

public class AbsolutelyAcidic {
	static class Pair implements Comparable<Pair>{
		int idx, val;
		Pair (int idx, int val) { this.idx = idx; this.val = val; }

		public int compareTo(Pair p) { 
			return Integer.compare(val, p.val);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main (String[] args) throws IOException {
		int n = readInt();
		ArrayList<Pair> arr = new ArrayList<Pair>();
		int[] freq = new int[1001];
		for (int i = 0; i < n; i ++) freq[readInt()] ++;
		
		for (int i = 1; i <= 1000; i ++) {
			if (freq[i] != 0) arr.add(new Pair(i, freq[i]));
		}
		Collections.sort(arr);
		
		int max, secondMax;
		if (arr.get(arr.size() - 1).val == arr.get(arr.size() - 2).val) { max = arr.get(arr.size() - 1).val; secondMax = max; }
		else { max = arr.get(arr.size() - 1).val; secondMax = arr.get(arr.size() - 2).val; }
	
		ArrayList<Integer> m = new ArrayList<Integer>();
		for (int i = 0; i < arr.size(); i ++) {
			if (arr.get(i).val == max) m.add(arr.get(i).idx);
		}
		Collections.sort(m);
		if (max == secondMax) System.out.println(m.get(m.size() - 1) - m.get(0));
		else {
			ArrayList<Integer> m2 = new ArrayList<Integer>();
			for (int i = 0; i < arr.size(); i ++) if (arr.get(i).val == secondMax) m2.add(arr.get(i).idx);
			Collections.sort(m2);
			int ans = 0;
			for (int i = 0; i < m.size(); i ++) ans = Math.max(ans, Math.max(Math.abs(m.get(i) - m2.get(0)), Math.abs(m.get(i) - m2.get(m2.size() - 1))));
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
