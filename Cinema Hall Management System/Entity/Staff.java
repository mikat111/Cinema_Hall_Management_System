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
public class Staff extends JFrame implements ActionListener {
    private JTable customerTable;
    ImageIcon img;
    private JPanel panel;
    private JButton add, delete, b, update;
    private DefaultTableModel customerModel;
    private Color c1;
    private Font f1, f2, f3;
    JLabel label,nameLabel,numberLabel,ageLabel,idLabel,salaryLabel,positionLabel;
    JTextField nameField,numberField,ageField,idField,salaryField,positionField;
    public Staff() {
        super("Staff Dashboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(950, 650);

        c1 = new Color(33, 43, 73);
        f1 = new Font("Arial", Font.BOLD, 40);
        f2 = new Font("Arial", Font.PLAIN, 20);
        f3 = new Font("Arial", Font.PLAIN, 20);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(c1);
        label = new JLabel("Manage Staff");
        label.setBounds(350,10,360,50);
        label.setFont(f1);
        label.setForeground(Color.WHITE);
        panel.add(label);
//Crating Labels
        label = new JLabel("Manage Doctor");
        label.setBounds(350,10,360,50);
        panel.add(label);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(280,60,100,40);
        nameLabel.setFont(f3);
        nameLabel.setForeground(Color.WHITE);
        panel.add(nameLabel);

        ageLabel = new JLabel("age");
        ageLabel.setBounds(385,60,100,40);
        ageLabel.setFont(f3);
        ageLabel.setForeground(Color.WHITE);
        panel.add(ageLabel);

        idLabel = new JLabel("ID");
        idLabel.setBounds(181,60,100,40);
        idLabel.setFont(f3);
        idLabel.setForeground(Color.WHITE);
        panel.add(idLabel);

        salaryLabel = new JLabel("Number");
        salaryLabel.setBounds(585,60,140,40);
        salaryLabel.setFont(f3);
        salaryLabel.setForeground(Color.WHITE);
        panel.add(salaryLabel);

        numberLabel = new JLabel("Salary");
        numberLabel.setBounds(484,60,140,40);
        numberLabel.setFont(f3);
        numberLabel.setForeground(Color.WHITE);
        panel.add(numberLabel);

        positionLabel = new JLabel("Position");
        positionLabel.setBounds(685,60,140,40);
        positionLabel.setFont(f3);
        positionLabel.setForeground(Color.WHITE);
        panel.add(positionLabel);

//TextFields
        nameField = new JTextField(" ");
        nameField.setBounds(280,100,80,40);
        panel.add(nameField);

        numberField = new JTextField(" ");
        numberField.setBounds(484,100,80,40);
        panel.add(numberField);

        ageField = new JTextField(" ");
        ageField.setBounds(385,100,80,40);
        panel.add(ageField);

        idField = new JTextField(" ");
        idField.setBounds(181,100,80,40);
        panel.add(idField);

        salaryField = new JTextField(" ");
        salaryField.setBounds(585,100,80,40);
        panel.add(salaryField);

        positionField = new JTextField(" ");
        positionField.setBounds(685,100,80,40);
        panel.add(positionField);

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
        customerModel.addColumn("ID");
        customerModel.addColumn("Name");
        customerModel.addColumn("Age");
        customerModel.addColumn("Salary");
        customerModel.addColumn("Number");
        customerModel.addColumn("Position");
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
            Scanner sc = new Scanner(new File("Data/Staff.txt"));
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
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            int selectedRow = customerTable.getSelectedRow();
            if (selectedRow != -1) { // Check if a row is selected
                String id = idField.getText();
                String name = nameField.getText();
                String age = ageField.getText();
                String number = numberField.getText();
                String salary = salaryField.getText();
                String position = positionField.getText();
                if (!id.trim().isEmpty() && !name.trim().isEmpty() && !age.trim().isEmpty() && !number.trim().isEmpty() && !salary.trim().isEmpty()&& !position.trim().isEmpty()) {
                    String[] newData = {id, name, age, number, salary ,position};

                    for (int i = 0; i < newData.length; i++) {
                        customerTable.setValueAt(newData[i], selectedRow, i);
                    }

                    try {

                        List<String> lines = Files.readAllLines(Paths.get("Data/Staff.txt"));

                        String updatedLine = String.join("\t", newData);
                        lines.set(selectedRow, updatedLine);

                        Files.write(Paths.get("Staff.txt"), lines);
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }

                    idField.setText("");
                    nameField.setText("");
                    ageField.setText("");
                    numberField.setText("");
                    salaryField.setText("");
                    positionField.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Please fill in all fields before updating the user information.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to update.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == add) {
            String id = idField.getText();
            String name = nameField.getText();
            String age = ageField.getText();
            String number = numberField.getText();
            String salary = salaryField.getText();
            String position = positionField.getText();
            if (!id.trim().isEmpty() && !name.trim().isEmpty() && !age.trim().isEmpty() && !number.trim().isEmpty() && !salary.trim().isEmpty()&& !position.trim().isEmpty()) {
                String[] newData = {id, name, age, number, salary, position};
                customerModel.addRow(newData);

                try {

                    Files.write(Paths.get("Data/Staff.txt"), Arrays.asList(String.join("\t", newData)), StandardOpenOption.APPEND);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

                idField.setText("");
                nameField.setText("");
                ageField.setText("");
                numberField.setText("");
                salaryField.setText("");
                positionField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields before adding a new user.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == delete) {
            int selectedRow = customerTable.getSelectedRow();
            if (selectedRow != -1) {

                customerModel.removeRow(selectedRow);

                try {

                    List<String> lines = Files.readAllLines(Paths.get("Data/Staff.txt"));

                    lines.remove(selectedRow);

                    Files.write(Paths.get("Data/Staff.txt"), lines);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == b)
        {
            AdminDashboard admindashboard =new AdminDashboard();
            this.setVisible(false);
            admindashboard.setVisible(true);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Staff());
    }
}
