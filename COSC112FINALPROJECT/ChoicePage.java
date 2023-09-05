import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** This will allow a user to make a choice on which part of our app they want to see first after logging into the app/*
 *
 */

public class ChoicePage implements ActionListener, frame {

    JFrame frame = new JFrame();

    //buttons
    JButton calendarApp = new JButton("View Calendar");
    JButton toDoApp = new JButton("View To-Do List");
    JButton remindersApp = new JButton("View Reminders for Today");


    //label
    JLabel info = new JLabel("Welcome " + LoginPage.nameOfUser+ "What would you like to view?");

    ChoicePage(){
        info.setBounds(300, 200, 400,25);
        info.setBackground(Color.magenta);
        info.setText("Dear " + LoginPage.nameOfUser + ", What would you like to view?");
        info.setLayout(null);
        info.setVisible(true);

        calendarApp.setBounds(360, 300, 200, 35);
        calendarApp.addActionListener(this);
        calendarApp.setFocusable(false);
        calendarApp.setBackground(Color.CYAN);

        toDoApp.setBounds(360, 400, 200, 35);
        toDoApp.addActionListener(this);
        toDoApp.setFocusable(false);
        toDoApp.setBackground(Color.CYAN);

        remindersApp.setBounds(360, 500, 200, 35);
        remindersApp.addActionListener(this);
        remindersApp.setFocusable(false);
        remindersApp.setBackground(Color.CYAN);

        frame.add(info);
        frame.add(calendarApp);
        frame.add(toDoApp);
        frame.add(remindersApp);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(Main.WIDTH, Main.HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void setVisible(boolean b){
        frame.setVisible(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == calendarApp){
            new ThemeFrame().setVisible(true);
            new CalendarFramework().setVisible(false);
            new AppFrame().setVisible(false);
            new ReminderFrame().setVisible(false);
            frame.dispose();
        } else if (e.getSource() == toDoApp){
            new AppFrame();
            new CalendarFramework().setVisible(false);
            new ReminderFrame().setVisible(false);
            new ThemeFrame().setVisible(false);
            frame.dispose();
        } else if (e.getSource() == remindersApp){
            new ReminderFrame();
            new CalendarFramework().setVisible(false);
            new AppFrame().setVisible(false);
            new ThemeFrame().setVisible(false);
            frame.dispose();
        } }}
