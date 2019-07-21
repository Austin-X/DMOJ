import java.io.*;
import java.util.*;

public class HouseOfCards {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		Integer[] cards = new Integer[n];
		int k = Integer.parseInt(st.nextToken());
			
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) cards[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(cards, Collections.reverseOrder());
		
		int cur = cards[0], ans = 1;
		for (int i = 1; i < n; i ++) {
			if (cur - cards[i] >= k) {
				ans ++; cur = cards[i];
			}
		}
		System.out.println(ans);
	}
}
