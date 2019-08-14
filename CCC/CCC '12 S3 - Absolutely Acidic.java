import java.io.*;
import java.util.*;

public class AbsolutelyAcidic {
	static class pair implements Comparable<pair>{
		int number, count;
		
		pair(int number, int count) {
			this.number = number;
			this.count = count;
		}
		
		public int compareTo(pair p) {
			return -Integer.compare(count, p.count);
		}
	}
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] readings = new int[n];
		int[] cn = new int[1001];
		for (int i = 0; i < n; i ++) {
			readings[i] = Integer.parseInt(br.readLine());
			cn[readings[i]] ++;
		}
		
		ArrayList<pair> nums = new ArrayList<pair>();
		for (int i = 1; i <= 1000; i ++) {
			if (cn[i] != 0) nums.add(new pair(i, cn[i]));
		}
		Collections.sort(nums);
		
		ArrayList<Integer> freq1 = new ArrayList<Integer>();
		freq1.add(nums.get(0).number); 
		ArrayList<Integer> freq2 = new ArrayList<Integer>();
		
		int check = 0;
		for (int i = 1; i < nums.size(); i ++) {
			if (nums.get(i).count == nums.get(i - 1).count) { 
				if (check == 0) freq1.add(nums.get(i).number);
				else freq2.add(nums.get(i).number);
			}
			else {
				if (check == 1) break;
				freq2.add(nums.get(i).number);
				check ++;
			}
		}
		
		Collections.sort(freq1);
		Collections.sort(freq2);

		if (freq1.size() >= 2) System.out.println(Math.abs(freq1.get(freq1.size() - 1) - freq1.get(0)));
		else {
			int max = 0;
			for (int i = 0; i < freq2.size(); i ++) {
				if (Math.abs(freq1.get(0) - freq2.get(i)) < max) break;
				else max = Math.abs(freq1.get(0) - freq2.get(i));
			}
			System.out.println(max);
		}
	}
}
