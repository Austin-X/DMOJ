import java.io.*;
import java.util.*;

public class SurmisingASprintersSpeed {
	static class pair implements Comparable<pair> {
		int time, position;
		
		pair (int time, int position) {
			this.time = time;
			this.position = position;
		}

		public int compareTo(pair p) {
			return Integer.compare(time, p.time);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		pair[] arr = new pair[n];
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken()), pos = Integer.parseInt(st.nextToken());
			arr[i] = new pair(t, pos);
		}
		
		Arrays.sort(arr);
		double ans = 0;

		for (int i = 0; i < n - 1; i ++) {
			ans = Math.max((double)Math.abs(arr[i].position - arr[i + 1].position) / (arr[i + 1].time - arr[i].time), ans);
		}
		
		System.out.println(ans);
	}
}
