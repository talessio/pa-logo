package PA.Logo;

import java.awt.*;
import java.util.ArrayList;

/**
 * The canvas on which one draws.
 */
public interface Area {

    /**
     * Get the color of the area.
     *
     * @return the color in RGB.
     */
    Color getColor();

    /**
     * Set the color of the area.
     *
     * @param color the color.
     */
    void setColor(Color color);

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
