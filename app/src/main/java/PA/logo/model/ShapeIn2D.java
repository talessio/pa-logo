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

    private Color fillColor = Color.white;
    private boolean closed = false;

    /**
     * ArrayList of all lines in the shape. Can contain any number of connected lines.
     */
    private ArrayList<StraightLineIn2D> lines = new ArrayList<>();
    private boolean needToClose = false;

    public ShapeIn2D(ArrayList<StraightLineIn2D> linesInShape, Color color) {
        LegalityChecker checker = new LegalityChecker();
        for (StraightLineIn2D line : linesInShape) {
            checker.lineIsLegal(line, this);
        }
        if (needToClose) {
            this.lines = linesInShape;
            this.fillColor = color;
            this.closed = true;
        } else {
            this.lines = linesInShape;
            this.fillColor = color;
        }
    }

    public ShapeIn2D(ArrayList<StraightLineIn2D> linesInShape) {
        LegalityChecker checker = new LegalityChecker();
        for (StraightLineIn2D line : linesInShape) {
            checker.lineIsLegal(line, this);
        }
        if (needToClose) {
            this.lines = linesInShape;
            this.closed = true;
        } else {
            this.lines = linesInShape;
        }
    }

    @Override
    public void addLineToShape(StraightLineIn2D line) {
        ArrayList<StraightLineIn2D> lineToAdd = new ArrayList<>();
        lineToAdd.add(line);
        addLinesToShape(lineToAdd);
    }

    @Override
    public void addLinesToShape(ArrayList<StraightLineIn2D> linesToAdd) {
        LegalityChecker checker = new LegalityChecker();
        checker.shapeIsLegal(this);
        for (StraightLineIn2D line : linesToAdd) {
            checker.lineIsLegal(line, this);
        }
        this.lines.addAll(linesToAdd);
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
    public void setShapeColor(Color color) {
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
