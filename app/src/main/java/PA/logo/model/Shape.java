package PA.logo.model;

import java.awt.*;
import java.util.ArrayList;

public interface Shape<C extends Coordinate, L extends Line<C>> {

    /**
     * Add a line to the shape.
     *
     * @param line the line to be added.
     */
    void addLine(L line);

    /**
     * Get the lines contained in the shape.
     */
    ArrayList<L> getShapeLines();

    /**
     * Checks if the shape contains a specific line.
     *
     * @param line the line.
     * @return true if the line is contained inside the shape, false otherwise.
     */
    boolean contains(L line);

    /**
     * Get the color of the shape.
     */
    Color getShapeColor();

    /**
     * Set the color of the shape.
     *
     * @param color the chosen color in RGB.
     */
    void setShapeColor(Color color);

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
}
