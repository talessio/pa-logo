package pa.logo.io;

import pa.logo.model.Line;
import pa.logo.model.Shape;

import java.awt.geom.Point2D;
import java.nio.file.Path;

/**
 * Reads given file.
 *
 * @param <P> a point.
 * @param <L> a line.
 * @param <S> a shape.
 */
public interface LogoReader<P extends Point2D, L extends Line<P>, S extends Shape<P, L>> {

    /**
     * Reads the input for the Logo program.
     *
     * @param path The path to the file to read.
     */
    void read(Path path);
}
