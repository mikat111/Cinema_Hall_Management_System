package GUI;
import Entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class registration extends JFrame implements MouseListener, ActionListener {

    JPanel panel;
    JTextField nameField, numberField, emailField;
    JRadioButton maleRadioButton, femaleRadioButton;
    JPasswordField pf;
    JButton submitButton, loginButton;
    JLabel nameLabel, numberLabel, emailLabel, genderLabel, m, nLabel, pass, t1;
    ImageIcon img;
    ButtonGroup bg1;

    Color c1;
    Font f1, f2, f3, f4;

    public registration() {
        super("Create Account");

        this.setSize(880, 570);
        c1 = new Color(33, 43, 73);
        f1 = new Font("Arial", Font.BOLD, 42);
        f4 = new Font("Arial", Font.BOLD, 25);
        f2 = new Font("Arial", Font.PLAIN, 17);
        f3 = new Font("Arial", Font.PLAIN, 20);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(c1);

        img = new ImageIcon("Image/regpic.png");
        m = new JLabel(img);
        m.setBounds(400, 129, img.getIconWidth(), img.getIconHeight());
        panel.add(m);

        nLabel = new JLabel("Create Account");
        nLabel.setBounds(290, 8, 336, 60);
        nLabel.setFont(f1);
        nLabel.setForeground(Color.WHITE);
        panel.add(nLabel);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(58, 115, 106, 32);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(f3);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(160, 115, 223, 29);
        panel.add(nameField);

        numberLabel = new JLabel("Number:");
        numberLabel.setBounds(44, 170, 100, 30);
        numberLabel.setForeground(Color.WHITE);
        numberLabel.setFont(f3);
        panel.add(numberLabel);

        numberField = new JTextField();
        numberField.setBounds(160, 170, 223, 29);
        panel.add(numberField);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(60, 218, 90, 30);
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(f3);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(160, 220, 223, 29);
        panel.add(emailField);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(48, 261, 85, 32);
        genderLabel.setForeground(Color.WHITE);
        genderLabel.setFont(f3);
        panel.add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(170, 263, 70, 30);
        maleRadioButton.setForeground(Color.WHITE);
        maleRadioButton.setFont(f2);
        maleRadioButton.setBackground(c1);
        panel.add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(260, 258, 80, 40);
        femaleRadioButton.setForeground(Color.WHITE);
        femaleRadioButton.setFont(f2);
        femaleRadioButton.setBackground(c1);
        panel.add(femaleRadioButton);

        bg1 = new ButtonGroup();
        bg1.add(maleRadioButton);
        bg1.add(femaleRadioButton);

        pass = new JLabel("Password:");
        pass.setForeground(Color.WHITE);
        pass.setFont(f3);
        pass.setBounds(30, 302, 126, 40);
        panel.add(pass);

        pf = new JPasswordField();
        pf.setBounds(160, 310, 223, 29);
        pf.setEchoChar('*');
        panel.add(pf);

        submitButton = new JButton("Submit");
        submitButton.setBounds(128, 365, 170, 30);
        submitButton.setBackground(new Color(255, 140, 0));
        submitButton.addMouseListener(this);
        submitButton.addActionListener(this);
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(submitButton);

        t1 = new JLabel("Already have an account?");
        t1.setBounds(30, 410, 288, 44);
        t1.setForeground(Color.WHITE);
        t1.setFont(f3);
        panel.add(t1);

        loginButton = new JButton("Log in");
        loginButton.setBounds(238, 410, 130, 40);
        loginButton.setForeground(new Color(43, 214, 214));
        loginButton.setFont(f4);
        loginButton.setBorderPainted(false);
        loginButton.setOpaque(false);
        loginButton.setBackground(c1);
        loginButton.addMouseListener(this);
        loginButton.addActionListener(this);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(loginButton);
        setLocationRelativeTo(null);
        this.add(panel);
    }

    public void mouseClicked(MouseEvent me) {}

    public void mousePressed(MouseEvent me) {}

    public void mouseReleased(MouseEvent me) {}

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == submitButton) {
            submitButton.setBackground(Color.BLUE);
            submitButton.setForeground(Color.WHITE);
        } else if (me.getSource() == loginButton) {
            loginButton.setForeground(Color.BLUE);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == submitButton) {
            submitButton.setBackground(new Color(255, 140, 0));
            submitButton.setForeground(Color.WHITE);
        } else if (me.getSource() == loginButton) {
            loginButton.setForeground(new Color(43, 214, 214));
        }
    }

  public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            login log = new login();
            log.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == submitButton) {
            String name = nameField.getText();
            String pass = pf.getText();
        String numberStr = numberField.getText(); 
            

            String email = emailField.getText();
            String male = maleRadioButton.isSelected() ? "Male" : "";
            String female = femaleRadioButton.isSelected() ? "Female" : "";

            if (name.isEmpty() || pass.isEmpty()|| numberStr.isEmpty() || email.isEmpty() || !(maleRadioButton.isSelected() || femaleRadioButton.isSelected())) {
                JOptionPane.showMessageDialog(null, "Attention: Form's crying in the corner. Give it some joy by filling those neglected fields!");
            } else {

                Account acc = new Account(name, pass, numberStr, email, male, female);
                acc.addaccount();

                JOptionPane.showMessageDialog(null, "Successfully Registered");

                login m = new login();
                m.setVisible(true);
                this.setVisible(false);
            }
        }
    }

    
}
