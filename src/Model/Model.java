package Model;

import Model.Vehicle.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Model implements ActionListener {

    VehicleFactory factory;
    ArrayList<Observer> observerList = new ArrayList<>();
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<ITurbo> carsWithTurbo = new ArrayList<>();
    ArrayList<Scania> ScaniaList = new ArrayList<>();
    private final int delay = 50;

    private Timer timer;

    public void actionPerformed(ActionEvent e) {
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
        collisionWithWalls();
        notifyObservers();
    }
    public void start(){
        timer = new Timer(delay, this);
        timer.start();
    }
    public void addObserver(Observer l){
        observerList.add(l);
    }

    protected void notifyObservers(){
        System.out.println("Here list has length" + vehicles.size());
        System.out.println("which vehicle" + vehicles);
        for(Observer ob : observerList){
            ArrayList<Vehicle> newCopy = new ArrayList<>(vehicles);
            ob.modelUpdate(newCopy);
        }
    }
    public void addCarWithPosition(){
        if(vehicles.size() == 0) {
            addVehicle(0, 0);
        }else{
            Vehicle lastVehicle =  vehicles.get(vehicles.size() - 1);
            double x = lastVehicle.getX();
            double y = lastVehicle.getY();
            addVehicle(x,y+160);
        }
        notifyObservers();
    }

    public void addVehicle(double x, double y){
        Random random = new Random();
        if(vehicles.size() < 10) {
            int min = 1;
            int max = 4;
            int value = random.nextInt(min, max);
            if (value == 1) {
                vehicles.add(factory.createVolvo(x, y));
            }
            if (value == 2) {
                Saab s = factory.createSaab(x, y);
                vehicles.add(s);
                carsWithTurbo.add(s);
            }
            if (value == 3) {
                Scania scania = factory.createScania(x, y);
                vehicles.add(scania);
                ScaniaList.add(scania);
            }
        }else{throw new IllegalArgumentException();}
    }

    public void remove(){
        int last = vehicles.size()- 1;
        vehicles.remove(last);
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }
    public void scaniaLiftBed() {
        for (Scania scania : ScaniaList) {
            scania.truckBedUp();
        }
    }

    public void scaniaLowerBed() {
        for (Scania scania : ScaniaList) {
            scania.truckBedDown();
        }
    }

    public void saabTurboOn() {
        for (ITurbo car : carsWithTurbo) {
            car.setTurboOn();
        }
    }

    public void saabTurboOff() {
        for (ITurbo car : carsWithTurbo) {
            car.setTurboOff();
        }
    }


    public void startAllCars() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    public void  stopAllCars() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    private void collisionWithWalls() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getX() > 700) {
                vehicle.setX(700);
                vehicle.turnLeft();
                vehicle.turnLeft();
            }
            if (vehicle.getY() > 500) {
                vehicle.setY(500);
                vehicle.turnLeft();
                vehicle.turnLeft();
            }
            if (vehicle.getX() < 0) {
                vehicle.setX(0);
                vehicle.turnLeft();
                vehicle.turnLeft();
            }
            if (vehicle.getY() < 0) {
                vehicle.setY(0);
                vehicle.turnLeft();
                vehicle.turnLeft();
            }
        }
    }
}
