import java.io.*;

public class GreatGraffiti {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int best = 1;
        char[] ch = {'D', 'M', 'O', 'J'};
       
        int idx = -1, temp = 0, cur;
        for (int i = 0; i < str.length(); i ++) {
        	cur = idx;

            for (int j = 0; j < 4; j ++) {
            	if (ch[j] == str.charAt(i)) { idx = j; break; }
            }

            if (idx <= cur) { best = Math.max(best, temp); temp = 1; }
            else temp ++;
        }
        best = Math.max(best, temp);

        System.out.println(4 - best);
    }
}
