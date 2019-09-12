import java.io.*;
import java.util.*;

public class BinaryIndexedTreeTest {
	static long[] BITree;
	static int[] freq;
	
	static void updateFreq(int index, int val) {
		while (index <= 100000) {
			freq[index] += val;
			index += index & (-index);
		}
	}
	
	static int q(int val) {
		int cn = 0;
		while (val > 0) {
			cn += freq[val];
			val -= val & (-val);
		}
		return cn;
	}
	
	/* 
	 * Returns sum of arr[0..index]. This functions assumes that the array is preprocessed
	 * and partial sums of array elements are stored in BITree[].
	 */
	static long getSum(int index) {
		long sum = 0; // Initialize result
		
		// Traverse ancestors of BITree[index];
		while (index > 0) {
			// Add current element of BITree to sum.
			sum += BITree[index];
			
			// Move index of parent node in getSum View
			index -= index & (-index);
		}
		return sum;
	}
	
	/* 
	 * Updates a node in Binary Indexed Tree (BITree) at given index in BITree. The given value 'val'
	 * is added to BITree[i] and all its ancestors in tree.
	 */
	static void updateBIT(int n, int index, int val) {
		// Index in BITree[] is 1 more than index in arr[].
		index ++;
		
		// Traverse all ancestors and all 'val'
		while (index <= n) {
			// Add 'val' to current node of BITree
			BITree[index] += val;
			
			// Update index to that of parent in update View
			index += index & (-index);
		}
	}
	
	// Functions to construct Fenwick Tree (BITree) from given array.
	static void constructBITree(int[] arr, int n) {
		for (int i = 0; i < n; i ++) {
			updateBIT(n, i, arr[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		BITree = new long[n + 1];
		freq = new int[100001];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
			updateFreq(arr[i], 1);
		}
		constructBITree(arr, n);

		int x, v;
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			char letter = st.nextToken().charAt(0);
			
			if (letter == 'C') {
				x = Integer.parseInt(st.nextToken()) - 1;
				v = Integer.parseInt(st.nextToken());
				
				updateBIT(n, x, v - arr[x]);
				updateFreq(arr[x], -1);
				updateFreq(v, 1);
				arr[x] = v;
			} else if (letter == 'S') {
				x = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				long high = getSum(v);
				long low = getSum(x - 1);
				System.out.println(high - low);
			} else {
				v = Integer.parseInt(st.nextToken());
				System.out.println(q(v));
			}
		}
	}
}
