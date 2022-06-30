package PA.Logo.Model;

import java.awt.*;
import java.util.ArrayList;

public interface Line {

    /**
     * Gets the line with the specified coordinates.
     *
     * @param start the start of the line.
     * @param end   the end of the line.
     * @return the line.
     */
    Line getLine(Coordinate start, Coordinate end);

    /**
     * Gets all lines that start from a certain point.
     *
     * @param start the start of the line.
     * @return an ArrayList of lines.
     */
    ArrayList<Line> getAllLinesFrom(Coordinate start);

    /**
     * Gets all lines that start, end or pass through a certain point.
     *
     * @param c the coordinate.
     * @return an ArrayList of lines.
     */
    ArrayList<Line> getAllLinesAt(Coordinate c);

    /**
     * The the line coordinates.
     *
     * @return the coordinates.
     */
    Coordinate getCoordinates();

    /**
     * Checks if the line is contained in the given shape.
     *
     * @param s the shape.
     * @return true if it is contained in the shape, false otherwise.
     */
    boolean isContained(Shape s);

    /**
     * Gets the color of the line.
     *
     * @return the color of the line.
     */
    Color getLineColor();
}
