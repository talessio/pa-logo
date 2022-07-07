package pa.logo.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Defines the canvas on which one draws.
 */
public interface Canvas<C extends Coordinate, L extends Line<C>, S extends Shape<C, L>> {

    /**
     * Gets all the shapes in the canvas.
     *
     * @return an ArrayList with all the shapes.
     */
    ArrayList<S> getAllShapesInCanvas();

    /**
     * Returns the coordinates for the home.
     */
    C getHome();

    /**
     * Get the color of the area.
     *
     * @return the color in RGB.
     */
    Color getCanvasColor();

    /**
     * Set the color of the area.
     *
     * @param color the chosen color in RGB.
     */
    void setCanvasColor(Color color);

    void addShapeToCanvas(S shape);

    void removeShapeFromCanvas(S shape);
}
