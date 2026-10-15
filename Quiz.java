import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String[][] questions = new String[10][5];
    String[][] answers = new String[10][2];
    String[] usersAnswer = new String[10];

    JLabel qno, question, timerLabel;

    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup group;

    JButton next, submit, help;

    int count = 0;
    int timer = 15;
    int score = 0;

    String Name;
    Timer quizTimer;

    Color navy = new Color(12, 22, 43);
    Color cyan = new Color(0, 220, 255);
    Color darkBlue = new Color(27, 42, 66);
    Color white = Color.WHITE;

    Quiz(String Name){
        this.Name = Name;

        setTitle("Java Quiz Platform - Quiz");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(navy);

        // Heading
        JLabel heading = new JLabel("JAVA QUIZ");
        heading.setBounds(50, 25, 450, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 36));
        heading.setForeground(cyan);
        add(heading);

        // Timer
        timerLabel = new JLabel("Time Left: 15 seconds");
        timerLabel.setBounds(680, 30, 280, 35);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 22));
        timerLabel.setForeground(Color.RED);
        add(timerLabel);

        // Question number
        qno = new JLabel();
        qno.setBounds(50, 145, 90, 45);
        qno.setFont(new Font("Arial", Font.BOLD, 28));
        qno.setForeground(white);
        add(qno);

        // Question text
        question = new JLabel();
        question.setBounds(140, 145, 810, 60);
        question.setFont(new Font("Arial", Font.BOLD, 25));
        question.setForeground(white);
        add(question);

        // Questions and options
        questions[0][0] = "How many primitive data types are in Java?";
        questions[0][1] = "6";
        questions[0][2] = "7";
        questions[0][3] = "8";
        questions[0][4] = "9";

        questions[1][0] = "What are the sizes of float and double in Java?";
        questions[1][1] = "32 and 64";
        questions[1][2] = "32 and 32";
        questions[1][3] = "64 and 64";
        questions[1][4] = "64 and 32";

        questions[2][0] = "Which is a widening type conversion?";
        questions[2][1] = "Byte to int";
        questions[2][2] = "Int to long";
        questions[2][3] = "Long to int";
        questions[2][4] = "Double to int";

        questions[3][0] = "What does a method receive when an array is passed?";
        questions[3][1] = "A reference to the array";
        questions[3][2] = "A copy of the array";
        questions[3][3] = "The length only";
        questions[3][4] = "The first element only";

        questions[4][0] = "Arrays in Java are:";
        questions[4][1] = "Primitive types";
        questions[4][2] = "Objects";
        questions[4][3] = "Operators";
        questions[4][4] = "Packages";

        questions[5][0] = "When is an object created using new?";
        questions[5][1] = "At runtime";
        questions[5][2] = "At compile time";
        questions[5][3] = "Before writing code";
        questions[5][4] = "Never";

        questions[6][0] = "A Java package can contain:";
        questions[6][1] = "Only variables";
        questions[6][2] = "Only loops";
        questions[6][3] = "Classes and interfaces";
        questions[6][4] = "Only operators";

        questions[7][0] = "What does String.compareTo() return?";
        questions[7][1] = "A boolean";
        questions[7][2] = "A String";
        questions[7][3] = "An int value";
        questions[7][4] = "A char";

        questions[8][0] = "Which package contains the String class?";
        questions[8][1] = "java.lang";
        questions[8][2] = "java.awt";
        questions[8][3] = "java.applet";
        questions[8][4] = "java.sql";

        questions[9][0] = "How many public constructors are listed in the Java String API?";
        questions[9][1] = "3";
        questions[9][2] = "7";
        questions[9][3] = "13";
        questions[9][4] = "20";

        // Correct answers
        answers[0][1] = "8";
        answers[1][1] = "32 and 64";
        answers[2][1] = "Int to long";
        answers[3][1] = "A reference to the array";
        answers[4][1] = "Objects";
        answers[5][1] = "At runtime";
        answers[6][1] = "Classes and interfaces";
        answers[7][1] = "An int value";
        answers[8][1] = "java.lang";
        answers[9][1] = "13";

        // Radio buttons
        opt1 = new JRadioButton();
        opt1.setBounds(120, 245, 800, 40);
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(120, 295, 800, 40);
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(120, 345, 800, 40);
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(120, 395, 800, 40);
        add(opt4);

        JRadioButton[] options = {opt1, opt2, opt3, opt4};

        for (int i = 0; i < options.length; i++) {
            options[i].setFont(new Font("Arial", Font.BOLD, 22));
            options[i].setBackground(navy);
            options[i].setForeground(white);
            options[i].setFocusPainted(false);
            options[i].setOpaque(true);
        }

        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        // Next button: cyan with bold navy text
        next = new JButton("NEXT");
        next.setBounds(120, 490, 180, 50);
        next.setFont(new Font("Arial", Font.BOLD, 20));
        next.setBackground(cyan);
        next.setForeground(navy);
        next.setBorder(BorderFactory.createLineBorder(cyan, 2));
        next.setFocusPainted(false);
        next.setOpaque(true);
        next.setContentAreaFilled(true);
        next.addActionListener(this);
        add(next);

        // Help button: dark blue with bold white text
        help = new JButton("HELP");
        help.setBounds(340, 490, 180, 50);
        help.setFont(new Font("Arial", Font.BOLD, 20));
        help.setBackground(darkBlue);
        help.setForeground(white);
        help.setBorder(BorderFactory.createLineBorder(cyan, 2));
        help.setFocusPainted(false);
        help.setOpaque(true);
        help.setContentAreaFilled(true);
        help.addActionListener(this);
        add(help);

        // Submit button: dark blue with bold white text
        submit = new JButton("SUBMIT");
        submit.setBounds(560, 490, 180, 50);
        submit.setFont(new Font("Arial", Font.BOLD, 20));
        submit.setBackground(darkBlue);
        submit.setForeground(white);
        submit.setBorder(BorderFactory.createLineBorder(cyan, 2));
        submit.setFocusPainted(false);
        submit.setOpaque(true);
        submit.setContentAreaFilled(true);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        // Display first question
        start(0);

        // Timer
        quizTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer--;

                timerLabel.setText("Time Left: " + timer + " seconds");

                if (timer <= 0) {
                    saveAnswer();
                    moveNext();
                }
            }
        });

        quizTimer.start();
        setVisible(true);
    }

    // Display question and options
    public void start(int count) {
        qno.setText("Q" + (count + 1) + ".");
        question.setText(questions[count][0]);

        opt1.setText(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt4.setText(questions[count][4]);

        opt1.setActionCommand(questions[count][1]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setActionCommand(questions[count][4]);

        group.clearSelection();

        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);

        help.setEnabled(true);

        timer = 15;
        timerLabel.setText("Time Left: 15 seconds");

        if (count == 9) {
            next.setEnabled(false);
            submit.setEnabled(true);
        } else {
            next.setEnabled(true);
            submit.setEnabled(false);
        }
    }

    // Save selected answer
    public void saveAnswer() {
        if (group.getSelection() == null) {
            usersAnswer[count] = "";
        } else {
            usersAnswer[count] = group.getSelection().getActionCommand();
        }
    }

    // Move to next question
    public void moveNext() {
        if (count == 9) {
            finishQuiz();
        } else {
            count++;
            start(count);
        }
    }

    // Calculate score and open result page
    public void finishQuiz() {
        quizTimer.stop();

        score = 0;

        for (int i = 0; i < usersAnswer.length; i++) {
            if (usersAnswer[i] != null && usersAnswer[i].equals(answers[i][1])) {
                score = score + 10;
            }
        }

        dispose();
        new Score(Name, score);
    }

    // Button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            saveAnswer();
            moveNext();
        }

        else if (e.getSource() == submit) {
            saveAnswer();
            finishQuiz();
        }

        else if (e.getSource() == help) {
            // Simple hint: remove two options
            if (count == 0 || count == 2 ||
                count == 4 || count == 6 || count == 8) {
                opt1.setEnabled(false);
                opt2.setEnabled(false);
            } else {
                opt3.setEnabled(false);
                opt4.setEnabled(false);
            }

            help.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Quiz("User"));
    }
}
