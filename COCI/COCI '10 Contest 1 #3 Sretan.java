import java.io.*;

public class Sretan {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		int[] powers = new int[30], psa = new int[30];
		int sum = 0, len = -1;
		for (int i = 1; i < 30; i ++) {
			powers[i] = (int) Math.pow(2, i);
			sum += powers[i];
			
			if (i == 1) psa[i] = 2;
			else psa[i] = psa[i - 1] + powers[i];
			
			if (len == -1 && sum >= k) {
				len = i; break;
			}
		}
		
		for (int i = len; i >= 1; i --) {
			if (i == 1) {
				System.out.print(k == 1 ? 4 : 7);
			}
			else {
				if (k > psa[i - 1] + powers[i - 1]) {
					System.out.print(7); k -= powers[i];
				} else {
					System.out.print(4); k -= powers[i - 1];
				}
			}
		}
	}
}
