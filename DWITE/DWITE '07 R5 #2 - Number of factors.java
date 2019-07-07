import java.io.*;

public class NumberOfFactors {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 5; t ++) {
			int n = Integer.parseInt(br.readLine());
			int size = n;
			
			int cn = 0;
			for (int i = 2; i < size; i ++) {
				while (n % i == 0) {
					n /= i;
					cn ++;
				}
			}
			System.out.println(cn);
		}
	}
}
