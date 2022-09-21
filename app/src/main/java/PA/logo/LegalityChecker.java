package pa.logo;

import pa.logo.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class LegalityChecker {

    private boolean needsToClose;

    /**
     * Checks that the coordinates don't violate any rules.
     *
     * @param x      the x coordinate.
     * @param y      the y coordinate.
     * @param canvas the canvas.
     * @return true if the coordinates are legal, false otherwise.
     */
    public boolean coordinatesAreLegal(double x, double y, CanvasIn2D canvas) {
        return withinCanvasLimits(x, y, canvas);
    }

    /**
     * Checks that the coordinates are within the limits of the canvas.
     *
     * @param x      the x coordinate.
     * @param y      the y coordinate.
     * @param canvas the canvas.
     * @return true if the coordinates are within the limits of the canvas, false otherwise.
     */
    private boolean withinCanvasLimits(double x, double y, CanvasIn2D canvas) {
        if (x > canvas.getBase() || x > canvas.getHeight() || y > canvas.getBase() || y > canvas.getHeight() || x < 0.0 || y < 0.0) {
            return false;
        }
        return true;
    }

    /**
     * Checks that the line doesn't violate any rules.
     *
     * @param line  the line.
     * @param shape the shape it belongs to.
     */
    public void lineIsLegal(StraightLineIn2D line, ShapeIn2D shape) throws NullPointerException, IllegalArgumentException {
        if (shape.isClosed()) throw new IllegalArgumentException("Shape is closed to new lines.");
        if (line == null) throw new NullPointerException("Line cannot be null.");
    }

//    /**
//     * Checks the line is duplicate inside the shape.
//     *
//     * @param line  the line.
//     * @param shape the shape.
//     * @return true if the line is a duplicate, false otherwise.
//     */
//    private boolean isDuplicate(StraightLineIn2D line, ShapeIn2D shape) {
//        for (StraightLineIn2D oldLine : shape.getShapeLines()) {
//            if (line.equals(oldLine)) {
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     * Checks that the shape doesn't violate any rules.
     *
     * @param lines the lines from the shape.
     * @return true if the shape is legal, false otherwise.
     */
    public boolean shapeIsLegal(LinkedHashSet<StraightLineIn2D> lines) {
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

    public boolean getNeedsToClose() {
        return needsToClose;
    }

    public void setNeedsToClose(boolean b) {
        this.needsToClose = b;
    }
}
