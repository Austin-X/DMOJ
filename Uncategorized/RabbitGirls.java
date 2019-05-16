import java.io.*;

public class RabbitGirls {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		long k = Long.parseLong(br.readLine());
		
		System.out.println(n < k ? k - n : Math.min(n % k, k - n % k));
	}
}
