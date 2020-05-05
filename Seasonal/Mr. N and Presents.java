import java.io.*;
import java.util.*;

public class MrNAndPresents {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int q = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for (int i = 0; i < q; i ++) {
			st = new StringTokenizer(br.readLine());
			char choice = st.nextToken().charAt(0);
			int x = Integer.parseInt(st.nextToken());
			
			if (choice == 'F') arr.add(0, x);
			else if (choice == 'E') arr.add(x);
			else arr.remove(arr.indexOf(x));
		}
		for (int num : arr) System.out.println(num);
	}
}
