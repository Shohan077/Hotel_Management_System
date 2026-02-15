import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

class Login extends JFrame implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JButton login;
    private JButton reset;
	private JButton reg;
    private JTextArea res;

    //check the new approaches such as use of Container, ContentPane, setBounds, setSize, setLocation, Font, Scanner constructor
    public Login() {
        setTitle("Login Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Login Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        c.add(tname);

        mno = new JLabel("Mobile");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 150);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(150, 20);
        tmno.setLocation(200, 150);
        c.add(tmno);

        login = new JButton("Login");
        login.setFont(new Font("Arial", Font.PLAIN, 15));
        login.setSize(100, 20);
        login.setLocation(150, 200);
        login.addActionListener(this);
        c.add(login);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(280, 200);
        reset.addActionListener(this);
        c.add(reset);
		
		reg = new JButton("Registration");
        reg.setFont(new Font("Arial", Font.PLAIN, 15));
        reg.setSize(150, 20);
        reg.setLocation(200, 250);
        reg.addActionListener(this);
        c.add(reg);

        res = new JTextArea();
        res.setFont(new Font("Arial", Font.PLAIN, 15));
        res.setSize(300, 300);
        res.setLocation(500, 100);
        res.setLineWrap(true);
        res.setEditable(false);
        c.add(res);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
           
		 String username = tname.getText();
        String password = tmno.getText();
        String fileData = "";
        boolean validCredentials = false;

        try {
            File file = new File("registration.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                fileData += scanner.nextLine() + "\n";
            }

            scanner.close();

            // Check if username and password match any registration data
            if (fileData.contains("Name : " + username) && fileData.contains("Mobile : " + password)) {
                validCredentials = true;
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
        }

        if (validCredentials) {
            // Successful login
            res.setText("Login successful!");
            
        } else {
            // Invalid username or password
            res.setText("Invalid username or password!");
        }
	}
         else if (e.getSource() == reset)
		{
			tname.setText("");
			tmno.setText("");
			res.setText("");
			
		}
		else if (e.getSource() == reg)
		{
			new Registration();
			this.setVisible(false);
			
		}
	}
	public static void main(String[] args) {
        new Login();
    }
}
