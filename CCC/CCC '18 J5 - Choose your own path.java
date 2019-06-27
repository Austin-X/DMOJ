import java.io.*;
import java.util.*;

public class ChooseYourOwnPath {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		boolean[] ending = new boolean[n + 1];
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i ++) adj[i] = new ArrayList<Integer>();
		
		for (int i = 1; i <= n; i ++) {
			st = new StringTokenizer(br.readLine());
			int options = Integer.parseInt(st.nextToken());
			if (options != 0) {
				for (int j = 0; j < options; j ++) {
					adj[i].add(Integer.parseInt(st.nextToken()));
				}
			} else ending[i] = true;
		}
		
		boolean allVisited = false;
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		
		ArrayList<Integer> pathSizes = new ArrayList<Integer>();
		int shortestPath = Integer.MAX_VALUE;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		
		int[] dis = new int[n + 1];
		dis[1] = 2;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int x : adj[cur]) {
				if (ending[x]) {
					visited[x] = true;
					pathSizes.add(dis[cur]);
				}
				else if (!visited[x]) {
					visited[x] = true;
					queue.add(x);
					dis[x] = dis[cur] + 1;
				}
			}
		}
		Collections.sort(pathSizes); shortestPath = pathSizes.get(0);
		
		for (int i = 1; i <= n; i ++) {
			if (visited[i]) allVisited = true;
			else {
				allVisited = false; break;
			}
		}
		
		if (allVisited) System.out.println("Y");
		else System.out.println("N");
		System.out.println(shortestPath);
	}
}
