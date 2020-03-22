import java.io.*;

public class GreatGraffiti {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.contains("DMOJ")) System.out.println(0);
        else if (str.contains("DOJ") || str.contains("DMO") || str.contains("DMJ") || str.contains("MOJ")) System.out.println(1);
        else if (str.contains("DM") || str.contains("DO") || str.contains("DJ") || str.contains("MO") || str.contains("MJ") || str.contains("OJ")) System.out.println(2);
        else System.out.println(3);
    }
}
