package Model.Vehicle;

import Model.Vehicle.Cars;

import java.awt.*;

/**
 * Overall logic for the car model: Saab
 */
public class Saab extends Cars implements ITurbo {

    /**
     * A boolean that checks if turbo i on.
     */
    public boolean turboOn;

    /**
     * Car attributes.
     */

    public Saab(double x, double y){
        super(x, y);
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        stopEngine();
        LengthVehicle = 5.0;
    }

    /**
     * @return true if turbo is on
     */

    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * @return false if turbo is off
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     *
     * @return the factor that effects the speed of the car
     * depends on  the enginePower and turbo
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

}
