package Model.Vehicle;
import java.awt.*;

public class Scania extends Trucks implements ITruckBed {
    /**
     * Truck attributes.
     */
    public Scania(double x, double y){
        super (x, y, 0, 70, 1);
        nrDoors = 2;
        color = Color.white;
        enginePower = 450;
        modelName = "Scania";
        stopEngine();
    }

    /**
     * Return the factor that effects the speed of the Truck.
     */
    @Override
    public double speedFactor() {
        return enginePower * 0.01;
    }

    /**
     * method to get truck bed angle.
     * @return the truck bed angle.
     */
    public double getTruckBedAngle(){ return truckBed.getTruckBedAngle();}

    /**
     * method to take the truck bed up one degree at the time.
     */
    public void truckBedUp(){
        truckBed.truckBedUp();
    }

    /**
     * method to take the truck bed down one degree at the time.
     */
    public void truckBedDown(){
        truckBed.truckBedDown();
    }
}
