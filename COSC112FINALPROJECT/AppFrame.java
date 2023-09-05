import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;


class AppFrame implements ActionListener, frame {

    // list of what all the activities that can be categorized as "Todo"
    private static LinkedList<String> whatToDo = new LinkedList<>();
    public LinkedList <String> newOnes = new LinkedList<>();


    JFrame aFrame = new JFrame();

    private JButton SaveButton = new JButton("Save");
    private JButton ClearButton = new JButton(" ClearAll");
    private JButton backToMainPageButton = new JButton("Back to Main Page");



    JButton clearFirst = new JButton("clear");
    JButton clearSecond = new JButton("clear");
    JButton clearThird = new JButton("clear");
    JButton clearFourth = new JButton("clear");
    JButton clearFifth = new JButton("clear");
    JButton clearSixth = new JButton("clear");
    JButton clearSeventh = new JButton("clear");
    JButton clearEighth = new JButton("clear");
    JButton clearNinth = new JButton("clear");
    JButton clearTenth = new JButton("clear");


    // should the field be private or public

    JTextField firstTaskField = new JTextField();
    JTextField secondTaskField = new JTextField();
    JTextField thirdTaskField = new JTextField();
    JTextField fourthTaskField = new JTextField();
    JTextField fifthTaskField = new JTextField();
    JTextField sixthTaskField = new JTextField();
    JTextField seventhTaskField = new JTextField();
    JTextField eighthTaskField = new JTextField();
    JTextField ninthTaskField = new JTextField();
    JTextField tenthTaskField = new JTextField();

    JLabel instructions = new JLabel();


    public AppFrame() {
        readFrom();

        aFrame.setSize(Main.WIDTH, Main.HEIGHT);
        aFrame.setTitle(" \t \t \t \t \t \t \t \t" + LoginPage.nameOfUser+ "'s ToDoApp");


        // optimization for this buttons so they show from the small view window
        SaveButton.setBounds(400, 600, 100, 25);
        SaveButton.addActionListener(this);
        SaveButton.setFocusable(false);

        ClearButton.setBounds(550, 600, 100, 25);
        ClearButton.addActionListener(this);
        ClearButton.setFocusable(false);

        backToMainPageButton.setBounds(40, 5, 200, 25);
        backToMainPageButton.setFocusable(false);
        backToMainPageButton.addActionListener(this);

        firstTaskField.setBounds(312, 100, 400, 20);
        firstTaskField.setBackground(new Color(204, 255, 229));

        secondTaskField.setBounds(312, 150, 400, 20);
        secondTaskField.setBackground(new Color(204, 255, 229));

        thirdTaskField.setBounds(312, 200, 400, 20);
        thirdTaskField.setBackground(new Color(204, 255, 229));

        fourthTaskField.setBounds(312, 250, 400, 20);
        fourthTaskField.setBackground(new Color(204, 255, 229));

        fifthTaskField.setBounds(312, 300, 400, 20);
        fifthTaskField.setBackground(new Color(204, 255, 229));

        sixthTaskField.setBounds(312, 350, 400, 20);
        sixthTaskField.setBackground(new Color(204, 255, 229));


        seventhTaskField.setBounds(312, 400, 400, 20);
        seventhTaskField.setBackground(new Color(204, 255, 229));

        eighthTaskField.setBounds(312, 450, 400, 20);
        eighthTaskField.setBackground(new Color(204, 255, 229));

        ninthTaskField.setBounds(312, 500, 400, 20);
        ninthTaskField.setBackground(new Color(204, 255, 229));

        tenthTaskField.setBounds(312, 550, 400, 20);
        tenthTaskField.setBackground(new Color(204, 255, 229));



        clearFirst.setBounds(815, 100, 100, 20);
        clearFirst.addActionListener(this);
        clearFirst.setBackground(new Color(255, 204, 204));
        clearFirst.setFocusable(false);



        clearSecond.setBounds(815, 150, 100, 20);
        clearSecond.addActionListener(this);
        clearSecond.setBackground(new Color(255, 204, 204));
        clearSecond.setFocusable(false);




        clearThird.setBounds(815, 200, 100, 20);
        clearThird.addActionListener(this);
        clearThird.setBackground(new Color(255, 204, 204));
        clearThird.setFocusable(false);




        clearFourth.setBounds(815, 250, 100, 20);
        clearFourth.addActionListener(this);
        clearFourth.setBackground(new Color(255, 204, 204));
        clearFourth.setFocusable(false);



        clearFifth.setBounds(815, 300, 100, 20);
        clearFifth.addActionListener(this);
        clearFifth.setBackground(new Color(255, 204, 204));
        clearFifth.setFocusable(false);




        clearSixth.setBounds(815, 350, 100, 20);
        clearSixth.addActionListener(this);
        clearSixth.setBackground(new Color(255, 204, 204));
        clearSixth.setFocusable(false);





        clearSeventh.setBounds(815, 400, 100, 20);
        clearSeventh.addActionListener(this);
        clearSeventh.setBackground(new Color(255, 204, 204));
        clearSeventh.setFocusable(false);



        clearEighth.setBounds(815, 450, 100, 20);
        clearEighth.addActionListener(this);
        clearEighth.setBackground(new Color(255, 204, 204));
        clearEighth.setFocusable(false);




        clearNinth.setBounds(815, 500, 100, 20);
        clearNinth.addActionListener(this);
        clearNinth.setBackground(new Color(255, 204, 204 ));
        clearNinth.setFocusable(false);



        clearTenth.setBounds(815, 550, 100, 20);
        clearTenth.addActionListener(this);
        clearTenth.setBackground(new Color(255, 204, 204));
        clearTenth.setFocusable(false);


        instructions.setBounds(300, 50, 2000, 25);
        instructions.setText(LoginPage.nameOfUser+ ", you may add new elements to your To-Do List. Remember to save any changes you make.");
        instructions.setLayout(null);
        instructions.setVisible(true);

        aFrame.setDefaultCloseOperation(aFrame.EXIT_ON_CLOSE);

        // what follows prevents IntelliJ from handling the layouts or what is displayed with pre-conceived values?
        aFrame.add(instructions);

        aFrame.add(firstTaskField);
        aFrame.add(secondTaskField);
        aFrame.add(thirdTaskField);
        aFrame.add(fourthTaskField);
        aFrame.add(fifthTaskField);
        aFrame.add(sixthTaskField);
        aFrame.add(seventhTaskField);
        aFrame.add(eighthTaskField);
        aFrame.add(ninthTaskField);
        aFrame.add(tenthTaskField);


        aFrame.add(clearFirst);


        aFrame.add(clearSecond);


        aFrame.add(clearThird);


        aFrame.add(clearFourth);


        aFrame.add(clearFifth);


        aFrame.add(clearSixth);


        aFrame.add(clearSeventh);


        aFrame.add(clearEighth);


        aFrame.add(clearNinth);


        aFrame.add(clearTenth);


        aFrame.add(SaveButton);
        aFrame.add(ClearButton);
        aFrame.add(backToMainPageButton);


        aFrame.setLayout(null);
        aFrame.setVisible(true);

    }

    public LinkedList<String> gettheLinkedlist() {
        return whatToDo;
    }

    public void gettheLinkedList(String toAdd) {
        whatToDo.add(toAdd);
    }

    @Override
    public void setVisible(boolean b) {
        aFrame.setVisible(b);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == SaveButton) {

            if ( !(firstTaskField.getText().isEmpty()) || (firstTaskField.getBackground() != new Color(153, 51, 255))){
                if (!whatToDo.contains(firstTaskField.getText())){
                    whatToDo.add((String) firstTaskField.getText());


                }}
            if ((!secondTaskField.getText().isEmpty()) || (secondTaskField.getBackground() != new Color(153, 51, 255))) {
                if (!whatToDo.contains(secondTaskField.getText())){
                    whatToDo.add((String) secondTaskField.getText());

                }}
            if ((!thirdTaskField.getText().isEmpty()) || (thirdTaskField.getBackground()!= new Color(153, 51, 255) ))  {
                if (!whatToDo.contains(thirdTaskField.getText())){
                    whatToDo.add((String) thirdTaskField.getText());

                }}
            if ((!fourthTaskField.getText().isEmpty()) || (fourthTaskField.getBackground()!= new Color(153, 51, 255))) {
                if (!whatToDo.contains(fourthTaskField.getText())){
                    whatToDo.add((String) fourthTaskField.getText());
                }}
            if ((!fifthTaskField.getText().isEmpty()) || (fifthTaskField.getBackground() != new Color(153, 51, 255))) {
                if (!whatToDo.contains(fifthTaskField.getText())){
                    whatToDo.add((String) fifthTaskField.getText());
                }}
            if ((!sixthTaskField.getText().isEmpty())|| (sixthTaskField.getBackground()!= new Color(153, 51, 255) )) {
                if (!whatToDo.contains(sixthTaskField.getText())){
                    whatToDo.add((String) sixthTaskField.getText());

                }}
            if ((!seventhTaskField.getText().isEmpty()) || (seventhTaskField.getBackground() != new Color(153, 51, 255) )){
                if (!whatToDo.contains(seventhTaskField.getText())){
                    whatToDo.add((String) seventhTaskField.getText());
                }}
            if (((!eighthTaskField.getText().isEmpty()) || (eighthTaskField.getBackground() != new Color(153, 51, 255) ))){
                if (!whatToDo.contains(eighthTaskField.getText())){
                    whatToDo.add((String) eighthTaskField.getText());}
            }
            if (((!ninthTaskField.getText().isEmpty()) ||  (ninthTaskField.getBackground() != new Color(153, 51, 255) ))){
                if (!whatToDo.contains(ninthTaskField.getText())){
                    whatToDo.add((String) ninthTaskField.getText());}
            }
            if (((!tenthTaskField.getText().isEmpty()) || (tenthTaskField.getBackground()!= new Color(153, 51, 255) ))) {
                if (!whatToDo.contains(tenthTaskField.getText())){

                    whatToDo.add((String) tenthTaskField.getText());;}
            }




            for (int i = 0; i < whatToDo.size(); i++){
                writeToFile(whatToDo);}

        }



        if (e.getSource() == ClearButton) {


// making sure that all the fields, even those that were affected by checkOff still look alike

            firstTaskField.setBackground(new Color(204, 255, 229));
            secondTaskField.setBackground(new Color(204, 255, 229));
            thirdTaskField.setBackground(new Color(204, 255, 229));
            fourthTaskField.setBackground(new Color(204, 255, 229));
            fifthTaskField.setBackground(new Color(204, 255, 229));
            sixthTaskField.setBackground(new Color(204, 255, 229));
            seventhTaskField.setBackground(new Color(204, 255, 229));
            eighthTaskField.setBackground(new Color(204, 255, 229));
            ninthTaskField.setBackground(new Color(204, 255, 229));
            tenthTaskField.setBackground(new Color(204, 255, 229));


            for (int i = 0; i < whatToDo.size(); i++) {
                deleteFrom(whatToDo, whatToDo.get(i));
            }
            firstTaskField.setText("");
            secondTaskField.setText("");
            thirdTaskField.setText("");
            fourthTaskField.setText("");
            fifthTaskField.setText("");
            sixthTaskField.setText("");
            seventhTaskField.setText("");
            eighthTaskField.setText("");
            ninthTaskField.setText("");
            tenthTaskField.setText("");

            aFrame.setVisible(true);

        }


/**
 * clearing;
 */
        if (e.getSource() == clearFirst) {

            deleteFrom(whatToDo, firstTaskField.getText());
            firstTaskField.setText("");

        }
        if (e.getSource() == clearSecond) {

            deleteFrom(whatToDo, secondTaskField.getText());
            secondTaskField.setText("");

        }
        if (e.getSource() == clearThird) {

            deleteFrom(whatToDo, thirdTaskField.getText());
            thirdTaskField.setText("");

        }
        if (e.getSource() == clearFourth) {

            deleteFrom(whatToDo, fourthTaskField.getText());
            fourthTaskField.setText("");


        }
        if (e.getSource() == clearFifth) {


            deleteFrom(whatToDo, fifthTaskField.getText());
            fifthTaskField.setText("");


        }
        if (e.getSource() == clearSixth) {

            deleteFrom(whatToDo, sixthTaskField.getText());
            sixthTaskField.setText("");


        }
        if (e.getSource() == clearSeventh) {


            deleteFrom(whatToDo, seventhTaskField.getText());
            seventhTaskField.setText("");


        }
        if (e.getSource() == clearEighth) {

            deleteFrom(whatToDo, eighthTaskField.getText());
            eighthTaskField.setText("");


        }
        if (e.getSource() == clearNinth) {

            deleteFrom(whatToDo, ninthTaskField.getText());
            ninthTaskField.setText("");


        }
        if (e.getSource() == clearTenth) {


            deleteFrom(whatToDo, ninthTaskField.getText());
            tenthTaskField.setText("");
        }



        if (e.getSource() == backToMainPageButton) {
            new ChoicePage();
            aFrame.dispose();

        }


    }

    public static void writeToFile(LinkedList<String> toDos) {
        try {
            String othername = LoginPage.nameOfUser;
            BufferedWriter writer = new BufferedWriter(new FileWriter(othername + "'s toDos.txt"));
            for (String strings : toDos) {
                writer.write(strings + "\n");
            }
            writer.close();
        } catch (IOException e) {
        }
    }

    public static void deleteFrom(LinkedList<String> toDos,  String taskToRemove) {


        for( String theString : toDos){

            if (theString.equals(taskToRemove)){
                System.out.println(" what was removed is " + theString + " and the task to remove is" + taskToRemove);
                System.out.println(" inside the if statements; ");
                toDos.remove(taskToRemove);
            }
        }
        System.out.println(" what is now inside thte toDos is ");
        for (int i = 0; i<toDos.size(); i++){
            System.out.println(toDos.get(i));
        }

        String othername = LoginPage.nameOfUser;
        String currentLine;
        try{
            File tempfile= new File ( "tempfile.txt");
            File inputfile= new File(othername + "'s toDos.txt");
            BufferedReader reader = new BufferedReader(new FileReader(new File(othername + "'s toDos.txt")));
            FileWriter otherwriter = new FileWriter(String.valueOf(new FileWriter(tempfile)));

            while ((currentLine = reader.readLine())!=null){

                String otherline= currentLine.trim();
                if(otherline.equals(taskToRemove)) {
                    otherwriter.write(currentLine + System.getProperty(" line.separator"));
                }}
            otherwriter.close();
            reader.close();
            boolean successful= tempfile.renameTo(new File(othername + "'s toDos.txt"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFrom() {
        String othername = LoginPage.nameOfUser;
        LinkedList<String> whatToDo = new LinkedList<String>();
        try {

            BufferedReader reader = new BufferedReader(new FileReader(othername + "'s toDos.txt"));

            String line;
            /**
             * we can create our own data collection
             */
            while ((line = reader.readLine()) != null) {
                whatToDo.add(line);
            }

            reader.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(" error inside readFrom");
        } catch (IOException ioException) {
            System.out.println(" error inside readFrom but second catch");
        }

        for ( int i = 0; i < whatToDo.size(); i++){
            //System.out.println(" Let's print what is inside the new ones" +  whatToDo.get(i));

            // System.out.println(firstTaskField.getText() + " firstask");
            if (firstTaskField.getText().isEmpty()) {

                firstTaskField.setText(whatToDo.get(i));
            }
            else if (secondTaskField.getText().isEmpty()) {

                secondTaskField.setText(whatToDo.get(i));
            }
            else if (thirdTaskField.getText().isEmpty()) {
                thirdTaskField.setText(whatToDo.get(i));
            }
            else if (fourthTaskField.getText().isEmpty()) {
                fourthTaskField.setText(whatToDo.get(i));
            }
            else if (fifthTaskField.getText().isEmpty()) {
                fifthTaskField.setText(whatToDo.get(i));
            }
            else if (sixthTaskField.getText().isEmpty()) {
                sixthTaskField.setText(whatToDo.get(i));
            }
            else if (seventhTaskField.getText().isEmpty()) {
                seventhTaskField.setText(whatToDo.get(i));
            }
            else if (eighthTaskField.getText().isEmpty()) {
                eighthTaskField.setText(whatToDo.get(i));
            }
            else if (ninthTaskField.getText().isEmpty()) {
                ninthTaskField.setText(whatToDo.get(i));
            }
            else if (tenthTaskField.getText().isEmpty()) {
                tenthTaskField.setText(whatToDo.get(i));
            }


        }
    }
}