package pa.logo.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Implements the cursor for a 2D canvas.
 */
public class CursorIn2D implements Cursor<Double, Double> {

    private CanvasIn2D canvas;
    private CoordinateIn2D currentPosition;
    private double currentDirection;
    Color color;

    public CursorIn2D(CanvasIn2D canvas) {
        this.canvas = canvas;
        this.currentPosition = new CoordinateIn2D(canvas.getBase() / 2, canvas.getHeight() / 2);
        this.currentDirection = 0.0;
        this.color = Color.black;
    }

    //TODO
    @Override
    public void forward(Double distance) {

    }

    //TODO
    @Override
    public void backward(Double distance) {

    }

    @Override
    public void left(Double angle) {
        Direction direct = new Direction();
        this.currentDirection = direct.counterclockwise(this.currentDirection, angle);
    }

    @Override
    public void right(Double angle) {
        Direction direct = new Direction();
        this.currentDirection = direct.clockwise(this.currentDirection, angle);
    }

    @Override
    public void clearScreen() {
        for (ShapeIn2D shape : canvas.getAllShapesInCanvas()) {
            this.canvas.removeShapeFromCanvas(shape);
        }
    }

    @Override
    public void home() {
        this.currentPosition = new CoordinateIn2D(canvas.getBase() / 2, canvas.getHeight() / 2);
    }

    //TODO
    @Override
    public void penUp() {

    }

    //TODO
    @Override
    public void penDown() {

    }

    @Override
    public void setPenColor(Color color) {
        this.color = color;
    }

    //TODO
    @Override
    public void setFillColor(Color color) {
        
    }

    //TODO
    @Override
    public void setScreenColor(Color color) {

    }

    //TODO
    @Override
    public void setPenSize(int size) {

    }

    //TODO
    @Override
    public void repeat(int numberOfTimes) {

    }
}
