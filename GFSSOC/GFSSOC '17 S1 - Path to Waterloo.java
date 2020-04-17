import java.io.*;
import java.util.*;

public class PathToWaterloo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());
		HashMap<String, ArrayList<String>> adj = new HashMap<String, ArrayList<String>>();
		
		for (int i = 0; i < n; i ++) {
			String x = br.readLine();
			adj.put(x, new ArrayList<String>());
		}
		adj.put("home", new ArrayList<String>());
		adj.put("Waterloo GO", new ArrayList<String>());
		
		for (int i = 0; i < t; i ++) {
			String[] arr = br.readLine().split("-");
			String a = arr[0], b = arr[1];
			adj.get(a).add(b); adj.get(b).add(a);
		}
		
		HashMap<String, Integer> dis = new HashMap<String, Integer>();
		dis.put("home", 0);
		Queue<String> q = new LinkedList<String>();
		ArrayList<String> vis = new ArrayList<String>();
		vis.add("home");
		q.add("home");
		while (!q.isEmpty()) {
			String x = q.poll();
			if (adj.get(x) == null) continue;
			for (String s : adj.get(x)) {
				if (!vis.contains(s)) {
					if (dis.containsKey(s) && dis.get(x) + 1 < dis.get(s)) {
						dis.replace(s, dis.get(x) + 1); vis.add(s); q.add(s);
					} else if (!dis.containsKey(s)) {
						dis.put(s, dis.get(x) + 1);	vis.add(s); q.add(s);
					}
				}
			}
		}
		
		System.out.println(dis.containsKey("Waterloo GO") ? dis.get("Waterloo GO") : "RIP ACE");
	}
}
