package Model.Vehicle;
import Model.Container.Container;
import java.awt.*;
import java.util.ArrayList;
import java.lang.Math;

public class CarTransport extends Trucks implements ITruckBed {
    public Container<Cars> container; //typ argument
    public boolean rampOut;

    /**
     * Truck attributes.
     */
    public CarTransport(double x, double y) {
        super (x, y, 0,70, 70);
        nrDoors = 2;
        color = Color.gray;
        enginePower = 450;
        modelName = "carTransport";
        stopEngine();
        LengthVehicle = 21.0;
        this.container = new Container(8);
    }

    /**
     * Return the factor that effects the speed of the Truck.
     */
    @Override
    public double speedFactor() {
        return enginePower * 0.01;
    }

    public void truckBedUp() {
        truckBed.truckBedUp();
        rampOut= true;
    }

    public void truckBedDown() {
        truckBed.truckBedDown();
        rampOut= false;

    }

    public void loadCar(Cars car){
        if (rampOut && checkDistanceBetweenVehicles(car) == true && currentSpeed == 0.0){
            container.loadN(car);
        }
    }

    public void unloadCar(Cars car){
        if (rampOut && currentSpeed == 0.0){
            container.unloadN(car);
            checkDistanceBetweenVehicles(car);
        }
    }
    @Override
    public void move(){
        super.move();
        updatePositionOfCarInContainer();

    }

    public void updatePositionOfCarInContainer(){
        if(container.size() > 0) {
            for (Cars car : container.container) {
                car.setX(this.x);
                car.setY(this.y);
            }
        }
    }

    public boolean checkDistanceBetweenVehicles(Vehicle vehicle) {
        double xDistance = this.x - vehicle.getX();
        double yDistance = this.y - vehicle.getY();
        if (xDistance >= 0 && xDistance <= 1 && yDistance >= 0 && yDistance <= 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean containerIsEmpty() {
        container.contains();
        return container.contains();
    }

}