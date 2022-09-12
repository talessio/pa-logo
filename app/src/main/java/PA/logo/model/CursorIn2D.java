package pa.logo.model;

import java.awt.*;

/**
 * Implements the cursor for a 2D canvas.
 */
public class CursorIn2D implements Cursor<Double, Integer, LogoPointIn2D, StraightLineIn2D, ShapeIn2D, CanvasIn2D> {

    private final CanvasIn2D canvas;
    private LogoPointIn2D currentPosition;
    private int currentDirection;
    private Color color;
    private int penSize;
    private boolean isWriting;

    public CursorIn2D(CanvasIn2D canvas) {
        this.canvas = canvas;
        this.currentPosition = new LogoPointIn2D(canvas.getBase() / 2, canvas.getHeight() / 2, canvas);
        this.currentDirection = 0;
        this.color = Color.black;
        this.penSize = 1;
        this.isWriting = true;
    }

    /**
     * Gets the current position of the cursor.
     *
     * @return the current position.
     */
    public LogoPointIn2D getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Gets the current direction of the cursor.
     *
     * @return the current direction.
     */
    public int getCurrentDirection() {
        return currentDirection;
    }

    /**
     * Gets the current pen color.
     *
     * @return the current pen color.
     */
    public Color getPenColor() {
        return this.color;
    }

    @Override
    public void forward(Double distance) {
        LogoPointIn2D newPosition = this.currentPosition;
        if ((this.currentDirection >= 0 && this.currentDirection < 90) || (this.currentDirection <= 360 && this.currentDirection > 270)) {
            newPosition.increaseXBy(distance);
        }
        if (this.currentDirection > 0 && this.currentDirection < 180) {
            newPosition.increaseYBy(distance);
        }
        if (this.currentDirection > 90 && this.currentDirection < 270) {
            newPosition.decreaseXBy(distance);
        }
        if (this.currentDirection > 180 && this.currentDirection < 360) {
            newPosition.decreaseYBy(distance);
        }
        this.currentPosition = checkAgainstCanvasSize(newPosition);
    }

    @Override
    public void backward(Double distance) {
        LogoPointIn2D newPosition = this.currentPosition;
        if ((this.currentDirection >= 0 && this.currentDirection < 90) || (this.currentDirection <= 360 && this.currentDirection > 270)) {
            newPosition.decreaseXBy(distance);
        }
        if (this.currentDirection > 0 && this.currentDirection < 180) {
            newPosition.decreaseYBy(distance);
        }
        if (this.currentDirection > 90 && this.currentDirection < 270) {
            newPosition.increaseXBy(distance);
        }
        if (this.currentDirection > 180 && this.currentDirection < 360) {
            newPosition.increaseYBy(distance);
        }
        this.currentPosition = checkAgainstCanvasSize(newPosition);
    }

    @Override
    public void left(Integer angle) {
        DirectionIn2D direct = new DirectionIn2D();
        this.currentDirection = direct.counterclockwise(this.currentDirection, angle);
    }

    @Override
    public void right(Integer angle) {
        DirectionIn2D direct = new DirectionIn2D();
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
        this.currentPosition = new LogoPointIn2D(canvas.getBase() / 2, canvas.getHeight() / 2, this.canvas);
    }

    @Override
    public void penUp() {
        this.isWriting = true;
    }

    @Override
    public void penDown() {
        this.isWriting = false;
    }

    @Override
    public void setPenColor(Color color) {
        this.color = color;
    }

    @Override
    public void setFillColor(Color color, ShapeIn2D shape) {
        if (shape.isClosed()) {
            shape.setShapeColor(color);
        }
    }

    @Override
    public void setScreenColor(Color color, CanvasIn2D canvas) {
        canvas.setCanvasColor(color);
    }

    @Override
    public void setPenSize(int size) {
        this.penSize = size;
    }

    //TODO
    @Override
    public void repeat(int numberOfTimes) {

    }

    /**
     * Checks the position against the size of the canvas, if it's too big or small it repositions it within the size.
     *
     * @param position the potential position.
     * @return the correct position.
     */
    private LogoPointIn2D checkAgainstCanvasSize(LogoPointIn2D position) {
        if (position.getX() > canvas.getBase()) {
//            position.setX(canvas.getBase());
            position.setLocation(canvas.getBase(), position.getY());
        } else if (position.getX() < 0) {
//            position.setX(0.0);
            position.setLocation(0.0, position.getY());
        }
        if (position.getY() > canvas.getHeight()) {
//            position.setY(canvas.getHeight());
            position.setLocation(position.getX(), canvas.getHeight());
        } else if (position.getY() < 0) {
//            position.setY(0.0);
            position.setLocation(position.getX(), 0.0);
        }
        return position;
    }
}
