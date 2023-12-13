package Model.Vehicle;
import java.awt.*;

public abstract class Vehicle implements Movable {

    Vehicle (double x, double y) {
        this.y = y;
        this.x = x;
    }
    protected int nrDoors; // Number of doors on the car

    protected double enginePower; // Engine power of the car

    protected double currentSpeed; // The current speed of the car

    protected Color color; // Color of the car

    protected String modelName; // The car model name
    protected double LengthVehicle;

    // Move car
    protected double x; //coordinates
    protected double y; //coordinates
    protected Directions direction = Directions.NORTH;
    public abstract double speedFactor();
    // get
    public double getLengthVehicle(){return LengthVehicle;}
    public int getNrDoors(){return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public Color getColor(){
        return color;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public Directions getDirection(){
        return direction;
    }

    // set
    public void setX (double Xcor){
        x = Xcor;
    }
    public void setY (double Ycor){
        y = Ycor;
    }
    public void setColor(Color clr){
        color = clr;
    }


    // start  and stop
    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * method to make the car turn left
     */
    public void turnLeft () {
        if (direction == Directions.NORTH) {
            direction = Directions.WEST;
        }
        else if (direction == Directions.WEST) {
            direction = Directions.SOUTH;
        }
        else if (direction == Directions.SOUTH) {
            direction = Directions.EAST;
        }
        else if (direction == Directions.EAST) {
            direction = Directions.NORTH;
        }
    }

    /**
     * method to make the car turn right
     */
    public void turnRight () {
        if (direction == Directions.NORTH) {
            direction = Directions.EAST;
        }
        else if (direction == Directions.EAST) {
            direction = Directions.SOUTH;
        }
        else if (direction == Directions.SOUTH) {
            direction = Directions.WEST;
        }
        else if (direction == Directions.WEST) {
            direction = Directions.NORTH;
        }
    }

    /**
     * The factor by which the speed of the cars increases.
     * @return the speed of the car
     *
     */
    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    /**
     * The factor by which the speed of the cars decrement.
     * @return the speed of the car
     *
     */
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * A method to makes the car accelerate
     * @param amount that has a values in the range [0,1]
     */
    public void gas(double amount) {
        if (amount > 0 && amount <= 1) {
            incrementSpeed(amount);
        }
        else if (amount < 0){
            incrementSpeed(0);
        }
        else if (amount > 1){
            incrementSpeed(1);

        }
    }

    /**
     * A method to makes the car brake
     * @param amount that has a values in the range [0,1]
     */
    public void brake(double amount){
        if (amount > 0 && amount <= 1) {
            decrementSpeed(amount);
        }
        else {
            decrementSpeed(0.0);
        }
    }





}
