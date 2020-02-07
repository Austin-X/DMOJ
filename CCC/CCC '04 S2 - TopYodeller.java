import java.io.*;
import java.util.*;

public class TopYodeller {
	static class player implements Comparable<player> {
		int num, score;
		player (int num, int score) {
			this.num = num;
			this.score = score;
		}
		
		public int compareTo(player p) {
			return(-Integer.compare(score, p.score));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] score = new int[n];
		int[] worst = new int[n];
		
		for (int t = 0; t < k; t ++) {
			ArrayList<player> arr = new ArrayList<player>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i ++) {
				int sc = Integer.parseInt(st.nextToken());
				score[i] += sc;
				arr.add(new player(i, score[i]));
			}
			Collections.sort(arr);
			
			int cn = 0;
			for (int i = 0; i < n; i ++) {
				worst[arr.get(i).num] = Math.max(worst[arr.get(i).num], i + 1 - cn);
				if (i < n - 1 && score[arr.get(i).num] == score[arr.get(i + 1).num]) cn ++;
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int max = -Integer.MAX_VALUE;
		for (int i = 0; i < n; i ++) {
			if (score[i] > max) {
				ans.clear();
				max = score[i];
				ans.add(i);
			} else if (score[i] == max) {
				ans.add(i);
			}
		}
		
		Collections.sort(ans);
		for (int x : ans) {
			System.out.println("Yodeller " + (x + 1) + " is the TopYodeller: score " + score[x] + ", worst rank " + worst[x]);
		}
	}
}
