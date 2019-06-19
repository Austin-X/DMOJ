import java.io.*;

public class Goon {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] n = br.readLine().split("-");
		int sum1 = 0, sum2 = 0, sum3 = 0;
		
		for (int i = 0; i < 3; i ++) sum1 += Character.getNumericValue((n[0].charAt(i)));
		for (int i = 0; i < 3; i ++) sum2 += Character.getNumericValue((n[1].charAt(i)));
		for (int i = 0; i < 4; i ++) sum3 += Character.getNumericValue((n[2].charAt(i)));
		
		if (sum1 == sum2 && sum2 == sum3) System.out.println("Goony!");
		else System.out.println("Pick up the phone!");
	}
}
