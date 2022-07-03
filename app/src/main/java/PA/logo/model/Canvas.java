package PA.logo.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Defines the canvas on which one draws.
 */
public interface Canvas<N extends Number, C extends Coordinate, L extends Line<C>, S extends Shape<C, L>> {

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

    /**
     * Obtain the size of the area.
     *
     * @return the size of the area.
     */
    N getCanvasSize();

    /**
     * Set the size of the area. Must have at least height and base.
     */
    void setCanvasSize();

}
