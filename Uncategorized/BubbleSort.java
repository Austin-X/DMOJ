import java.util.Scanner;

public class BubbleSort {
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void bubbleSort(int[] nums) {
		for (int x : nums) System.out.print(x + " "); 
		System.out.println();
		
		for (int k = 0; k < nums.length - 1; k ++) {
			for (int i = 0; i < nums.length - 1 - k; i ++) {
				if (nums[i] > nums[i + 1]) {
					swap(nums, i, i + 1);
					for (int x : nums) System.out.print(x + " ");
					System.out.println();
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n =  sc.nextInt();
		int[] nums = new int[n];
		
		for (int i = 0; i < n; i ++) {
			nums[i] = sc.nextInt();
		}
		
		bubbleSort(nums);
		sc.close();
	}
}
