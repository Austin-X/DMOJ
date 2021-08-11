import java.io.*;
import java.util.*;

public class PostfixNotation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		String[] arr = readLine().split(" ");
		
		Stack<Double> operands = new Stack<Double>();
		for (int i = 0; i < arr.length; i ++) {
			if (Character.isDigit(arr[i].charAt(0))) operands.push(Double.valueOf(arr[i]));
			else {
				double x = operands.pop(), y = operands.pop();
				char c = arr[i].charAt(0);
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
