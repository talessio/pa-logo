package pa.logo;

import pa.logo.model.CoordinateIn2D;
import pa.logo.model.ShapeIn2D;
import pa.logo.model.StraightLineIn2D;

import java.util.ArrayList;
import java.util.HashMap;

public class LegalityChecker {

    /**
     * Checks that the line doesn't violate any rules.
     *
     * @param line  the line.
     * @param shape the shape it belongs to.
     */
    public void lineIsLegal(StraightLineIn2D line, ShapeIn2D shape) {
        if (line == null) throw new NullPointerException("Line cannot be null.");
        if (isDuplicate(line, shape)) {
            throw new IllegalArgumentException("Cannot have duplicate lines.");
        }
    }

    /**
     * Checks that the shape doesn't violate any rules.
     *
     * @param shape the shape.
     */
    public void shapeIsLegal(ShapeIn2D shape) {
        if (hasIllegalNumberOfEnds(shape)) {
            throw new IllegalArgumentException("Shape has an illegal number of ends.");
        }
        //TODO: figure out if you need to check for more than that.
    }

    //TODO implement
    //TODO add javadoc
    private boolean hasIllegalNumberOfEnds(ShapeIn2D shape) {
        ArrayList<CoordinateIn2D> coordinates = getAllCoordinates(shape);
        return false;
    }

    /**
     * Gets all the coordinates from all the lines in the given shape.
     *
     * @param shape the shape.
     * @return an ArrayList with all the coordinates from all the lines inside the shape.
     */
    private ArrayList<CoordinateIn2D> getAllCoordinates(ShapeIn2D shape) {
        ArrayList<CoordinateIn2D> coordinates = new ArrayList<>();
        for (StraightLineIn2D line : shape.getShapeLines()) {
            coordinates.addAll(line.getCoordinates());
        }
        return coordinates;
    }

    //TODO fix
    /**
     * Checks that the shape has either 2 or 0 ends. If it has 1 or more than 2, then the shape is either open only on one end, or open on more than 2 ends. If it has 0 ends, the shape is closed. If it has 2 ends, the shape is open.
     *
     * @param numberOfEndsOfShape the number of ends in the shape.
     * @return true if it has a legal number of ends, false otherwise.
     */
    private boolean shapeHasLegalNumberOfEnds(int numberOfEndsOfShape) {
        if (numberOfEndsOfShape > 2 || numberOfEndsOfShape == 1) {
            return false;
        }
        if (numberOfEndsOfShape == 2) {
            return true;
        }
        if (numberOfEndsOfShape == 0) {
            this.needToClose = true;
            return true;
        }
        return false;
    }

    //TODO fix
    /**
     * Records how many times each coordinate would appear in the shape, should the new lines be added to it.
     *
     * @param allCoordinates     the ArrayList containing all coordinates, both new and old (if present).
     * @param studiedCoordinates the coordinates with their respective number of appearences in allCoordinates.
     */
    private void generateNumberOfOccurrences(ArrayList<CoordinateIn2D> allCoordinates, HashMap<CoordinateIn2D, Integer> studiedCoordinates) {
        for (CoordinateIn2D coordinateInLines : allCoordinates) {
            if (studiedCoordinates.containsValue(coordinateInLines)) {
                int newValue = studiedCoordinates.get(coordinateInLines) + 1;
                //I update the value
                studiedCoordinates.put(coordinateInLines, newValue);
            } else {
                //It's the first time I see the coordinate, so I add it.
                studiedCoordinates.put(coordinateInLines, 1);
            }
        }
    }

    //TODO fix
    /**
     * Counts how many coordinates occur only once, which means that they correspond to one end of the shape.
     *
     * @param studiedCoordinates  the coordinates with their respective number of appearences in allCoordinates.
     * @param numberOfEndsOfShape how many ends of shape are found.
     * @return how many ends of shape are found.
     */
    private int getNumberOfEndsOfShape(HashMap<CoordinateIn2D, Integer> studiedCoordinates, int numberOfEndsOfShape) {
        for (Integer value : studiedCoordinates.values()) {
            if (value == 1) {
                numberOfEndsOfShape++;
            }
        }
        return numberOfEndsOfShape;
    }

    //TODO fix
    /**
     * Checks that lines to be added to shape are legal.
     *
     * @param linesToAdd the lines to add to the shape.
     * @return true if lines are legal, false otherwise.
     */
    private boolean linesAreLegal(ArrayList<StraightLineIn2D> linesToAdd) {
//        ArrayList<CoordinateIn2D> newLinesCoordinates = new ArrayList<>();
//        getAllCoordinates(linesToAdd, newLinesCoordinates);
        ArrayList<CoordinateIn2D> allCoordinates = new ArrayList<>();
        if (this.lines.isEmpty()) {
            allCoordinates = newLinesCoordinates;
        } else {
            ArrayList<CoordinateIn2D> oldLinesCoordinates = new ArrayList<>();
            getAllCoordinates(this.lines, oldLinesCoordinates);
            allCoordinates.addAll(newLinesCoordinates);
            allCoordinates.addAll(oldLinesCoordinates);
        }
        HashMap<CoordinateIn2D, Integer> studiedCoordinates = new HashMap<>();
        int numberOfEndsOfShape = 0;
        generateNumberOfOccurrences(allCoordinates, studiedCoordinates);
        numberOfEndsOfShape = getNumberOfEndsOfShape(studiedCoordinates, numberOfEndsOfShape);
        return shapeHasLegalNumberOfEnds(numberOfEndsOfShape);
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
