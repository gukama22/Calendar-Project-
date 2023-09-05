import com.mindfusion.common.DateTime;
import com.mindfusion.scheduling.awt.AwtCalendar;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Calendar extends JFrame {

    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;

    AwtCalendar calendar;

    Calendar(){{
        // shut down when exit button is pressed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set window size
        setSize(WIDTH, HEIGHT);

        BorderLayout layout = new BorderLayout();
        getContentPane().setLayout(layout);

        calendar = new AwtCalendar();

        // initialize the calendar
        calendar.beginInit();

        // set the current time
        calendar.setCurrentTime(DateTime.now());

        JButton backToMainPageButton = new JButton("Back to Main Page");
        backToMainPageButton.setBounds(100, 3, 200, 23);
        backToMainPageButton.setVisible(true);
        backToMainPageButton.setFocusable(false);
        backToMainPageButton.setOpaque(true);
        backToMainPageButton.setBackground(Color.magenta);

        getContentPane().add(backToMainPageButton);

        LinkedList<String> startTimesRead = loadFromFile(LoginPage.nameOfUser + " Event Start Times");
        int numActivitiesToday = 0;
        for (int i = 0; i < startTimesRead.size(); i++){
            String startStr = startTimesRead.get(i);
            startStr = startStr.split("Greenwich")[0];
            startStr = startStr.replaceAll(" AM ", " ");
            startStr = startStr.replaceAll(" PM ", " ");
            startStr = startStr.replaceAll(",", " ");
            String startDate = startStr.split("  ")[0];
            String startTime = startStr.split("  ")[1];

            String stringStartMonth = startDate.split("/")[0].replaceAll(" ","");
            String stringStartDay = startDate.split("/")[1].replaceAll(" ","");;
            String stringStartYear = startDate.split("/")[2].replaceAll(" ","");;
            String stringStartHour = startTime.split(":")[0].replaceAll(" ","");
            String stringStartMinute = startTime.split(":")[1].replaceAll(" ", "");
            String stringStartSecond = startTime.split(":")[2].replaceAll(" ", "");
            int startMonth = Integer.parseInt(stringStartMonth);
            int startDay = Integer.parseInt(stringStartDay);
            int startYear = Integer.parseInt(stringStartYear);
            int startHour = Integer.parseInt(stringStartHour);
            int startMinute = Integer.parseInt(stringStartMinute);
            int startSecond = Integer.parseInt(stringStartSecond);

            DateTime start = new DateTime(startYear + 2000, startMonth, startDay, startHour, startMinute, startSecond);

            if(start == DateTime.today()){
                numActivitiesToday++;
            }
        }

        // display the calendar on the content pane
        getContentPane().add(calendar, BorderLayout.CENTER);

        backToMainPageButton.addActionListener(e -> takeBackToMainPage());

        calendar.endInit();

        setVisible(false);

    }

    }

    private void takeBackToMainPage() {

        setVisible(false);
        new ChoicePage();

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

}
