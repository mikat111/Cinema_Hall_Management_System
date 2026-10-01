package GUI;
import Entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserAdminPage extends JFrame implements ActionListener {

    private JButton userButton;
    private JButton adminButton;
    public UserAdminPage() {
        setTitle("User and Admin Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(880, 570);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(33, 43, 73));

        Icon usericon= new ImageIcon("Image/user.png");
        userButton = new JButton(usericon);
        userButton.setBounds(250, 150, 165, 190);
        userButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        Icon adminicon= new ImageIcon("Image/admin.png");
        adminButton = new JButton(adminicon);
        adminButton.setBounds(500, 150, 165, 190);
        adminButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel userLabel = new JLabel("User");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        userLabel.setBounds(290, 360, 100, 30);

        JLabel adminLabel = new JLabel("Admin");
        adminLabel.setForeground(Color.WHITE);
        adminLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        adminLabel.setBounds(540, 360, 100, 30);
        panel.add(userButton);
        panel.add(adminButton);
        panel.add(userLabel);
        panel.add(adminLabel);
        userButton.addActionListener(this);
        adminButton.addActionListener(this);

        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == userButton) {
            login log = new login();
            log.setVisible(true);
            this.setVisible(false);
        }
        else if (ae.getSource() == adminButton) {
            Admin a = new Admin();
           a.setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new UserAdminPage();
    }
}
