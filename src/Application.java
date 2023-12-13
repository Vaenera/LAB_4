import Controller.CarController;
import Model.Model;
import View.CarView;
public class Application {

    public static void main(String[] args) {

        Model model = new Model();
        CarController cc = new CarController(model);
        CarView frame = new CarView("CarSim 1.0", cc);
        model.addObserver(frame);

        // Start the timer
        model.start();
    }
}
