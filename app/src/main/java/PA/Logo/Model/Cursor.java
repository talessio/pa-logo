package PA.Logo.Model;

import java.awt.*;

public interface Cursor {

    /**
     * Moves the cursor forwards in the direction it faces.
     *
     * @param distance how far the cursor is to move.
     */
    void forwards(double distance);

    /**
     * Moves the cursor backwards to the direction it faces.
     *
     * @param distance how far the cursor is to move.
     */
    void backwards(double distance);

    /**
     * Rotates the cursor counterclockwise.
     *
     * @param angle the degrees by which the cursor should rotate counterclockwise.
     */
    void left(double angle);

    /**
     * Rotates the cursor clockwise.
     *
     * @param angle the degrees by which the cursor should rotate clockwise.
     */
    void right(double angle);

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
    void penup();

    /**
     *
     */
    void pendown();

    void setPenColor(Color color);

    void setFillColor(Color color);

    void setScreenColor(Color color);

    void setPenSize(int size);

    void repeat(int numberOfTimes,); //TODO: implement properly
}
