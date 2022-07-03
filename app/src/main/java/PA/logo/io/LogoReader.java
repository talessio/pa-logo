package pa.logo.io;

import pa.logo.model.Coordinate;
import pa.logo.model.Line;
import pa.logo.model.Shape;

import java.nio.file.Path;

public interface LogoReader<C extends Coordinate, L extends Line<C>, S extends Shape<C, L>> {

    /**
     * Reads the input for the Logo program.
     *
     * @param path The path to the file to read.
     */
    void read(Path path);
}
