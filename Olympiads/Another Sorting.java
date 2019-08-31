import java.io.*;
import java.util.*;

public class AnotherSorting {
	static class E implements Comparable<E> {
		int num, ones;
		
		E (int num) {
			this.num = num;
			String temp = String.valueOf(num);
			ones = Character.getNumericValue(temp.charAt(temp.length() - 1));
		}
		
		public int compareTo(E e) {
			if (ones == e.ones) return -Integer.compare(num, e.num);
			else return Integer.compare(ones, e.ones);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		E[] nums = new E[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) nums[i] = new E(Integer.parseInt(st.nextToken()));
		Arrays.sort(nums);
		for (int i = 0; i < n; i ++) System.out.print(nums[i].num + " ");
	}
}
