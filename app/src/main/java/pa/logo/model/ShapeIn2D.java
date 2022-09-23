package pa.logo.model;

import pa.logo.LineChecker;
import pa.logo.ShapeChecker;

import java.awt.*;
import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * A shape in two dimensions. Can have a fill color, if none is given it's automatically white.
 * Can be open or closed.
 */
public class ShapeIn2D implements Shape<LogoPointIn2D, StraightLineIn2D> {

    private Color fillColor;
    private boolean closed = false;
    private CanvasIn2D canvas;

    /**
     * ArrayList of all lines in the shape. Can contain any number of connected lines.
     */
    private LinkedHashSet<StraightLineIn2D> lines = new LinkedHashSet<>();

    /**
     * A shape in 2D.
     *
     * @param l the lines to add to the shape. Must contain at least one line.
     * @param c the canvas where the shape is located.
     */
    public ShapeIn2D(LinkedHashSet<StraightLineIn2D> l, CanvasIn2D c) {
        this.addLinesToShape(l);
        this.canvas = c;
        c.addShapeToCanvas(this);
    }

    @Override
    public void addLinesToShape(LinkedHashSet<StraightLineIn2D> linesToAdd) throws IllegalArgumentException {
        if (this.isClosed()) throw new IllegalArgumentException("Shape is closed to new lines.");
        LinkedHashSet<StraightLineIn2D> allLines = new LinkedHashSet<>();
        for (StraightLineIn2D l : linesToAdd) {
            if (l == null) throw new NullPointerException("Line cannot be null.");
            allLines.add(l);
        }
        //putting new lines and old lines together in a mock shape to test
        if (!this.lines.isEmpty()) {
            allLines.addAll(this.lines);
        }
        //check that old lines and new lines don't conflict with each other
        ShapeChecker sCh = new ShapeChecker();
        if (sCh.isLegal(allLines)) {
            //if passed, I add new lines to the actual shape
            this.lines.addAll(linesToAdd);
            if (sCh.getNeedsToClose()) {
                this.setClosed();
            }
        } else {
            throw new IllegalArgumentException("Cannot add lines to the shape.");
        }
    }

    @Override
    public LinkedHashSet<StraightLineIn2D> getShapeLines() {
        return this.lines;
    }

    @Override
    public Color getShapeColor() {
        return this.fillColor;
    }

    @Override
    public void setShapeColor(Color color) throws NullPointerException {
        if (color == null) throw new NullPointerException();
        if (!isClosed()) {
            throw new IllegalArgumentException();
        } else this.fillColor = color;
    }

    @Override
    public boolean isClosed() {
        return this.closed;
    }

    @Override
    public void setClosed() {
        this.closed = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShapeIn2D shapeIn2D = (ShapeIn2D) o;
        return closed == shapeIn2D.closed && Objects.equals(fillColor, shapeIn2D.fillColor) && canvas.equals(shapeIn2D.canvas) && lines.equals(shapeIn2D.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fillColor, closed, canvas, lines);
    }

    @Override
    public String toString() {
        return "ShapeIn2D{" + "fillColor=" + fillColor + ", closed=" + closed + ", canvas=" + canvas + ", lines=" + lines + '}' + "\n";
    }
}
