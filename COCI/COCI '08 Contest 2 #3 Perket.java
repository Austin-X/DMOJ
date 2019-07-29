import java.io.*;
import java.util.*;

public class Perket {
	static int[] sourness, bitterness;
	static int n, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		sourness = new int[n];
		bitterness = new int[n];
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			sourness[i] = Integer.parseInt(st.nextToken());
			bitterness[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(recurse(1, 0, 0));
	}
	
	static int recurse(int sour, int bitter, int idx) {
		for (int i = idx + 1; i < n; i ++) {
			recurse (sour * sourness[idx], bitter + bitterness[idx], i);
			recurse (1, 0, i);
		}
		
		min = Math.min(min, Math.abs(sour * sourness[idx] - (bitter + bitterness[idx])));
		return min;
	}
}
