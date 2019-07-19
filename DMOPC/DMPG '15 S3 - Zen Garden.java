import java.io.*;
import java.util.*;

public class ZenGarden {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] flowers = new int[n];
		int[] disturbances = new int[n - 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) flowers[i] = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			disturbances[a - 1] = d;
		}
		
		for (int i = 1; i < n; i ++) {
			if (flowers[i] < disturbances[i - 1] || flowers[i - 1] < disturbances[i - 1]) {
				if (flowers[i] < flowers[i - 1]) {
					flowers[i] = 0;
				} else {
					flowers[i - 1] = 0;
				}
			} else {
				flowers[i] -= disturbances[i - 1];
			}
		}
		
		int sum = 0;
		for (int x : flowers) sum += x;
		
		System.out.println(sum);
	}
}
