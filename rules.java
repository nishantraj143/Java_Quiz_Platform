import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class rules extends JFrame implements ActionListener {

    JButton Start, Back;
    String Name;

    rules(String Name) {
        this.Name = Name;

        Color navy = new Color(12, 22, 43);
        Color cyan = new Color(0, 220, 255);
        Color darkBlue = new Color(27, 42, 66);
        Color white = Color.WHITE;

        setTitle("Java Quiz Platform - Instructions");
        setSize(1600, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);
        getContentPane().setBackground(navy);

        // Heading
        JLabel heading = new JLabel("QUIZ INSTRUCTIONS");
        heading.setBounds(55, 55, 700, 65);
        heading.setFont(new Font("Arial", Font.BOLD, 44));
        heading.setForeground(cyan);
        add(heading);

        // Subtitle
        JLabel subtitle = new JLabel("Please read all the rules before starting.");
        subtitle.setBounds(60, 125, 700, 40);
        subtitle.setFont(new Font("Arial", Font.BOLD, 24));
        subtitle.setForeground(new Color(190, 205, 225));
        add(subtitle);

        // Rules panel
        JPanel rulesPanel = new JPanel(new BorderLayout());
        rulesPanel.setBounds(55, 200, 930, 610);
        rulesPanel.setBackground(darkBlue);

        rulesPanel.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(cyan, 2),
                BorderFactory.createEmptyBorder(35, 30, 35, 30)
            )
        );

        // Rules text
        JLabel rulesLabel = new JLabel(
            "<html><div style='line-height:160%;'>" +

            "<font color='#00DCFF'><b>01.</b></font> " +
            "Participation is open to persons above 18 years old.<br><br>" +

            "<font color='#00DCFF'><b>02.</b></font> " +
            "There are a total of 10 questions.<br><br>" +

            "<font color='#00DCFF'><b>03.</b></font> " +
            "You have 15 seconds for each question.<br><br>" +

            "<font color='#00DCFF'><b>04.</b></font> " +
            "Do not use phones during the quiz.<br><br>" +

            "<font color='#00DCFF'><b>05.</b></font> " +
            "Do not talk while taking the quiz.<br><br>" +

            "<font color='#00DCFF'><b>06.</b></font> " +
            "Complete the quiz independently." +

            "</div></html>"
        );

        rulesLabel.setFont(new Font("Arial", Font.BOLD, 23));
        rulesLabel.setForeground(white);
        rulesPanel.add(rulesLabel, BorderLayout.CENTER);
        add(rulesPanel);

        // Quiz board image
        ImageIcon icon = new ImageIcon("icon/Glossy Quiz Board with Graduation Cap.png");

        if (icon.getIconWidth() > 0){Image scaled = icon.getImage().getScaledInstance(530, 530, Image.SCALE_SMOOTH);
            JLabel image = new JLabel(new ImageIcon(scaled));
            image.setBounds(1020, 220, 530, 530);
            add(image);
        } else {
            JLabel imageText = new JLabel("JAVA QUIZ");
            imageText.setBounds(1120, 420, 300, 60);
            imageText.setFont(new Font("Arial", Font.BOLD, 38));
            imageText.setForeground(cyan);
            add(imageText);
        }

        // Back button
        Back = new JButton("BACK");
        Back.setBounds(400, 855, 240, 65);
        Back.setFont(new Font("Arial", Font.BOLD, 24));
        Back.setBackground(darkBlue);
        Back.setForeground(white);
        Back.setBorder(BorderFactory.createLineBorder(cyan, 3));
        Back.setFocusPainted(false);
        Back.setOpaque(true);
        Back.setContentAreaFilled(true);
        Back.addActionListener(this);
        add(Back);

        // Start Quiz button
        Start = new JButton("START QUIZ");
        Start.setBounds(690, 855, 290, 65);
        Start.setFont(new Font("Arial", Font.BOLD, 24));
        Start.setBackground(cyan);
        Start.setForeground(navy);
        Start.setBorder(BorderFactory.createLineBorder(cyan, 3));
        Start.setFocusPainted(false);
        Start.setOpaque(true);
        Start.setContentAreaFilled(true);
        Start.addActionListener(this);
        add(Start);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == Start){
            dispose();
            new Quiz(Name);

        } else if (e.getSource() == Back){
            dispose();
            new login();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new rules("User"));
    }
}
