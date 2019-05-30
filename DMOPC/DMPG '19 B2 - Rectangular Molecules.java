import java.io.*;
import java.util.Arrays;

public class RectangularMolecules {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int highest = 0, check = 0, secondHighest = 0;
		String[] temp = br.readLine().split(" ");
		int[]  molecules = Arrays.asList(temp).stream().mapToInt(Integer::parseInt).toArray();
		for (int i = 0; i < molecules.length; i ++) {
			if (molecules[i] > highest) {
				highest = molecules[i]; check = i;
			}
		}
		for (int i = 0; i < molecules.length; i ++) {
			if (i != check && molecules[i] > secondHighest) secondHighest = molecules[i];
		}
		if (molecules[0] == highest && molecules[2] == secondHighest || molecules[1] == secondHighest && molecules[3] == highest
				|| molecules[0] == secondHighest && molecules[2] == highest || molecules[1] == highest && molecules[3] == secondHighest)
			System.out.println("trans");
		else System.out.println("cis");
	}
}
