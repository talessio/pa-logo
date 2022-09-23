package pa.logo.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A file reader for logo.
 */
public class FileReader {
    Path path = Paths.get("../logo_file.txt");
    InputStream inStream = Files.newInputStream(path);
    Reader in = new InputStreamReader(inStream, StandardCharsets.UTF_8);

    /**
     * Reads a file
     *
     * @throws IOException if I/O operation fails
     */
    public FileReader() throws IOException {
    }
}
