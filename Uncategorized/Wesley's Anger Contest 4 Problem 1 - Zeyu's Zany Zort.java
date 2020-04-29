import java.io.*;
import java.util.*;

public class ZeyusZanyZort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());
		int[] acorns = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) acorns[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < q; i ++) {
			st = new StringTokenizer(br.readLine());
			int choice = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken()) - 1, r = Integer.parseInt(st.nextToken()) - 1;
			
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int j = l; j <= r; j ++) temp.add(acorns[j]);
			if (choice == 1) Collections.sort(temp);
			else Collections.sort(temp, Collections.reverseOrder());
			int cn = 0;
			for (int j = l; j <= r; j ++) {
				acorns[j] = temp.get(cn);
				cn ++;
			}
		}
		for (int i = 0; i < n; i ++) {
			if (i != n - 1) System.out.print(acorns[i] + " ");
			else System.out.println(acorns[i]);
		}
	}
}
