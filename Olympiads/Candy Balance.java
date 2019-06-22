import java.io.*;

public class CandyBalance {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n]; 
		int total = 0, average, candiesMoved = 0;
		for (int i = 0; i < n; i ++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
		}
		
		average = total /= n;
		for (int i = 0; i < n; i ++) {
			candiesMoved += Math.abs(arr[i] - average);
		}
		System.out.println(candiesMoved / 2);
	}
}
