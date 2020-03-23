import java.io.*;

public class AGraphProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long sum = 0, max = 0;
		for (int i = 0; i < n; i ++) {
			int x = Integer.parseInt(br.readLine());
			sum += x;
			max = Math.max(max, x);
		}
		
		if (sum % 2 == 0 && max <= sum - max) System.out.println("YES");
		else System.out.println("NO");
	}
}
