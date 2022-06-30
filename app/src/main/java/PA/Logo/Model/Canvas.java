package PA.Logo.Model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Defines the canvas on which one draws.
 */
public interface Canvas<T extends Number> {

    /**
     * Array List of all the shapes that are on the canvas.
     * Shapes can be of any type: single lines, a concatenation of lines, straight or curved lines, coloured or not, closed or not.
     */
    ArrayList<Shape> allShapesInCanvas = new ArrayList<>();

    /**
     * Returns the coordinates for the home.
     */
    Coordinate getHome();

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
    T getCanvasSize();

    /**
     * Set the size of the area. Must have at least height and base.
     */
    void setCanvasSize();

}
