package pa.logo.io;

import pa.logo.model.Shape;
import pa.logo.model.Line;
import pa.logo.model.Coordinate;
import pa.logo.model.Shape;

import java.nio.file.Path;
import java.util.ArrayList;

public interface LogoWriter<C extends Coordinate, L extends Line<C>, S extends Shape<C, L>> {

    /**
     * Writes down the output of a logo execution.
     *
     * @param path   The path to save the output.
     * @param shapes All the shapes to convert into the desired output.
     */
    void write(Path path, ArrayList<S> shapes);
}
