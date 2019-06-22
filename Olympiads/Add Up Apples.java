import java.io.*;

public class AddUpApples {
	public static int cn = 0;
	
	// Recursive function to print out all combinations that add up to a given number
	static void combinations(int[] arr, int index, int num, int reducedNum) {
		
		if (reducedNum < 0) return;
		
		if (reducedNum == 0 && arr[0] != num) {
			System.out.print(num + "=");
			for (int i = 0; i < index; i++) {
				if (i != index - 1) System.out.print(arr[i] + "+");
				else System.out.print(arr[i]);
			}
			System.out.println();
			cn ++;
			return;
		}
		else if (reducedNum == 0 && arr[0] == num) {
			System.out.println("total=" + cn);
		}

		int prev = (index == 0) ? 1 : arr[index - 1];
		
		for (int i = prev; i <= num; i ++) {
			arr[index] = i;
			combinations(arr, index + 1, num, reducedNum - i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if (n != 1) {
			int[] array = new int[n];
			combinations(array, 0, n, n);
		} else System.out.println("total=0");
	}
}
