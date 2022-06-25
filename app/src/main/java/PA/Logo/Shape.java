package PA.Logo;

import java.util.ArrayList;

public interface Shape {
    ArrayList<Line> lines = new ArrayList<Line>();

    public default void Shape(Coordinates c) {
    }

    public Shape getShape(Shape s); //TODO is this the right parameter?

    public void setShape(ArrayList<Line> lines);

    public void getShapeColour(Shape s);

    public void setShapeColour(Shape s);

    public void addLine(Line l);


}
