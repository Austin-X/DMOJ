import java.io.*;
import java.util.*;

public class BridgeCrossing {
	static class pair {
		String name;
		int time;
		
		public pair(String name, int time) {
			this.name = name;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<pair> people = new ArrayList<pair>();
		int m = Integer.parseInt(br.readLine());
		int q = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < q; i ++) {
			String name = br.readLine();
			int time = Integer.parseInt(br.readLine());
			people.add(new pair(name, time));
		}
		
		int[] dp = new int[q + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int[] order = new int[q + 1];

		int max;
		for (int i = 0; i <= q; i ++) {
			max = 0;
			for (int j = i + 1; j <= q && j <= i + m; j ++) {
				max = Math.max(max, people.get(j - 1).time);
				if (dp[i] + max < dp[j]) {
					order[j] = j - i;
					dp[j] = dp[i] + max;
				}
			}
		}

		System.out.println("Total Time: " + dp[q]);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int index = q;
		while (index != 0) {
			list.add(order[index]);
			index -= order[index];
		}
		
		index = 0;
		for (int i = list.size() - 1; i >= 0; i --) {
			for (int j = 0; j < list.get(i); j ++) {
				System.out.print(people.get(index++).name + " ");
			}
			System.out.println();
		} 
	}
}
