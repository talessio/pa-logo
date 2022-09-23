package pa.logo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class App {

    public static void main(String[] args) {
        try {
            File in = new File("app/src/main/java/pa/logo/files/input.txt");
            File out = new File("app/src/main/java/pa/logo/files/output.txt");
            FileReader fr = new FileReader(in);
            FileWriter fw = new FileWriter(out);

            int i;
            while ((i = fr.read()) != -1) {
                fw.write(i);
            }
            fr.close();
            fw.close();
        } catch (Exception e) {
            return;
        }
    }
}