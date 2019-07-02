import java.io.*;

public class ShiftySum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int sum = n;
		
		String temp = String.valueOf(n);
		for (int i = 0; i < k; i ++) {
			temp += "0";
			int cur = Integer.parseInt(temp);
			sum += cur;
		}
		
		System.out.println(sum);
	}
}
