package pa.logo;

import java.io.FileReader;

/**
 * The main app.
 */
public class App {

    /**
     * Descript
     * @param args args
     * @throws Exception if file not found
     */
    public static void main(String[] args) throws Exception {
        // Passing the path to the file as a parameter
        FileReader fr = new FileReader("/Users/alessiotozzi/GitHub/pa-logo/app/src/main/java/pa/logo/logo_file.txt");

        // Declaring loop variable
        int i;
        // Holds true till there is nothing to read
        while ((i = fr.read()) != -1)

            // Print all the content of a file
            System.out.print((char) i);
    }
}
