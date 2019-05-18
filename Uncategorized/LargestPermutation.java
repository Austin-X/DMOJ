import java.util.Scanner;

public class LargestPermutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int max, count = 0;
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		while (k > 0 && count < arr.length - 1) {
			max = count;
			for (int i = count; i < arr.length - 1; i ++) {
				if (arr[i + 1] > arr[max]) max = (i + 1);
			}
			
			if (arr[count] != arr[max]) {
				int temp = arr[max];
				arr[max] = arr[count];
				arr[count] = temp;
				k--;
				count ++; 
			}
			else {
				count ++;
			}
		
		}
		
		for (int x : arr) System.out.print(x + " ");
	}
}
