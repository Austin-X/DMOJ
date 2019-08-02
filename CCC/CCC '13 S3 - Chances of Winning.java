import java.io.*;
import java.util.*;

public class ChancesOfWinning {
	static class Game {
		int x, y;
		Game(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int ways = 0, t;
	static int[] score = new int[5];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		int g = Integer.parseInt(br.readLine());
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList[5];
		for (int i = 0; i <= 4; i ++) adj[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < g; i ++) {
			st = new StringTokenizer(br.readLine());
			int teamA = Integer.parseInt(st.nextToken());
			int teamB = Integer.parseInt(st.nextToken());
			int scoreA = Integer.parseInt(st.nextToken());
			int scoreB = Integer.parseInt(st.nextToken());
			
			if (scoreA > scoreB) score[teamA] += 3;
			else if (scoreA < scoreB) score[teamB] += 3;
			else {
				score[teamA] ++; score[teamB] ++;
			}
			
			adj[teamA].add(teamB);
			adj[teamB].add(teamA);
		}

		ArrayList<Game> arr = new ArrayList<Game>();
		for (int i = 1; i <= 4; i ++) {
			for (int j = 1; j <= 4; j ++) {
				if (i != j && !adj[i].contains(j)) {
					arr.add(new Game(i, j));
					adj[j].add(i);
				}
			}
		}

		recurse(arr, 0);
		System.out.println(ways);
	}
	
	static void recurse (ArrayList<Game> arr, int idx) {
		if (idx == arr.size()) {
			int topContender = 0;
			for (int i = 1; i <= 4; i ++) {
				if (i != t) topContender = Math.max(topContender, score[i]);
			}
			
			if (score[t] > topContender) ways ++;
			return;
		}
		
		Game game = arr.get(idx);
		
		score[game.x] += 3;
		recurse(arr, idx + 1);
		
		score[game.x] -= 3;
		score[game.y] += 3;
		recurse(arr, idx + 1);
		
		score[game.y] -= 3;
		score[game.x] ++; score[game.y] ++;
		recurse(arr, idx + 1);
		
		score[game.x] --; score[game.y] --;
	}
}
