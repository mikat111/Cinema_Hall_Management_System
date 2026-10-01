package GUI;
import Entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CinemaHallPage extends JFrame implements ActionListener {

    private JButton b;
    private ImageIcon img;
    private Color c1;
    private String username;
    private Profile userProfile;

    public CinemaHallPage(String username, Profile userProfile) {
        setTitle("Cinema Hall Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(880, 570);
        this.username = username;
        this.userProfile = userProfile;
        JPanel panel = new JPanel();
        panel.setBackground(new Color(33, 43, 73));
        panel.setLayout(null); // Set layout to null for manual positioning

        // Hall 1
        JPanel hall1Panel = createHallPanel("Hall 1");
        hall1Panel.setBounds(200, 50, 400, 110);

        // Hall 2
        JPanel hall2Panel = createHallPanel("Hall 2");
        hall2Panel.setBounds(200, 200, 400, 110);

        // Hall 3
        JPanel hall3Panel = createHallPanel("Hall 3");
        hall3Panel.setBounds(200, 350, 400, 110);

        // Add components to the panel
        panel.add(hall1Panel);
        panel.add(hall2Panel);
        panel.add(hall3Panel);

        // Add panel to the frame
        add(panel);

        // Initialize b button and c1 color
        ImageIcon originalImg = new ImageIcon("Image/b.png");
        int smallMaxWidth = 30;
        int smallMaxHeight = 30;
        Image smallScaledImage = originalImg.getImage().getScaledInstance(smallMaxWidth, smallMaxHeight, Image.SCALE_SMOOTH);
        img = new ImageIcon(smallScaledImage);
        b = new JButton(img);
        b.setBounds(15, 13, smallMaxWidth, smallMaxHeight);
        c1 = new Color(33, 43, 73);
        b.setBackground(c1);
        b.addActionListener(this);
        panel.add(b);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createHallPanel(String hallName) {
        JPanel hallPanel = new JPanel(null);

        JLabel hallLabel = new JLabel(hallName);
        hallLabel.setBounds(10, 0, 400, 80);
        hallLabel.setOpaque(true);
        hallLabel.setBackground(Color.WHITE);
        hallLabel.setFont(new Font("Arial", Font.BOLD, 25));

        JButton button1 = new JButton("10.00 AM");
        button1.setBounds(20, 70, 100, 30);
        JButton button2 = new JButton("2.00 PM");
        button2.setBounds(150, 70, 100, 30);
        JButton button3 = new JButton("8.00 PM");
        button3.setBounds(280, 70, 100, 30);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        hallPanel.add(hallLabel);
        hallPanel.add(button1);
        hallPanel.add(button2);
        hallPanel.add(button3);

        return hallPanel;
    }

    // ActionListener implementation
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("10.00 AM")) {
            openTicketPricePage("Hall 1 - 10.00 AM");
        } else if (ae.getActionCommand().equals("2.00 PM")) {
            openTicketPricePage("Hall 2 - 2.00 PM");
        } else if (ae.getActionCommand().equals("8.00 PM")) {
            openTicketPricePage("Hall 3 - 8.00 PM");
        } else if (ae.getSource() == b) {
            time t=new time(username, userProfile);
            t.setVisible(true);
            this.setVisible(false);
        }
    }

    private void openTicketPricePage(String hallInfo) {
        TicketPrice ticketPrice = new TicketPrice(username, userProfile);
        ticketPrice.setVisible(true);
        this.setVisible(false);
    }


}

