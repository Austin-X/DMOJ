import java.io.*;
import java.util.*;

public class PyramidMessageScheme {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int l = Integer.parseInt(br.readLine());
		for (int t = 0; t < l; t ++) {
			int n = Integer.parseInt(br.readLine());
			
			int original = n * 10;
			
			HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
			
			String cur = br.readLine();
			map.put(cur, new ArrayList<String>());
			
			for (int i = 0; i < n - 1; i ++) {
				String str = br.readLine();
				if (!map.containsKey(str)) {
					map.put(str, new ArrayList<String>());
					map.get(str).add(cur);
					map.get(cur).add(str);
				} else if (!map.get(str).contains(cur)) {
					map.get(str).add(cur);
					map.get(cur).add(str);
				} 
				cur = str;
			}
			
			ArrayList<String> check = new ArrayList<String>();
			for (String x : map.keySet()) check.add(x);
			check.remove(check.indexOf(cur));

			Queue<String> q = new LinkedList<String>();
			q.add(cur);
			HashMap<String, Integer> dis = new HashMap<String, Integer>();
			dis.put(cur, 0);
			
			while (!q.isEmpty()) {
				String s = q.poll();
				for (String x : map.get(s)) {
					if (check.contains(x)) {
						q.add(x);
						dis.put(x, dis.get(s) + 1);
						check.remove(check.indexOf(x));
					}
				}
			}
			
			int ans = 0;
			for (String x : dis.keySet()) ans = Math.max(ans, dis.get(x));
			System.out.println(original - ans * 20);
		}
	}
}
