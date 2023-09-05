//
//  keep track of start times and end times. .. each events will be in the linkedlist and then

/**
 * goals; try to keep the name of the person that logged in and refer to them on the title right next to calendar and to do app label
 */

// display beginning has to have an interface

import javax.swing.*;

public class Main extends JFrame {


    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;



    // add recurrence later!!


    public static void main(String[] args) {

        // displays what is happening in Main using Java Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                // add a while true line to update calendar!!?? ****

                try {
                    // set visible on display window
                    /**
                     * this will call these two classes and if you are able to successfully
                     * login In your account, the calendar and todoapp will be called from the loginPage.
                     *
                     * Also, as for now you may not want or feel like you have the time to enter a new userID,
                     * open ID and passwords aclass nd pickup one of the IDs and passwords combinations you want to use and use them to
                     * sign In and login and Boom the calendar will appear.
                     */
                    IDsandPasswords idandpasswords = new IDsandPasswords();
                    new LoginPage(idandpasswords.getLoginInfo());

                    /**
                     * those that follow are to be uncommented only when you want things to be easier
                     * and you want to add the to do list and  mainclass without having to pass through the LoginPage
                     *
                     */
//                    new MainClass().setVisible(true);
//                    new AppFrame();

                    // edit to store login info/ userID

                } catch (Exception exception) {

                }
            }
        });

    }


    CalendarOwner owner1 = new CalendarOwner("John", "Doe");
    //System.out.println(owner1.getUserID());
    CalendarOwner owner2 = new CalendarOwner("Jane", "Doe");
    //System.out.println(owner2.getUserID());

    // Testing calendar framework will access user ID's in the end
    //CalendarFramework calendarFramework = new CalendarFramework(owner1.getUserID());


}


