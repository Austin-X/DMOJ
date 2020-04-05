import java.io.*;
import java.util.*;

public class SegmentTreeTest {
	static class Node {
		int min, gcd, cn;
		Node(int min, int gcd, int cn) {
			this.min = min;
			this.gcd = gcd;
			this.cn = cn;
		}
	}
	
	static Node segmentTree[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		int sizeTemp = 0;
		for (int i = 0; i <= 17; i ++) {
			if (Math.pow(2, i) >= n) { sizeTemp = (int)Math.pow(2, i); break; }
		}
		segmentTree = new Node[2 * sizeTemp - 1];
		for (int i = 0; i < 2 * sizeTemp - 1; i ++) segmentTree[i] = new Node(0, 0, 0);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) arr[i] = Integer.parseInt(st.nextToken()); 
		constructTree(arr, 0, n - 1, 0);
		
		for (int t = 0; t < m; t ++) {
			st = new StringTokenizer(br.readLine());
			char choice = st.nextToken().charAt(0);
			
			if (choice == 'C') {
				int x = Integer.parseInt(st.nextToken()) - 1, v = Integer.parseInt(st.nextToken());
				updateTree(x, 0, n - 1, 0, v);
			} else if (choice == 'M') {
				int l = Integer.parseInt(st.nextToken()) - 1, r = Integer.parseInt(st.nextToken()) - 1;
				System.out.println(getMin(l, r, 0, n - 1, 0));
			} else if (choice == 'G') {
				int l = Integer.parseInt(st.nextToken()) - 1, r = Integer.parseInt(st.nextToken()) - 1;
				System.out.println(getGcd(l, r, 0, n - 1, 0));
			} else {
				int l = Integer.parseInt(st.nextToken()) - 1, r = Integer.parseInt(st.nextToken()) - 1;
				int g = getGcd(l, r, 0, n - 1, 0);
				System.out.println(getCn(l, r, 0, n - 1, 0, g));
			} 
		}
	}
	
	static int gcd (int a, int b) {
		return (b == 0 ? a : gcd(b, a % b));
	}
	
	static void constructTree(int[] arr, int low, int high, int pos) {
		if (low == high) {
			segmentTree[pos].min = arr[low];
			segmentTree[pos].gcd = arr[low];
			segmentTree[pos].cn = 1;
			return;
		}
		
		int mid = (low + high) / 2;
		constructTree(arr, low, mid, 2 * pos + 1);
		constructTree(arr, mid + 1, high, 2 * pos + 2);
		segmentTree[pos].min = Math.min(segmentTree[2 * pos + 1].min, segmentTree[2 * pos + 2].min);
		segmentTree[pos].gcd = gcd(segmentTree[2 * pos + 1].gcd, segmentTree[2 * pos + 2].gcd);
		if (segmentTree[pos].gcd == segmentTree[2 * pos + 1].gcd) segmentTree[pos].cn += segmentTree[2 * pos + 1].cn;
		if (segmentTree[pos].gcd == segmentTree[2 * pos + 2].gcd) segmentTree[pos].cn += segmentTree[2 * pos + 2].cn;
	}
	
	static void updateTree(int idx, int low, int high, int pos, int val) {	
		if (low == high) {
			segmentTree[pos].min = val;
			segmentTree[pos].gcd = val;
			segmentTree[pos].cn = 1;
		}
		else {
			int mid = (low + high) / 2;
			if (idx >= low && idx <= mid) updateTree(idx, low, mid, 2 * pos + 1, val);
			else updateTree(idx, mid + 1, high, 2 * pos + 2, val);
			segmentTree[pos].min = Math.min(segmentTree[2 * pos + 1].min, segmentTree[2 * pos + 2].min);
			segmentTree[pos].gcd = gcd(segmentTree[2 * pos + 1].gcd, segmentTree[2 * pos + 2].gcd);
			
			segmentTree[pos].cn = 0;
			if (segmentTree[pos].gcd == segmentTree[2 * pos + 1].gcd) segmentTree[pos].cn += segmentTree[2 * pos + 1].cn;
			if (segmentTree[pos].gcd == segmentTree[2 * pos + 2].gcd) segmentTree[pos].cn += segmentTree[2 * pos + 2].cn;
		}
	}
	
	static int getMin(int l, int r, int low, int high, int pos) {
		if (l <= low && r >= high) return segmentTree[pos].min;
		else if (l > high || r < low) return Integer.MAX_VALUE;
		int mid = (low + high) / 2;
		return Math.min(getMin(l, r, low, mid, 2 * pos + 1), getMin(l, r, mid + 1, high, 2 * pos + 2));
	}
	
	static int getGcd(int l, int r, int low, int high, int pos) {
		if (l <= low && r >= high) return segmentTree[pos].gcd;
		int mid = (low + high) / 2;
		
		if (r <= mid) return getGcd(l, r, low, mid, 2 * pos + 1);
		else if (l > mid) return getGcd(l, r, mid + 1, high, 2 * pos + 2);
		else return gcd(getGcd(l, r, low, mid, 2 * pos + 1), getGcd(l, r, mid + 1, high, 2 * pos + 2));
	}
	
	static int getCn(int l, int r, int low, int high, int pos, int g) {
		if (l <= low && r >= high) {
			if (segmentTree[pos].gcd == g) return segmentTree[pos].cn;
			else return 0;
		}
		else if (l > high || r < low) return 0;
		int mid = (low + high) / 2;
		return getCn(l, r, low, mid, 2 * pos + 1, g) + getCn(l, r, mid + 1, high, 2 * pos + 2, g);
	}
}
