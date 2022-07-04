package pa.logo.model;

import java.awt.*;
import java.util.ArrayList;

public class ShapeIn2D implements Shape<CoordinateIn2D, StraightLineIn2D> {

    private Color fillColor;
    private CoordinateIn2D endOfShape1;
    private CoordinateIn2D endOfShape2;

    /**
     * ArrayList of all lines in the shape. Can contain any number of connected lines.
     */
    ArrayList<StraightLineIn2D> lines = new ArrayList<>();

    public ShapeIn2D(ArrayList<StraightLineIn2D> linesInShape, Color color) {
        if (linesAreSequential(linesInShape)) {
            this.lines = linesInShape;
            this.fillColor = color;
        } else {
            throw new IllegalArgumentException("Lines must be sequential for it to be a shape.");
        }
    }

    public ShapeIn2D(ArrayList<StraightLineIn2D> linesInShape) {
        if (linesAreSequential(linesInShape)) {
            this.lines = linesInShape;
            this.fillColor = Color.white;
        } else {
            throw new IllegalArgumentException("Lines must be sequential for it to be a shape.");
        }
    }

    //TODO: i should check that arraylist lines are sequential, yes, but i also need to check that a new line that is added has coordinates = to one of the two ends of the shape. do i need two methods for this or should i write only one method for both things?
    public boolean linesAreSequential(ArrayList<StraightLineIn2D> lines) {
        StraightLineIn2D previous = null;
        for (StraightLineIn2D line : lines) {
            if (previous != null) {
                if ((previous.getCoordinates().get(0) == line.getCoordinates().get(0)) || (previous.getCoordinates().get(1) == line.getCoordinates().get(1))) {
                    previous = line;
                    continue;
                } else {
                    return false;
                }
            }
        }
    }

    @Override
    public void addLine(StraightLineIn2D line) {

    }

    @Override
    public ArrayList<StraightLineIn2D> getShapeLines() {
        return null;
    }

    @Override
    public Color getShapeColor() {
        return this.fillColor;
    }

    @Override
    public void setShapeColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public void setClosed() {

    }
}
