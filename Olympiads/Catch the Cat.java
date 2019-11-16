import java.io.*;
import java.util.*;

public class CatchTheCat {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
		
		int[] best = new int[100001];
		Arrays.fill(best, Integer.MAX_VALUE - 1);
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		best[x] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if (cur != y && cur <= 100000) {
				if (cur != 100000 && best[cur] + 1 < best[cur + 1]) {
					q.add(cur + 1); best[cur + 1] = best[cur] + 1;
				}
				if (cur <= 50000 && best[cur] + 1 < best[cur * 2]) {
					q.add(cur * 2); best[cur * 2] = best[cur] + 1;
				}
				if (cur >= 1 && best[cur] + 1 < best[cur - 1]) {
					q.add(cur - 1); best[cur - 1] = best[cur] + 1;
				}
			} else if (cur > y && cur <= 100000 && cur >= 1) {
				if (best[cur] + 1 < best[cur - 1]) {
					q.add(cur - 1); best[cur - 1] = best[cur] + 1;
				}
			}
		}
		
		System.out.println(best[y]);
	}
}
