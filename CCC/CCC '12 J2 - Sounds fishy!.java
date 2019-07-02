import java.io.*;

public class SoundsFishy {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[4];
		int[] diff = new int[3];
		for (int i = 0; i < 4; i ++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (i > 0) diff[i - 1] = arr[i] - arr[i - 1];
		}
		
		boolean rising = false, diving = false, constant = false;
		if (diff[0] > 0) rising = true;
		else if (diff[0] < 0) diving = true;
		else constant = true;
		
		for (int i = 1; i < 3; i ++) {
			if (rising && diff[i] <= 0) {
				rising = false; break;
			} else if (diving && diff[i] >= 0) {
				diving = false; break;
			} else if (constant && diff[i] != 0) {
				constant = false; break;
			}
		}
		
		if (rising) System.out.println("Fish Rising");
		else if (diving) System.out.println("Fish Diving");
		else if (constant) System.out.println("Fish At Constant Depth");
		else System.out.println("No Fish");
	}
}
