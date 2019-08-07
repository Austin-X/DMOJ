import java.io.*;
import java.util.*;

public class TandemBicycle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int choice = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		Integer[] dmojistan = new Integer[n];
		Integer[] peg = new Integer[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) dmojistan[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) peg[i] = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		if (choice == 1) {
			Arrays.sort(dmojistan); Arrays.sort(peg);
		} else {
			Arrays.sort(dmojistan, Collections.reverseOrder()); Arrays.sort(peg);
		}
		for (int i = 0; i < n; i ++) ans += Math.max(dmojistan[i], peg[i]);
		System.out.println(ans);
	}
}
