import java.io.*;

public class SumacSequences {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t1 = Integer.parseInt(br.readLine());
		int t2 = Integer.parseInt(br.readLine());
		int cn = 2;
		int diff = t1 - t2;
		
		while (diff >= 0) {
			cn ++;
			int temp = diff;
			diff = t2 - diff;
			t2 = temp;
		}
		
		System.out.println(cn);
	}
}
