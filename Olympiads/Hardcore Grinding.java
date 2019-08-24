import java.io.*;
import java.util.*;

public class HardcoreGrinding {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] diff = new int[10000001];
		
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			diff[a] ++;
			diff[b] --;
		}
		
		for (int i = 1; i <= 10000000; i ++) diff[i] += diff[i - 1];
		int max = 0;
		for (int i = 1; i <= 10000000; i ++) max = Math.max(max, diff[i]);
		System.out.println(max);
	}
}
