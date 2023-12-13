package Model.Vehicle;

/**
 * Overall all logic for the cars
 */
public abstract class Cars extends Vehicle {

    Cars(double x, double y) {
        super(x, y);
    }

    /**
     * method to set the car in motion
     *
     * @return
     */

    public void move() {
        if (direction == Directions.NORTH) {
            x += currentSpeed;
        }
        if (direction == Directions.WEST) {
            y -= currentSpeed;
        }
        if (direction == Directions.SOUTH) {
            x -= currentSpeed;
        }
        if (direction == Directions.EAST) {
            y += currentSpeed;
        }
    }

}


