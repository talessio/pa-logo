package pa.logo.model;

import java.awt.*;
import java.util.ArrayList;

public class StraightLineIn2D implements Line<CoordinateIn2D> {

    CoordinateIn2D c1;
    CoordinateIn2D c2;
    Color color;

    public StraightLineIn2D(CoordinateIn2D start, CoordinateIn2D end, Color color) {
        this.c1 = start;
        this.c2 = end;
        this.color = color;
    }

    public StraightLineIn2D(CoordinateIn2D start, CoordinateIn2D end) {
        this.c1 = start;
        this.c2 = end;
        this.color = Color.black;

    }

    @Override
    public ArrayList<CoordinateIn2D> getCoordinates() {
        ArrayList<CoordinateIn2D> lineCoordinates = new ArrayList<>();
        lineCoordinates.add(this.c1);
        lineCoordinates.add(this.c2);
        return lineCoordinates;
    }

    @Override
    public Color getLineColor() {
        return null;
    }

//    @Override
//    public StraightLineIn2D getLine(CoordinateIn2D start, CoordinateIn2D end) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<StraightLineIn2D> getAllLinesFrom(CoordinateIn2D start) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<StraightLineIn2D> getAllLinesAt(CoordinateIn2D c) {
//        return null;
//    }
}
