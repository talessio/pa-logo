package PA.logo.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader implements LogoReader {
    Path path = Paths.get("../logofile.txt");
    InputStream inStream = Files.newInputStream(path);
    Reader in = new InputStreamReader(inStream, StandardCharsets.UTF_8);

    public FileReader() throws IOException {
    }

    @Override
    public void read(Path path) {

    }
}
