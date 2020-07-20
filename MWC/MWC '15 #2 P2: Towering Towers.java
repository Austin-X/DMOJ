import java.io.*;
import java.util.*;

public class ToweringTowers {
	static class Pair {
		int height, idx;
		Pair (int height, int idx) { this.height = height; this.idx = idx; }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] towers = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) towers[i] = Integer.parseInt(st.nextToken());

		Stack<Pair> s = new Stack<Pair>();
		for (int i = 0; i < n; i ++) {
			if (i == 0) { System.out.print(0 + " "); s.push(new Pair(towers[i], 0)); }
			else {
				while (!s.isEmpty() && towers[i] >= s.peek().height) s.pop();
				if (s.isEmpty()) System.out.print(i + " ");
				else System.out.print((i - s.peek().idx) + " ");
				s.push(new Pair(towers[i], i));
			}
		}
	}
}
