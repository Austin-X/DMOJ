import java.io.*;
import java.util.*;

public class WinniesOrphans {
	static class op implements Comparable<op> {
		int idx, cn;
		op (int idx, int cn) { this.idx = idx; this.cn = cn; }
		public int compareTo(op o) {
			return Integer.compare(cn, o.cn);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		op[] arr = new op[n];
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int cn = 0;
			for (int j = 0; j < m; j ++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1 || num == 10) cn ++;
			}
			arr[i] = new op(i, cn);
		}
		Arrays.sort(arr);
		ArrayList<Integer> possible = new ArrayList<Integer>();
		possible.add(arr[0].idx + 1);
		
		for (int i = 1; i < n; i ++) {
			if (arr[i].cn != arr[i - 1].cn) break;
			possible.add(arr[i].idx + 1);
		}
		Collections.sort(possible);
		System.out.println(possible.get(0));
	}
}
