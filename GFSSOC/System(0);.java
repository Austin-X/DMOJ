import java.io.*;
import java.util.*;

public class System0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		double[] coefficients = new double[n + 1];
		for (int i = 0; i < n + 1; i ++) coefficients[i] = Double.parseDouble(br.readLine());
		
		double a = coefficients[0];
		double b = coefficients[1];
		double ans = -b / a / n;
		System.out.format("%.6f %n", ans);
	}
}
