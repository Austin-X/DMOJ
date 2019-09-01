import java.io.*;
import java.util.*;

public class BasketballDodgeball {
	static class player {
		int x, y, r;
		player(int x, int y, int r) { this.x = x; this.y = y; this.r = r; }
	}
			
	static int bfs (player[] team, int size, int start, int baller) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[size];
		int[] dis = new int[size];
		q.add(start); visited[start] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < size; i ++) {
				if (!visited[i] && cur != i && Math.pow(team[cur].r, 2) >= Math.pow(Math.abs(team[cur].x - team[i].x), 2) + Math.pow(Math.abs(team[cur].y - team[i].y), 2)) {
					q.add(i);
					visited[i] = true;
					dis[i] = dis[cur] + 1;
				}
			}
		}
		
		return dis[baller] != 0 ? dis[baller] : Integer.MAX_VALUE;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		player[] teamA = new player[n];
		player[] teamB = new player[m];
		
		int startA = 0, ballerA = 0;
		int max = 0;
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			teamA[i] = new player(x, y, r);
			if (y > max) { max = y; startA = i; }
			if (r == 9001) ballerA = i;
		}
		int startB = 0, ballerB = 0;
		max = 0;
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			teamB[i] = new player(x, y, r);
			if (y > max) { max = y; startB = i; }
			if (r == 9001) ballerB = i;
		}
		
		int passesA = bfs(teamA, n, startA, ballerA);
		int passesB = bfs(teamB, m, startB, ballerB);
		
		if (passesA < passesB) System.out.println("We are the champions!");
		else if (passesA > passesB) System.out.println(":'(");
		else System.out.println("SUDDEN DEATH");
	}
}
