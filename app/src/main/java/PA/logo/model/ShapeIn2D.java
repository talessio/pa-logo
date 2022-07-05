package pa.logo.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ShapeIn2D implements Shape<CoordinateIn2D, StraightLineIn2D> {

    private Color fillColor;
    private CoordinateIn2D endOfShape1;
    private CoordinateIn2D endOfShape2;
    private boolean closed = false;
    private int endsOfShape = 0;

    /**
     * ArrayList of all lines in the shape. Can contain any number of connected lines.
     */
    ArrayList<StraightLineIn2D> lines = new ArrayList<>();

    public ShapeIn2D(ArrayList<StraightLineIn2D> linesInShape, Color color) {
        if (closed = false) {
            if (linesAreLegal(linesInShape)) {
                if () { //TODO: must check that the ends of shape are either 2 or 0! it 2, simply add lines, if 0 set shape closed!
                    this.lines = linesInShape;
                    this.fillColor = color;
                } else if () {
                    this.lines = linesInShape;
                    this.fillColor = color;
                    this.closed = true;
                }
            } else {
                throw new IllegalArgumentException("Lines must be sequential for it to be a shape.");
            }
        } else {
            throw new IllegalArgumentException("Shape is closed, cannot add lines.");
        }
    }

    public ShapeIn2D(ArrayList<StraightLineIn2D> linesInShape) {
        if (closed = false) {
            if ((linesAreLegal(linesInShape))) {
                this.lines = linesInShape;
                this.fillColor = Color.white;
            } else {
                throw new IllegalArgumentException("Lines must be sequential for it to be a shape.");
            }
        } else {
            throw new IllegalArgumentException("Shape is closed, cannot add lines.");
        }
    }

    public boolean linesAreLegal(ArrayList<StraightLineIn2D> lines) {
        ArrayList<CoordinateIn2D> allCoordinates = new ArrayList<>();
        HashMap<CoordinateIn2D, Integer> studiedCoordinates = new HashMap<>();
        int numberOfEndsOfShape = 0;

        //save all new coordinates from all new lines in an arraylist
        for (StraightLineIn2D newLine : lines) {
            for (CoordinateIn2D newCoordinate : newLine.getCoordinates()) {
                allCoordinates.add(newCoordinate);
            }
        }
        //if not empty, add old coordinates from old lines to the arraylist
        if (!this.lines.isEmpty()) {
            for (StraightLineIn2D oldLine : this.lines) {
                for (CoordinateIn2D oldCoordinate : oldLine.getCoordinates()) {
                    allCoordinates.add(oldCoordinate);
                }
            }
        }
//        Check how many times each coordinate is present inside the arraylist.
//        If present once, then the coordinate corresponds to one of the two ends of the shape
//        (must check if either or both ends of the shape match the current ends of the shape,
//        if none match, throw error, if both match set shape closed, if only one matches update one end of the shape).
//        There *must* be either 0 or 2 ends in the new shape: if you have only one end, then two lines are overlapped.
//        If there are overlapping lines, throw error or return false.
//        If present twice, that's lawful and it means that two lines are connected and that coordinate will not be an
//        end of the shape. keep analysing.
//        TODO: i need to compare the given shape with the shape already in the array. if there is a shape already i will inevitably end up with one coordinate present more than once, if there are no lines in the shape, i must
        for (CoordinateIn2D coordinateInLines : allCoordinates) {
            if (studiedCoordinates.containsValue(coordinateInLines)) {
                int newValue = studiedCoordinates.get(coordinateInLines) + 1;
                if (newValue > 2) {
//                  If present more than twice, then there are more than two line starting or ending at one point,
//                  that's illegal.
                    return false;
                } else {
                    studiedCoordinates.put(coordinateInLines, newValue);
                }
            } else {
                studiedCoordinates.put(coordinateInLines, 1);
            }
        }
        for (Integer value : studiedCoordinates.values()) {
            if (value == 1) {
                numberOfEndsOfShape++;
            } else if (value == 2) {
                continue;
            } else if (value > 2) return false;
        }
        if (numberOfEndsOfShape > 2 || numberOfEndsOfShape == 1) {
            return false;
        }
        if (numberOfEndsOfShape == 2) {
            return true;
        }
        if (numberOfEndsOfShape == 0) {
            //must set shape closed!!
            return true;
        }
        return false;
    }

    /**
     * Checks if the coordinates of the line match one of the two ends of the shape.
     *
     * @param line the line to check.
     * @return true if one of the coordinates match one of the ends, false otherwise.
     */
    public boolean lineIsLegal(StraightLineIn2D line) {
        for (CoordinateIn2D coordinate : line.getCoordinates()) {
            if ((coordinate == this.endOfShape1) || (coordinate == this.endOfShape2)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addLine(StraightLineIn2D line) {
        //TODO: check line is legal and update end of shapes after adding
    }

    @Override
    public ArrayList<StraightLineIn2D> getShapeLines() {
        return null;
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
        return false;
    }

    @Override
    public void setClosed() {

    }
}
