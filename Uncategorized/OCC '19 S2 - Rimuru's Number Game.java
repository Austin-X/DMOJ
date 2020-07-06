import java.io.*;

public class RimurusNumberGame {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		long ans = 0;
		// The upper bound '524288' comes from the fact that 10,000,000,000,000,000,000 in binary is 524288 in decimal
		for (long i = 2; i <= 524288; i ++) {
			String binary = Long.toBinaryString(i);
			long temp = 0;
			for (int j = 1; j < binary.length(); j ++) {
				if (binary.charAt(j) == '1') temp += 3 * Math.pow(10, binary.length() - j - 1);
				else temp += 2 * Math.pow(10, binary.length() - j - 1);
			}
			if (temp > n) break;
			ans ++;
		}
		System.out.println(ans);
	}
}	
