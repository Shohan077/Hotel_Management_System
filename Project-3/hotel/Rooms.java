import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import static javax.swing.JOptionPane.showMessageDialog;
import java.io.File;  
import java.io.IOException; 
import java.io.FileWriter;
import java.io.*;
import java.nio.file.*;
import static javax.swing.JOptionPane.showMessageDialog;
import java.util.Scanner;

public class Rooms implements ActionListener {

    //private Container c;
   // private ImageIcon icon;
    //private JLabel label1;
    private Font f1, f2, f3;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JButton btn1, btn2;
   // private Cursor cursor;

    private String[] column = { "Room No", "Room Status", "Bed Types", "Clean Status", "Price" };
    private String[] rows = new String[7];
	
	JFrame frame;

   public Rooms() {
        frame = new JFrame();
				
	/*frame.setSize(700, 600);
	frame.setVisible(true);
	frame.getContentPane().setBackground(Color.WHITE); 
    frame.setLocationRelativeTo(null);   
	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);	
    frame.setLayout(null);  

      /*  c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F2F2F2"));*/

        // Icon
      /*  icon = new ImageIcon(getClass().getResource("/images/Icon.png"));
        this.setIconImage(icon.getImage());*/

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI", Font.PLAIN, 20);

        // Cursor for JButtons
        //cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
       /* label1 = new JLabel();
        label1.setText("User Data");
        label1.setBounds(200, 10, 400, 80);
        label1.setFont(f1);
        c.add(label1);*/

        // JButtons
          btn1 = new JButton("Refresh");
        btn1.setBounds(50, 418, 150, 50);
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        btn1.setForeground(Color.white);
        btn1.setBackground(Color.black);
        frame.add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(250, 418, 150, 50);
        btn2.setFont(new Font("Tahoma", Font.PLAIN, 18));
      
        btn2.setForeground(Color.white);
        btn2.setBackground(Color.red);
        frame.add(btn2);

       

        

        // JTable Layout
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);
		frame.add(table);

        table.setModel(model);
        table.setFont(f3);
        table.setSelectionBackground(Color.decode("#8AC5FF"));
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(300);
        table.getColumnModel().getColumn(3).setPreferredWidth(220);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
       

        scroll = new JScrollPane(table);
        scroll.setBounds(53, 96, 578, 300);
        scroll.setBackground(Color.WHITE);
        frame.add(scroll);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
			
	btn1.addActionListener(this);
	btn2.addActionListener(this);
	  try  
			{  
			//the file to be opened for reading  
			FileInputStream fis=new FileInputStream("addrooms.txt");   
			Scanner sc=new Scanner(fis);    //file to be scanned  
			//returns true if there is another line to read  
			int i =0;
			String[] valueToshowOntable = new String[5];
			while(sc.hasNextLine())  
			{ 
			if(i>= 0 && i<=4){
		   String value = sc.nextLine();
		   if(value == ""){
			   i=-1;
		   }
			String[] parts = value.split(":");
			System.out.println("ARRAY : "+i);
			
			if(parts.length>1){
				System.out.println(parts[1]); 
				valueToshowOntable[i]=parts[1];
			}
			
				
			}else if(i==5){
			model.addRow(new Object[]{valueToshowOntable[0],valueToshowOntable[1], valueToshowOntable[2], valueToshowOntable[3], valueToshowOntable[4]});		
			valueToshowOntable=null;
			valueToshowOntable= new String[5];
			i=-1;
			}
			
			  i++;   //returns the line that was skipped  
			} 
    model.addRow(new Object[]{valueToshowOntable[0],valueToshowOntable[1], valueToshowOntable[2], valueToshowOntable[3], valueToshowOntable[4]});		
						
			sc.close();     //closes the scanner  
			}  
			catch(IOException ae)  
			{  
			ae.printStackTrace();  
			}
	
	
		
			  
	frame.setSize(700, 600);
    frame.getContentPane().setBackground(Color.WHITE); 
    frame.setLocationRelativeTo(null);   
	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);	
    frame.setLayout(null);  
    frame.setVisible(true);
	
	 
   }
		public void actionPerformed(ActionEvent e) 
	 {  
	     
	     
	      
         if(e.getSource()==btn1)
		 {
			  frame.setVisible(false);
                Rooms frame = new Rooms();
               
		 }	
		 
		 if(e.getSource()==btn2)
		 {
			  frame.setVisible(false);
              new Reception();
               
		 }	
	    
    }
       
		/*btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
				
                if (table.getSelectionModel().isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a user to delete", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
                try{
				File inputFile = new File("filename.txt");
        File tempFile = new File("myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = removeUser;
       // String currentLine;

        while((removeUser = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = removeUser.trim();
            if(trimmedLine.equals(lineToRemove)) continue;
            writer.write(removeUser );
        }
        writer.close(); 
        reader.close(); 
        boolean successful = tempFile.renameTo(inputFile);
        System.out.println(successful);
				}
				catch (Exception a)
				{
					System.out.println(a);
				}
				
				}
	}
      
            
        });*/
		
		
				
	
	

       

  
}
