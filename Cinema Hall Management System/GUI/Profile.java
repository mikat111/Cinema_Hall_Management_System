package GUI;
import Entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Profile extends JFrame implements ActionListener {
    JPanel panel;
    JButton b;
    ImageIcon img;
	private String username;
    private Profile userProfile;
	Font myFont;
	Color c1;


    public Profile(String username, String number, String email, String male, String female) {
        super("User Profile Information");
        this.setSize(500, 400);
		this.username = username;
        this.userProfile = this;
		c1 = new Color(33,43,73);
		myFont = new Font("Arial", Font.PLAIN, 17);


        setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setLayout(null);
		panel.setBackground(c1);
		
		
		
		JLabel label1 = new JLabel(
    "<html><div style='text-align: left;'>" +
    "Your Information: " + "<br>" +
    "Name: " + username + "<br>" +
    "</div></html>");

       label1.setBounds(120, 60, 300, 300);

	   label1.setForeground(Color.WHITE);
		label1.setFont(myFont);
        panel.add(label1);



        ImageIcon originalImg = new ImageIcon("Image/b.png");
        int smallMaxWidth = 30;
        int smallMaxHeight = 30;
        Image smallScaledImage = originalImg.getImage().getScaledInstance(smallMaxWidth, smallMaxHeight, Image.SCALE_SMOOTH);
        img = new ImageIcon(smallScaledImage);
        b = new JButton(img);
        b.setBounds(15, 13, smallMaxWidth, smallMaxHeight);
        b.addActionListener(this);
        panel.add(b);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b) {
            movie m = new movie(username, userProfile);
            m.setVisible(true);
            this.setVisible(false);
        }
    }
}
