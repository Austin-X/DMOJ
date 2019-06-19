import java.io.*;

public class MaximumProduct {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] numbs = new int[n];
		int negativesCn = 0, maxProduct = 1;
		boolean onlyZeros = false;
		
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			numbs[i] = x;
			if (x < 0) negativesCn ++;
		}
		
		if (n == 1 && numbs[0] < 0) {
			System.out.println(numbs[0]); System.exit(0);
		}
		
		if (negativesCn % 2 == 1) {
			int highestNegative = -Integer.MAX_VALUE, index = 0;
			for (int i = 0; i < n; i ++) {
				if (numbs[i] > highestNegative && numbs[i] < 0) {
					highestNegative = numbs[i]; index = i;
				}
			}
			numbs[index] = 0;
		} 
		
		negativesCn = 0;
		for (int i = 0; i < n; i ++) {
			if (numbs[i] == 0) onlyZeros = true;
			else if (numbs[i] < 0 && negativesCn < 1) {
				negativesCn ++;
				onlyZeros = true;
			}
			else {
				onlyZeros = false; break;
			}
		}
		
		if (onlyZeros) maxProduct = 0;
		
		for (int i = 0; i < n; i ++) {
			if (numbs[i] != 0) {
				maxProduct *= numbs[i];
			} 
		}
		System.out.println(maxProduct);
	}
}
