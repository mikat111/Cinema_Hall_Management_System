package Entity;
import GUI.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdminDashboard extends JFrame implements ActionListener {
    private JTable customerTable;
    ImageIcon img;
    private JPanel panel;
    private JButton add, delete, b,  update, staff;
    private DefaultTableModel customerModel;
    private Color c1;
    private Font f1, f2, f3;
    JLabel label,nameLabel,numberLabel,email,passwordLabel;
    JTextField nameField,numberField,emailField,passField;

    public AdminDashboard() {
        super("Admin Dashboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(950, 650);


        c1 = new Color(33, 43, 73);

        f1 = new Font("Arial", Font.BOLD, 40);
        f2 = new Font("Arial", Font.PLAIN, 20);
        f3 = new Font("Arial", Font.PLAIN, 20);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(c1);

        label = new JLabel("Manage User");
        label.setBounds(350,10,360,50);
        label.setFont(f1);
        label.setForeground(Color.WHITE);
        panel.add(label);

        nameLabel = new JLabel("Userame");
        nameLabel.setBounds(220,73,85,40);
        nameLabel.setFont(f3);
        nameLabel.setForeground(Color.WHITE);
        panel.add(nameLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(365,73,90,40);
        passwordLabel.setFont(f3);
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel);

        numberLabel = new JLabel("Number");
        numberLabel.setBounds(529,73,90,40);
        numberLabel.setFont(f3);
        numberLabel.setForeground(Color.WHITE);
        panel.add(numberLabel);

        email = new JLabel("Gender");
        email.setBounds(650,73,90,40);
        email.setFont(f3);
        email.setForeground(Color.WHITE);
        panel.add(email);

        nameField = new JTextField("");
        nameField.setBounds(210,115,100,30);
        panel.add(nameField);

        numberField = new JTextField("");
        numberField.setBounds(510,115,100,30);
        panel.add(numberField);

        emailField = new JTextField("");
        emailField.setBounds(650,115,100,30);
        panel.add(emailField);

        passField = new JTextField("");
        passField.setBounds(360,115,100,30);
        panel.add(passField);

        update = new JButton("Update");
        update.setBounds(800, 250, 90, 30);
        update.setBackground(new Color(255, 140, 0));
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        panel.add(update);

        add = new JButton("Add");
        add.setBounds(800, 200, 90, 30);
        add.setBackground(new Color(255, 140, 0));
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        delete = new JButton("Delete");
        delete.setBounds(800, 300, 90, 30);
        delete.setBackground(new Color(255, 140, 0));
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        panel.add(delete);

        staff = new JButton("Staff Info");
        staff.setBounds(800, 400, 90, 30);
        staff.setBackground(Color.CYAN);
        staff.setForeground(Color.BLACK);
        staff.addActionListener(this);
        panel.add(staff);

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

        customerModel = new DefaultTableModel();
        customerModel.addColumn("Username");
        customerModel.addColumn("Password");
        customerModel.addColumn("Number");
        customerModel.addColumn("Gender");

        customerTable = new JTable(customerModel);
        customerTable.setRowHeight(30);
        customerTable.setBackground(new Color(211,227,253));

        createTableFromAccountData();

        JScrollPane scrollPane = new JScrollPane(customerTable);
        scrollPane.setBounds(180, 170, 600, 400);
        panel.add(scrollPane);
        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);

    }
    private void createTableFromAccountData() {
        try {
            Scanner sc = new Scanner(new File("Data/Data.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] values = line.split("\t");
                if (values.length >= 4) {
                    customerModel.addRow(values);
                }
            }
            sc.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            int selectedRow = customerTable.getSelectedRow();
            if (selectedRow != -1) { // Check if a row is selected
                String name = nameField.getText();
                String number = numberField.getText();
                String email = emailField.getText();
                String password = passField.getText();
                if (!name.trim().isEmpty() && !number.trim().isEmpty() && !email.trim().isEmpty() && !password.trim().isEmpty()) {
                    String[] newData = {name, password, number, email};
                    for (int i = 0; i < newData.length; i++) {
                        customerTable.setValueAt(newData[i], selectedRow, i);
                    }

                    try {

                        List<String> lines = Files.readAllLines(Paths.get("Data.txt"));

                        String updatedLine = String.join("\t", newData);
                        lines.set(selectedRow, updatedLine);

                        Files.write(Paths.get("Data/Data.txt"), lines);
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }

                    nameField.setText("");
                    numberField.setText("");
                    emailField.setText("");
                    passField.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Please fill in all fields before updating the user information.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to update.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == add) {
            String name = nameField.getText();
            String number = numberField.getText();
            String email = emailField.getText();
            String password = passField.getText();
            if (!name.trim().isEmpty() && !number.trim().isEmpty() && !email.trim().isEmpty() && !password.trim().isEmpty()) {
                String[] newData = {name, password, number, email};
                customerModel.addRow(newData);

                try {

                    Files.write(Paths.get("Data/Data.txt"), Arrays.asList(String.join("\t", newData)), StandardOpenOption.APPEND);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
// Clear the input fields
                nameField.setText("");
                numberField.setText("");
                emailField.setText("");
                passField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields before adding a new user.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == delete) {
            int selectedRow = customerTable.getSelectedRow();
            if (selectedRow != -1) { // Check if a row is selected
// Remove the selected row from the table
                customerModel.removeRow(selectedRow);
// Remove the selected row from the file
                try {
// Read all lines from the file
                    List<String> lines = Files.readAllLines(Paths.get("Data.txt"));
// Remove the corresponding line from the list
                    lines.remove(selectedRow);
// Write the updated lines back to the file
                    Files.write(Paths.get("Data/Data.txt"), lines);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == b)
        {
            Admin admin =new Admin();
            this.setVisible(false);
            admin.setVisible(true);

        }
        else if(e.getSource()==staff)

        {
            Staff staff =new Staff();
            this.setVisible(false);
            staff.setVisible(true);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminDashboard());
    }
}