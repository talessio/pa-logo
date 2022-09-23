package pa.logo.model;

/**
 * Represents the direction of the cursor. Can be moved clockwise or counterclockwise.
 *
 * @param <N> the value used to count degrees.
 */
public interface Direction<N extends Number> {

    /**
     * Turns the cursor by some degrees in a clockwise direction.
     *
     * @param currentDegrees     the degrees indicating where the cursor currently faces.
     * @param degreesToIncrement the degrees by which I want the cursor to turn clockwise.
     * @return the new direction of the cursor in degrees.
     */
    N clockwise(N currentDegrees, N degreesToIncrement);

    /**
     * Turns the cursor by some degrees in a counterclockwise direction.
     *
     * @param currentDegrees     the degrees indicating where the cursor currently faces.
     * @param degreesToDecrement the degrees by which I want the cursor to turn counterclockwise.
     * @return the new direction of the cursor in degrees.
     */
    N counterclockwise(N currentDegrees, N degreesToDecrement);
}
