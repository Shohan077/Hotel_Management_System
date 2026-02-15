import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class TicketDetails extends JFrame { 
    private Font font,font2;
    private Container contain;
    private JButton btnOk;
    private JTextArea ticket;
    private String ticketDetails="Ticket Details : \n";
    
    TicketDetails(){
    addFont();
    addButton();
    addLabel();
    addContainer();
    ticketReader();
    addAllComponents();


    setVisible(true);
    setBounds(500,100,1080,900);
    setTitle("Air Ticket Management");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

private void addLabel(){

        ticket= new JTextArea("Ticket Details");
        ticket.setBounds(150,120,500,250);
        ticket.setFont(font);
        ticket.setForeground(Color.BLACK);
        ticket.setBackground(Color.white);
        ticket.setEditable(false);
}
private void addButton(){
    btnOk= new JButton("Purchase");
    btnOk.setBounds(340,380,120,25);
    btnOk.setFont(font);
    btnOk.setForeground(Color.BLACK);
    btnOk.addActionListener(new Listener());
}

private void addAllComponents(){
    
    contain.add(ticket);
    contain.add(btnOk);
}
public void ticketReader(){
    try{
        FileReader fr= new FileReader("ticket.txt");
        BufferedReader br= new BufferedReader(fr);
        String line;
        while((line=br.readLine())!=null){
           
            ticketDetails=ticketDetails+line+"\n";
            ticket.setText(ticketDetails);
        
    }
        br.close();
        fr.close();
    }catch(Exception e){
        System.out.println(e);
    }
}

//action listener for button
class Listener implements ActionListener{
public void actionPerformed(ActionEvent e){
    if(e.getSource()==btnOk){
        try{
            FileReader fr= new FileReader("ticket.txt");
               BufferedReader br= new BufferedReader(fr);
               String line=br.readLine();
               String details;
               
               
               while(line!=null){
                   details=br.readLine();
                   if (details==null){
                       break;
                   }
                   FileWriter fw= new FileWriter("AllTickets.txt",true);
                   fw.write(details+"\n");
                   fw.close();
          } 
               br.close();
               fr.close();
               JOptionPane.showMessageDialog(null,"Ticket Purchased");
               File file= new File("ticket.txt");
               if (file.exists()){
                file.delete();
               }
               new Frame();
               dispose();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
}


public static void main(String[] args) {
    TicketDetails ticketDetails= new TicketDetails();
    System.out.println(ticketDetails);
}

}
