import java.io.*;

public class UnevenSand {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = "";
		int low = 1, high = 2000000000;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			System.out.println(mid);
			System.out.flush();
			input = br.readLine();
			if (input.equals("SINKS")) {
				low = mid + 1;
			} else if (input.equals("FLOATS")) {
				high = mid - 1;
			} else {
				System.exit(0);
			}
		}
	}
}
