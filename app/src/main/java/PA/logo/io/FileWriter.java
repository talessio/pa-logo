package pa.logo.io;

import pa.logo.model.CoordinateIn2D;
import pa.logo.model.ShapeIn2D;
import pa.logo.model.StraightLineIn2D;

import java.nio.file.Path;
import java.util.ArrayList;

public class FileWriter implements LogoWriter<CoordinateIn2D, StraightLineIn2D, ShapeIn2D> {
    @Override
    public void write(Path path, ArrayList<ShapeIn2D> shapes) {

    }
}
