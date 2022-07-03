package pa.logo.io;

import java.nio.file.Path;

public interface LogoReader {

    /**
     * Reads the input for the Logo program.
     *
     * @param path The path to the file to read.
     */
    void read(Path path);
}
