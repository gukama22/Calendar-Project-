import com.mindfusion.common.DateTime;
import com.mindfusion.scheduling.CalendarAdapter;
import com.mindfusion.scheduling.CalendarView;
import com.mindfusion.scheduling.model.Appointment;
import com.mindfusion.scheduling.model.ItemEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;


public class DayView extends Calendar implements frame{

    File outputNames = new File(LoginPage.nameOfUser + " Event Names");
    File outputStartTimes = new File(LoginPage.nameOfUser + " Event Start Times");
    File outputEndTimes = new File(LoginPage.nameOfUser + " Event End Times");

    String eventName;
    DateTime startTime;
    DateTime endTime;

    LinkedList<String> eventNames = new LinkedList<String>();
    LinkedList<DateTime> eventStartTimes = new LinkedList<DateTime>();
    LinkedList<DateTime> eventEndTimes = new LinkedList<DateTime>();

    int theme = ThemeFrame.themeNum;

    DayView(DateTime dateClicked){

        // title the window
        setTitle("Calendar Day View");

        //sets date to whatever date was clicked in the Main calendar frame
        calendar.setDate(dateClicked);

        // highlight the current date
        calendar.getSelection().set(dateClicked);

        calendar.setCurrentView(CalendarView.Timetable);

        calendar.getMonthSettings().getDaySettings().setHeaderSize(20);

        // some stylistic choices
        calendar.getTimetableSettings().setShowNavigationButtons(true);
        calendar.getTimetableSettings().setShowDayHeader(true);
        calendar.getTimetableSettings().getDates().add(dateClicked);
        calendar.getTimetableSettings().getShowDayHeader();
        calendar.setTheme(theme);

        JButton backToMonthView = new JButton("Back to Month View");
        backToMonthView.setBounds(750, 3, 200, 23);
        backToMonthView.setFocusable(false);
        backToMonthView.setVisible(true);
        backToMonthView.setOpaque(true);
        backToMonthView.setBackground(Color.magenta);

        // Read from Files
        LinkedList<String> eventNamesRead = loadFromFile(LoginPage.nameOfUser + " Event Names");
        LinkedList<String> startTimesRead = loadFromFile(LoginPage.nameOfUser + " Event Start Times");
        LinkedList<String> endTimesRead = loadFromFile(LoginPage.nameOfUser + " Event End Times");


        // Populate calendar with information from linked lists
        for (int i = 0; i < eventNamesRead.size(); i++){

            // Get start and end times
            String startStr = startTimesRead.get(i);
            String endStr = endTimesRead.get(i);

            // Convert start and end times into the appropriate String format
            startStr = startStr.split("Greenwich")[0];
            startStr = startStr.replaceAll(" AM ", " ");
            startStr = startStr.replaceAll(" PM ", " ");
            startStr = startStr.replaceAll(",", " ");
            endStr = endStr.split("Greenwich")[0];
            endStr = endStr.replaceAll(" AM ", " ");
            endStr = endStr.replaceAll(" PM ", " ");
            endStr = endStr.replaceAll(",", " ");


            // Get the date and time separately
            String startDate = startStr.split("  ")[0];
            String startTime = startStr.split("  ")[1];
            String endDate = endStr.split("  ")[0];
            String endTime = endStr.split("  ")[1];


            // Get individual values
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

            String stringEndMonth = endDate.split("/")[0].replaceAll(" ","");
            String stringEndDay = endDate.split("/")[1].replaceAll(" ","");;
            String stringEndYear = endDate.split("/")[2].replaceAll(" ","");;
            String stringEndHour = endTime.split(":")[0].replaceAll(" ","");
            String stringEndMinute = endTime.split(":")[1].replaceAll(" ", "");
            String stringEndSecond = endTime.split(":")[2].replaceAll(" ", "");
            int endMonth = Integer.parseInt(stringEndMonth);
            int endDay = Integer.parseInt(stringEndDay);
            int endYear = Integer.parseInt(stringEndYear);
            int endHour = Integer.parseInt(stringEndHour);
            int endMinute = Integer.parseInt(stringEndMinute);
            int endSecond = Integer.parseInt(stringEndSecond);

            // This outputs the correct datetime from event start times and event end times for each activity
            DateTime start = new DateTime(startYear + 2000, startMonth, startDay, startHour, startMinute, startSecond);
            DateTime end = new DateTime(endYear + 2000, endMonth, endDay, endHour, endMinute, endSecond);
            System.out.println(start);
            System.out.println(end);


            // Using the time and event name, populate the calendar.
            Appointment app = new Appointment();
            app.setStartTime(start);
            app.setEndTime(end);
            app.setHeaderText(eventNamesRead.get(i));
            calendar.getSchedule().getItems().add(app);
            //calendar.ensureVisible(app);

        }

        // display the calendar on the content pane
        getContentPane().add(backToMonthView);
        getContentPane().add(calendar, BorderLayout.CENTER);


        backToMonthView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                takeBackToMonthView();
            }
        });

        calendar.addCalendarListener(new CalendarAdapter(){
            @Override
            public void itemInplaceEdited(ItemEvent itemEvent){
                super.itemInplaceEdited(itemEvent);

                whenItemIsEdited(itemEvent);
            }
        });

    }


    private void takeBackToMonthView(){

        setVisible(false);
        new CalendarFramework().setVisible(true);
    }

    private void whenItemIsEdited(ItemEvent itemEvent){
        System.out.println("Inside item is edited method");

        eventName = itemEvent.getItem().getHeaderText();

        startTime = itemEvent.getItem().getStartTime();

        endTime = itemEvent.getItem().getEndTime();

        System.out.println(eventName);



        eventNames.add(eventName);
        eventStartTimes.add(startTime);
        eventEndTimes.add(endTime);


        // edit activities
        if (eventStartTimes.contains(startTime) && eventEndTimes.contains(endTime) && eventName == null){
            int index = eventStartTimes.indexOf(startTime);
            eventNames.remove(index);
            eventStartTimes.remove(index);
            eventEndTimes.remove(index);
        }



        System.out.println(eventNames.toString());


        // delete activities -- FIX! NOT WORKING PROPERLY!
        /*if(eventName.equals(" ")){
            int index = eventStartTimes.indexOf(startTime);
            eventNames.remove(index);
            eventStartTimes.remove(index);
            eventEndTimes.remove(index);
        }*/

        // Store activities --CHANGE USERID!!
        /*for(int i = 0; i < eventNames.size(); i++){
            activities.add(new Activity(1, eventNames.get(i), eventStartTimes.get(i), eventEndTimes.get(i)));
        }*/

        // Duplicate code below -- clean that up later!
        // THIS WRITES TO FILE IN THE MOMENT BUT DOESN'T ADD TO FILE!

        // Store event names
        try {
            FileWriter outputPrinter = new FileWriter(outputNames, true);


            outputPrinter.write(" " + eventName);
            outputPrinter.write("\n");

            outputPrinter.close();

        } catch (IOException e) {
            System.err.println("File not found.");
            System.err.println(e);
        }



        // Store event start times
        try {
            FileWriter outputPrinter = new FileWriter(outputStartTimes, true);

            outputPrinter.write(" " + startTime);
            outputPrinter.write(" " + endTime);
            outputPrinter.write("\n");

            outputPrinter.close();

        } catch (IOException e) {
            System.err.println("File not found.");
            System.err.println(e);
        }


        // Store event end times
        try {
            FileWriter outputPrinter = new FileWriter(outputEndTimes, true);

            outputPrinter.write(" " + endTime);
            outputPrinter.write("\n");

            outputPrinter.close();

        } catch (IOException e) {
            System.err.println("File not found.");
            System.err.println(e);
        }

    }

}


