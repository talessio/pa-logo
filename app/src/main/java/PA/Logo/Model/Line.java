package PA.Logo.Model;

public interface Line {

    /**
     * Gets the line with the specified coordinates.
     *
     * @param c the coordinates.
     * @return the line.
     */
    Line getLine(Coordinates c);

    /**
     * The the line coordinates.
     *
     * @param l the line whose coordinates we need.
     * @return the coordinates.
     */
    Coordinates getCoordinates(Line l);

    /**
     * Checks if the line is contained in the given shape.
     *
     * @param s the shape.
     * @return true if it is contained in the shape, false otherwise.
     */
    boolean isContained(Shape s);
}
