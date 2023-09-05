import com.mindfusion.common.DateTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

class ReminderFrame implements ActionListener, frame {
    LinkedList<String> startTimesRead = loadFromFile(LoginPage.nameOfUser + " Event Start Times");
    LinkedList<String> eventNamesRead = loadFromFile(LoginPage.nameOfUser + " Event Names");
    LinkedList<String> remindersForToday = new LinkedList<String>();

    JFrame frame = new JFrame();
    private JButton backToMainPageButton = new JButton("Back to Main Page");
    private JButton viewCalendarButton = new JButton("View Your Calendar");
    private JButton viewToDoList = new JButton("Add to Your To-Do list");
    private JLabel noReminders = new JLabel("No Reminders for Today!");
    private JLabel info = new JLabel("Here are your reminders for today:");
    private JLabel reminders = new JLabel("", SwingConstants.CENTER);



    public ReminderFrame(){
        frame.setSize(Main.WIDTH, Main.HEIGHT);
        frame.setTitle(" \t \t \t \t Reminders for Today");

        backToMainPageButton.setBounds(40, 5, 200, 25);
        backToMainPageButton.setFocusable(false);
        backToMainPageButton.addActionListener(this);

        viewCalendarButton.setBounds(800, 5, 200, 25);
        viewCalendarButton.setFocusable(false);
        viewCalendarButton.addActionListener(this);

        viewToDoList.setBounds(800, 35, 200, 25);
        viewToDoList.setFocusable(false);
        viewToDoList.addActionListener(this);

        noReminders.setBounds(Main.WIDTH/2 - 100, Main.HEIGHT/2 - 25, 200,50);
        noReminders.setText("No Reminders for Today!");
        noReminders.setLayout(null);
        noReminders.setVisible(false);

        info.setBounds(360, 50, 400,25);
        info.setText("Here are your reminders for today:");
        info.setFont(new Font("Verdana", Font.PLAIN, 16));
        info.setLayout(null);
        info.setVisible(false);

        reminders.setBounds(100, 100, 824, 585);
        reminders.setLayout(null);
        reminders.setVerticalAlignment(JLabel.TOP);
        reminders.setFont(new Font("Verdana", Font.PLAIN, 14));
        reminders.setOpaque(true);
        reminders.setBackground(Color.LIGHT_GRAY);

        // obtain only activities from today
        for(int i = 0; i < startTimesRead.size(); i++) {
            String startStr = startTimesRead.get(i);
            startStr = startStr.split("Greenwich")[0];
            startStr = startStr.replaceAll(" AM ", " ");
            startStr = startStr.replaceAll(" PM ", " ");
            startStr = startStr.replaceAll(",", " ");
            String startDate = startStr.split("  ")[0];
            String startTime = startStr.split("  ")[1];

            String stringStartMonth = startDate.split("/")[0].replaceAll(" ", "");
            String stringStartDay = startDate.split("/")[1].replaceAll(" ", "");
            ;
            String stringStartYear = startDate.split("/")[2].replaceAll(" ", "");
            ;
            String stringStartHour = startTime.split(":")[0].replaceAll(" ", "");
            String stringStartMinute = startTime.split(":")[1].replaceAll(" ", "");
            String stringStartSecond = startTime.split(":")[2].replaceAll(" ", "");
            int startMonth = Integer.parseInt(stringStartMonth);
            int startDay = Integer.parseInt(stringStartDay);
            int startYear = Integer.parseInt(stringStartYear);
            int startHour = Integer.parseInt(stringStartHour);
            int startMinute = Integer.parseInt(stringStartMinute);
            int startSecond = Integer.parseInt(stringStartSecond);

            DateTime start = new DateTime(startYear + 2000, startMonth, startDay, startHour, startMinute, startSecond);

            if (start.getDate().equals(DateTime.today().getDate())) {
                remindersForToday.add(eventNamesRead.get(i));
            }
            System.out.println(remindersForToday.toString());
        }

        if(remindersForToday.size() == 0){
            noReminders.setVisible(true);
        } else{
            info.setVisible(true);
            reminders.setText("<html> <br/>");
            for (int i = 0; i < remindersForToday.size(); i++){
                reminders.setText(reminders.getText() + (i + 1) + "." + remindersForToday.get(i) + "<br/> <br/>");
               // reminders.setText(reminders.getText() + remindersForToday.get(i) + "\n");
            }

            reminders.setText(reminders.getText() + "</html>");
        }

        frame.add(noReminders);
        frame.add(backToMainPageButton);
        frame.add(viewCalendarButton);
        frame.add(viewToDoList);
        frame.add(info);
        frame.add(reminders);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void setVisible(boolean b){
        frame.setVisible(b);
    }

    public static LinkedList<String> loadFromFile(String fileName) {

        LinkedList<String> eventDetailFromFile = new LinkedList<String>();

        try {

            File input = new File(fileName);
            Scanner sc = new Scanner(input);

            while (sc.hasNextLine()) {
                eventDetailFromFile.add(sc.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.out.println(e);
        }


        return eventDetailFromFile;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backToMainPageButton){
            new ChoicePage();
            frame.dispose();
        } else if(e.getSource() == viewCalendarButton){
            new CalendarFramework().setVisible(true);
            frame.dispose();
        } else if(e.getSource() == viewToDoList){
            new AppFrame().setVisible(true);
            frame.dispose();
        }

    }
}
