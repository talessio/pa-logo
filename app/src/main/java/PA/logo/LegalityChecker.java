package pa.logo;

import pa.logo.model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class LegalityChecker {

    /**
     * Checks that the coordinates don't violate any rules.
     *
     * @param x      the x coordinate.
     * @param y      the y coordinate.
     * @param canvas the canvas.
     */
    public boolean coordinatesAreLegal(double x, double y, CanvasIn2D canvas) {
        if (x > canvas.getBase() || x > canvas.getHeight()) {
            if (y > canvas.getBase() || y > canvas.getHeight()) {
                return false;
            }
        }
        return !(x < 0.0) && !(y < 0.0);
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
        if (isDuplicate(line, shape)) throw new IllegalArgumentException("Cannot have duplicate lines.");
    }

    /**
     * Checks that the shape doesn't violate any rules.
     *
     * @param lines the lines from the shape.
     * @return true if the shape is legal, false otherwise.
     */
    public boolean shapeIsLegal(ArrayList<StraightLineIn2D> lines) {
        return !hasIllegalNumberOfEnds(lines);
    }

    /**
     * Checks if shape needs to be closed.
     *
     * @param lines the lines.
     * @return true if the shape needs to be set closed, false otherwise.
     */
    public boolean needsToClose(ArrayList<StraightLineIn2D> lines) {
        ArrayList<LogoPointIn2D> coordinates = getAllCoordinates(lines);
        HashMap<LogoPointIn2D, Integer> occurrences = generateNumberOfOccurrences(coordinates);
        int ends = getNumberOfEndsOfShape(occurrences);
        return ends == 0;
    }

    /**
     * Checks that the shape has either 2 or 0 ends.
     * If it has 1 or more than 2, then the shape is either open only on one end, or open on more than 2 ends.
     * If it has 0 ends, the shape is closed.
     * If it has 2 ends, the shape is open.
     *
     * @param lines the lines from the shape.
     * @return true if the shape has an illegal number of ends, false otherwise.
     */
    private boolean hasIllegalNumberOfEnds(ArrayList<StraightLineIn2D> lines) {
        //get all the coordinates from all the lines inside the shape
        ArrayList<LogoPointIn2D> coordinates = getAllCoordinates(lines);
        //check how many times each coordinate appears and save it into a hashmap
        HashMap<LogoPointIn2D, Integer> occurrences = generateNumberOfOccurrences(coordinates);
        //check how many ends the shape has by counting the number of ends in the shape
        int ends = getNumberOfEndsOfShape(occurrences);
        if (ends > 2 || ends == 1) {
            return true;
        } else if (ends == 2) {
            return false;
        } else if (ends == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Gets all the coordinates from all the lines in the given shape.
     *
     * @param lines the lines in the shape.
     * @return an ArrayList with all the coordinates from all the lines inside the shape.
     */
    private ArrayList<LogoPointIn2D> getAllCoordinates(ArrayList<StraightLineIn2D> lines) {
        ArrayList<LogoPointIn2D> coordinates = new ArrayList<>();
        for (StraightLineIn2D line : lines) {
            coordinates.addAll(line.getPoints());
        }
        return coordinates;
    }

    /**
     * Records how many times each coordinate appears in the given ArrayList.
     *
     * @param coordinates the ArrayList containing all coordinates.
     * @return a HashMap with each coordinate and how many times it occurs.
     */
    private HashMap<LogoPointIn2D, Integer> generateNumberOfOccurrences(ArrayList<LogoPointIn2D> coordinates) {
        HashMap<LogoPointIn2D, Integer> coordinatesWithOccurrence = new HashMap<>();
        for (LogoPointIn2D coordinate : coordinates) {
            if (coordinatesWithOccurrence.containsKey(coordinate)) {
                int newValue = coordinatesWithOccurrence.get(coordinate) + 1;
                //I update the value
                coordinatesWithOccurrence.put(coordinate, newValue);
            } else {
                //It's the first time I see the coordinate, so I add it.
                coordinatesWithOccurrence.put(coordinate, 1);
            }
        }
        return coordinatesWithOccurrence;
    }

    /**
     * Counts how many coordinates occur only once, which means that they correspond to one end of the shape.
     *
     * @param studiedCoordinates the coordinates with their respective number of appearences in allCoordinates.
     * @return how many ends of shape are found.
     */
    private int getNumberOfEndsOfShape(HashMap<LogoPointIn2D, Integer> studiedCoordinates) {
        int numberOfEndsOfShape = 0;
        for (Integer value : studiedCoordinates.values()) {
            if (value == 1) {
                numberOfEndsOfShape++;
            }
        }
        return numberOfEndsOfShape;
    }

    /**
     * Checks the line is duplicate inside the shape.
     *
     * @param line  the line.
     * @param shape the shape.
     * @return true if the line is a duplicate, false otherwise.
     */
    private boolean isDuplicate(StraightLineIn2D line, ShapeIn2D shape) {
        for (StraightLineIn2D oldLine : shape.getShapeLines()) {
            if (line.equals(oldLine)) {
                return true;
            }
        }
        return false;
    }
}
