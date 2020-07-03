import java.io.*;
import java.util.*;

public class FakeJudges {
	static class Node implements Comparable<Node> {
		int idx, cn;
		Node (int idx, int cn) {
			this.idx = idx;
			this.cn = cn;
		}

		public int compareTo(Node n) {
			return -Integer.compare(cn, n.cn);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(st.nextToken());
		
		Node[] queries = new Node[n];
		for (int i = 0; i < n; i ++) queries[i] = new Node(i, 0);

		int[] left = new int[q], right = new int[q];
		for (int i = 0; i < q; i ++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()) - 1, r = Integer.parseInt(st.nextToken()) - 1;
			left[i] = l; right[i] = r;
			queries[l].cn ++;
			if (r + 1 < n) queries[r + 1].cn --;
		}
		for (int i = 1; i < n; i ++) queries[i].cn += queries[i - 1].cn;
		Arrays.sort(queries);
		
		int[] newArr = new int[n];
		Arrays.sort(arr);
		for (int i = 0; i < n; i ++) newArr[queries[i].idx] = arr[i];
		long[] psa = new long[n];
		for (int i = 0; i < n; i ++) {
			if (i == 0) psa[i] = newArr[i];
			else psa[i] = psa[i - 1] + newArr[i];
		}
		long minSum = 0;
		for (int i = 0; i < q; i ++) {
			if (left[i] != 0) minSum += psa[right[i]] - psa[left[i] - 1];
			else minSum += psa[right[i]];
		}
		System.out.println(minSum);
	}
}
