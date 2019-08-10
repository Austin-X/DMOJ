import java.io.*;
import java.util.*;

public class ComputerPurchase {
	static class computer implements Comparable<computer> {
		String name;
		int value;
		
		computer (String name, int r, int s, int d) {
			this.name = name;
			value = 2 * r + 3 * s + d;
		}
		
		public int compareTo(computer c) {
			if (value > c.value) return -1;
			else if (value == c.value) {
				return name.compareTo(c.name);
			} else return 1;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		computer[] list = new computer[n];
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int r = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list[i] = new computer(name, r, s, d);
		}
		
		Arrays.sort(list);
		if (list.length == 1) System.out.println(list[0].name);
		else if (list.length != 0){
			System.out.println(list[0].name + "\n" + list[1].name);
		}
	}
}
