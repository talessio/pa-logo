package pa.logo.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A shape in two dimensions. Can have a fill color, if none is given it's automatically white.
 * Can be open or closed.
 */
public class ShapeIn2D implements Shape<CoordinateIn2D, StraightLineIn2D> {

    private Color fillColor = Color.white;
    private boolean closed = false;

    /**
     * ArrayList of all lines in the shape. Can contain any number of connected lines.
     */
    ArrayList<StraightLineIn2D> lines = new ArrayList<>();
    private boolean needToClose = false;

    public ShapeIn2D(ArrayList<StraightLineIn2D> linesInShape, Color color) {
        if ((linesInShape == null) || (color == null)) {
            throw new NullPointerException("Lines cannot be empty.");
        }
        if (isLineDuplicate(linesInShape)) {
            throw new IllegalArgumentException("Line already present in shape.");
        }
        if (linesAreLegal(linesInShape)) {
            if (needToClose) {
                this.lines = linesInShape;
                this.fillColor = color;
                this.closed = true;
            } else {
                this.lines = linesInShape;
                this.fillColor = color;
            }
        } else {
            throw new IllegalArgumentException("Shape is closed, cannot add lines.");
        }
    }

    public ShapeIn2D(ArrayList<StraightLineIn2D> linesInShape) {
        this.closed = false;
        if (linesInShape == null) {
            throw new NullPointerException("Lines cannot be empty.");
        }
        if (isLineDuplicate(linesInShape)) {
            throw new IllegalArgumentException("Line already present in shape.");
        }
        if (linesAreLegal(linesInShape)) {
            if (needToClose) {
                this.lines = linesInShape;
                this.closed = true;
            } else {
                this.lines = linesInShape;
            }
        } else {
            throw new IllegalArgumentException("Shape is closed, cannot add lines.");
        }
    }

    /**
     * Checks for duplicate lines.
     *
     * @param newLines the new lines to add to the Shape.
     * @return true if there are duplicates, false otherwise.
     */
    private boolean isLineDuplicate(ArrayList<StraightLineIn2D> newLines) {
        for (StraightLineIn2D newLine : newLines) {
            for (StraightLineIn2D oldLine : this.lines) {
                if (newLine == oldLine) {
                    return true;
                }
            }
        }
        return false;
    }

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

    /**
     * Gets all the coordinates from all the given lines.
     *
     * @param linesToCheck the lines already in the shape.
     * @param coordinates  the ArrayList where all the coordinates are saved.
     * @return an ArrayList with all the coordinates from all the given lines.
     */
    private ArrayList<CoordinateIn2D> getAllCoordinates(ArrayList<StraightLineIn2D> linesToCheck, ArrayList<CoordinateIn2D> coordinates) {
        for (StraightLineIn2D line : linesToCheck) {
            coordinates.addAll(line.getCoordinates());
        }
        return coordinates;
    }

    /**
     * Checks that lines to be added to shape are legal.
     *
     * @param linesToAdd the lines to add to the shape.
     * @return true if lines are legal, false otherwise.
     */
    private boolean linesAreLegal(ArrayList<StraightLineIn2D> linesToAdd) {
        if (linesToAdd == null) throw new NullPointerException();
        ArrayList<CoordinateIn2D> newLinesCoordinates = new ArrayList<>();
        getAllCoordinates(linesToAdd, newLinesCoordinates);
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

    @Override
    public void addLine(StraightLineIn2D line) {
        if (line == null) {
            throw new NullPointerException();
        }
        ArrayList<StraightLineIn2D> lineToAdd = new ArrayList<>();
        lineToAdd.add(line);
        addLines(lineToAdd);
    }

    @Override
    public void addLines(ArrayList<StraightLineIn2D> linesToAdd) {
        if (linesToAdd == null) {
            throw new NullPointerException();
        }
        if (linesAreLegal(linesToAdd)) {
            for (StraightLineIn2D line : linesToAdd) {
                this.lines.add(line);
            }
        }
    }

    @Override
    public ArrayList<StraightLineIn2D> getShapeLines() {
        return this.lines;
    }

    @Override
    public Color getShapeColor() {
        return this.fillColor;
    }

    @Override
    public void setShapeColor(Color color) {
        if (color == null) throw new NullPointerException();
        this.fillColor = color;
    }

    @Override
    public boolean isClosed() {
        return this.closed;
    }

    @Override
    public void setClosed() {
        this.closed = true;
    }

}
