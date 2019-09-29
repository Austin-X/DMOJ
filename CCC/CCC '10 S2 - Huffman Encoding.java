import java.io.*;
import java.util.HashMap;

public class HuffmanEncoding {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap <String, String> code = new HashMap<String, String>();
		int k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < k; i ++) {
			String[] words = br.readLine().split(" ");
			code.put(words[0], words[1]);
		}
		String newWord = "";
		String word = br.readLine();
		for (char c :word.toCharArray()) {
			newWord += c;
			for (String x : code.keySet()) {
	            if (code.get(x).equals(newWord)) {
	                System.out.print(x);
	                newWord = "";
	            }
	        }
		}
	}
}
