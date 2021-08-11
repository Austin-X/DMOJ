import java.io.*;
import java.util.*;

public class PostfixNotation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		String[] op2 = {"*", "/", "+", "-", "%", "^"};
		ArrayList<String> op = new ArrayList<String>(Arrays.asList(op2));
		String[] arr = readLine().split(" ");
		
		Stack<Double> operands = new Stack<Double>();
		Stack<Character> operators = new Stack<Character>();
		for (int i = 0; i < arr.length; i ++) {
			if (op.contains(arr[i])) operators.push(arr[i].charAt(0));
			else operands.push(Double.valueOf(arr[i]));
			
			while (operands.size() >= 2 && !operators.isEmpty()) {
				double x = operands.pop(), y = operands.pop();
				char c = operators.pop();
				switch (c) {
				  case '*': operands.push(y * x); break;
				  case '/': operands.push(y / x); break;
				  case '+': operands.push(y + x); break;
				  case '-': operands.push(y - x); break;
				  case '%': operands.push(y % x); break;
				  case '^': operands.push(Math.pow(y, x)); break;
				}
			}
		}
		System.out.format("%.1f %n", operands.pop());
	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong() throws IOException {
		return Long.parseLong(next());
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter() throws IOException {
		return next().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
