import java.io.*;
import java.util.*;

public class NightmareAThon {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int[] ratings = new int[n], prefix = new int[n + 1], suffix = new int[n + 1], freqLeft = new int[n + 1], freqRight = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) ratings[i] = Integer.parseInt(st.nextToken());
		
		prefix[1] = ratings[0];
		freqLeft[1] = 1;
		for (int i = 1; i < n; i ++) {
			if (ratings[i] > prefix[i]) freqLeft[i + 1] = 1;
			else if (ratings[i] == prefix[i]) freqLeft[i + 1] = freqLeft[i] + 1;
			else freqLeft[i + 1] = freqLeft[i];
			prefix[i + 1] = Math.max(ratings[i], prefix[i]);
		}
		
		freqRight[n - 1] = 1;
		suffix[n - 1] = ratings[n - 1];
		for (int i = n - 2; i >= 0; i --) {
			if (ratings[i] > suffix[i + 1]) freqRight[i] = 1;
			else if (ratings[i] == suffix[i + 1]) freqRight[i] = freqRight[i + 1] + 1;
			else freqRight[i] = freqRight[i + 1];
			suffix[i] = Math.max(ratings[i], suffix[i + 1]);
		}

		for (int i = 0; i < q; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
	
			if (prefix[a - 1] > suffix[b]) {
				System.out.println(prefix[a - 1] + " " + freqLeft[a - 1]);
			} else if (suffix[b] > prefix[a - 1]) {
				System.out.println(suffix[b] + " " + freqRight[b]);
			} else {
				System.out.println(suffix[b] + " " + (freqLeft[a - 1] + freqRight[b]));
			}
		}
	}
}
