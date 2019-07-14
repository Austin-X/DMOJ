import java.io.*;
import java.util.*;

public class SumGame {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int max = 0;
		int n = Integer.parseInt(br.readLine());
		
		int[] swifts = new int[n];
		st = new StringTokenizer(br.readLine());
		swifts[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < n; i ++) {
			swifts[i] = swifts[i - 1] + Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int temp = 0;
		for (int i = 0; i < n; i ++) {
			temp += Integer.parseInt(st.nextToken());
			if (temp == swifts[i]) max = i + 1;
		}
		
		System.out.println(max);
	}
}
