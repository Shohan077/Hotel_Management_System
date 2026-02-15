import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class UserData implements ActionListener
{
	private JFrame frame;
	private JLabel label1;
	private JButton refresh;
	private JButton previous0;
	private JButton add;
	private JButton delete;
	private JButton exitButton;
	private JTable table;
    private DefaultTableModel model;
    private String[] column = { "User Name", "Password", "Email", "Date and Time" };
    private String[] rows = new String[8];
    private JScrollPane scroll;
	
	private String file = "C:\\Users\\DELL\\Desktop\\Project-3\\User_Information.txt";
    private String temp = "C:\\Users\\DELL\\Desktop\\Project-3\\temp.txt";
	
	public UserData()
	{   
	    
		
		this.frame = new JFrame();
		frame.setSize(850, 550);
		
		// Create Component
		label1 = new JLabel("User Data");
		refresh= new JButton("Refresh");
		delete= new JButton("Delete User");
		add= new JButton("Add User");
		previous0 = new JButton ("Back");
		exitButton = new JButton("Exit");
	    table = new JTable();
        model = new DefaultTableModel();
		
		// SetBounds
		label1.setBounds(350, 0, 300, 60);
		refresh.setBounds(150, 380, 150, 35);
		add.setBounds(350, 380, 150, 35);
		delete.setBounds(550, 380, 150, 35);
		previous0.setBounds(270, 440, 150, 35);
		exitButton.setBounds(460, 440, 150, 35);
		
        model.setColumnIdentifiers(column);
        
        table.setModel(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        table.setSelectionBackground(Color.decode("#8AC5FF"));
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(300);
        table.getColumnModel().getColumn(3).setPreferredWidth(220);

        scroll = new JScrollPane(table);
        scroll.setBounds(70, 80, 700, 280);
        scroll.setBackground(Color.WHITE);
        frame.add(scroll);
 
       try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
            {
                totalLines++;
            }
            reader.close();

            for (int i = 0; i < totalLines; i++)
			{
                String line = Files.readAllLines(Paths.get(file)).get(i);
                String x = line.substring(0, 4);
                if (x.equals("User"))
				{
                    rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(12); // User Name
                    rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(11); // Password
                    rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(8); // Email
                    rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(14); // Date and Time
                    model.addRow(rows);
                }
            }

        } 
        catch (Exception ex)
		{
        	JOptionPane.showMessageDialog(null, "Something went horribly wrong!", "Warning!", 0);
            return;
        }
		
		
		
		// Add Component
		frame.add(label1);
		frame.add(refresh);
		frame.add(add);
		frame.add(delete);
		frame.add(previous0);
		frame.add(exitButton);
		
		
		// Add ActionListener
		add.addActionListener(this);
		delete.addActionListener(this);
		previous0.addActionListener(this);
		exitButton.addActionListener(this);
		
		// Frame Component
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout (null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==refresh)
		{
            new UserData();
			frame.setVisible(false);
		}
		else if(e.getSource()==delete)
		{
			if(table.getSelectionModel().isSelectionEmpty())
			{
				 JOptionPane.showMessageDialog(null, "Please select a user to delete", "Warning!",JOptionPane.WARNING_MESSAGE);
             }
			 else 
			 {
				 String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

                 File oldFile = new File(file);
                 File newFile = new File(temp);

                 int q = 0;

                 try
				 {
					 BufferedReader reader = new BufferedReader(new FileReader(file));
                     int totalLines = 0;
                     while (reader.readLine() != null)
						 totalLines++;
					 reader.close();
					 
					 for (int i = 0; i < totalLines; i++)
					 {
                         String line = Files.readAllLines(Paths.get(file)).get(i);
                         String x = line.substring(0, 4);
                         if (x.equals("User"))
						 {
							 String userName = Files.readAllLines(Paths.get(file)).get(i);
                             if (userName.substring(12).equals(removeUser))
							 {
                                 q = i;
                             }
                         }
                     }
                 }				 
                 catch (Exception ex)
				 {
                     return;
                 }
                 	try
					{
                     	FileWriter fw = new FileWriter(temp, true);
                     	BufferedWriter bw = new BufferedWriter(fw);
                     	PrintWriter pw = new PrintWriter(bw);

                     	FileReader fr = new FileReader(file);
                     	BufferedReader br = new BufferedReader(fr);

                     	BufferedReader reader = new BufferedReader(new FileReader(file));
                     	int totalLines = 0;
                     	while (reader.readLine() != null)
						{
                         	totalLines++;
                     	}
                     	reader.close();

                     	for (int j = 0; j < totalLines; j++)
						{
                         	String line = Files.readAllLines(Paths.get(file)).get(j);
                         	String x = line.substring(0, 4);

                         	if (q != 0 && (j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4) || j == (q + 5)))
							{
                        	 	String userName = Files.readAllLines(Paths.get(file)).get(j);
                             	pw.println("#Removed! " + userName);
                         	} 
                         	else
							{
                             	String userName = Files.readAllLines(Paths.get(file)).get(j);
                             	pw.println(userName);
                         	}
                     	}
                     	pw.flush();
                     	pw.close();
                     	fr.close();
                     	br.close();
                     	bw.close();
                     	fw.close();

                 	} 
                 	catch (Exception ex) 
                 	{
						System.out.print(ex);
                 	}

                 	oldFile.delete();
                 	File dump = new File(file);
                 	newFile.renameTo(dump);

                 	frame.setVisible(false);
                 	new UserData();
			 	}
			}
		
		
		else if (e.getSource()==add)
		{
            new Registration();
			frame.setVisible(false);
		}
		
		else if (e.getSource()==previous0)
		{
            new Registration();
			frame.setVisible(false); 			
		}
		else if (e.getSource()==exitButton)
		{
			int a = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Confirmation", 0);
			if(a==0)
			{
				System.exit(0);
			}
		}		
	}
	public static void main(String[] args) {
        new UserData();
    }
		
}







































