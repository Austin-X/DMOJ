import java.io.*;
import java.util.*;

public class PizzaBag {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(st.nextToken());
		
		long[] psa = new long[n];
		psa[0] = arr[0]; 
		for (int i = 1; i < n; i ++) psa[i] = psa[i - 1] + arr[i];

		int pow = (int) Math.ceil(Math.log(n) / Math.log(2));
		int size = (int) (2 * Math.pow(2, pow) - 1);
		long[] segTree = new long[size];
		construct(segTree, psa, 0, n - 1, 0);

		long ans = 0, max;
		int idx = 0;
		while (idx != k - 1) {
			if (idx == 0) max = Math.max(psa[idx] + psa[n - 1] - psa[n - k + idx], psa[idx] + psa[n - 1] - psa[n - k + idx] - rangeMinimumQuery(segTree, n - k + idx + 1, n - 1, 0, n - 1, 0) + psa[n - k + idx]);
			else {
				max = Math.max(arr[idx], psa[idx] - rangeMinimumQuery(segTree, 0, idx - 1, 0, n - 1, 0));
				max = Math.max(max, Math.max(psa[idx] + psa[n - 1] - psa[n - k + idx], psa[idx] + psa[n - 1] - psa[n - k + idx] - rangeMinimumQuery(segTree, n - k + idx + 1, n - 1, 0, n - 1, 0) + psa[n - k + idx]));
			}
			ans = Math.max(ans, max);
			idx ++;
		}
		
		idx = k - 1;
		while (idx < n) {
			if (idx == k - 1) max = Math.max(psa[idx], psa[idx] - rangeMinimumQuery(segTree, idx - k + 1, idx - 1, 0, n - 1, 0));
			else max = Math.max(psa[idx] - psa[idx - k], psa[idx] - psa[idx - k] - rangeMinimumQuery(segTree, idx - k + 1, idx - 1, 0, n - 1, 0) + psa[idx - k]);
			ans = Math.max(ans, max);
			idx ++;
		}
		System.out.println(ans);
	}
	
	static long construct(long[] tree, long[] psa, int low, int high, int pos) {
		if (low == high) { 
			tree[pos] = psa[low];
		} else {
			int mid = (low + high) / 2;
			tree[pos] = Math.min(construct(tree, psa, low, mid, pos * 2 + 1), construct(tree, psa, mid + 1, high, pos * 2 + 2));
		}
		return tree[pos];
	}
	
	static long rangeMinimumQuery (long[] tree, int l, int r, int low, int high, int pos) {
		if (l <= low && r >= high) return tree[pos];
		int mid = (low + high) / 2;
		if (r <= mid) return rangeMinimumQuery(tree, l, r, low, mid, pos * 2 + 1);
		else if (l > mid) return rangeMinimumQuery(tree, l, r, mid + 1, high, pos * 2 + 2);
		else return Math.min(rangeMinimumQuery(tree, l, r, low, mid, pos * 2 + 1), rangeMinimumQuery(tree, l, r, mid + 1, high, pos * 2 + 2));
	}
}
