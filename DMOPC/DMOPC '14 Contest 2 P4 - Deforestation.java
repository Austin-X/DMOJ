import java.io.*;
import java.util.*;

public class Deforestation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] psa = new int[n + 1];
		psa[1] = Integer.parseInt(br.readLine());
		for (int i = 2; i <= n; i ++) psa[i] = psa[i - 1] + Integer.parseInt(br.readLine());
		
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(psa[b + 1] - psa[a]);
		}
	}
}
