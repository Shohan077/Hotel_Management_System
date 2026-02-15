import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AdminFrame extends JFrame {
    private JLabel lblImage,lblTitle;
    private JButton btnViewUserList,btnSearchUser,btnFlightList;
    private JTextField txtSearchUser;
    private Container contain;
    private Font font,font2;
    private ImageIcon icon,image;
    private Cursor cursor;
    String route;
    public String getRoute(){
        return route;
    }
    AdminFrame(){
        addCursor();
        addFont();
        addTextField();
        addButton();
        addContainer();
        addImage();
        addLabel();
        addAllComponents();

        setVisible(true);
        setBounds(500,200,700,700);
        setTitle("Admin Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void addContainer(){
        contain= this.getContentPane();
        contain.setBackground(Color.cyan);
        contain.setLayout(null);

    }
    private void addFont(){
        font= new Font("YONDER",Font.BOLD,15);
        font2=new Font("Congenial Black",Font.BOLD,40);
    }
    private void addImage(){
        icon= new ImageIcon(getClass().getResource("admin.png"));
        this.setIconImage(icon.getImage());

        image= new ImageIcon(getClass().getResource("flight4.png"));
    }
    private void addCursor(){
        cursor= new Cursor(Cursor.HAND_CURSOR);
    }
    private void addLabel(){

        lblTitle= new JLabel("ADMIN");
        lblTitle.setBounds(270,20,200,40);
        lblTitle.setFont(font2);
        lblTitle.setForeground(Color.gray);

        lblImage= new JLabel(image);
        lblImage.setBounds(150,300,image.getIconWidth(),image.getIconHeight());
    }
    private void addButton(){
        btnViewUserList= new JButton("View User List");
        btnViewUserList.setBounds(150,100,150,30);
        btnViewUserList.setBackground(Color.pink);
        btnViewUserList.setForeground(Color.white);
        btnViewUserList.setFont(font);
        btnViewUserList.setCursor(cursor);
        btnViewUserList.addActionListener(new Listener());

        btnSearchUser= new JButton("Search User");
        btnSearchUser.setBounds(370,140,150,30);
        btnSearchUser.setBackground(Color.pink);
        btnSearchUser.setForeground(Color.white);
        btnSearchUser.setFont(font);
        btnSearchUser.setCursor(cursor);
        btnSearchUser.addActionListener(new Listener());

        btnFlightList= new JButton("Add Flight");
        btnFlightList.setBounds(150,250,150,30);
        btnFlightList.setBackground(Color.pink);
        btnFlightList.setForeground(Color.white);
        btnFlightList.setFont(font);
        btnFlightList.setCursor(cursor);
        btnFlightList.addActionListener(new Listener(){
                
                public void actionPerformed(ActionEvent e){
                    new TimeSchedule();
                }
        });

    }
    private void addTextField(){
        txtSearchUser= new JTextField();
        txtSearchUser.setBounds(150,140,200,30);
        txtSearchUser.setBackground(Color.white);

    }
    private void addAllComponents(){
        contain.add(btnViewUserList);
        contain.add(btnSearchUser);
        contain.add(btnFlightList);
       
        contain.add(txtSearchUser);
       
        contain.add(lblImage);
        contain.add(lblTitle);


    }
    class Listener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            if(e.getSource()==btnViewUserList){
               new UserList();
            }
            else if(e.getSource()==btnSearchUser){
                String username= txtSearchUser.getText().toString();
                Boolean userFound=false;
                try{
                    FileReader fr= new FileReader("User.txt");
                    BufferedReader br= new BufferedReader(fr);
                    String line;
    
                    while((line=br.readLine())!=null){
                        String data[]= line.split("-");
                        if(data[0].equals(username)){
                            JOptionPane.showMessageDialog(null,"User Found");
                            userFound=true;
                            break;
                        }
                        
                    }
                    if(userFound){
                        String data[]= line.split("-");
                        JOptionPane.showMessageDialog(null,"User Name: "+data[0]+" "+"Phone: "+data[1]);
                    }else
                        JOptionPane.showMessageDialog(null,"User Not Found");

                    br.close();    
                    fr.close();
                    
                }catch(Exception ex){
                    System.out.println(ex);
                }

            }
    }
}
    
   

    public static void main(String[] args) {
            AdminFrame adminFrame= new AdminFrame();
    }
}

