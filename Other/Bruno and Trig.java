import java.io.*;
import java.util.Arrays;

public class BrunoAndTrig {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[3];
		arr[0] = Integer.parseInt(br.readLine());
		arr[1] = Integer.parseInt(br.readLine());
		arr[2] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		if (arr[0] + arr[1] > arr[2]) System.out.println("Huh? A triangle?");
		else System.out.println("Maybe I should go out to sea...");
	}
}
