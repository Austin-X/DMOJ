import java.io.*;

public class HailstoneNumbers {
	static int cn = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		recurse(n);
		System.out.println(cn);
	}
	
	static void recurse(int n) {
		if (n == 1) return;
		else if (n % 2 == 1) n = n * 3 + 1;
		else n /= 2;
		cn ++;
		recurse(n);
	}
}
