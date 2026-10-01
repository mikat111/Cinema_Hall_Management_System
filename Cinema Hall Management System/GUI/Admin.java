package GUI;
import Entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Admin extends JFrame implements MouseListener, ActionListener {
    JLabel nLabel, loginLabel, userLabel, passLabel;
    JTextField userTF;
    JPasswordField passPF;
    JButton loginBtn, b;
    JPanel panel;
    Color c1;
    Font f1, f2, f3;
    ImageIcon img;
    public Admin() {
        super("Admin");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(880, 570);
        c1 = new Color(33, 43, 73);
        f1 = new Font("Arial", Font.BOLD, 40);
        f2 = new Font("Arial", Font.PLAIN, 20);
        f3 = new Font("Arial", Font.PLAIN, 17);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(c1);
        nLabel = new JLabel("Admin ");
        nLabel.setBounds(330, 70, 300, 100);
        nLabel.setFont(f1);
        nLabel.setForeground(Color.WHITE);
        panel.add(nLabel);
        loginLabel = new JLabel("Log In ");
        loginLabel.setBounds(470, 72, 100, 100);
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
        loginBtn.setBounds(420, 320, 80, 30);
        loginBtn.setBackground(new Color(255, 140, 0));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.addMouseListener(this);
        loginBtn.addActionListener(this);
        panel.add(loginBtn);

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
        this.add(panel);
        setLocationRelativeTo(null);
    }
    public void mouseClicked(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == loginBtn) {
            loginBtn.setBackground(Color.BLUE);
            loginBtn.setForeground(Color.WHITE);
        }
    }
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == loginBtn) {
            loginBtn.setBackground(new Color(255, 140, 0));
            loginBtn.setForeground(Color.WHITE);
        }
    }
    public void actionPerformed(ActionEvent e){
      if (e.getSource() == loginBtn) {
				String textField1 = userTF.getText().toLowerCase(); // User Name
				String textField2 = passPF.getText(); // Password

				if (("nabil".equalsIgnoreCase(textField1) && "123".equals(textField2))||("koushik".equalsIgnoreCase(textField1) && "456".equals(textField2))||("mikat".equalsIgnoreCase(textField1) && "789".equals(textField2))||("aboni".equalsIgnoreCase(textField1) && "aboni".equals(textField2))) {
					JOptionPane.showMessageDialog(null, "Login Successful.", "", JOptionPane.WARNING_MESSAGE);
					AdminDashboard ad=new AdminDashboard();
                    this.setVisible(false);
                    ad.setVisible(true);
					
				}
                else if(textField1.isEmpty() || textField2.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Enter all necessary data", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                }
                else {
					JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",
							JOptionPane.WARNING_MESSAGE);
				}
			}
        else if(e.getSource()==b)
      {UserAdminPage u=new UserAdminPage();
          this.setVisible(false);
          u.setVisible(true);
        }

    }

    public static void main(String[] args) {
        Admin a=new Admin();
        a.setVisible(true);
    }
}