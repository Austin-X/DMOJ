import java.io.*;
import java.util.*;

public class ThiefInTheNight {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int f = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList[f + 1];
		for (int i = 0; i <= f; i ++) adj[i] = new ArrayList<Integer>();
		
		int sum;
		for (int i = 1; i <= f; i ++) {
			sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < r; j ++) {
				int cost = Integer.parseInt(st.nextToken());
				sum += cost;
				adj[i].add(sum);
			}
		}
		
		int lower, higher;
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 2;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			
			higher = adj[c].get(b);
			if (a < 0) lower = 0;
			else lower = adj[c].get(a);
			
			System.out.println(higher - lower);
		}
	}
}
