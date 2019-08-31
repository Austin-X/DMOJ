import java.io.*;
import java.util.*;

public class NotEnoughPersonnel {
	static class pair implements Comparable<pair> {
		String name;
		int skill;
		
		pair (String name, int skill) {
			this.name = name;
			this.skill = skill;
		}
		
		public int compareTo(pair p) {
			return Integer.compare(skill, p.skill);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		pair[] veterans = new pair[n];
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			veterans[i] = new pair(st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(veterans);
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i ++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			String partner = "";
			for (int j = 0; j < n; j ++) {
				if (veterans[j].skill >= s && veterans[j].skill <= s + d) { partner = veterans[j].name; break; }
				else if (veterans[j].skill > s + d) break;
			}
			System.out.println(!partner.equals("") ? partner : "No suitable teacher!");
		}
	}
}
