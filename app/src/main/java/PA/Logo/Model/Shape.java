package PA.Logo.Model;

import java.awt.*;
import java.util.ArrayList;

public interface Shape {
    /**
     * ArrayList of all lines in the shape. Can contain any number of connected lines.
     */
    ArrayList<Line> lines = new ArrayList<Line>();

    /**
     * Get the shape that contains a specific line.
     *
     * @param l the line included in the shape.
     * @return the shape.
     */
    Shape getShape(Line l); //TODO is this the right parameter?

    /**
     * Get the color of the shape.
     *
     * @param s the shape whose color is needed.
     */
    void getShapeColor(Shape s);

    /**
     * Set the color of the shape.
     *
     * @param c the color.
     */
    void setShapeColor(Color c);

    /**
     * Add a line to the shape.
     *
     * @param l the line to be added.
     */
    void addLine(Line l);

    /**
     * Get the lines contained in the shape.
     */
    void getShapeLines();

    /**
     * Checks if the shape is closed or not.
     *
     * @return true if the shape is closed, false otherwise.
     */
    boolean isClosed();

    /**
     * Sets shape as closed, such that it cannot join other shapes.
     */
    void setClosed();

    /**
     * Checks if the shape contains a specific line.
     *
     * @param l the line.
     * @return true if the line is contained inside the shape, false otherwise.
     */
    boolean contains(Line l);
}
