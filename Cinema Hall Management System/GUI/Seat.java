package GUI;
import Entity.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Seat extends JFrame implements ActionListener,MouseListener
{
ImageIcon img;
JLabel headline,ticket,imgLabel,totalprice,stype;
JButton b1,b2,b3,b4,b5,b6,b7,b8,a1,a2,a3,a4,a5,a6,a7,a8,C1,C2,C3,c4,c5,c6,c7,c8,confirm,b,next;
JPanel panel;
Color c1,c2,c3;
Font myFont;
JComboBox type,tickets;
JTextField tprice;
    private String username;
    private Profile userProfile;
public Seat(String username, Profile userProfile)
{
super("Select Your Seat");
this.setSize(880,570);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.username = username;
    this.userProfile = userProfile;
c1 = new Color(33,43,73);
myFont = new Font("Cambria", Font.PLAIN, 28);
panel = new JPanel();
panel.setLayout(null);
panel.setBackground(c1);
headline = new JLabel("Select Your Seat");
headline.setBounds(280, 50, 300, 75);
headline.setForeground(Color.WHITE);
headline.setFont(new Font("Arial",Font.BOLD,30));
panel.add(headline);
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
totalprice= new JLabel("Total Cost");
totalprice.setBounds(250,410,150,30);
totalprice.setForeground(Color.WHITE);
totalprice.setFont(new Font("Arial",Font.BOLD,22));
panel.add(totalprice);
tprice=new JTextField();
tprice.setBounds(380,410,60,30);
tprice.setText("350");
panel.add(tprice);
 
Integer Tickets[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
String SType[]={"Regular","Premium","VIP"};
stype=new JLabel("Seat Type");
stype.setBounds(40,125,100,40);
stype.setForeground(Color.WHITE);
stype.setFont(new Font("Arial",Font.BOLD,20));
panel.add(stype);
tickets = new JComboBox(Tickets);
tickets.setBounds(640,125,50,40);
tickets.addActionListener(this);
panel.add(tickets);
type = new JComboBox(SType);
type.setBounds(150,125,100,40);
type.addActionListener(this);
 
panel.add(type);
ticket = new JLabel("Tickets:");
ticket.setBounds(530, 110, 300, 75);
ticket.setForeground(Color.WHITE);
ticket.setFont(new Font("Arial",Font.BOLD,20));
panel.add(ticket);
a1=new JButton("a1");
a1.setBounds(200,200,50,50);
a1.setBackground(Color.WHITE);
a1.addMouseListener(this);
panel.add(a1);
a2=new JButton("a2");
a2.setBounds(250,200,50,50);
a2.setBackground(Color.WHITE);
a2.addMouseListener(this);
panel.add(a2);
a3=new JButton("a3");
a3.setBounds(300,200,50,50);
a3.setBackground(Color.WHITE);
a3.addMouseListener(this);
panel.add(a3);
a4=new JButton("a4");
a4.setBounds(350,200,50,50);
a4.setBackground(Color.WHITE);
a4.addMouseListener(this);
panel.add(a4);
a5=new JButton("a5");
a5.setBounds(430,200,50,50);
a5.setBackground(Color.WHITE);
a5.addMouseListener(this);
panel.add(a5);
a6=new JButton("a6");
a6.setBounds(480,200,50,50);
a6.setBackground(Color.WHITE);
a6.addMouseListener(this);
panel.add(a6);
a7=new JButton("a7");
a7.setBounds(530,200,50,50);
a7.setBackground(Color.WHITE);
a7.addMouseListener(this);
panel.add(a7);
a8=new JButton("a8");
a8.setBounds(580,200,50,50);
a8.setBackground(Color.WHITE);
a8.addMouseListener(this);
panel.add(a8);
 
b1=new JButton("b1");
b1.setBounds(200,260,50,50);
b1.setBackground(Color.WHITE);
b1.addMouseListener(this);
panel.add(b1);
b2=new JButton("b2");
b2.setBounds(250,260,50,50);
b2.setBackground(Color.WHITE);
b2.addMouseListener(this);
panel.add(b2);
 
b3=new JButton("b3");
b3.setBounds(300,260,50,50);
b3.setBackground(Color.WHITE);
b3.addMouseListener(this);
panel.add(b3);
b4=new JButton("b4");
b4.setBounds(350,260,50,50);
b4.setBackground(Color.WHITE);
b4.addMouseListener(this);
panel.add(b4);
b5=new JButton("b5");
b5.setBounds(430,260,50,50);
b5.setBackground(Color.WHITE);
b5.addMouseListener(this);
panel.add(b5);
 
b6=new JButton("b6");
b6.setBounds(480,260,50,50);
b6.setBackground(Color.WHITE);
b6.addMouseListener(this);
panel.add(b6);
b7=new JButton("b7");
b7.setBounds(530,260,50,50);
b7.setBackground(Color.WHITE);
b7.addMouseListener(this);
panel.add(b7);
b8=new JButton("b8");
b8.setBounds(580,260,50,50);
b8.setBackground(Color.WHITE);
b8.addMouseListener(this);
panel.add(b8);
 
C1=new JButton("c1");
C1.setBounds(200,320,50,50);
C1.setBackground(Color.WHITE);
C1.addMouseListener(this);
panel.add(C1);
C2=new JButton("c2");
C2.setBounds(250,320,50,50);
C2.setBackground(Color.WHITE);
C2.addMouseListener(this);
panel.add(C2);
C3=new JButton("c3");
C3.setBounds(300,320,50,50);
C3.setBackground(Color.WHITE);
C3.addMouseListener(this);
panel.add(C3);
c4=new JButton("c4");
c4.setBounds(350,320,50,50);
c4.setBackground(Color.WHITE);
c4.addMouseListener(this);
panel.add(c4);
c5=new JButton("c5");
c5.setBounds(430,320,50,50);
c5.setBackground(Color.WHITE);
c5.addMouseListener(this);
panel.add(c5);
c6=new JButton("c6");
c6.setBounds(480,320,50,50);
c6.setBackground(Color.WHITE);
c6.addMouseListener(this);
panel.add(c6);
c7=new JButton("c7");
c7.setBounds(530,320,50,50);
c7.setBackground(Color.WHITE);
c7.addMouseListener(this);
panel.add(c7);
c8=new JButton("c8");
c8.setBounds(580,320,50,50);
c8.setBackground(Color.WHITE);
c8.addMouseListener(this);
panel.add(c8);

next=new JButton("NEXT");
next.setBounds(630,400,100,50);
next.setBackground(Color.ORANGE);
next.setForeground(Color.BLACK);
next.setFont(new Font("Arial",Font.BOLD,13));
next.addActionListener(this);
 

panel.add(next);
setLocationRelativeTo(null);
this.add(panel);
}
public void mouseClicked(MouseEvent me)
{
if (me.getSource() == a1){
a1.setBackground(Color.CYAN);
} else if (me.getSource() == a2){
a2.setBackground(Color.CYAN);
}else if (me.getSource() == a3) {
a3.setBackground(Color.CYAN);
}else if (me.getSource() == a4) {
a4.setBackground(Color.CYAN);
}else if (me.getSource() == a5) {
a5.setBackground(Color.CYAN);
}else if (me.getSource() == a6) {
a6.setBackground(Color.CYAN);
}else if (me.getSource() == a7) {
a7.setBackground(Color.CYAN);
}else if (me.getSource() == a8) {
a8.setBackground(Color.CYAN);
}else if (me.getSource() == b1) {
b1.setBackground(Color.CYAN);
}else if (me.getSource() == b2) {
b2.setBackground(Color.CYAN);
}else if (me.getSource() == b3) {
b3.setBackground(Color.CYAN);
}else if (me.getSource() == b4) {
b4.setBackground(Color.CYAN);
}else if (me.getSource() == b5) {
b5.setBackground(Color.CYAN);
}else if (me.getSource() == b6) {
b6.setBackground(Color.CYAN);
}else if (me.getSource() == b7) {
b7.setBackground(Color.CYAN);
}else if (me.getSource() == b8) {
b8.setBackground(Color.CYAN);
}else if (me.getSource() == C1) {
C1.setBackground(Color.CYAN);
}else if (me.getSource() == C2) {
C2.setBackground(Color.CYAN);
}else if (me.getSource() == C3) {
C3.setBackground(Color.CYAN);
}else if (me.getSource() == c4) {
c4.setBackground(Color.CYAN);
}else if (me.getSource() == c5) {
c5.setBackground(Color.CYAN);
}else if (me.getSource() == c6) {
c6.setBackground(Color.CYAN);
}else if (me.getSource() == c7) {
c7.setBackground(Color.CYAN);
}else if (me.getSource() == c8) {
c8.setBackground(Color.CYAN);
}
}
public void mousePressed(MouseEvent me){}
public void mouseReleased(MouseEvent me){}
public void mouseEntered(MouseEvent me){}
public void mouseExited(MouseEvent me) {}


public void actionPerformed(ActionEvent ae) {
if (ae.getSource() == b) {
TicketPrice tp = new TicketPrice(username, userProfile);
tp.setVisible(true);
this.setVisible(false);
}
    if (ae.getSource() == next) {
        Payment p=new Payment(username, userProfile);
        p.setVisible(true);
        this.setVisible(false);
    }
if (ae.getSource() == type || ae.getSource() == tickets) {
updateTotalPrice();
}
}
private void updateTotalPrice() {
int ticketTypeIndex = type.getSelectedIndex();
int totalTickets = tickets.getSelectedIndex() + 1;
if (ticketTypeIndex == 0) {
int totalPrice = 350 * totalTickets;
tprice.setText(String.valueOf(totalPrice));
} else if (ticketTypeIndex == 1) {
int totalPrice = 500 * totalTickets;
tprice.setText(String.valueOf(totalPrice));
}
else if (ticketTypeIndex == 2) {
int totalPrice = 800 * totalTickets;
tprice.setText(String.valueOf(totalPrice));
}
}
 
}