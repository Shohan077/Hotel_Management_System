import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import myClasses.Customer;

public class Login extends JFrame implements ActionListener
 {
    JLabel userNameLable, userPassLabel;
    JTextField userName;
    JPasswordField password;
    JButton btnLogin;
    Font font = new Font("cambria", Font.PLAIN, 20);

    public Login() {
        super("Login");
        this.setSize(400, 300);
        this.setLocation(300, 200);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


		//USER NAME Lable
        userNameLable = new JLabel("User Name");
        userNameLable.setBounds(30, 50, 100, 25);
        userNameLable.setFont(font);
        this.add(userNameLable);
		//USER NAME TextField
        userName = new JTextField("John");
        userName.setBounds(150, 50, 150, 25);
        userName.setFont(font);
        this.add(userName);
		
		//User Password Label 
        userPassLabel = new JLabel("Password");
        userPassLabel.setBounds(30, 100, 100, 25);
        userPassLabel.setFont(font);
        this.add(userPassLabel);
		//User Password Password Field
        password = new JPasswordField("1234");
        password.setBounds(150, 100, 150, 25);
		password.setEchoChar('*');
        password.setFont(font);
        this.add(password);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(100, 140, 120, 35);
        btnLogin.setFont(font);
        btnLogin.addActionListener(this);
        this.add(btnLogin);

        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (btnLogin == e.getSource()) {
            String name = userName.getText();
            String pass = String.valueOf(password.getPassword());

            if (name.equals("John") && pass.equals("1234")) {
				
                Customer c = new Customer("+988877655544", 15);
                
				DataEntry entry = new DataEntry(this, c);

                userName.setText("");
                password.setText("");

                entry.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid User Name or Password", 
											  "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
