package pa.logo;

/**
 * Checks legality of given input.
 */
public interface LegalityChecker<T> {

    /**
     * Checks that the given input is legal.
     *
     * @param t the input, which can be a coordinate, a line or a shape.
     * @return true if it's legal, false otherwise.
     */
    boolean isLegal(T t);
}
