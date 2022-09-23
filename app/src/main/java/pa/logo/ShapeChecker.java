package pa.logo;

import pa.logo.model.LogoPointIn2D;
import pa.logo.model.StraightLineIn2D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Checks legality of shape.
 */
public class ShapeChecker implements LegalityChecker<LinkedHashSet<StraightLineIn2D>> {

    private boolean needsToClose;

    /**
     * Checks that the shape doesn't violate any rules.
     *
     * @param lines the lines from the shape.
     * @return true if the shape is legal, false otherwise.
     */
    @Override
    public boolean isLegal(LinkedHashSet<StraightLineIn2D> lines) {
        return hasLegalNumberOfEnds(lines);
    }

    /**
     * Checks that the shape has either 2 or 0 ends.
     * If it has 1 or more than 2, then the shape is either open only on one end, or open on more than 2 ends.
     * If it has 0 ends, the shape is closed.
     * If it has 2 ends, the shape is open.
     *
     * @param lines the lines from the shape.
     * @return true if the shape has a legal number of ends, false otherwise.
     */
    private boolean hasLegalNumberOfEnds(LinkedHashSet<StraightLineIn2D> lines) {
        //get all the points from all the lines inside the shape
        ArrayList<LogoPointIn2D> points = getAllPoints(lines);
        //check how many times each coordinate appears and save it into a hashmap
        HashMap<LogoPointIn2D, Integer> occurrences = generateNumberOfOccurrences(points);
        //check how many ends the shape has by counting the number of ends in the shape
        if (occurrences.isEmpty()) {
            return false;
        }
        int ends = getNumberOfEndsOfShape(occurrences);
//        System.out.println("number of ends: " + ends);
//        if (ends > 2 || ends == 1) {
//            return false;
//        } else
        if (ends == 2) {
            return true;
        } else if (ends == 0) {
            setNeedsToClose(true);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets all the start and end points from all the lines in the given shape.
     *
     * @param lines the lines in the shape.
     * @return an ArrayList with all the points from all the lines inside the shape.
     */
    private ArrayList<LogoPointIn2D> getAllPoints(LinkedHashSet<StraightLineIn2D> lines) {
        ArrayList<LogoPointIn2D> points = new ArrayList<>();
        for (StraightLineIn2D line : lines) {
            points.addAll(line.getPoints());
        }
        return points;
    }

    /**
     * Records how many times each coordinate appears in the given ArrayList.
     *
     * @param p the ArrayList containing all points.
     * @return a HashMap with each coordinate and how many times it occurs.
     */
    private HashMap<LogoPointIn2D, Integer> generateNumberOfOccurrences(ArrayList<LogoPointIn2D> p) {
        HashMap<LogoPointIn2D, Integer> pointsWithOccurrences = new HashMap<>();
        for (LogoPointIn2D point : p) {
            if (pointsWithOccurrences.containsKey(point)) {
                int newValue = pointsWithOccurrences.get(point) + 1;
                //I update the value
                pointsWithOccurrences.put(point, newValue);
            } else {
                //It's the first time I see the point, so I add it.
                pointsWithOccurrences.put(point, 1);
            }
        }
        return pointsWithOccurrences;
    }

    /**
     * Counts how many points occur only once, which means that they correspond to one end of the shape.
     *
     * @param studiedPoints the points with their respective number of appearances in allPoints.
     * @return how many ends of shape are found.
     */
    private int getNumberOfEndsOfShape(HashMap<LogoPointIn2D, Integer> studiedPoints) {
        int counter = 0;
        for (Integer value : studiedPoints.values()) {
            if (value == 1) {
                counter++;
            }
//            System.out.println("num end of shape counted: " + counter);
        }
        return counter;
    }

    /**
     * Gets if the shape needs to be closed.
     *
     * @return true if shape needs to be closed, false otherwise.
     */
    public boolean getNeedsToClose() {
        return needsToClose;
    }

    /**
     * Sets the need for the shape to be closed.
     *
     * @param b what to set the shape, if true the shape needs to be closed, if false the shape will need to be open.
     */
    public void setNeedsToClose(boolean b) {
        this.needsToClose = b;
    }
}
