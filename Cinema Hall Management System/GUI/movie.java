package GUI;
import Entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class movie extends JFrame implements ActionListener {
    JPanel panel;
    JLabel l, b4;
    JButton b1, b2, b3, b,userdetail;
	login log;
    Font f1;
    Color c1, c2;
    ImageIcon img;
	private String username;
    private Profile userProfile;

	

    public movie(String username, Profile userProfile) {
        super("Now Showing");
        this.setSize(880, 570);


		this.log=log;
		this.username = username;
        this.userProfile = userProfile;

        f1 = new Font("Times New Roman", Font.BOLD, 39);
        c1 = new Color(33, 43, 73);
        c2 = new Color(218, 232, 252);

        panel = new JPanel();
        panel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(c1);

        l = new JLabel("NOW SHOWING!!");
        l.setBounds(287, 60, 344, 50);
        l.setForeground(new Color(255, 140, 0));
        l.setFont(f1);
        panel.add(l);
		
		

        // Button b1
        b1 = addImageButton("Image/five.PNG", 9, 160);

        // Button b2
        b2 = addImageButton("Image/lala.PNG", 295, 160);

        // Button b3
        b3 = addImageButton("Image/dunki.JPEG", 577, 160);

        // Button b
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

        ImageIcon org = new ImageIcon("Image/film.png");
        int a = 150;
        int b = 150;
        Image scl = org.getImage().getScaledInstance(a, b, Image.SCALE_SMOOTH);
        img = new ImageIcon(scl);
        b4 = new JLabel(img);
        b4.setBounds(165, 15, a, b);
        b4.setBackground(c1);
        panel.add(b4);
		
		ImageIcon p = new ImageIcon("Image/p.JPG");
        int px = 80;
        int py = 80;
        Image sclp = p.getImage().getScaledInstance(px, py, Image.SCALE_SMOOTH);
        img = new ImageIcon(sclp);
        userdetail = new JButton(img);
        userdetail.setBounds(750, 15, px, py);
        userdetail.setBackground(c1);
		userdetail.addActionListener(this);
        panel.add(userdetail);
        setLocationRelativeTo(null);

        this.add(panel);
        this.setVisible(true);
        setLocationRelativeTo(null);
    }

    private JButton addImageButton(String imageName, int x, int y) {
        ImageIcon originalImg = new ImageIcon(imageName);

        int maxWidth = 270;
        int maxHeight = 300;
        Image scaledImage = originalImg.getImage().getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);
        img = new ImageIcon(scaledImage);

        JButton button = new JButton(img);
        button.setBounds(x, y, img.getIconWidth(), img.getIconHeight());
        button.addActionListener(this); 
        panel.add(button);
		return button; 

       
    }

   public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b) {
            login log = new login();
            log.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == userdetail) {
            // Show user profile
            userProfile.setVisible(true);
			this.setVisible(false);
        } else if (ae.getSource() == b1 || ae.getSource() == b2 || ae.getSource() == b3) {
            Location location = new Location(username, userProfile);
            location.setVisible(true);
            this.setVisible(false);
        }
    }

    
}
