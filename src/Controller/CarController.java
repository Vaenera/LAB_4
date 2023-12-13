package Controller;
import Model.Model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarController {
    private static final int X = 800;

    Model model;

    public CarController(Model model) {
        this.model = model;
    }

    void gas(int amount) {
        model.gas(amount);
    }

    void brake(int amount) {
        model.brake(amount);
    }

    void scaniaLiftBed() {
        model.scaniaLiftBed();
    }

    void scaniaLowerBed() {
        model.scaniaLowerBed();
    }

    void setTurboOn() {
        model.saabTurboOn();
    }

    void setTurboOff() {
        model.saabTurboOff();
    }

    void startAllCars() {
        model.startAllCars();
    }

    void stopAllCars() {
        model.stopAllCars();
    }

    void AddCar(){model.addCarWithPosition();}
    void RemoveCar(){model.remove();}


    public JPanel gasPanel = new JPanel();
    public JPanel controlPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of Gas/Brake");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    JButton addcarbutton = new JButton("Add Car");
    JButton removebutton = new JButton("Remove car");


    public void actionListeners() {
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(gasAmount);
            }
        });
        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(gasAmount);
            }
        });
        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.saabTurboOn();
            }
        });
        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.saabTurboOff();
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.startAllCars();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.stopAllCars();
            }
        });
        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.scaniaLiftBed();
            }
        });
        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.scaniaLowerBed();
            }
        });
        addcarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addCarWithPosition();
            }
        });
        removebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.remove();
            }
        });
    }


    public void buttons() {
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, //initial value
                0, //min
                100, //max
                1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);


        controlPanel.setLayout(new GridLayout(2, 5));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(addcarbutton,3);
        controlPanel.add(startButton,4);

        controlPanel.add(brakeButton, 5);
        controlPanel.add(turboOffButton, 6);
        controlPanel.add(lowerBedButton, 7);
        controlPanel.add(removebutton, 8);
        controlPanel.add(stopButton,9);



        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        controlPanel.setBackground(Color.CYAN);

    }
}