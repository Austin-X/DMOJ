import java.io.*;
import java.util.*;

public class Deforestation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] sum = new int[n + 1];
		int[] arr = new int[n + 1];
		
		arr[0] = 0; sum[0] = 0;
		for (int i = 1; i <= n; i ++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (i == 1) sum[i] = arr[i];
			else {
				sum[i] = sum[i - 1] + arr[i];
			}
		}
		
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(a == b ? arr[a + 1] : sum[b + 1] - sum[a]);
		}
	}
}
