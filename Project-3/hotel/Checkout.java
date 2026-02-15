import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;


public class Checkout implements ActionListener {

 
    private Font f1, f2, f3;
    private JScrollPane scroll;
    private JTable table;
    private static DefaultTableModel model;
    private JButton btn1, btn2, nBtn;
   

    private String[] column = { "Name", "NID Number", "Address", "Phone" };
    private String[] rows = new String[7];
	
	JFrame frame;

   public Checkout() {
        frame = new JFrame();
				
	

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI", Font.PLAIN, 20);

        

        // JButtons
        btn1 = new JButton("Checkout");
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

        
        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        frame.add(nBtn);


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
			FileInputStream fis=new FileInputStream("new_customer.txt");   
			Scanner sc=new Scanner(fis);    //file to be scanned  
			//returns true if there is another line to read  
			int i =0;
			String[] valueToshowOntable = new String[4];
			while(sc.hasNextLine())  
			{ 
			if(i>= 0 && i<=3){
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
			
				
			}else if(i==4){
			model.addRow(new Object[]{valueToshowOntable[0],valueToshowOntable[1], valueToshowOntable[2], valueToshowOntable[3]});		
			valueToshowOntable=null;
			valueToshowOntable= new String[6];
			i=-1;
			}
			
			  i++;   //returns the line that was skipped  
			} 
    model.addRow(new Object[]{valueToshowOntable[0],valueToshowOntable[1], valueToshowOntable[2], valueToshowOntable[3]});		
						
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
			   int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                    writeDataToFile("new_customer.txt");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete.");
                }
               
		 }	
		 if (e.getSource()==btn2)
		 {
			 frame.setVisible(false);
			 new Reception();
		 }
		}
		 private static List<String[]> readDataFromFile(String filename) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split("\n");
                data.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static void writeDataToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < model.getColumnCount(); j++) {
                    row.append(model.getValueAt(i, j));
                    if (j < model.getColumnCount() - 1) {
                        row.append("");
                    }
                }
                writer.write(row.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	    
}