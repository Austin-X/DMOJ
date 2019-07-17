import java.io.*;
import java.util.*;

public class Gates {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int g = Integer.parseInt(br.readLine());
		TreeSet<Integer> gates = new TreeSet<Integer>();
		for (int i = 1; i <= g; i ++) gates.add(i);
		
		int p = Integer.parseInt(br.readLine());
		int plane, cn = 0;
		
		for (int i = 0; i < p; i ++) {
			plane = Integer.parseInt(br.readLine());

			if (gates.contains(plane)) {
				cn ++;
				gates.remove(plane);
			} else if (gates.floor(plane) != null) {
				gates.remove(gates.floor(plane));
				cn ++;
			} else break;
		}	
		System.out.println(cn);
	}
}
