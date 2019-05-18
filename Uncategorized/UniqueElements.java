import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class UniqueElements {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> list = new HashSet<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i ++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		System.out.println(list.size());
	}
}
