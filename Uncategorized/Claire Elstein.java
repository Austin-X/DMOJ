import java.io.*;
import java.util.*;

public class ClaireElstein {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m =  Integer.parseInt(st.nextToken());
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList[n + 1];
		ArrayList<Integer> starts = new ArrayList<Integer>();
		
		boolean[] startVisited = new boolean[n + 1];
		boolean[] endVisited = new boolean[n + 1];
		long[] dp = new long[n + 1];
		long[] deg = new long[n + 1];
		int[] howMany = new int[n + 1];
		
		for (int i = 0; i <= n; i ++) adj[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[x].add(y);
			startVisited[y] = true;
			deg[y] ++;
			endVisited[x] = true;
		}
		
		for (int i = 1; i <= n; i ++) {
			if (!startVisited[i]) {
				starts.add(i);
				howMany[i] = 1;
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		long cn = 0;

		for (int i = 0; i < starts.size(); i ++) {
			q.add(starts.get(i));

			while (!q.isEmpty()) {	
				int cur = q.poll();
			
				for (int x : adj[cur]) {
					deg[x] --;
					if (deg[x] == 0) q.add(x);
					howMany[x] = (howMany[x] + howMany[cur]) % 1000000007;
					dp[x] = (dp[cur] + howMany[cur] + dp[x]) % 1000000007;
				}
			}
		}
		for (int i = 1; i <= n; i ++) if (!endVisited[i]) cn += dp[i];
		
		System.out.println(cn % 1000000007);
	}
}
