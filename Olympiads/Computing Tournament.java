import java.io.*;
import java.util.*;

public class ComputingTournament {
	static boolean flag = false;
	static class participant implements Comparable<participant> {
		int index, first, second;
		
		participant (int index, int first, int second) {
			this.index = index;
			this.first = first;
			this.second = second;
		}
		
		public int compareTo (participant p) {
			if (!flag) return -Integer.compare(first, p.first);
			else return -Integer.compare(second, p.second);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		participant[] pa = new participant[n];
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			pa[i] = new participant(i + 1, f, s);
		}
		
		Arrays.sort(pa);
		participant[] second = new participant[k];
		for (int i = 0; i < k; i ++) second[i] = pa[i];
		
		flag = true;
		Arrays.sort(second);
		System.out.println(second[0].index);
	}
}
