package View;

import Model.Observer;
import Model.Vehicle.Vehicle;
import Controller.CarController;
import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame implements Observer { //static??
    private static final int X = 800;
    private static final int Y = 800;


    // The controller member
    CarController carC;

    DrawPanel drawPanel = new DrawPanel(X, Y-240);

    // Constructor
    // Constructor
    public CarView(String frameName, CarController cc){
        this.carC = cc;
        initComponents(frameName);
    }

    public void modelUpdate(List<Vehicle> vehicles){
        drawPanel.updateList(vehicles);
        drawPanel.repaint();
    }

    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);
        this.add(carC.controlPanel);
        this.add(carC.gasPanel);
        this.add(drawPanel);

        carC.buttons();
        carC.actionListeners();

        this.pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}





