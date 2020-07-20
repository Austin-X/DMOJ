import java.io.*;
import java.util.*;

public class AClassicProblem {
	static class Pair {
		int val, idx;
		Pair (int val, int idx) { this.val = val; this.idx = idx; }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(st.nextToken());
		
		long ans = 0;
		Deque<Pair> max = new ArrayDeque<Pair>(), min = new ArrayDeque<Pair>();
		int l = 0;
		for (int r = 0; r < n; r ++) {
			while (!max.isEmpty() && arr[r] >= max.peekLast().val) max.pollLast();
			while (!min.isEmpty() && arr[r] <= min.peekLast().val) min.pollLast();
			max.add(new Pair(arr[r], r)); min.add(new Pair(arr[r], r));
			
			if (min.size() == 1 && max.peekFirst().val - min.peekFirst().val > k) {
				while (max.peekFirst().val - min.peekFirst().val > k) l = max.pollFirst().idx + 1;
			} else if (max.size() == 1 && max.peekFirst().val - min.peekFirst().val > k) {
				while (max.peekFirst().val - min.peekFirst().val > k) l = min.pollFirst().idx + 1;
			}
			ans += r - l + 1;
		}
		
		System.out.println(ans);
	}
}
