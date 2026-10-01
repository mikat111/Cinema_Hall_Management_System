package Entity;
import GUI.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account {
    private String username;
    private String pass;
    private String number;
    private String email;
    private String male;
    private String female;

    private File file;
    private FileWriter fwriter;
    private Scanner sc;

    public Account() {
        this.username = "";
    }

    public Account(String username, String pass, String number, String email, String male, String female) {
        this.username = username;
        this.pass = pass;
        this.number = number;
        this.email = email;
        this.male = male;
        this.female = female;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public void setpass(String pass) {
        this.pass = pass;
    }

    public String getusername() {
        return username;
    }

    public String getpass() {
        return pass;
    }

    public void addaccount() {
        try {
            file = new File("Data/Data.txt");
            file.createNewFile();
            fwriter = new FileWriter(file, true);
            fwriter.write(getusername() + "\t");
            fwriter.write(number + "\t");
            fwriter.write(email + "\t");
            fwriter.write(male + "\t");
            fwriter.write(getpass() + "\t");
            fwriter.write(female + "\n");
            
            fwriter.flush();
            fwriter.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public boolean getAccount(String username, String pass) {
        boolean flag = false;
        file = new File("Data/Data.txt");

        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] values = line.split("\t");

                if (values.length >= 2 && values[0].equals(username) && values[4].equals(pass)) {
                    flag = true;
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return flag;
    }
    public List<String[]> getAccountInfo(String username) {
        List<String[]> userInfos = new ArrayList<>();
        file = new File("Data/Data.txt");

        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] values = line.split("\t");

                if (values.length >= 2 && values[0].equals(username)) {
                    userInfos.add(values);
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return userInfos;
    }

}