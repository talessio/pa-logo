package pa.logo.io;

import pa.logo.model.LogoPointIn2D;
import pa.logo.model.ShapeIn2D;
import pa.logo.model.StraightLineIn2D;

import java.nio.file.Path;
import java.util.LinkedHashSet;

/**
 * A file writer for logo.
 */
public class FileWriter implements LogoWriter<LogoPointIn2D, StraightLineIn2D, ShapeIn2D> {

    @Override
    public void write(Path path, LinkedHashSet<ShapeIn2D> shapes) {

    }
}
