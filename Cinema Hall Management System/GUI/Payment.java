package GUI;
import Entity.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener

{

	ImageIcon img;

	JPanel panel;

	JButton nextButton,b;

	JLabel SP,CardNo,NameOnCard,ExpDate,CP,tk;

	JTextField CN,NameoC,EXP,c;

	Color c1;

	Font f1,f2;

	private String username;

	private Profile userProfile;

	public Payment(String username, Profile userProfile)

	{

		super("Payment");

		this.setSize(880,570);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		c1 = new Color(33,43,73);

		f1=new Font("Arial", Font.PLAIN,23);

		f2=new Font("Arial",Font.BOLD,33);

		panel = new JPanel();

		panel.setLayout(null);

		panel.setBackground(c1);

		ImageIcon originalImg = new ImageIcon("Image/b.PNG");

		int smallMaxWidth = 30;

		int smallMaxHeight = 30;

		Image smallScaledImage = originalImg.getImage().getScaledInstance(smallMaxWidth, smallMaxHeight, Image.SCALE_SMOOTH);

		img = new ImageIcon(smallScaledImage);

		b = new JButton(img);

		b.setBounds(450, 50, smallMaxWidth, smallMaxHeight);

		b.setBackground(c1);

		b.addActionListener(this);

		panel.add(b);

		ImageIcon taka = new ImageIcon("Image/tk.PNG");

		int tkx = 440;

		int tky = 570;

		Image smallScaledImage1 = taka.getImage().getScaledInstance(tkx, tky, Image.SCALE_SMOOTH);

		img = new ImageIcon(smallScaledImage1);

		tk = new JLabel(img);

		tk.setBounds(0, 0, tkx, tky);

		tk.setBackground(c1);

		panel.add(tk);
		nextButton = new JButton("Pay");

		nextButton.setBounds(450,400,400,50);

		nextButton.setBackground(Color.ORANGE);

		nextButton.setForeground(Color.BLACK);

		nextButton.setFont(new Font("Arial",Font.BOLD,26));

		nextButton.addActionListener(this);

		panel.add(nextButton);
		SP = new JLabel("Secure Payment");

		SP.setBounds(500, 50, 400, 75);

		SP.setForeground(Color.WHITE);

		SP.setFont(new Font("Arial",Font.BOLD,36));

		panel.add(SP);
		CardNo = new JLabel("*Card Number:");

		CardNo.setBounds(450, 150, 300, 25);

		CardNo.setForeground(Color.WHITE);

		CardNo.setFont(new Font("Arial",Font.BOLD,14));

		panel.add(CardNo);

		CN = new JTextField();

		CN.setBounds(450, 175, 400, 25);

		CN.setBackground(Color.WHITE);

		panel.add(CN);
		NameOnCard= new JLabel("*Name On Card:");

		NameOnCard.setBounds(450, 225, 300, 25);

		NameOnCard.setForeground(Color.WHITE);

		NameOnCard.setFont(new Font("Arial",Font.BOLD,14));

		panel.add(NameOnCard);

		NameoC= new JTextField();

		NameoC.setBounds(450, 250, 400, 25);

		NameoC.setBackground(Color.WHITE);

		panel.add(NameoC);
		ExpDate = new JLabel("*Expiration Date:");

		ExpDate.setBounds(450, 300, 200, 25);

		ExpDate.setForeground(Color.WHITE);

		ExpDate.setFont(new Font("Arial",Font.BOLD,14));

		panel.add(ExpDate);

		EXP = new JTextField();

		EXP.setBounds(450, 325, 200, 25);

		EXP.setBackground(Color.WHITE);

		panel.add(EXP);
		CP = new JLabel("*CVV:");

		CP.setBounds(675, 300, 200, 25);

		CP.setForeground(Color.WHITE);

		CP.setFont(new Font("Arial",Font.BOLD,14));

		panel.add(CP);

		c = new JTextField();

		c.setBounds(675, 325, 175, 25);

		c.setBackground(Color.WHITE);

		panel.add(c);

		setLocationRelativeTo(null);

		this.add(panel);

	}

	public void actionPerformed(ActionEvent ae)

	{

		if (ae.getSource() == b) {

			Seat s=new Seat(username,userProfile);

			s.setVisible(true);

			this.setVisible(false);

		}

		else if (ae.getSource() == nextButton) {
			if (CN.getText().isEmpty() || NameoC.getText().isEmpty() || EXP.getText().isEmpty() || c.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Thank you for purchasing", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
		}


	}


}