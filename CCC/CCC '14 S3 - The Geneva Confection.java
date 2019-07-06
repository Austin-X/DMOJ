import java.io.*;
import java.util.*;

public class TheGenevaConfection {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t ++) {
			int n = Integer.parseInt(br.readLine());
			
			Stack<Integer> ingredients = new Stack<Integer>();
			Stack<Integer> branch = new Stack<Integer>();
			int cur = 1;
			boolean yum = true;
			
			for (int i = 0; i < n; i ++) {
				ingredients.push(Integer.parseInt(br.readLine()));
			}
			
			while (yum && cur != n) {			
				if (!branch.empty() && branch.peek() == cur) {
					branch.pop(); cur ++;
				} else if (!ingredients.empty() && ingredients.peek() == cur) {
					ingredients.pop();
					cur ++;
				} else if (!ingredients.empty()){
					branch.push(ingredients.pop());
				} else {
					yum = false;
				}
			}
			
			System.out.println(yum ? "Y" : "N");
		}
	}
}
