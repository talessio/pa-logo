package pa.logo.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Defines the canvas on which one draws.
 *
 * @param <P> the point containing the coordinates of the line.
 * @param <L> the line.
 * @param <S> the shape.
 */
public interface Canvas<P extends Point2D, L extends Line<P>, S extends Shape<P, L>> {

    /**
     * Gets all the shapes in the canvas.
     *
     * @return a Set with all the shapes.
     */
    ArrayList<S> getAllShapesInCanvas();

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
     * Add a new shape to the canvas.
     *
     * @param shape the shape to add.
     */
    void addShapeToCanvas(S shape);

    /**
     * Remove a shape from the canvas.
     *
     * @param shape the shape to remove.
     */
    void removeShapeFromCanvas(S shape);
}
