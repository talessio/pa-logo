package pa.logo.model;

import java.awt.*;

/**
 * Defines the cursor.
 */
public interface Cursor<T extends Number, K extends Number> {

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
    void setFillColor(Color color);

    /**
     * Sets the screen color.
     *
     * @param color the chosen color in RGB.
     */
    void setScreenColor(Color color);

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
    void repeat(int numberOfTimes); //TODO: implement properly
}
