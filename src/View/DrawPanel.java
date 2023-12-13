package View;

import Model.Vehicle.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.List;
import java.util.Objects;

public class DrawPanel extends JPanel {
    List<Vehicle> vehicleList = new ArrayList();

    // Just a single image, TODO: Generalize !!!!!!!!!!!
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;


    // To keep track of a single cars position
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();


    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            volvoImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("pics/Volvo240.jpg")));
            saabImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("pics/Saab95.jpg")));
            scaniaImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource("pics/Scania.jpg")));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void updateList(List<Vehicle> vehicles){
        vehicleList =  vehicles;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Vehicle vehicle : vehicleList) {
            if (vehicle instanceof Volvo) {
                g.drawImage(volvoImage, (int) vehicle.getX(), (int) vehicle.getY(), null);//
            } else if (vehicle instanceof Saab) {
                g.drawImage(saabImage, (int) vehicle.getX(), (int) vehicle.getY(), null);//
            } else if (vehicle instanceof Scania) {
                g.drawImage(scaniaImage, (int) vehicle.getX(), (int) vehicle.getY(), null);//
            }
        }
    }
}
