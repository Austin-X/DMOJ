import java.io.*;
import java.util.*;

public class WaitTime {
	static class pair {
		int curTime, friend;
		
		pair (int curTime, int friend) {
			this.curTime = curTime;
			this.friend = friend;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int m = Integer.parseInt(br.readLine());
		ArrayList<pair> nums = new ArrayList<pair>();
		int[] sum = new int[101];
		
		int curTime = 0;
		for (int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			String choice = st.nextToken();
			int friend = Integer.parseInt(st.nextToken());
			
			if (choice.equals("R")) {
				nums.add(new pair(curTime, friend));
				curTime ++;
			} else if (choice.equals("W")) {
				curTime += friend - 1;
			} else {
				for (pair x : nums) {
					if (x.friend == friend) {
						sum[x.friend] += curTime - x.curTime;
						nums.remove(nums.indexOf(x)); break;
					}
				}
				curTime ++;
			}
		}
		
		for (pair x : nums) {
			sum[x.friend] = -1;
		}
		
		for (int i = 1; i <= 100; i ++) {
			if (sum[i] != 0) System.out.println(i + " " + sum[i]);
		}
	}
}
