package PA.Logo;

import java.util.ArrayList;

public interface Line {
    void getLine(Coordinates c);

    void setLine(ArrayList<Integer> coordinatesList);

    boolean isContained(Shape s);
}
