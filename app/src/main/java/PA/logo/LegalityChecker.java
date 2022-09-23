package pa.logo;

import pa.logo.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Checks legality of given input.
 */
public interface LegalityChecker<T> {

    /**
     * Checks that the given input is legal.
     *
     * @param t the input.
     * @return true if it's legal, false otherwise.
     */
    boolean isLegal(T t);

}
