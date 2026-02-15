import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.awt.Cursor;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.swing.BorderFactory;
import javax.swing.border.Border;


public class Registration  implements ActionListener {

    private JLabel nameLabel, emailLabel, passwordLabel, confirmPasswordLabel,titleLabel,alreadyLabel;
    private JTextField nameField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton, clearButton, exitButton,loginButton;
    private ImageIcon on;
    private ImageIcon off;
    private JToggleButton toggleButton;
    private JToggleButton toggleButton2;
    private Cursor cursor;
     JFrame frame;
    

    public Registration() {
		
       frame = new JFrame();
	   
        // Set window title
        frame.setTitle("Registration Page");

        // Set window size
        frame.setSize(900, 600);
        frame.setResizable(false);
		
        // Create labels
		
		titleLabel = new JLabel("Registration Form");
        nameLabel = new JLabel("Username:*");
        emailLabel = new JLabel("Email:*");
        passwordLabel = new JLabel("Password:*");
        confirmPasswordLabel = new JLabel("Confirm Password:*");
        alreadyLabel = new JLabel("Already have an account?");
		
        // Create text fields
        nameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();

        // Create buttons
        registerButton = new JButton("Register");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");
		loginButton = new JButton("Login");
		
        // Set bounds for components
		titleLabel.setBounds(300,30,300,40);
        nameLabel.setBounds(210, 90, 100, 30);
        emailLabel.setBounds(210, 170, 100, 30);
        passwordLabel.setBounds(210, 250, 100, 30);
        confirmPasswordLabel.setBounds(210, 330, 180, 30);
        nameField.setBounds(210, 130, 240, 25);
        emailField.setBounds(210, 210, 240, 25);
        passwordField.setBounds(210, 290, 240, 25);
        confirmPasswordField.setBounds(210, 370, 240, 25);
        registerButton.setBounds(210, 420, 100, 30);
        clearButton.setBounds(350, 420, 100, 30);
        exitButton.setBounds(280,470,100,30);
		loginButton.setBounds(350, 520, 100, 30);
		alreadyLabel.setBounds(135, 520, 250, 30);
		
		new TextPrompt("James Pater", nameField);
		new TextPrompt("amesgosling@example.com", emailField);
		new TextPrompt("Password (*Java17#@)", passwordField);
		new TextPrompt("Confirm Password (Java17#@)", confirmPasswordField);
		
		//Font 
		titleLabel.setFont(new Font("Times And Roman", Font.PLAIN, 28));
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		confirmPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		confirmPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clearButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		alreadyLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		// Set Background
		
		registerButton.setForeground(Color.white);
        registerButton.setBackground(Color.black);
		clearButton.setForeground(Color.white);
        clearButton.setBackground(Color.blue);
		exitButton.setForeground(Color.white);
        exitButton.setBackground(Color.red);
		loginButton.setFocusPainted(false);
		loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginButton.setForeground(new Color(25, 118, 211));
        loginButton.setBackground(new Color(255, 255, 255));
		
        // Add components to window
        frame.add(titleLabel);
		frame.add(nameLabel);
        frame.add(nameField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(confirmPasswordLabel);
        frame.add(confirmPasswordField);
        frame.add(registerButton);
        frame.add(clearButton);
        frame.add(exitButton);
		frame.add(loginButton);
		frame.add(alreadyLabel);
		
		// Hide & Unhide Section
		on = new ImageIcon("C:\\Users\\DELL\\Desktop\\Project-3\\Image\\unhide.png");
        off = new ImageIcon("C:\\Users\\DELL\\Desktop\\Project-3\\Image\\hide.png");
        toggleButton = new JToggleButton(off);
        toggleButton.setBounds(460, 290, 30, 25);
        toggleButton.setBackground(new Color(0, 0, 0, 0));
        toggleButton.setForeground(new Color(0, 0, 0, 0));
        toggleButton.setOpaque(false);
        toggleButton.setCursor(cursor);
        frame.add(toggleButton);

        toggleButton2 = new JToggleButton(off);
        toggleButton2.setBounds(460, 370, 30, 25);
        toggleButton2.setBackground(new Color(0, 0, 0, 0));
        toggleButton2.setForeground(new Color(0, 0, 0, 0));
        toggleButton2.setOpaque(false);
        toggleButton2.setCursor(cursor);
        frame.add(toggleButton2);

        
		
        // Add action listeners to buttons
        registerButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);
		loginButton.addActionListener(this);
		toggleButton.addActionListener(this);
        toggleButton2.addActionListener(this);
		
        // Set window layout to null
        frame.setLayout(null);

        // Set window visibility
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
		
        // Set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            // Get user input
            String username = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
            
			
            // Validate user input
			String upperCaseChars = "(.*[A-Z].*)";
			String lowerCaseChars = "(.*[a-z].*)";
			String numbers = "(.*[0-9].*)";
			String specialChars = "(.*[@,#,$,%].*$)";
			
            if (username.equals("") || email.equals("") || password.equals("") || confirmPassword.equals("")) {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields.");
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(frame, "Passwords do not match.");
            } else if (Email_Decision(email)) {
					JOptionPane.showMessageDialog(null, "Enter a valid Email Address", "Email Warning",
							JOptionPane.WARNING_MESSAGE);
			} else if (password.length() > 15 || password.length() < 8) {
					JOptionPane.showMessageDialog(null, "Password must be less than 20 and more than 8 characters in length.", "Password Warning",
							JOptionPane.WARNING_MESSAGE);
			} else if (!password.matches(upperCaseChars ))
            {
                    JOptionPane.showMessageDialog(null, "Password must have atleast one uppercase character", "Password Warning",
							JOptionPane.WARNING_MESSAGE);
                    
            }
            
            else if (!password.matches(lowerCaseChars ))
            {
                  JOptionPane.showMessageDialog(null, "Password must have atleast one lowercase character", "Password Warning",
							JOptionPane.WARNING_MESSAGE);
                    
            }
            
           else if (!password.matches(numbers ))
            {
                   JOptionPane.showMessageDialog(null, "Password must have atleast one number", "Password Warning",
							JOptionPane.WARNING_MESSAGE);
                    
            }
            
            else if (!password.matches(specialChars ))
            {
                    JOptionPane.showMessageDialog(null, "Password must have atleast one special character", "Password Warning",
							JOptionPane.WARNING_MESSAGE);
                    
            }
			
			
			else {
                // Register user
                if (registerUser(username, email, password)) {
                    JOptionPane.showMessageDialog(frame, "Registration successful.");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(frame, "Registration failed.");
                }
            }
        }  else if (e.getSource() == toggleButton) {
            if (toggleButton.isSelected()) {
                toggleButton.setIcon(on);
				
                passwordField.setEchoChar((char) 0);
            } else {
                toggleButton.setIcon(off);
				
                passwordField.setEchoChar('*');
            }
        }

        else if (e.getSource() == toggleButton2) {
            if (toggleButton2.isSelected()) {
                toggleButton2.setIcon(on);
				
                confirmPasswordField.setEchoChar((char) 0);
            } else {
                toggleButton2.setIcon(off);
			
                confirmPasswordField.setEchoChar('*');
            }
        } else if (e.getSource() == clearButton) {
            // Clear input fields
            clearFields();
        }
		else if(e.getSource()==exitButton)
			  {
			int a = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Confirmation", 0);
			if(a==0)
			{
				System.exit(0);
			}
			
			}
			    else if (loginButton == e.getSource()) {
			    frame.setVisible(false);
                //new Login();
                    }
    }

    boolean registerUser(String username, String email, String password) {
        try {
            // Open user data file for appending
            FileWriter fileWriter = new FileWriter("C:\\Users\\DELL\\Desktop\\Project-3\\Data\\User_Information.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");
            String timeAndDate = myDateObj.format(myFormatObj);
			
            // Write user data to file
            printWriter.println("Name :" +username);
            printWriter.println("Email :" +email);
			printWriter.println("Password :" +password);
			printWriter.println("Time & Date :" +timeAndDate);
			printWriter.println("========================================");
			
			
			
			// Close file
            printWriter.close();
			
           return true;
					
        } catch (IOException e){
            
			System.out.print(e);
            return false;
        }
		   
    }
    private boolean Email_Decision(String email) {

		String word = email;
		int countAt = 0, countDot = 0;

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == '@') {
				countAt++;
			}
			if (countAt == 1 && word.charAt(i) == '.') {
				countDot++;
			}

		}

		if (countAt == 1 && countDot == 1) {
			return false;
		} else {
			return true;
		}

	}
	
    void clearFields() {
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
    }

    
    public static void main(String[] args) {
        new Registration();
    }
}
  