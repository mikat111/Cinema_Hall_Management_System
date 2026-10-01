package GUI;
import Entity.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Location extends JFrame implements ActionListener
{
	ImageIcon img;
	JLabel location,imgLabel;
	JButton b1,b2,b3,b;
	JPanel panel;
	Color c1,c2,c3;
	Font myFont;
	private String username;
	private Profile userProfile;
	
	public Location(String username, Profile userProfile)
	{
		super("Choose Your Cinema Hall:");
		this.username = username;
		this.userProfile = userProfile;
		this.setSize(880,570);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c1 = new Color(33,43,73);
		myFont = new Font("Cambria", Font.PLAIN, 28);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(c1);
		
		location = new JLabel("Choose Your Cine Complex:");
		location.setBounds(200, 50, 500, 75);
		location.setForeground(Color.WHITE);
		location.setFont(new Font("Arial",Font.BOLD,30));
		panel.add(location);
		
		//ImageIcon locimg= new ImageIcon("");
		
		b1=new JButton("Mirpur Movie Complex");
		b1.setBounds(240,150,400,100);
		//b1.setIcon(locimg);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Arial",Font.BOLD,20));
		
		b1.addActionListener(this);
		panel.add(b1);
		
		b2=new JButton("Uttara Gram Movie Complex");
		b2.setBounds(240,250,400,100);
		//b2.setIcon(locimg);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Arial",Font.BOLD,20));
		
		b2.addActionListener(this);
		panel.add(b2);
		
		b3=new JButton("Dhanmondi Movie Complex");
		b3.setBounds(240,350,400,100);
		//b3.setIcon(locimg);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Arial",Font.BOLD,20));
		
		b3.addActionListener(this);
		panel.add(b3);
		
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



public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b) {
			movie m = new movie(username, userProfile);
			m.setVisible(true);
			this.setVisible(false);
        } 
		else if (ae.getSource() == b1 || ae.getSource() == b2 || ae.getSource() == b3) {
            time t = new time(username, userProfile);
            t.setVisible(true);
            this.setVisible(false);
        }
    }
}