package cgpa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CGPACalculatorGUI extends JFrame implements ActionListener {

    // Components declare kiye
    JTextField nameField, gradeField, creditField;
    JTextArea displayArea;
    JLabel resultLabel;
    JButton addButton, calcButton;

    // List data store karne ke liye
    ArrayList<Subject> subjects = new ArrayList<>();

    public CGPACalculatorGUI() {
        // Window ki settings
        setTitle("Simple CGPA Calculator");
        setSize(350, 500);
        setLayout(new FlowLayout()); // Sabse simple layout use kiya
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Subject Name Input
        add(new JLabel("Subject Name:"));
        nameField = new JTextField(20); // 20 columns size
        add(nameField);

        // Grade Input
        add(new JLabel("Grade Points:"));
        gradeField = new JTextField(20);
        add(gradeField);

        // Credit Input
        add(new JLabel("Credit Hours:"));
        creditField = new JTextField(20);
        add(creditField);

        // Buttons add kiye
        addButton = new JButton("Add Subject");
        add(addButton);
        addButton.addActionListener(this); // Button ko bataya ke click par yahan aana hai

        calcButton = new JButton("Calculate CGPA");
        add(calcButton);
        calcButton.addActionListener(this);

        // List dikhane ke liye area
        displayArea = new JTextArea(15, 30);
        add(new JScrollPane(displayArea));

        // Result show karne ke liye
        resultLabel = new JLabel("CGPA: 0.0");
        add(resultLabel);

        setVisible(true); // Window show ki
    }

    // Jab button click hoga to ye function chalega
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            try {
                // Text fields se data liya
                String name = nameField.getText();
                double grade = Double.parseDouble(gradeField.getText());
                int credit = Integer.parseInt(creditField.getText());

                // Subject object banaya
                Subject s = new Subject(name, grade, credit);
                subjects.add(s);

                // Display area me show kiya
                displayArea.append(name + " - " + grade + " - " + credit + "\n");

                // Fields khali kiye
                nameField.setText("");
                gradeField.setText("");
                creditField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers");
            }
        }
        else if (e.getSource() == calcButton) {
            // Calculation logic
            double totalPoints = 0;
            int totalCredits = 0;

            for (Subject s : subjects) {
                totalPoints = totalPoints + s.getTotalPoints();
                totalCredits = totalCredits + s.getCreditHours();
            }

            if (totalCredits > 0) {
                double cgpa = totalPoints / totalCredits;
                resultLabel.setText("Your CGPA is: " + cgpa);
            }
        }
    }

    public static void main(String[] args) {
        new CGPACalculatorGUI();
    }
}
//Code improvements