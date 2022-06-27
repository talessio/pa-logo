package PA.Logo;

import java.util.ArrayList;

public interface Size {

    /**
     * ArrayList of all measurements. Must have at least a height and a base.
     */
    ArrayList<Integer> size = new ArrayList<Integer>();

    /**
     * Returns the height.
     *
     * @return the height.
     */
    int getHeight();

    /**
     * Returns the base.
     *
     * @return the base.
     */
    int getBase();

    /**
     * Returns all measurements.
     *
     * @return all measurements.
     */
    ArrayList<Integer> allMeasurements();

    /**
     * Add an additional measurement to height and base.
     *
     * @param measurement the measurement.
     */
    void addMeasurement(Integer measurement);
}
