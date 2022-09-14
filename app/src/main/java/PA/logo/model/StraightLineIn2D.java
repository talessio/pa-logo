package pa.logo.model;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * A straight line. If no color is given it is black by default.
 */
public class StraightLineIn2D extends Line2D implements Line<LogoPointIn2D> {

    LogoPointIn2D c1;
    LogoPointIn2D c2;
    Color color;

    public StraightLineIn2D(LogoPointIn2D start, LogoPointIn2D end, Color color) {
        this.c1 = start;
        this.c2 = end;
        this.color = color;
    }

    public StraightLineIn2D(LogoPointIn2D start, LogoPointIn2D end) {
        this.c1 = start;
        this.c2 = end;
        this.color = Color.black;

    }

    @Override
    public LinkedHashSet<LogoPointIn2D> getPoints() {
        LinkedHashSet<LogoPointIn2D> lineCoordinates = new LinkedHashSet<>();
        lineCoordinates.add(this.c1);
        lineCoordinates.add(this.c2);
        return lineCoordinates;
    }

    @Override
    public Color getLineColor() {
        return this.color;
    }

    @Override
    public double getX1() {
        return this.c1.getX();
    }

    @Override
    public double getY1() {
        return this.c1.getY();
    }

    @Override
    public LogoPointIn2D getP1() {
        return this.c1;
    }

    @Override
    public double getX2() {
        return this.c2.getX();
    }

    @Override
    public double getY2() {
        return this.c2.getY();
    }

    @Override
    public LogoPointIn2D getP2() {
        return this.c2;
    }

    @Override
    public void setLine(double x1, double y1, double x2, double y2) {
        this.c1.setLocation(x1, y1);
        this.c2.setLocation(x2, y2);
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
        return c1.equals(that.c1) && c2.equals(that.c2) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(c1, c2, color);
    }
}
