import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 * this will allow us to sign in, sign up, login...
 * the calendar and todo app drawings are called at around lign344
 * get the messageLabel to display the specific errors one made or their progress while logging in
 */


// the parameter have to be set up to receive a hashmap.
public class LoginPage implements ActionListener {

    Random rand = new Random(89);

    public int anint = rand.nextInt(60) + 40;


    // a copy of each hashmap that will be accessible by other methods;
    HashMap<Object, Object> loginInfo = new HashMap<>();

    JFrame jframe = new JFrame();

    // should this be static or not??
    public static String nameOfUser;

    /**
     * Later in hte program.
     */
    // buttons
    JButton returnMainPage = new JButton(" Go-Back");
    JButton loginButton = new JButton("LogIn");
    JButton resetButton = new JButton(" Reset");


    // the labels
    JLabel userLabel = new JLabel(" Username");
    JLabel passwordLabel = new JLabel(" Password");
    JLabel messageLabel = new JLabel();

    // the fields
    //JField is specific for passwordfield so that whatever you enter is not visible to the screen
    JPasswordField PasswordField = new JPasswordField();
    JTextField userIdField = new JTextField();

    /**
     * In the beginning.
     */
    JButton signInButton = new JButton("SignIn");
    JButton signUpButton = new JButton("SignUp");

    //for the fields
    JPasswordField passwordRegistrationField = new JPasswordField();
    JPasswordField verificationPasswordRegistrationField = new JPasswordField();
    JTextField userRegistrationField = new JTextField();

    //for the labels
    JLabel userRegistrationLabel = new JLabel(" UserName");
    JLabel passwordregistrationlabel = new JLabel(" Password");
    JLabel verificationpasswordlabel = new JLabel(" Password");

    // for the buttons.
    JButton RegisterButton = new JButton("Register");
    JButton CancelButton = new JButton("Cancel");


    LoginPage(HashMap<Object, Object> loginInfoPassed) {
        this.loginInfo = loginInfoPassed;

        /**
         * change this please; it's the message label
         */
        messageLabel.setBounds((Main.WIDTH / 2) - (Main.WIDTH / 3), (Main.HEIGHT / 2) + (Main.HEIGHT / 15), 900, 30);
        messageLabel.setFont(new Font(null, Font.ITALIC, 19));


        /**
         * later
         */

        // label
        userLabel.setBounds((Main.WIDTH / 2) - (Main.WIDTH / 4), (Main.HEIGHT / 2) - (Main.HEIGHT / 3), 75, 30);
        userLabel.setForeground(new Color(102, 0, 153));

        passwordLabel.setBounds((Main.WIDTH / 2) - (Main.WIDTH / 4), (Main.HEIGHT / 2) - (Main.HEIGHT / 5), 75, 30);
        passwordLabel.setForeground(new Color(102, 0, 153));


        // fields
        userIdField.setBounds((Main.WIDTH / 2) - (Main.WIDTH / 6), (Main.HEIGHT / 2) - (Main.HEIGHT / 3), 300, 30);
        PasswordField.setBounds((Main.WIDTH / 2) - (Main.WIDTH / 6), (Main.HEIGHT / 2) - (Main.HEIGHT / 5), 300, 30);


        // buttons in the beginning.

        loginButton.setBounds((Main.WIDTH / 2) - (Main.WIDTH / 6), (Main.HEIGHT / 2) + (Main.HEIGHT / 6), 100, 30);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);
        loginButton.setBackground(new Color(204, 204, 255));

        resetButton.setBounds((Main.WIDTH / 2) - (Main.WIDTH / 15), (Main.HEIGHT / 2) + (Main.HEIGHT / 6), 100, 30);
        resetButton.addActionListener(this);
        resetButton.setBackground(new Color(204, 204, 255));
        resetButton.setFocusable(false);

        returnMainPage.setBounds(Main.WIDTH / 2 - Main.WIDTH / 10, (Main.HEIGHT) - (Main.HEIGHT / 10), 100, 30);
        returnMainPage.addActionListener(this);
        returnMainPage.setBackground(new Color(229, 255, 204));
        returnMainPage.setFocusable(false);


        /**
         *  in the beginning
         */

// buttons in the beginning.
        signInButton.setBounds((Main.WIDTH / 2) - (Main.WIDTH / 4), Main.HEIGHT / 3, 150, 60);
        signInButton.setFocusable(false);
        signInButton.setBackground(new Color(153, 153, 255));
        signInButton.addActionListener(this);

        signUpButton.setBounds((Main.WIDTH / 2) + (Main.WIDTH / 6), Main.HEIGHT / 3, 150, 60);
        signUpButton.setFocusable(false);
        signUpButton.setBackground(new Color(153, 153, 255));
        signUpButton.addActionListener(this);

        jframe.add(signInButton);
        jframe.add(signUpButton);

        /**
         * after signIning, these are the variables that will be added.
         */


        // labels
        userRegistrationLabel.setBounds((Main.WIDTH / 2) - (Main.WIDTH / 4), (Main.HEIGHT / 2) - (Main.HEIGHT / 3), 75, 30);
        userRegistrationLabel.setForeground(new Color(255 - 102 - 0));

        passwordregistrationlabel.setBounds((Main.WIDTH / 2) - (Main.WIDTH / 4), (Main.HEIGHT / 2) - (Main.HEIGHT / 5), 75, 30);
        passwordregistrationlabel.setForeground(new Color(255 - 102 - 0));

        verificationpasswordlabel.setBounds((Main.WIDTH / 2) - (Main.WIDTH / 4), (Main.HEIGHT / 2) - (Main.HEIGHT / 8), 75, 30);
        verificationpasswordlabel.setForeground(new Color(255 - 102 - 0));

        userRegistrationField.setBounds((Main.WIDTH / 2) - (Main.WIDTH / 6), (Main.HEIGHT / 2) - (Main.HEIGHT / 3), 300, 30);
        passwordRegistrationField.setBounds((Main.WIDTH / 2) - (Main.WIDTH / 6), (Main.HEIGHT / 2) - (Main.HEIGHT / 5), 300, 30);
        verificationPasswordRegistrationField.setBounds((Main.WIDTH / 2) - (Main.WIDTH / 6), (Main.HEIGHT / 2) - (Main.HEIGHT / 8), 300, 30);


        RegisterButton.setBounds((Main.WIDTH / 2) - (Main.WIDTH / 6), (Main.HEIGHT / 2) + (Main.HEIGHT / 6), 100, 30);
        RegisterButton.addActionListener(this);
        RegisterButton.setBackground(new Color(255, 204, 255));
        RegisterButton.setFocusable(false);


        CancelButton.setBounds((Main.WIDTH / 2) - (Main.WIDTH / 15), (Main.HEIGHT / 2) + (Main.HEIGHT / 6), 100, 30);
        CancelButton.setBackground((new Color(255, 204, 255)));
        CancelButton.setFocusable(false);
        CancelButton.addActionListener(this);


        jframe.add(signInButton);
        jframe.add(signUpButton);

        /**
         * remove this from here
         */


        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setSize(Main.WIDTH, Main.HEIGHT);
        // what follows prevents IntelliJ from handling the layouts or what is displayed with pre-conceived values?
        jframe.setForeground(Color.DARK_GRAY);
        jframe.setLayout(null);
        jframe.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == returnMainPage) {
            jframe.dispose();
            jframe.getContentPane().removeAll();

            jframe.add(signInButton);
            jframe.add(signUpButton);

            jframe.setLayout(null);
            jframe.setVisible(true);

        }
        if (e.getSource() == signInButton) {


            jframe.dispose();
            jframe.getContentPane().removeAll();
            jframe.setBackground(Color.red);
            jframe.add(userLabel);
            jframe.add(passwordLabel);
            jframe.add(userIdField);
            jframe.add(PasswordField);
            jframe.add(loginButton);
            jframe.add(resetButton);
            jframe.add(returnMainPage);
            messageLabel.setForeground(new Color (102 - 51 - 0));
            messageLabel.setText("You are in the process of retrieving your account and your details.");
            jframe.add(messageLabel);
            jframe.setVisible(true);

        }


        if (e.getSource() == CancelButton) {
            /*
            set out userandPassword fields to empty
             clearing what is inside
            */
            jframe.dispose();
            jframe.getContentPane().removeAll();

            jframe.add(signInButton);
            jframe.add(signUpButton);

            jframe.setLayout(null);
            jframe.setVisible(true);

        }


        if (e.getSource() == signUpButton) {
            // they have to enter the new Datas
            jframe.dispose();
            jframe.getContentPane().removeAll();

            // adding the labels
            jframe.add(userRegistrationLabel);
            jframe.add(passwordregistrationlabel);
            jframe.add(verificationpasswordlabel);

            // adding the fields
            jframe.add(userRegistrationField);
            jframe.add(passwordRegistrationField);
            jframe.add(verificationPasswordRegistrationField);

            // adding the relevant buttons.
            jframe.add(RegisterButton);
            jframe.add(CancelButton);

            messageLabel.setForeground(new Color(102 - 51 - 0));
            messageLabel.setText("You are in the process of signing up to our app; we are " + anint + "% excited about that ");
            jframe.add(messageLabel);

            jframe.setVisible(true);
        }

        if (e.getSource() == RegisterButton) {
            if (!userRegistrationField.getText().isEmpty()) {
                String userIDtemporary = (String) userRegistrationField.getText();
                if (!(String.valueOf(passwordRegistrationField.getPassword()).isEmpty()) && (
                        (!(String.valueOf((verificationPasswordRegistrationField.getPassword())).isEmpty())
                        ))) {
                    String passwordtemporary = String.valueOf(passwordRegistrationField.getPassword());
                    String otherpasswordtemporary = String.valueOf(verificationPasswordRegistrationField.getPassword());

                    if (passwordtemporary.equals(otherpasswordtemporary)) {

                        loginInfo.put(userIDtemporary, passwordtemporary);
                        messageLabel.setForeground(new Color(102 - 51 - 0));
                        messageLabel.setText("You have successfully entered your information");
                        jframe.add(messageLabel);
                        jframe.setVisible(true);

                        /**
                         * after this a message should pop up and wish them a warm welcome
                         */

                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true));
                            writer.write("\n" + userIDtemporary);
                            // had to add \n for the next line
                            writer.write("\n" + passwordtemporary + " \n\n");
                            writer.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                            System.out.println(" Eror message while registering");
                        }
                        nameOfUser();

                        jframe.dispose();

                        jframe.getContentPane().removeAll();
                        jframe.add(userLabel);
                        jframe.add(passwordLabel);
                        jframe.add(userIdField);
                        jframe.add(PasswordField);
                        jframe.add(loginButton);
                        jframe.add(resetButton);
                        jframe.setVisible(true);


                    } else {
                        messageLabel.setForeground(new Color(153-0-76));
                        messageLabel.setText("Oopsie! The passwords you have entered aren't the same");
                        jframe.add(messageLabel);
                        jframe.setVisible(true);
                    }
                } else {
                    messageLabel.setForeground(Color.magenta);
                    messageLabel.setText("Make sure that you entered your password");
                    jframe.add(messageLabel);
                    jframe.setVisible(true);
                }
            } else {
                // change the message here.
                messageLabel.setForeground(new Color(153-0-76));
                messageLabel.setText("Make sure you entered the right username");
                jframe.add(messageLabel);
                jframe.setVisible(true);
            }
        }


        if (e.getSource() == resetButton) {
            userIdField.setText("");
            PasswordField.setText("");
            jframe.setVisible(true);
        }


        if (e.getSource() == loginButton) {


            String userIDtemp = (String) userIdField.getText();
            String passwordtemp = String.valueOf(PasswordField.getPassword());

            // going in the data collection of passwords and usernames.
            LinkedList<Object> lines = new LinkedList<Object>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
                // read the whole file;
                //

                String line;
                /**
                 * we can create our own data collection
                 */
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
                reader.close();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            // because it's a pair, we have to make sure that the key refers to the same value
            if (!userIdField.getText().isEmpty()) {
                if (!String.valueOf(PasswordField.getPassword()).isEmpty()) {
                    if ((loginInfo.containsKey(userIDtemp)) || (lines.contains(userIDtemp))) {
                        if ((loginInfo.containsValue(passwordtemp)) || (lines.contains(userIDtemp))) {

                            messageLabel.setForeground(new Color(153-0-76));
                            messageLabel.setText(" You have successfully logged in \n Welcome to your calendar app!");
                            jframe.setLayout(null);
                            jframe.add(messageLabel);
                            jframe.setVisible(true);
                            // getting rid of the jframe
                            jframe.dispose();
                            /**
                             * switch this.
                             */
                            //new Main().setVisible(true);
                            nameOfUser = userIdField.getText();
                            nameOfUser();
                            new ChoicePage();

                        } else {
                            messageLabel.setForeground(new Color(153-0-76));
                            messageLabel.setText(" The passwords you have entered in are wrong");
                            jframe.setLayout(null);
                            jframe.add(messageLabel);
                            jframe.setVisible(true);
                        }
                    } else {
                        messageLabel.setForeground(new Color(153-0-76));
                        messageLabel.setText("Username is not found. Access to the calendar is denied");
                        jframe.setLayout(null);
                        jframe.add(messageLabel);
                        jframe.setVisible(true);
                    }
                } else {
                    messageLabel.setForeground(new Color(153-0-76));
                    messageLabel.setText("Your password field is empty.");
                    jframe.setLayout(null);
                    jframe.add(messageLabel);
                    jframe.setVisible(true);
                }
            } else {
                messageLabel.setForeground(new Color(153-0-76));
                messageLabel.setText("Your username field is empty.");
                jframe.setLayout(null);
                jframe.add(messageLabel);
                jframe.setVisible(true);
            }
        }
    }


    public void writeToFileTHeTODoS() {

        File tempFile = new File(nameOfUser() + "'s toDos.txt");
        boolean exists = tempFile.exists();
        if (exists == true) {
            try {
                BufferedWriter towrite = new BufferedWriter(new FileWriter(nameOfUser() + "'s toDo.txt"));
                towrite.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.out.println(" Eror message while registering");
            }

        } else {
            String name = nameOfUser();
            try {
                BufferedWriter justWrite = new BufferedWriter(new FileWriter(name + "'s toDo.txt", true));
                justWrite.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.out.println(" Eror message while registering");
            }

        }
    }

    public String nameOfUser() {
        // if nameOfUSer already exists in that array, then you don't need to create a new file since theoretically,
        // the file was created during the very first loggin in .
        if (!AllUsers.username.contains(nameOfUser)) {
            AllUsers.username.add(nameOfUser);
            writeToFileTHeTODoS();

        }
        return nameOfUser;
    }
}