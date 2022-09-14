package pa.logo.io;

import pa.logo.model.Shape;
import pa.logo.model.Line;

import java.awt.geom.Point2D;
import java.nio.file.Path;
import java.util.LinkedHashSet;

public interface LogoWriter<P extends Point2D, L extends Line<P>, S extends Shape<P, L>> {

    /**
     * Writes down the output of a logo execution.
     *
     * @param path   The path to save the output.
     * @param shapes All the shapes to convert into the desired output.
     */
    void write(Path path, LinkedHashSet<S> shapes);
}
