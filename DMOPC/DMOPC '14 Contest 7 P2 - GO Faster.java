import java.io.*;
import java.util.*;

public class GOFaster {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] on = new int[n], off = new int[n];
		
		for (int i = 0; i < n - 1; i ++) {
			st = new StringTokenizer(br.readLine());
			on[i] = Integer.parseInt(st.nextToken());
			off[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = on[0], max = on[0];

		for (int i = 1; i < n - 1; i ++) min -= off[i];
		
		int extra = 0, minus = 0;
		for (int i = 1; i < n - 1; i ++) {
			if (i != 1) {
				extra -= off[i];
				if (extra < 0) { minus = 0 - extra; extra = 0; }
				max -= minus;
			}
			else max -= off[i];
			extra += on[i];
		}
		
		System.out.println(min < 0 ? 0 : min);
		System.out.println(max);
	}
}
