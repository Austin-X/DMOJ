import java.io.*;
import java.util.*;

public class VoronoiVillages {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		double[] villages = new double[n];
		for (int i = 0; i < n; i ++) villages[i] = Integer.parseInt(br.readLine());
		Arrays.sort(villages);
		
		double min = Integer.MAX_VALUE;
		for (int i = 1; i < n - 1; i ++) {
			min = Math.min(min, ((villages[i] - villages[i - 1]) / 2) + ((villages[i + 1] - villages[i]) / 2));
		}
		System.out.format("%.1f %n", min);
	}
}
