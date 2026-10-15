import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame implements ActionListener {

    JTextField text;
    JButton Next, Back;

    login(){
        Color navy = new Color(12, 22, 43);
        Color cyan = new Color(0, 220, 255);
        Color darkBlue = new Color(27, 42, 66);
        Color white = Color.WHITE;

        setTitle("Java Quiz Platform - Login");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(navy);

        // Heading
        JLabel heading = new JLabel("JAVA QUIZ");
        heading.setBounds(55, 40, 420, 60);
        heading.setFont(new Font("Arial", Font.BOLD, 42));
        heading.setForeground(cyan);
        add(heading);

        // Subtitle
        JLabel subtitle = new JLabel("Welcome to Java Quiz Platform");
        subtitle.setBounds(60, 110, 420, 35);
        subtitle.setFont(new Font("Arial", Font.BOLD, 19));
        subtitle.setForeground(white);
        add(subtitle);

        // Name label
        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(60, 190, 400, 40);
        name.setFont(new Font("Arial", Font.BOLD, 25));
        name.setForeground(white);
        add(name);

        // Name input
        text = new JTextField();
        text.setBounds(60, 240, 400, 50);
        text.setFont(new Font("Arial", Font.BOLD, 20));
        text.setBackground(darkBlue);
        text.setForeground(white);
        text.setCaretColor(cyan);
        text.setBorder(BorderFactory.createLineBorder(cyan, 3));
        add(text);

        // Next button
        Next = new JButton("NEXT");
        Next.setBounds(60, 335, 185, 50);
        Next.setFont(new Font("Arial", Font.BOLD, 20));
        Next.setBackground(cyan);
        Next.setForeground(navy);
        Next.setBorder(BorderFactory.createLineBorder(cyan, 2));
        Next.setFocusPainted(false);
        Next.setOpaque(true);
        Next.setContentAreaFilled(true);
        Next.addActionListener(this);
        add(Next);

        // Exit button
        Back = new JButton("EXIT");
        Back.setBounds(265, 335, 195, 50);
        Back.setFont(new Font("Arial", Font.BOLD, 20));
        Back.setBackground(darkBlue);
        Back.setForeground(white);
        Back.setBorder(BorderFactory.createLineBorder(cyan, 2));
        Back.setFocusPainted(false);
        Back.setOpaque(true);
        Back.setContentAreaFilled(true);
        Back.addActionListener(this);
        add(Back);

        // Footer
        JLabel footer = new JLabel("Learn | Practice | Achieve");
        footer.setBounds(60, 425, 400, 35);
        footer.setFont(new Font("Arial", Font.BOLD, 17));
        footer.setForeground(new Color(190, 210, 230));
        add(footer);

        // Quiz board image
        ImageIcon icon = new ImageIcon("icon/Glossy Quiz Board with Graduation Cap.png");
        if (icon.getIconWidth() > 0){Image scaled = icon.getImage().getScaledInstance(450, 450, Image.SCALE_SMOOTH);
            JLabel image = new JLabel(new ImageIcon(scaled));
            image.setBounds(500, 55, 450, 450);
            add(image);
        } else {
            JLabel imageText = new JLabel("JAVA QUIZ");
            imageText.setBounds(600, 230, 250, 50);
            imageText.setFont(new Font("Arial", Font.BOLD, 30));
            imageText.setForeground(cyan);
            add(imageText);
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == Next){
            String playerName = text.getText().trim();
            if (playerName.isEmpty()){
                JOptionPane.showMessageDialog(this,
                    "Please enter your name!",
                    "Name Required",
                    JOptionPane.WARNING_MESSAGE
                );
            } else {
                dispose();
                new rules(playerName);
            }

        } else if (e.getSource() == Back) {
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new login());
    }
}
