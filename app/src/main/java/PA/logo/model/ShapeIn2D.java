package pa.logo.model;

import java.awt.*;
import java.util.ArrayList;

public class ShapeIn2D implements Shape<CoordinateIn2D, StraightLineIn2D> {

    Color fillColor;

    /**
     * ArrayList of all lines in the shape. Can contain any number of connected lines.
     */
    ArrayList<StraightLineIn2D> lines = new ArrayList<>();

    public ShapeIn2D(ArrayList<StraightLineIn2D> linesInShape, Color color) {
        this.lines = linesInShape;
        this.fillColor = color;
    }

    public ShapeIn2D(ArrayList<StraightLineIn2D> linesInShape) {
        this.lines = linesInShape;
        this.fillColor = Color.white;
    }

    @Override
    public void addLine(StraightLineIn2D line) {

    }

    @Override
    public ArrayList<StraightLineIn2D> getShapeLines() {
        return null;
    }

    @Override
    public boolean contains(StraightLineIn2D line) {
        return false;
    }

    @Override
    public Color getShapeColor() {
        return null;
    }

    @Override
    public void setShapeColor(Color color) {

    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public void setClosed() {

    }
}
