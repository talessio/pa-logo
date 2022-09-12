package pa.logo.model;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Defines the cursor.
 *
 * @param <T> the value that makes up the canvas.
 * @param <K> the value that makes up the angle.
 * @param <P> the points containing the coordinates of the lines. can be 2D, 3D or more.
 * @param <L> the lines.
 * @param <S> the shapes.
 * @param <X> the canvas.
 */
public interface Cursor<T extends Number, K extends Number, P extends Point2D, L extends Line<P>, S extends Shape<P, L>, X extends Canvas<P, L, S>> {

    /**
     * Moves the cursor forwards in the direction it faces.
     *
     * @param distance how far the cursor is to move.
     */
    void forward(T distance);

    /**
     * Moves the cursor backwards to the direction it faces.
     *
     * @param distance how far the cursor is to move.
     */
    void backward(T distance);

    /**
     * Rotates the cursor counterclockwise.
     *
     * @param angle the degrees by which the cursor should rotate counterclockwise.
     */
    void left(K angle);

    /**
     * Rotates the cursor clockwise.
     *
     * @param angle the degrees by which the cursor should rotate clockwise.
     */
    void right(K angle);

    /**
     * Clears the canvas.
     */
    void clearScreen();

    /**
     * Moves the cursor to the home.
     */
    void home();

    /**
     * Lifts the pen from the canvas.
     */
    void penUp();

    /**
     * Puts the pen down on the canvas.
     */
    void penDown();

    /**
     * Sets the pen color.
     *
     * @param color the chosen color in RGB.
     */
    void setPenColor(Color color);

    /**
     * Sets the fill color of a closed shape.
     *
     * @param color the chosen color in RGB.
     */
    void setFillColor(Color color, S shape);

    /**
     * Sets the screen color.
     *
     * @param color the chosen color in RGB.
     */
    void setScreenColor(Color color, X canvas);

    /**
     * Sets the pen size.
     *
     * @param size the chosen pen size in integer number.
     */
    void setPenSize(int size);

    /**
     * Repeats a sequence of commands a specific number of times.
     *
     * @param numberOfTimes how many times to repeat the sequence of commands.
     */
    void repeat(int numberOfTimes);
}
