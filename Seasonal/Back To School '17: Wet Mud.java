import java.io.*;
import java.util.*;

public class WetMud {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), j = Integer.parseInt(st.nextToken());
		int[] forest = new int[n + 1];
		Arrays.fill(forest, Integer.MAX_VALUE);
		
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int inch = Integer.parseInt(st.nextToken()), time = Integer.parseInt(st.nextToken());
			forest[inch] = Math.min(forest[inch], time);
		}

		int cur = 0, time = 1;
		while (cur + j <= n) {		
			int minTime = Integer.MAX_VALUE;
			for (int i = cur + 1; i <= cur + j; i ++) {
				minTime = Math.min(minTime, forest[i]);
			}
			if (minTime == Integer.MAX_VALUE) { System.out.println(-1); System.exit(0); }
			for (int i = cur + 1; i <= cur + j && i <= n; i ++) {
				if (forest[i] == minTime) cur = i;
			}
			time = Math.max(time, minTime);
		}
		
		System.out.println(j != n + 1 ? time : 0);
	}
}
