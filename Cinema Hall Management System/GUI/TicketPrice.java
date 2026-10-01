package GUI;
import Entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketPrice extends JFrame implements ActionListener {

    JPanel panel;
    JButton  b, n;
    JLabel title, rs, ps, vs, b1, b2, b3;
    Color c1;
    Font f1, f2;
    ImageIcon img;
    private String username;
    private Profile userProfile;

    public TicketPrice(String username, Profile userProfile) {
        super("Ticket Price Information");

        setSize(880, 570);

        c1 = new Color(33, 43, 73);
        this.username = username;
        this.userProfile = userProfile;

        f1 = new Font("Arial", Font.PLAIN, 23);
        f2 = new Font("Arial", Font.BOLD, 33);

        panel = new JPanel();
        panel.setBackground(new Color(33, 43, 73));
        panel.setLayout(null); // set layout to null for manual positioning

        
        // ticket info
        title = new JLabel("Ticket Price Information");
        title.setBounds(240, 10, 452, 90);
        title.setFont(f2);
        title.setForeground(Color.WHITE);
        panel.add(title);

        // Regular Seat
        rs = new JLabel("<html>Regular Seat<br>Price:350</html>");
        rs.setBounds(423, 107, 188, 100);
        rs.setFont(f1);
        rs.setForeground(Color.WHITE);
        panel.add(rs);

        // Premium Seat
        ps = new JLabel("<html>Premium Seat<br>Price:500</html>");
        ps.setBounds(423, 230, 188, 100);
        ps.setFont(f1);
        ps.setForeground(Color.WHITE);
        panel.add(ps);

        // VIP Seat
        vs = new JLabel("<html>VIP Seat<br>Price:800</html>");
        vs.setBounds(423, 365, 188, 100);
        vs.setFont(f1);
        vs.setForeground(Color.WHITE);
        panel.add(vs);

        b1 = add("Image/Regular.JPG", 50, 100);
        b2 = add("Image/Premium.JPG", 50, 250);
        b3 = add("Image/Vip.JPG", 50, 400);

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

        ImageIcon nm = new ImageIcon("Image/n.png");
        int nx = 30;
        int ny = 30;
        Image ns = nm.getImage().getScaledInstance(nx, ny, Image.SCALE_SMOOTH);
        img = new ImageIcon(ns);
        n = new JButton(img);
        n.setBounds(830, 13, nx, ny);
        n.setBackground(c1);
        n.addActionListener(this);
        panel.add(n);
        setLocationRelativeTo(null);
        this.add(panel);
        this.setVisible(true);
    }

    private JLabel add(String imageName, int x, int y) {
        ImageIcon originalImg = new ImageIcon(imageName);

        int w = 230;
        int h = 110;
        Image sc = originalImg.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        img = new ImageIcon(sc);

        JLabel m = new JLabel(img);
        m.setBounds(x, y, img.getIconWidth(), img.getIconHeight());
       
        panel.add(m);

        return m;
    }

    
    public void actionPerformed(ActionEvent ae)
	{
        if (ae.getSource() == n) {
            Seat s = new Seat(username, userProfile);
            s.setVisible(true);
            this.setVisible(false);
        } 
		
		else if (ae.getSource() == b) {
            CinemaHallPage c = new CinemaHallPage(username, userProfile);
            c.setVisible(true);
            this.setVisible(false);
        }

    }

   
}

