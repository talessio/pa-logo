package pa.logo.model;

import pa.logo.LegalityChecker;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * A shape in two dimensions. Can have a fill color, if none is given it's automatically white.
 * Can be open or closed.
 */
public class ShapeIn2D implements Shape<CoordinateIn2D, StraightLineIn2D> {

    private Color fillColor;
    private boolean closed = false;

    /**
     * ArrayList of all lines in the shape. Can contain any number of connected lines.
     */
    private ArrayList<StraightLineIn2D> lines = new ArrayList<>();


    public ShapeIn2D(ArrayList<StraightLineIn2D> linesInShape, Color color) {
        this.addLinesToShape(linesInShape);
        if (this.closed) {
            this.fillColor = color;
        } else {
            throw new IllegalArgumentException("Open shapes cannot have fill color.");
        }
    }

    public ShapeIn2D(ArrayList<StraightLineIn2D> linesInShape) {
        this.addLinesToShape(linesInShape);
    }

    @Override
    public void addLineToShape(StraightLineIn2D line) {
        ArrayList<StraightLineIn2D> lineToAdd = new ArrayList<>();
        lineToAdd.add(line);
        addLinesToShape(lineToAdd);
    }

    @Override
    public void addLinesToShape(ArrayList<StraightLineIn2D> linesToAdd) throws IllegalArgumentException {
        LegalityChecker checker = new LegalityChecker();
        ArrayList<StraightLineIn2D> allLines = new ArrayList<>();
        for (StraightLineIn2D line : linesToAdd) {
            checker.lineIsLegal(line, this);
            allLines.add(line);
        }
        //putting new lines and old lines together in a mock shape to test
        if (!this.lines.isEmpty()) {
            allLines.addAll(this.lines);
        }
        //check that lines old lines and new lines don't conflict with each other
        if (checker.shapeIsLegal(allLines)) {
            //if passed, i add new lines to the actual shape
            this.lines.addAll(linesToAdd);
        } else {
            throw new IllegalArgumentException("Cannot add lines to the shape.");
        }
        if (checker.needsToClose(allLines)) {
            this.closed = true;
        }
    }

    @Override
    public ArrayList<StraightLineIn2D> getShapeLines() {
        return this.lines;
    }

    @Override
    public Color getShapeColor() {
        return this.fillColor;
    }

    @Override
    public void setShapeColor(Color color) throws NullPointerException {
        if (color == null) throw new NullPointerException();
        this.fillColor = color;
    }

    @Override
    public boolean isClosed() {
        return this.closed;
    }

    @Override
    public void setClosed() {
        this.closed = true;
    }

}
