import java.io.*;
import java.util.*;

public class Dom {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 1; i <= n; i ++) {
			st = new StringTokenizer(br.readLine());
			int fav = Integer.parseInt(st.nextToken()), worst = Integer.parseInt(st.nextToken());
			if (!map.containsKey(worst)) map.put(worst, fav);
		}
		
		boolean[] vis = new boolean[m + 1];
		
		int cur = p;
		int ans = recurse(vis, map, cur, 0);
		
		System.out.println(ans);
	}
	
	static int recurse(boolean[] vis, HashMap<Integer, Integer> map, int cur, int cn) {
		if (vis[cur]) return -1; 
		if (map.containsKey(cur)) {
			cn ++; vis[cur] = true; cur = map.get(cur);
		} else return cn;
		return recurse(vis, map, cur, cn);
	}
}
