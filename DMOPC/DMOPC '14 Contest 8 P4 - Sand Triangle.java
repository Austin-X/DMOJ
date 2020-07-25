import java.io.*;

public class SandTriangle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cn = 1, add = 2;
		while (true) {
			if (n > cn) {
				cn += add; add ++;
			} else {
				cn -= add - 2; break;
			}
		}
		add -= 2;
		long sum = 0;
		for (int i = cn; i <= cn + add; i ++) sum += i;
		System.out.println(sum);
	}
}
