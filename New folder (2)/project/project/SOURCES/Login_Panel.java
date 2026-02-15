import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//import java.awt.Font.*;
import java.util.*;
import java.io.*;
//import java.net.URL;
//import javax.sound.sampled.*;

public class Login_Panel {
	String user_username, user_password;

	static int invalidCount = 0;
	int fileNo;
	int employee_fileNo;

	/////////////////////// Colors/////////////////////
	Color BRAND_BLUE = new Color(13, 60, 251);
	Color BRAND_GREEN = new Color(19, 156, 126);
	Color LIGHT_RED = new Color(255, 102, 102);
	Color LIGHT_BLUE = new Color(51, 153, 255);
	Color Dark_CYAN = new Color(14, 161, 177);

	public Login_Panel() {
		///////////////////// Basic Frame Creation/////////////////////
		JFrame frame = new JFrame();
		frame.setSize(933, 700);
		frame.setLocationRelativeTo(null);
		// frame.setTitle("Welcome back!");
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("Image\\Logo.png");
		frame.setIconImage(frame_icon);
		frame.setResizable(false);

		///////////////////// Frame Close Confirmation/////////////////////

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {

				int result = JOptionPane.showConfirmDialog(null, "Do you want to Exit?", "Exit Confirmation",
						JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					//////////////////////////////////////////
					///////////////////// Source Folder/////////////////////

					/////////////// Change the path when you edit the code////////////////////
					////////////// Use double back slash (\\) before every folder name////////////

					File folder = new File("D:\\New folder (2)\\project\\SOURCES");
					File fList[] = folder.listFiles();

					for (File f : fList) {
						if (f.getName().endsWith(".class")) {
							f.delete();
						}
					}

					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				} else {
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});

		/////////////////////// Container creation/////////////////////
		Container panel = new Container();
		panel = frame.getContentPane();
		panel.setLayout(null);

		//////////////////// Reading User File NO///////////////////////////////////////
		String filenumber = "";
		try {
			File otp_File = new File("TXT FILES\\User_File_No.txt");
			Scanner scanFile = new Scanner(otp_File);// Scan File

			while (scanFile.hasNext()) {
				filenumber = scanFile.next();
				break;
			}
			scanFile.close();

			fileNo = Integer.parseInt(filenumber);
			fileNo = fileNo - 1;

		} catch (Exception f) {
			System.out.println("Running user file No Reading Problem in Signup Panel");
		}


		/////////////////////// Font for user and pass field
		Font PassUser_font = new Font("Ubuntu", Font.PLAIN, 14);

		/////////////////////// Username textfield/////////////////////
		JTextField user_field = new JTextField();
		user_field.setBounds(160, 290, 125, 30);
		user_field.setFont(PassUser_font);
		user_field.setOpaque(false);
		user_field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		new TextPrompt("Username", user_field);
		panel.add(user_field);

		/////////////////////// Password Field/////////////////////
		JPasswordField pass_field = new JPasswordField();
		pass_field.setBounds(160, 360, 125, 30);
		pass_field.setEchoChar('*');
		pass_field.setOpaque(false);
		pass_field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pass_field.setFont(PassUser_font);
		new TextPrompt("Password", pass_field);
		panel.add(pass_field);

		/////////////////////// Hide Icon/////////////////////
		JButton hide = new JButton(new ImageIcon("Image\\hide.png"));
		hide.setBounds(275, 365, 22, 20);
		hide.setVisible(true);
		hide.setCursor(new Cursor(Cursor.HAND_CURSOR));

		hide.setContentAreaFilled(false);
		hide.setFocusPainted(false);
		hide.setBorderPainted(false);

		panel.add(hide);

		/////////////////////// Unhide Icon/////////////////////
		JButton unhide = new JButton(new ImageIcon("Image\\unhide.png"));
		unhide.setBounds(275, 365, 22, 20);
		unhide.setVisible(false);
		unhide.setCursor(new Cursor(Cursor.HAND_CURSOR));

		unhide.setContentAreaFilled(false);
		unhide.setFocusPainted(false);
		unhide.setBorderPainted(false);

		panel.add(unhide);

		/////////////////////// hideIcon active listener/////////////////////
		hide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				pass_field.setEchoChar((char) 0);
				hide.setVisible(false);
				unhide.setVisible(true);
				pass_field.requestFocusInWindow();

			}
		});

		/////////////////////// unhideIcon active listener/////////////////////
		unhide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				pass_field.setEchoChar('*'); //// display password
				unhide.setVisible(false);
				hide.setVisible(true);
				pass_field.requestFocusInWindow();
			}
		});

		//////////////////// Login Button/////////////////////
		Font loginFont = new Font("Ubuntu", Font.BOLD, 15);
		JButton login_button = new JButton("Log In");
		login_button.setBounds(155, 395, 140, 30);
		login_button.setFont(loginFont);
		login_button.setFocusPainted(false);
		login_button.setCursor(new Cursor(Cursor.HAND_CURSOR));

		login_button.setBackground(BRAND_BLUE);
		login_button.setForeground(Color.WHITE);

		// Add hover in login button
		login_button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				login_button.setBackground(BRAND_GREEN);
				login_button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				login_button.setBackground(BRAND_BLUE);
				login_button.setForeground(Color.WHITE);
			}
		});

		panel.add(login_button);

		// Create Account Button
		Font sign_font = new Font("Ubuntu", Font.PLAIN, 16);

		JButton create_button = new JButton("Create an account");
		create_button.setBounds(148, 460, 180, 30);
		create_button.setToolTipText("Create New Account");
		create_button.setForeground(LIGHT_RED);
		create_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		create_button.setFont(sign_font);
		// Make Transparent Button
		create_button.setContentAreaFilled(false);
		create_button.setFocusPainted(false);
		create_button.setBorderPainted(false);

		// Add hover in Creat Account button
		create_button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				create_button.setForeground(BRAND_BLUE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				create_button.setForeground(LIGHT_RED);
			}
		});

		panel.add(create_button);

		/////////////////////// Forgate Password Button/////////////////////
		Font forgetFont = new Font("Ubuntu", Font.PLAIN, 12);

		JButton forget_button = new JButton("Forgot Password ?");
		forget_button.setBounds(200, 430, 140, 30);
		forget_button.setToolTipText("Enter to change password");
		forget_button.setForeground(LIGHT_RED);
		forget_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		forget_button.setFont(forgetFont);
		// Make Transparent Button
		forget_button.setContentAreaFilled(false);
		forget_button.setFocusPainted(false);
		forget_button.setBorderPainted(false);

		// Add hover in Forgate Password button
		forget_button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				forget_button.setForeground(BRAND_BLUE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				forget_button.setForeground(LIGHT_RED);
			}
		});

		panel.add(forget_button);

		/////////////////////// Set Background Image/////////////////////
		ImageIcon bg_image = new ImageIcon("Image\\LogIn_BG.jpg");

		JLabel bg_label = new JLabel(bg_image);
		bg_label.setBounds(0, 0, 933, 700);
		panel.add(bg_label);

		// ActionListener for Create Account Button
		create_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				frame.setVisible(false);
				new Signup_Panel();
			}
		});

		// ActionListener for Forgot Password Button
		forget_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				frame.setVisible(false);
				try {
					new Username();
				} catch (Exception fd) {
					System.out.println("Login Panel user gui call problem");
				}
			}
		});

		// ActionListener for Login Button
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Admin Panel Login Confirmation
				String user = user_field.getText();
				String pass = new String(pass_field.getPassword());
				boolean user_access = false;
				/////////////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////////////

				// Get User Information

				for (int i = 1; i <= fileNo; i++) {
					String User_Information_File_Path = "TXT FILES/User Information/User--" + i + ".txt";

					try {
						File user_file = new File(User_Information_File_Path);
						Scanner scanFile = new Scanner(user_file);// Scan File

						while (scanFile.hasNext()) {
							user_username = scanFile.next();
							user_password = scanFile.next();
							break;
						}
						scanFile.close();

						if ((user.equals(user_username)) && (pass.equals(user_password))) {
							break;
						}
					} catch (Exception f) {
						System.out.println("User File Problem in Login Panel");
					}
				}

				if ((user.equals(user_username)) && (pass.equals(user_password))) {
					user_access = true;
				} else {
					user_access = false;
				}

				// Get Login

				if (user_access) {

					// Writting the username to running user file
					try {
						Formatter formatter = new Formatter("TXT FILES\\Running_User.txt");

						formatter.format("%s", user_username);
						formatter.close();

					} catch (Exception f) {
						System.out.println(f);
					}

					// writting done
					//JOptionPane.showMessageDialog(null, "NEW GUI OBJECT WILL BE CREATE HERE", "WARNING",
							//JOptionPane.WARNING_MESSAGE);
							frame.setVisible(false);
							Home H=new Home();
							H.setVisible(true);
				}

				else {
					invalidCount++;

					if (invalidCount > 5) {
						JOptionPane.showMessageDialog(null,
								"You Have Entered wrong Information more than 5 times. Get Out from my Store",
								"WARNING", JOptionPane.WARNING_MESSAGE);
						System.exit(0);
					}
					JOptionPane.showMessageDialog(null, "Enter Valid Username or Password", "Login Confirmation",
							JOptionPane.WARNING_MESSAGE);
				}

				///////////////////
			}
		});
		frame.setVisible(true);

	}
}