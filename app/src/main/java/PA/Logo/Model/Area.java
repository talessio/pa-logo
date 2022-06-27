package PA.Logo.Model;

import java.awt.*;
import java.util.ArrayList;

/**
 * The canvas on which one draws. Must implement home variable, etc depending on whether the Area is 2D or 3D or more.
 */
public interface Area {

    /**
     * Returns the coordinates for the home. Corresponds to the place where all coordinates = 0.
     *
     * @return the home.
     */
    Coordinates getHome();

    /**
     * Get the color of the area.
     *
     * @return the color in RGB.
     */
    Color getFillColor();

    /**
     * Set the color of the area.
     *
     * @param color the color.
     */
    void setFillColor(Color color);

    /**
     * Obtain the size of the area.
     *
     * @return the size of the area.
     */
    Size getSize();

    /**
     * Set the size of the area. Must have at least height and base.
     *
     * @param measurements the measurements for the area.
     */
    void setSize(ArrayList<Integer> measurements);

}
