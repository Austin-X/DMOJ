import java.util.*;
import java.io.*;

public class MaxProfit {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0;
		int n = Integer.parseInt(br.readLine());
		int[] value = new int[n];
		int[] diff = new int[n];
		int tem = 0;
		
		String[] temp = br.readLine().split(" ");
		for (int i = 0; i < temp.length; i ++) {
			value[i] = Integer.parseInt(temp[i]);
		}
		String[] temp2 = br.readLine().split(" ");
		for (int i = 0; i < temp2.length; i ++) {
			diff[i] = value[i] - Integer.parseInt(temp2[i]);
		}

		Arrays.sort(diff);
		for (int x : diff) {
			if (x > 0) max += x;
		}
			
		System.out.println(max);
	}
}
