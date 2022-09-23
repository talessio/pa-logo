package pa.logo;

import pa.logo.model.StraightLineIn2D;

/**
 * Checks legality of line.
 */
public class LineChecker implements LegalityChecker<StraightLineIn2D> {

    /**
     * Checks that the line doesn't violate any rules.
     *
     * @param line the line.
     */
    @Override
    public boolean isLegal(StraightLineIn2D line) {
        if (line == null) throw new NullPointerException("Line cannot be null.");
        else return true;
    }
}
