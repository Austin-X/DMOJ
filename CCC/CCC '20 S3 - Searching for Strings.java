import java.io.*;
import java.util.*;

public class SearchingForStrings {
	static final long MOD = 29996224275833L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] n = br.readLine().toCharArray(), h = br.readLine().toCharArray();
		
		int[] cn1 = new int[26], cn2 = new int[26];
		if (n.length > h.length) { System.out.println(0); System.exit(0); }
		
		double[] powers = new double[2000001]; powers[0] = 1;
		for (int i = 1; i <= 2000000; i ++) powers[i] = powers[i - 1] * 26 % MOD;
		
		double haystackHashcode = 0;
		for (int i = 0; i < n.length; i ++)  {
			cn1[n[i] - 'a'] ++;
			cn2[h[i] - 'a'] ++;
			haystackHashcode += (h[i] - 96) * powers[n.length - i - 1];
			haystackHashcode %= MOD;
		}

		HashSet<Long> arr = new HashSet<Long>();
		if (Arrays.equals(cn1, cn2)) arr.add((long)haystackHashcode);

		for (int i = n.length; i < h.length; i ++) {
			cn2[h[i - n.length] - 'a'] --;
			cn2[h[i] - 'a'] ++;
			haystackHashcode -= (h[i - n.length] - 96) * powers[n.length - 1];
			haystackHashcode *= 26;
			haystackHashcode %= MOD;
			haystackHashcode += (h[i] - 96);
			haystackHashcode %= MOD;
			if (Arrays.equals(cn1, cn2)) arr.add((long)haystackHashcode);
		}
		
		System.out.println(arr.size());
	}
}
