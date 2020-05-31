import java.io.*;

public class TheOddNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int ans = 0;
		
		// This XOR method works because it is associative, so all the numbers that appear an even amount of time will cancel each other out
		for (int i = 0; i < n; i ++) {
			ans ^= Integer.parseInt(br.readLine());
		}
		System.out.println(ans);
	}
}
