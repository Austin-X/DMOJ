import java.io.*;
import java.util.*;

public class DynamicDictionaryCoding {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < n; t ++) {
			
			ArrayList<String> lines = new ArrayList<String>();
			String line;
			while (true) {
				line = br.readLine();
				if (line.equals("")) break;
				lines.add(line);
			}
			
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int cn = 1;
			
			for (int i = 0; i < lines.size(); i ++) {
				String[] temp = lines.get(i).split(" ");
				for (int j = 0; j < temp.length; j ++) {
					if (map.containsKey(temp[j])) System.out.print(map.get(temp[j]) + " ");
					else {
						System.out.print(temp[j] + " ");
						map.put(temp[j], cn);
						cn ++;
					}
				}
				System.out.println();
			}
		}
	}
}
