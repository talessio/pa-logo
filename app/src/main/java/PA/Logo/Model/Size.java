package PA.Logo.Model;

import java.util.ArrayList;

public interface Size {

    /**
     * ArrayList of all measurements. Must have at least a height and a base.
     */
    ArrayList<Double> size = new ArrayList<Double>();

    /**
     * Returns the height. Always the first element in the size ArrayList.
     *
     * @return the height.
     */
    static double getHeight() {
        return size.get(0);
    }

    /**
     * Returns the base. Always the second element in the size ArrayList.
     *
     * @return the base.
     */
    static double getBase() {
        return size.get(1);
    }

    /**
     * Returns all measurements.
     *
     * @return all measurements.
     */
    ArrayList<Double> getAllMeasurements();

    /**
     * Add an additional measurement to height and base.
     *
     * @param measurement the measurement.
     */
    void addMeasurement(Double measurement);
}
