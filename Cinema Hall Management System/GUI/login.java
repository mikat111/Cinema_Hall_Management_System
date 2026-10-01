package GUI;
import Entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class login extends JFrame implements MouseListener, ActionListener {
    JLabel nLabel, loginLabel, userLabel, passLabel;
    JTextField userTF;
    JPasswordField passPF;
    JButton loginBtn, sBtn, b;
    JPanel panel;
    Color c1;
    Font f1, f2, f3;
    ImageIcon img;

    public login() {
        super("Showtime");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(880, 570);
        c1 = new Color(33, 43, 73);
        f1 = new Font("Arial", Font.BOLD, 40);
        f2 = new Font("Arial", Font.PLAIN, 20);
        f3 = new Font("Arial", Font.PLAIN, 17);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(c1);

        nLabel = new JLabel("Showtime ");
        nLabel.setBounds(330, 70, 300, 100);
        nLabel.setFont(f1);
        nLabel.setForeground(Color.WHITE);
        panel.add(nLabel);

        loginLabel = new JLabel("Log In ");
        loginLabel.setBounds(530, 72, 100, 100);
        loginLabel.setFont(f2);
        loginLabel.setForeground(Color.WHITE);
        panel.add(loginLabel);

        userLabel = new JLabel("User Name : ");
        userLabel.setBounds(260, 200, 100, 30);
        userLabel.setFont(f3);
        userLabel.setForeground(Color.WHITE);
        panel.add(userLabel);

        userTF = new JTextField();
        userTF.setBounds(365, 200, 210, 30);
        panel.add(userTF);

        passLabel = new JLabel("Password : ");
        passLabel.setBounds(265, 265, 100, 30);
        passLabel.setFont(f3);
        passLabel.setForeground(Color.WHITE);
        panel.add(passLabel);

        passPF = new JPasswordField();
        passPF.setBounds(365, 265, 210, 30);
        passPF.setEchoChar('*');
        panel.add(passPF);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(370, 320, 80, 30);
        loginBtn.setBackground(new Color(255, 140, 0));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.addMouseListener(this);
        loginBtn.addActionListener(this);
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(loginBtn);

        sBtn = new JButton("Sign up");
        sBtn.setBounds(470, 320, 80, 30);
        sBtn.setForeground(new Color(33, 43, 73));
        sBtn.addMouseListener(this);
        sBtn.addActionListener(this);
        sBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(sBtn);

        ImageIcon originalImg = new ImageIcon("Image/b.png");
        int smallMaxWidth = 30;
        int smallMaxHeight = 30;
        Image smallScaledImage = originalImg.getImage().getScaledInstance(smallMaxWidth, smallMaxHeight, Image.SCALE_SMOOTH);
        img = new ImageIcon(smallScaledImage);
        b = new JButton(img);
        b.setBounds(15, 13, smallMaxWidth, smallMaxHeight);
        b.setBackground(c1);
        b.addActionListener(this);
        panel.add(b);
        setLocationRelativeTo(null);

        this.add(panel);
    }

    public void mouseClicked(MouseEvent me) {}

    public void mousePressed(MouseEvent me) {}

    public void mouseReleased(MouseEvent me) {}

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == loginBtn) {
            loginBtn.setBackground(Color.BLUE);
            loginBtn.setForeground(Color.WHITE);
        } else if (me.getSource() == sBtn) {
            sBtn.setBackground(Color.BLUE);
            sBtn.setForeground(Color.WHITE);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == loginBtn) {
            loginBtn.setBackground(new Color(255, 140, 0));
            loginBtn.setForeground(Color.WHITE);
        } else if (me.getSource() == sBtn) {
            sBtn.setBackground(new Color(233, 241, 247));
            sBtn.setForeground(new Color(33, 43, 73));
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sBtn) {
            registration r = new registration();
            r.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == loginBtn) {
            String username = userTF.getText();
            String userpass = passPF.getText();

            Account acc = new Account();

            if (acc.getAccount(username, userpass)) {
                JOptionPane.showMessageDialog(null, "Valid Account");

                List<String[]> userInfoList = acc.getAccountInfo(username);

                if (!userInfoList.isEmpty()) {
                    String[] userInfo = userInfoList.get(0);

                    Profile profile = new Profile(username, userInfo[1], userInfo[2], userInfo[3], userInfo[4]);
                    profile.setVisible(false);

                    movie m = new movie(username, profile);
                    m.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Account Missing, last seen being chased by wild algorithms! Register now before it's in an epic chase scene!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Account");
            }
        } else if (ae.getSource() == b) {
            UserAdminPage u = new UserAdminPage();
            u.setVisible(true);
            this.setVisible(false);
        }
    }
}
