package pa.logo.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A shape in two dimensions. Can have a fill color, if none is given it's automatically white.
 * Can be open or closed.
 */
public class ShapeIn2D implements Shape<CoordinateIn2D, StraightLineIn2D> {

    private Color fillColor;
    private boolean closed = false;

    /**
     * ArrayList of all lines in the shape. Can contain any number of connected lines.
     */
    ArrayList<StraightLineIn2D> lines = new ArrayList<>();
    private boolean needToClose;

    public ShapeIn2D(ArrayList<StraightLineIn2D> linesInShape, Color color) {
        if ((linesInShape == null) || (color == null)) {
            throw new NullPointerException();
        }
        if ((closed = false) && (linesAreLegal(linesInShape))) {
            if (needToClose = false) {
                this.lines = linesInShape;
                this.fillColor = color;
            } else if (needToClose = true) {
                this.lines = linesInShape;
                this.fillColor = color;
                this.closed = true;
            }
        } else if (closed = true) {
            throw new IllegalArgumentException("Shape is closed, cannot add lines.");
        }
    }

    public ShapeIn2D(ArrayList<StraightLineIn2D> linesInShape) {
        if (linesInShape == null) {
            throw new NullPointerException();
        }
        if ((closed = false) && (linesAreLegal(linesInShape))) {
            if (needToClose = false) {
                this.lines = linesInShape;
                this.fillColor = Color.white;
            } else if (needToClose = true) {
                this.lines = linesInShape;
                this.fillColor = Color.white;
                this.closed = true;
            }
        } else if (closed = true) {
            throw new IllegalArgumentException("Shape is closed, cannot add lines.");
        }
    }

    /**
     * Checks that lines to be added to shape are legal.
     *
     * @param linesToAdd the lines to add to the shape.
     * @return true if lines are legal, false otherwise.
     */
    public boolean linesAreLegal(ArrayList<StraightLineIn2D> linesToAdd) {
        ArrayList<CoordinateIn2D> allCoordinates = new ArrayList<>();
        HashMap<CoordinateIn2D, Integer> studiedCoordinates = new HashMap<>();
        int numberOfEndsOfShape = 0;
        prepareForCheck(linesToAdd, allCoordinates);
        checkNumberOfOccurrences(allCoordinates, studiedCoordinates);
        numberOfEndsOfShape = getNumberOfEndsOfShape(studiedCoordinates, numberOfEndsOfShape);
        if (numberOfEndsOfShape > 2 || numberOfEndsOfShape == 1) {
            //The shape has ended up either open only on one end, or open in more than two ends, which is illegal.
            return false;
        }
        if (numberOfEndsOfShape == 2) {
            //the shape has two open ends, which is legal
            return true;
        }
        if (numberOfEndsOfShape == 0) {
            //the shape is closed, which is legal
            this.needToClose = true;
            return true;
        }
        return false;
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
                //I have found one end of the shape
                numberOfEndsOfShape++;
            } else if (value >= 2) {
//            } else if (value == 2) {
                continue;
            }
//            else if (value > 2) {
//                //I have found a coordinate with too many lines attached
//                return false;
//            }
        }
        return numberOfEndsOfShape;
    }

    /**
     * Records how many times each coordinate would appear in the shape, should the new lines be added to it.
     *
     * @param allCoordinates     the ArrayList containing all coordinates, both new and old (if present).
     * @param studiedCoordinates the coordinates with their respective number of appearences in allCoordinates.
     */
    private void checkNumberOfOccurrences(ArrayList<CoordinateIn2D> allCoordinates, HashMap<CoordinateIn2D, Integer> studiedCoordinates) {
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
     * Prepares the data structures to check that the lines to be added to the shape are legal.
     *
     * @param newLines       the new lines I want to add to the shape.
     * @param allCoordinates the ArrayList containing all coordinates, both new and old (if present).
     */
    private void prepareForCheck(ArrayList<StraightLineIn2D> newLines, ArrayList<CoordinateIn2D> allCoordinates) {
        //if not empty, add old coordinates from old lines to the arraylist
        if (!this.lines.isEmpty()) {
            for (StraightLineIn2D oldLine : this.lines) {
                for (CoordinateIn2D oldCoordinate : oldLine.getCoordinates()) {
                    allCoordinates.add(oldCoordinate);
                }
            }
        }
        //save all new coordinates from all new lines in an arraylist
        for (StraightLineIn2D newLine : newLines) {
            for (CoordinateIn2D newCoordinate : newLine.getCoordinates()) {
                allCoordinates.add(newCoordinate);
            }
        }
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
