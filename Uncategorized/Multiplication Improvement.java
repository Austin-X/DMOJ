import java.io.*;
import java.util.*;

public class MultiplicationImprovement {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split("x");
		int len = temp.length;
		int[] nums = new int[len];
		long res = 1;
		
		for (int i = 0; i < len; i ++) {
			nums[i] = Integer.parseInt(temp[i]); res *= nums[i];
		}
		
		Arrays.sort(nums);
		for (int i = 0; i < len; i ++) {
			if (i != len - 1) System.out.print(nums[i] + "x");
			else System.out.print(nums[i]);
		}	
		System.out.println("\n" + res);
	}
}
