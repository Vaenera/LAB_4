package Model.Vehicle;

/**
 * Overall logic for the Truck: Scania
 */
public class TruckBed implements ITruckBed {
    public TruckBed(int min, int max, int stepSize) {
        this.max = max;
        this.min = min;
        this.stepSize = stepSize;
    }

    private final int max;
    private final int min;
    private final int stepSize;

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    protected double truckBedAngle = 0.0; // The angle of the truck bed.
    protected double currentSpeed; // The current speed of the car.

    public double getTruckBedAngle() {
        return truckBedAngle;
    }

    /**
     * A method to make the truck bed go up.
     * @return
     */
    public void truckBedUp() {
        if (min <= truckBedAngle && truckBedAngle < max && currentSpeed == 0.0) {
            truckBedAngle += stepSize;
        } else if (truckBedAngle > max && currentSpeed == 0.0) ;
        truckBedAngle = max;
    }

    /**
     * A method to make the truck bed go down.
     * @param
     */
    public void truckBedDown() {
        if (min < truckBedAngle && truckBedAngle <= max && currentSpeed == 0.0) {
            truckBedAngle -= stepSize;
        } else if (truckBedAngle < min && currentSpeed == 0.0) ;
        truckBedAngle = min;
    }


}

