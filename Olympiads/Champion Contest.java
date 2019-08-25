import java.io.*;
import java.util.*;

public class ChampionContest {
	static class ch implements Comparable<ch>{
		int index;
		long power;
		
		ch (int index, long power) {
			this.index = index;
			this.power = power;
		}
		
		public int compareTo(ch c) {
			return -Long.compare(power, c.power);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] cn = new int[n];
		ch[] champions = new ch[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i ++) champions[i] = new ch(i, Long.parseLong(st.nextToken()));
		

		for (int i = 0; i < k; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (champions[a - 1].power > champions[b - 1].power) cn[a - 1] --;
			else if (champions[b - 1].power > champions[a - 1].power) cn[b - 1] --;
		}
		
		Arrays.sort(champions);
		for (int i = 0; i < n; i ++) {
			cn[champions[i].index] += n - (i + 1);
			for (int j = i + 1; j < n; j ++) {
				if (champions[j].power == champions[i].power) cn[champions[i].index] --;
				else break;
			}
		}
		
		for (int i = 0; i < n; i ++) System.out.print(cn[i] + " ");
	}
}
