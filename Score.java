import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    JButton exit;
    String name;
    int score;

    Score(String name, int score) {
        this.name = name;
        this.score = score;

        Color navy = new Color(12, 22, 43);
        Color cyan = new Color(0, 220, 255);
        Color darkBlue = new Color(27, 42, 66);

        setTitle("Java Quiz Platform - Result");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(navy);

        // Heading
        JLabel heading = new JLabel("QUIZ COMPLETED!");
        heading.setBounds(100, 35, 600, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 34));
        heading.setForeground(cyan);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading);

        // Student name
        JLabel student = new JLabel("Well done, " + name + "!");
        student.setBounds(100, 95, 600, 40);
        student.setFont(new Font("Arial", Font.BOLD, 24));
        student.setForeground(Color.WHITE);
        student.setHorizontalAlignment(SwingConstants.CENTER);
        add(student);

        // Trophy image
        ImageIcon icon = new ImageIcon("icon/Golden Trophy Achievement Glow.png");

        if (icon.getIconWidth() > 0) {
            Image scaled = icon.getImage().getScaledInstance(
                200, 170, Image.SCALE_SMOOTH
            );

            JLabel trophy = new JLabel(new ImageIcon(scaled));
            trophy.setBounds(300, 145, 200, 170);
            add(trophy);
        }

        // Score
        JLabel result = new JLabel(
            "Your Score: " + score + " / 100"
        );
        result.setBounds(100, 335, 600, 50);
        result.setFont(new Font("Arial", Font.BOLD, 32));
        result.setForeground(cyan);
        result.setHorizontalAlignment(SwingConstants.CENTER);
        add(result);

        // Performance message
        String message;

        if (score >= 80) {
            message = "Excellent! Keep it up!";
        } else if (score >= 50) {
            message = "Good job! Keep practising!";
        } else {
            message = "Keep learning and try again!";
        }

        JLabel feedback = new JLabel(message);
        feedback.setBounds(100, 390, 600, 35);
        feedback.setFont(new Font("Arial", Font.BOLD, 19));
        feedback.setForeground(Color.WHITE);
        feedback.setHorizontalAlignment(SwingConstants.CENTER);
        add(feedback);

        // Exit button
        exit = new JButton("EXIT");
        exit.setBounds(300, 465, 200, 50);
        exit.setFont(new Font("Arial", Font.BOLD, 20));
        exit.setBackground(cyan);
        exit.setForeground(navy);
        exit.setBorder(BorderFactory.createLineBorder(cyan, 2));
        exit.setFocusPainted(false);
        exit.setOpaque(true);
        exit.addActionListener(this);
        add(exit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            dispose();
            new login();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Score("User", 80));
    }
}
