import java.io.*;
import java.util.*;

public class FromPrefixToPostfix {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		while (true) {
			str = br.readLine().replaceAll(" ", "");
			if (str.equals("0")) break;
			
			int len = str.length();
			Stack<String> ans = new Stack<String>();
			for (int i = len - 1; i >= 0; i --) {
				if (str.charAt(i) == '+' || str.charAt(i) == '-') {
					String op1 = ans.pop();
					String op2 = ans.pop();
					String temp = op1 + op2 + str.charAt(i);
					ans.push(temp + " ");
				} else {
					ans.push(Character.toString(str.charAt(i)) + " ");
				}
			}
			System.out.println(ans.peek());
		}
	}
}
