package pa.logo.model;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * A straight line. If no color is given it is black by default.
 */
public class StraightLineIn2D extends Line2D implements Line<LogoPointIn2D> {

    LogoPointIn2D point1;
    LogoPointIn2D point2;
    Color color;


    private CanvasIn2D canvas;

    public StraightLineIn2D(LogoPointIn2D start, LogoPointIn2D end, Color color) {
        this.point1 = start;
        this.point2 = end;
        this.color = color;
        this.canvas = point1.getCanvas();
    }

    public StraightLineIn2D(LogoPointIn2D start, LogoPointIn2D end) {
        this.point1 = start;
        this.point2 = end;
        this.color = Color.black;
        this.canvas = point1.getCanvas();
    }

    public CanvasIn2D getCanvas() {
        return this.canvas;
    }

    @Override
    public ArrayList<LogoPointIn2D> getPoints() {
        ArrayList<LogoPointIn2D> lineCoordinates = new ArrayList<>();
        lineCoordinates.add(this.point1);
        lineCoordinates.add(this.point2);
        return lineCoordinates;
    }

    @Override
    public Color getLineColor() {
        return this.color;
    }

    @Override
    public double getX1() {
        return this.point1.getX();
    }

    @Override
    public double getY1() {
        return this.point1.getY();
    }

    @Override
    public LogoPointIn2D getP1() {
        return this.point1;
    }

    @Override
    public double getX2() {
        return this.point2.getX();
    }

    @Override
    public double getY2() {
        return this.point2.getY();
    }

    @Override
    public LogoPointIn2D getP2() {
        return this.point2;
    }

    @Override
    public void setLine(double x1, double y1, double x2, double y2) {
        this.point1.setLocation(x1, y1);
        this.point2.setLocation(x2, y2);
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null; //TODO implement
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StraightLineIn2D that = (StraightLineIn2D) o;
        return point1.equals(that.point1) && point2.equals(that.point2) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2, color);
    }

    @Override
    public String toString() {
        return "StraightLineIn2D{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                ", color=" + color +
                ", canvas=" + canvas +
                '}';
    }
}
