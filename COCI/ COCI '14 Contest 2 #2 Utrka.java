import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Utrka {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> names = new HashMap<String, Integer>();
		
		for (int i = 0; i < n; i ++) {
			String st = br.readLine();
			if (!names.containsKey(st)) {
				names.put(st, 1);
			}
			else names.put(st, names.get(st) + 1);
		}
		
		for (int i = 0; i < n - 1; i ++) {
			String word = br.readLine();
			if (names.containsKey(word)) names.put(word, names.get(word) - 1);
		}

		for (String x : names.keySet()) {
            if (names.get(x) > 0) {
                System.out.println(x);
                System.exit(0);
            }
        }
	}
}
