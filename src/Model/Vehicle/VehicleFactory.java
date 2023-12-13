package Model.Vehicle;

public class VehicleFactory {
    public static Volvo createVolvo(double x, double y){
        return new Volvo(x, y);
    }
    public static Saab createSaab(double x, double y){ return new Saab(x,y);}
    public static Scania createScania(double x, double y){ return new Scania(x, y);}
}
