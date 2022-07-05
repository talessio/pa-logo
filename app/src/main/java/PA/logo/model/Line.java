package pa.logo.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * A line. Can be any length, shape or color.
 *
 * @param <C> the coordinate(s) of the shape.
 */
public interface Line<C extends Coordinate> {

    /**
     * Gets the coordinates of the line.
     *
     * @return an ArrayList with the coordinates.
     */
    ArrayList<C> getCoordinates();

    /**
     * Gets the color of the line.
     *
     * @return the color of the line.
     */
    Color getLineColor();

//    /**
//     * Gets the line with the specified coordinates.
//     *
//     * @param start the start of the line.
//     * @param end   the end of the line.
//     * @return the line.
//     */
//    L getLine(C start, C end);
//
//    /**
//     * Gets all lines that start from a certain point.
//     *
//     * @param start the start of the line.
//     * @return an ArrayList of lines.
//     */
//    ArrayList<L> getAllLinesFrom(C start);
//
//    /**
//     * Gets all lines that start, end or pass through a certain point.
//     *
//     * @param coordinate the coordinate.
//     * @return an ArrayList of lines.
//     */
//    ArrayList<L> getAllLinesAt(C coordinate);
}
