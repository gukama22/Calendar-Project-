import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** This will allow a user to make a choice on which part of our app they want to see first after logging into the app/*
 *
 */

public class ThemeFrame implements ActionListener, frame {

    // 1 - LILAC
    // 2 - PINK
    // 3 - SILVER
    // 4 - DARK MODE

    static int themeNum;

    JFrame frame = new JFrame();

    //buttons
    JButton theme1 = new JButton("Lilac");
    JButton theme2 = new JButton("Pink");
    JButton theme3 = new JButton("Silver");
    JButton theme4 = new JButton("Dark");


    //label
    JLabel info = new JLabel(LoginPage.nameOfUser + ", What theme would you like for your calendar?");

    ThemeFrame(){
        info.setBounds(300, 200, 450,25);
        //info.setBackground(Color.magenta);
        info.setText("Dear " + LoginPage.nameOfUser + ", What theme would you like for your calendar?");
        info.setLayout(null);
        info.setVisible(true);

        theme1.setBounds(360, 300, 200, 35);
        theme1.addActionListener(this);
        theme1.setFocusable(false);
        theme1.setBackground(Color.CYAN);

        theme2.setBounds(360, 400, 200, 35);
        theme2.addActionListener(this);
        theme2.setFocusable(false);
        theme2.setBackground(Color.CYAN);

        theme3.setBounds(360, 500, 200, 35);
        theme3.addActionListener(this);
        theme3.setFocusable(false);
        theme3.setBackground(Color.CYAN);

        theme4.setBounds(360, 600, 200, 35);
        theme4.addActionListener(this);
        theme4.setFocusable(false);
        theme4.setBackground(Color.CYAN);

        frame.add(info);
        frame.add(theme1);
        frame.add(theme2);
        frame.add(theme3);
        frame.add(theme4);

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

        if(e.getSource() == theme1){
            themeNum = 1;
            new CalendarFramework().setVisible(true);
            new AppFrame().setVisible(false);
            new ReminderFrame().setVisible(false);
            frame.dispose();
        } else if(e.getSource() == theme2){
            themeNum = 2;
            new CalendarFramework().setVisible(true);
            new AppFrame().setVisible(false);
            new ReminderFrame().setVisible(false);
            frame.dispose();
        } else if(e.getSource() == theme3) {
            themeNum = 3;
            new CalendarFramework().setVisible(true);
            new AppFrame().setVisible(false);
            new ReminderFrame().setVisible(false);
            frame.dispose();
        } else if(e.getSource() == theme4) {
            themeNum = 4;
            new CalendarFramework().setVisible(true);
            new AppFrame().setVisible(false);
            new ReminderFrame().setVisible(false);
            frame.dispose();
        }
    }
}
