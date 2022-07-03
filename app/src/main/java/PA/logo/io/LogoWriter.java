package pa.logo.io;

import PA.logo.model.Shape;

import java.nio.file.Path;
import java.util.ArrayList;

public interface LogoWriter {

    /**
     * Writes down the output of a logo execution.
     *
     * @param path   The path to save the output.
     * @param shapes All the shapes to convert into the desired output.
     */
    void write(Path path, ArrayList<Shape> shapes);
}
