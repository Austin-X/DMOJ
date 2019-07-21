import java.io.*;
import java.util.*;

public class PowerRankings {
	static class pair implements Comparable<pair> {
		String name;
		int time = 0;
		
		pair(String name, int time) {
			this.name = name;
		}
		
		public void add(int x) {
			time += x;
		}
		
		public int compareTo(pair p) {
			return -Integer.compare(time, p.time);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		ArrayList<pair> arr = new ArrayList<pair>();
		
		for (int i = 0; i < n; i ++) {
			arr.add(new pair(br.readLine(), 0));
		}
		
		for (int i = 0; i < p; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j ++) {
				int x = Integer.parseInt(st.nextToken());
				arr.get(j).add(x);
			}
		}	
		int ind = 3;
		
		Collections.sort(arr);
		
		for (int i = 0; i < n; i ++) {
			System.out.println(ind + ". " + arr.get(i).name);
			ind ++;
		}
	}
}
