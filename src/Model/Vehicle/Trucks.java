package Model.Vehicle;

public abstract class Trucks extends Vehicle{
    TruckBed truckBed;

    Trucks(double x, double y, int min, int max, int stepSize) {
        super(x,y);
        this.truckBed = new TruckBed(min, max, stepSize);
    }

    public void move () {
        if (direction == Directions.NORTH && truckBed.getTruckBedAngle() == 0) {
            x += currentSpeed;
        }
        if (direction == Directions.WEST && truckBed.getTruckBedAngle() == 0) {
            y -= currentSpeed;
        }
        if (direction == Directions.SOUTH && truckBed.getTruckBedAngle() == 0) {
            x -= currentSpeed;
        }
        if (direction == Directions.EAST && truckBed.getTruckBedAngle() == 0) {
            y += currentSpeed;
        }
    }

}
