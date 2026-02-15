import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class UserFrame extends JFrame {
    private JLabel lblTitle,lblName,lblFrom,lblTo,lblDateOfJourney,lblTickets,lblTotalFare;
    private JTextField txtName,txtFrom,txtTo,txtDateOfJourney,txtTickets;
    private Font font,font2;
    private Container contain;
    private JButton btnBookTickets;
    private ImageIcon icon,image;
    UserFrame(){

        addFont();
        addTextField();
        addButton();
        addImage();
        addLabel();
        addContainer();
        addAllComponents();


        setVisible(true);
        setBounds(350,70,1080,900);
        setTitle("Air Ticket Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    private void addContainer(){
        contain=this.getContentPane();
        contain.setBackground(Color.cyan);
        contain.setLayout(null);
    }
    private void addFont(){
        font= new Font("Times New",Font.BOLD,16);
        font2= new Font("YONDER",Font.BOLD,15);
    }
    private void addImage(){
        icon= new ImageIcon(getClass().getResource("air.png"));
        this.setIconImage(icon.getImage());

        image= new ImageIcon(getClass().getResource("air2.png"));

    }
    private void addLabel(){

            lblTitle= new JLabel(image);
            lblTitle.setBounds(200,2,image.getIconWidth(),image.getIconHeight());

            lblName= new JLabel("NAME :");
            lblName.setBounds(70,100,200,20);
            lblName.setFont(font);
            lblName.setForeground(Color.BLACK);

            lblFrom= new JLabel("FROM :");
            lblFrom.setBounds(70,170,200,20);
            lblFrom.setFont(font);
            lblFrom.setForeground(Color.BLACK);

            lblTo= new JLabel("TO :");
            lblTo.setBounds(70,240,200,20);
            lblTo.setFont(font);
            lblTo.setForeground(Color.BLACK);

            lblDateOfJourney= new JLabel("DATE OF JOURNEY :");
            lblDateOfJourney.setBounds(70,310,200,20);
            lblDateOfJourney.setFont(font);
            lblDateOfJourney.setForeground(Color.BLACK);

            lblTickets= new JLabel("TICKETS :");
            lblTickets.setBounds(70,380,200,20);
            lblTickets.setFont(font);
            lblTickets.setForeground(Color.BLACK);

            lblTotalFare= new JLabel("TOTAL FARE :");
            lblTotalFare.setBounds(70,450,200,20);
            lblTotalFare.setFont(font);
            lblTotalFare.setForeground(Color.BLACK);

            
    }
    private void addTextField(){
        txtName= new JTextField();
        txtName.setBounds(70,130,220,30);
        txtName.setBackground(Color.white);

        txtFrom= new JTextField();
        txtFrom.setBounds(70,200,220,30);
        txtFrom.setBackground(Color.white);

        txtTo= new JTextField();
        txtTo.setBounds(70,270,220,30);
        txtTo.setBackground(Color.white);

        txtDateOfJourney= new JTextField();
        txtDateOfJourney.setBounds(70,340,220,30);
        txtDateOfJourney.setBackground(Color.white);

        txtTickets= new JTextField();
        txtTickets.setBounds(70,410,220,30);
        txtTickets.setBackground(Color.white);
    }
    private void addButton(){
        
        btnBookTickets= new JButton("Book Tickets");
        btnBookTickets.setBounds(200,550,150,30);
        btnBookTickets.setFont(font2);
        btnBookTickets.setBackground(Color.pink);
        btnBookTickets.setForeground(Color.white);
        btnBookTickets.addActionListener(new Listener());

    }
    private void addAllComponents(){
        contain.add(lblName);
        contain.add(lblFrom);
        contain.add(lblTo);
        contain.add(lblDateOfJourney);
        contain.add(lblTickets);
        contain.add(lblTotalFare);
        contain.add(lblTitle);

        contain.add(txtName);
        contain.add(txtFrom);
        contain.add(txtTo);
        contain.add(txtDateOfJourney);
        contain.add(txtTickets);

        contain.add(btnBookTickets);
        
    }
    class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==btnBookTickets){
                    String name=txtName.getText();
                    String from=txtFrom.getText();
                    String to=txtTo.getText();
                    String date=txtDateOfJourney.getText();
                    String tickets=txtTickets.getText();
                    int totalFare=0;
                    int ticket= Integer.parseInt(tickets);
                    if(name.equals("")||from.equals("")||to.equals("")||date.equals("")||txtTickets.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Please fill up all the fields");
                    }
                    else{
                    if(from.equals("Dhaka") && to.equals("Rajshahi")){
                        totalFare= ticket*3200;
                       try{
                         FileReader fr= new FileReader("Dhaka to Rajshahi.txt");
                            BufferedReader br= new BufferedReader(fr);
                            String line=br.readLine();
                            String details;
                            
                            
                            while(line!=null){
                                details=br.readLine();
                                if (details==null){
                                    break;
                                }
                                FileWriter fw= new FileWriter("ticket.txt",true);
                                fw.write(details+"\n");
                                fw.close();
                       }
                          
                          FileWriter fw1= new FileWriter("ticket.txt",true);
                            fw1.write("Passenger Name : "+name+"\nDate of Journey : "+date+"\nTotal Seats : "+ ticket +"\nTotal Fare : "+totalFare+"\n");   
                            fw1.close();  
                            br.close();
                            fr.close();
                            new TicketDetails();
                            dispose();
                     
                    }catch(Exception ex){
                           System.out.println(ex);
                       }
                    }
                    else if(from.equals("Rajshahi") && to.equals("Dhaka")){
                        totalFare= ticket*3200;
                       try{
                         FileReader fr= new FileReader("Rajshahi to Dhaka.txt");
                            BufferedReader br= new BufferedReader(fr);
                            String line=br.readLine();
                            String details;
                            
                            
                            while(line!=null){
                                details=br.readLine();
                                if (details==null){
                                    break;
                                }
                                FileWriter fw= new FileWriter("ticket.txt",true);
                                fw.write(details+"\n");
                                fw.close();
                       }
                          
                          FileWriter fw1= new FileWriter("ticket.txt",true);
                            fw1.write("Passenger Name : "+name+"\nDate of Journey : "+date+"\nTotal Seats : "+ ticket +"\nTotal Fare : "+totalFare+"\n");   
                            fw1.close();  
                            br.close(); 
                            fr.close();
                            new TicketDetails();
                            dispose();                    
                    }catch(Exception ex){
                           System.out.println(ex);
                       }
                    }
                    else if(from.equals("Dhaka") && to.equals("Chittagong")){
                        totalFare= ticket*4000;
                       try{
                         FileReader fr= new FileReader("Dhaka to Chittagong.txt");
                            BufferedReader br= new BufferedReader(fr);
                            String line=br.readLine();
                            String details;
                            
                            
                            while(line!=null){
                                details=br.readLine();
                                if (details==null){
                                    break;
                                }
                                FileWriter fw= new FileWriter("ticket.txt",true);
                                fw.write(details+"\n");
                                fw.close();
                       }
                          
                          FileWriter fw1= new FileWriter("ticket.txt",true);
                            fw1.write("Passenger Name : "+name+"\nDate of Journey : "+date+"\nTotal Seats : "+ ticket +"\nTotal Fare : "+totalFare+"\n");   
                            fw1.close();  
                            br.close();
                            fr.close();
                            new TicketDetails();
                            dispose();
                    }
                    catch(Exception ex){
                           System.out.println(ex);
                       }
                    }
                    else if(from.equals("Chittagong") && to.equals("Dhaka")){
                        totalFare= ticket*4000;
                       try{
                         FileReader fr= new FileReader("Chittagong to Dhaka.txt");
                            BufferedReader br= new BufferedReader(fr);
                            String line=br.readLine();
                            String details;
                            
                            
                            while(line!=null){
                                details=br.readLine();
                                if (details==null){
                                    break;
                                }
                                FileWriter fw= new FileWriter("ticket.txt",true);
                                fw.write(details+"\n");
                                fw.close();
                       }
                          
                          FileWriter fw1= new FileWriter("ticket.txt",true);
                            fw1.write("Passenger Name : "+name+"\nDate of Journey : "+date+"\nTotal Seats : "+ ticket +"\nTotal Fare : "+totalFare+"\n");   
                            fw1.close();  
                            br.close();
                            fr.close();
                            new TicketDetails();
                            dispose();
                    }
                    catch(Exception ex){
                           System.out.println(ex);
                       }
                    }
                    else if(from.equals("Dhaka") && to.equals("Khulna")){
                        totalFare= ticket*3000;
                       try{
                         FileReader fr= new FileReader("Dhaka to Khulna.txt");
                            BufferedReader br= new BufferedReader(fr);
                            String line=br.readLine();
                            String details;
                            
                            
                            while(line!=null){
                                details=br.readLine();
                                if (details==null){
                                    break;
                                }
                                FileWriter fw= new FileWriter("ticket.txt",true);
                                fw.write(details+"\n");
                                fw.close();
                       }
                          
                          FileWriter fw1= new FileWriter("ticket.txt",true);
                            fw1.write("Passenger Name : "+name+"\nDate of Journey : "+date+"\nTotal Seats : "+ ticket +"\nTotal Fare : "+totalFare+"\n");   
                            fw1.close();  
                            br.close();
                            fr.close();
                            new TicketDetails();
                            dispose();
                    }
                    catch(Exception ex){
                           System.out.println(ex);
                       }
                    }
                    else if(from.equals("Khulna") && to.equals("Dhaka")){
                        totalFare= ticket*3000;
                       try{
                         FileReader fr= new FileReader("Khulna to Dhaka.txt");
                            BufferedReader br= new BufferedReader(fr);
                            String line=br.readLine();
                            String details;
                            
                            
                            while(line!=null){
                                details=br.readLine();
                                if (details==null){
                                    break;
                                }
                                FileWriter fw= new FileWriter("ticket.txt",true);
                                fw.write(details+"\n");
                                fw.close();
                          }
                          FileWriter fw1= new FileWriter("ticket.txt",true);
                          fw1.write("Passenger Name : "+name+"\nDate of Journey : "+date+"\nTotal Seats : "+ ticket +"\nTotal Fare : "+totalFare+"\n");   
                          fw1.close();  
                          br.close();
                            fr.close();
                            new TicketDetails();
                            dispose();
                  }
                  catch(Exception ex){
                         System.out.println(ex);
                     }
                    }

                    else{
                        JOptionPane.showMessageDialog(null,"No Flight Available");
                    
                }
            }
            
            
        }
    }
    }

    public static void main(String[] args) {
        UserFrame userFrame= new UserFrame();
    }
    }
