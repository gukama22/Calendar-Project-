import com.mindfusion.common.DateTime;
import com.mindfusion.scheduling.CalendarAdapter;
import com.mindfusion.scheduling.CalendarView;
import com.mindfusion.scheduling.DayOfWeekFormat;
import com.mindfusion.scheduling.ResourceDateEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarFramework extends Calendar implements Doable, ActionListener, frame {

    int theme = ThemeFrame.themeNum;

    CalendarFramework() {

        // title the window
        setTitle("Calendar");

        // set the current date
        DateTime today = DateTime.today();
        calendar.setDate(today);

        // highlight the current date
        calendar.getSelection().set(DateTime.today());

        // set calendar view -- month, week, etc
        // may be important for task tab! -- could also add buttons for changing default view using this method!
        calendar.setCurrentView(CalendarView.SingleMonth);

        calendar.getMonthSettings().setShowDayOfWeek(true);

        // calendar.setCustomDraw(CustomDrawElements.CalendarItem); ***

        // can be changed to month, week, etc
        calendar.getMonthSettings().getDaySettings().setHeaderSize(20);
        calendar.getMonthSettings().setDayOfWeekFormat(DayOfWeekFormat.Abbreviated);

        calendar.setTheme(theme);

        // Handling user clicks on a specific date
        calendar.addCalendarListener(new CalendarAdapter() {

            public void dateClick(ResourceDateEvent e) {

                // calling method to expand when date is clicked -- defined below
                whenDateIsClicked(e);

                System.out.println("Inside date click adapter");

            }

        });


    }


    private void whenDateIsClicked(ResourceDateEvent e) {

        System.out.println("Inside date click method");

        setVisible(false);

        new DayView(e.getDate()).setVisible(true);

    }










    private int userID;

    /*public CalendarFramework(int userID) {
        this.userID = userID;
    }*/

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


    @Override
    public void addActivity(Activity a) {

    }

    @Override
    public void editActivity(Activity a) {

    }

    @Override
    public void deleteActivity(Activity a) {

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }


    // add, edit, delete activities and tasks above

    // if statement to populate reminders tab below!

    // call it all in grid/ main.

}


