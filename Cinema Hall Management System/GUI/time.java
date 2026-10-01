package GUI;
import Entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class time extends JFrame implements ActionListener {
    JPanel panel;
    JLabel t, s, m, s1, s2, s3, m1, m2, m3, sd, md;
    JButton b,m4;
    Font f1, f2, f3;
    Color c1, c2;
	ImageIcon img;
    private String username;
    private Profile userProfile;
   

    public time(String username, Profile userProfile) {
        super("Time and Date");
        this.setSize(880, 570);
        f1 = new Font("Arial", Font.BOLD, 22);
        f3 = new Font("Arial", Font.PLAIN, 22);
        f2 = new Font("Times New Roman", Font.BOLD, 36);
        c1 = new Color(33, 43, 73);
        c2 = new Color(218, 232, 252);

        panel = new JPanel();
        panel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(c1);
		
		ImageIcon originalImg = new ImageIcon("Image/b.png");

        
        int maxWidth = 30; 
        int maxHeight = 30;
        Image scaledImage = originalImg.getImage().getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);
        img = new ImageIcon(scaledImage);
        m4 = new JButton(img);
        m4.setBounds(15, 13, img.getIconWidth(), img.getIconHeight());
		m4.setBackground(c1);
		m4.addActionListener(this);
        panel.add(m4);



        s = new JLabel("Sunday");
        s.setBounds(219, 110, 81, 40);
        s.setForeground(Color.WHITE);
        s.setFont(f1);
        panel.add(s);

        t = new JLabel("Time and Date Information");
        t.setBounds(223, 12, 502, 77);
        t.setForeground(Color.WHITE);
        t.setFont(f2);
        panel.add(t);

        m = new JLabel("Monday");
        m.setBounds(608, 110, 89, 40);
        m.setForeground(Color.WHITE);
        m.setFont(f1);
        panel.add(m);

        s1 = new JLabel("11:10 AM");
        s1.setBounds(168, 220, 95, 44);
        s1.setForeground(Color.BLACK);
        s1.setOpaque(true);
        s1.setBackground(c2);
        s1.setFont(f1);
        panel.add(s1);

        s2 = new JLabel("12:10 PM");
        s2.setBounds(249, 290, 95, 44);
        s2.setForeground(Color.BLACK);
        s2.setOpaque(true);
        s2.setBackground(c2);
        s2.setFont(f1);
        panel.add(s2);

        s3 = new JLabel("11:30 AM");
        s3.setBounds(168, 360, 95, 44);
        s3.setForeground(Color.BLACK);
        s3.setOpaque(true);
        s3.setBackground(c2);
        s3.setFont(f1);
        panel.add(s3);

        m1 = new JLabel("11:00 AM");
        m1.setBounds(600, 220, 95, 44);
        m1.setForeground(Color.BLACK);
        m1.setOpaque(true);
        m1.setBackground(c2);
        m1.setFont(f1);
        panel.add(m1);

        m2 = new JLabel("11:30 AM");
        m2.setBounds(686, 290, 95, 44);
        m2.setForeground(Color.BLACK);
        m2.setOpaque(true);
        m2.setBackground(c2);
        m2.setFont(f1);
        panel.add(m2);

        m3 = new JLabel("12:30 PM");
        m3.setBounds(600, 360, 95, 44);
        m3.setForeground(Color.BLACK);
        m3.setOpaque(true);
        m3.setBackground(c2);
        m3.setFont(f1);
        panel.add(m3);

        sd = new JLabel("24th , December 2023");
        sd.setBounds(147, 160, 223, 40);
        sd.setForeground(Color.WHITE);
        sd.setFont(f3);
        panel.add(sd);

        md = new JLabel("25th , December 2023");
        md.setBounds(556, 160, 223, 40);
        md.setForeground(Color.WHITE);
        md.setFont(f3);
        panel.add(md);

        b = new JButton("Get Ticket");
        b.setBounds(325, 445, 216, 40);
        b.setBackground(new Color(255, 140, 0));
        b.setForeground(Color.WHITE);
        b.setFont(f1);
		b.addActionListener(this);
        panel.add(b);
        setLocationRelativeTo(null);
		
		



        this.add(panel);
       
    }
	public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b) {
            CinemaHallPage l = new CinemaHallPage(username, userProfile);
            l.setVisible(true);
            this.setVisible(false);
        } 
		else if (ae.getSource() == m4) {
        Location l = new Location(username, userProfile);
        l.setVisible(true);
        this.setVisible(false);
    }

}
}
