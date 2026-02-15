import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JScrollPane;


public class UserList extends JFrame { 
    private Font font,font2;
    private Container contain;
    private JButton btnOk;
    private JTextArea user;
    private javax.swing.JScrollPane scrollPane1;
    private String userDetails="User Information : \n\n";
    
    UserList(){
    addFont();
    addButton();
    addLabel();
    addScrollPane();
    addContainer();
    uListReader();
    addAllComponents();


       // Set window layout to null
        setLayout(null);

        // Set window visibility
        setVisible(true);
        setLocationRelativeTo(null);
		
        
        // Set window size
        setSize(1080, 900);
        setResizable(false);
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

        user= new JTextArea("Ticket Details");
        user.setBounds(150,120,500,250);
        user.setFont(font);
        user.setForeground(Color.BLACK);
        user.setBackground(Color.white);
        user.setEditable(false);
      


}

//scrollpane for user list
private void addScrollPane(){
    scrollPane1 = new JScrollPane();
    scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    setVisible(true);
    scrollPane1.add(user);
   
}
private void addButton(){
    btnOk= new JButton("Ok");
    btnOk.setBounds(340,380,120,25);
    btnOk.setFont(font);
    btnOk.setForeground(Color.BLACK);
    btnOk.addActionListener(new Listener());
}

private void addAllComponents(){
    
    contain.add(user);
    contain.add(btnOk);
}
public void uListReader(){
    try{
        FileReader fr= new FileReader("User.txt");
        BufferedReader br= new BufferedReader(fr);
        String line;
        while((line=br.readLine())!=null){
           
            userDetails=userDetails+line+"\n";
            user.setText(userDetails);
        
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
        new AdminFrame();
        dispose();
    }
}
}


public static void main(String[] args) {
   new UserList();
}

}
