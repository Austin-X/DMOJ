import java.io.*;
import java.util.*;

/* Submit this code using Java11 instead of Java8 because the 'int' primitive data type in Java8 takes up 16 bytes whereas for Java11, the 'int' primitive data type
 * takes up only 4 bytes. */

public class Sound {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i ++) arr[i] = Integer.parseInt(st.nextToken());
		
		if (m > n) { System.out.println("NONE"); System.exit(0); }
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		int[] cn = new int[1000001];
		for (int i = 1; i <= m; i ++) {
			cn[arr[i]] ++;
			set.add(arr[i]);
		}

		boolean flag = false;
		if (set.last() - set.first() <= c) {
			flag = true; System.out.println(1);
		}
		for (int i = m + 1; i <= n; i ++) {
			cn[arr[i - m]] --;
			cn[arr[i]] ++;
			if (cn[arr[i - m]] == 0) set.remove(arr[i - m]);
			if (cn[arr[i]] == 1) set.add(arr[i]);
			if (set.last() - set.first() <= c) {
				flag = true; System.out.println(i - m + 1);
			}
		}
		
		if (!flag) System.out.println("NONE");
	}
}
