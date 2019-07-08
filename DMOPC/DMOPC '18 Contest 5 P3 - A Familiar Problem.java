import java.io.*;
import java.util.*;

public class AFamiliarProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		double m = Double.parseDouble(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int lower = 0, upper = 1;
		double cn = 0, sum = arr[0], temp = 0;
		
		while (true) {	
			if (upper == n) {
				if (sum < m) cn = Math.max(cn, temp + 1);
				break;
			}
			
			if (sum < m) {
				sum += arr[upper];
				upper ++;
				temp ++;
			} else {
				sum -= arr[lower];
				lower ++;
				temp --;
			}
			cn = Math.max(cn, temp);
		}
		System.out.println((int)cn);
	}
}
