package Model.Vehicle;

import Model.Vehicle.Cars;

import java.awt.*;

public class Volvo extends Cars {
    public Volvo(double x, double y){
        super(x, y);
        direction = Directions.NORTH;
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    public final static double trimFactor = 1.25;
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}

