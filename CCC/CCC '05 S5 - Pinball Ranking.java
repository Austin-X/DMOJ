import java.io.*;

public class PinballRanking {
	static class Node {
		int score, rank;
		Node(int score, int rank) { this.score = score; this.rank = rank; }	
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		long total = 0;
		
		Node[] arr = new Node[T];
		for (int t = 0; t < T; t ++) {
			int score = Integer.parseInt(br.readLine());
			arr[t] = new Node(score, 1);
		}	
		mergeSort(arr, 0, T - 1);
		for (Node x : arr) total += x.rank;

		double ans = total / (double)T;
		double decimal = Double.valueOf(String.format("%.2f", ans * 100 - (int)(ans * 100)));
		if (decimal == 0.5 && (int)((ans * 10 - (int)(ans * 10)) * 10) % 2 == 0) ans -= 0.001;
		System.out.format("%.2f %n", ans);
	}
	
	static void mergeSort(Node[] arr, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, high);
		} 
	}
	
	static void merge(Node[] arr, int low, int high) {
		int mid = (low + high) / 2;
		int subarray1Size = mid - low + 1, subarray2Size = high - mid;
		
		Node[] subarray1 = new Node[subarray1Size], subarray2 = new Node[subarray2Size];
		for (int i = 0; i < subarray1Size; i ++) subarray1[i] = arr[low + i];
		for (int i = 0; i < subarray2Size; i ++) subarray2[i] = arr[mid + i + 1];
		
		int i = 0, j = 0;
		int idx = low;
		
		while (i < subarray1Size && j < subarray2Size) {
			if (subarray1[i].score <= subarray2[j].score) {
				arr[idx] = subarray1[i];
				i ++; idx ++;
			} else {
				arr[idx] = subarray2[j];
				arr[idx].rank = mid + 1 + j + 1 - low - (idx - low) + (subarray2[j].rank - 1);
				j ++; idx ++;
			}
		}
		
		while (i < subarray1Size) {
			arr[idx] = subarray1[i];
			i ++; idx ++;
		}
		while (j < subarray2Size) {
			arr[idx] = subarray2[j];
			arr[idx].rank = mid + 1 + j + 1 - low - (idx - low) + (subarray2[j].rank - 1);
			j ++; idx ++;
		}
	}
}
