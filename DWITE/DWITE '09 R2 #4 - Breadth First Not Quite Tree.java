import java.util.*;
import java.io.*;

public class BreadthFirstNotQuiteTree {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int times = 0; times < 5; times ++) {
			int ids = Integer.parseInt(br.readLine()), cn = 0;
			
			@SuppressWarnings("unchecked")
			ArrayList<Integer>[] adj = new ArrayList[101];

			for (int i = 1; i <= 100; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 0; i < ids; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				adj[x].add(y);
				adj[y].add(x);
			}

			int[] dis = new int[101];
			Arrays.fill(dis, -1);
			dis[1] = 0;
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(1);

			// Starting the bfs
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				for (int x : adj[cur]) {
					if (dis[x] == -1) {
						dis[x] = dis[cur] + 1;
						queue.add(x);
					}
				}
			}

			for (int i = 1; i <= 100; i++) {
				for (int x : adj[i]) {
					if (dis[x] == dis[i]) {
						cn ++;
					}
				}
			}
			
			// Dividing by two because this is an undirected graph
			System.out.println(cn / 2);
		}
	}
}
