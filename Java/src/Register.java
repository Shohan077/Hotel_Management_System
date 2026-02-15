import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Register extends JFrame {
    private JLabel lblUserName,lblPassword,lblConfirmPassword,lblNumber,lblRegister;
    private JTextField txtUserName,txtNumber;
    private JPasswordField pfPassword,pfConfirmPassword;
    private Font font,font2;
    private Container contain;
    private JButton btnRegister;
    private ImageIcon icon;
    Register(){

        addFont();
        addTextField();
        addImage();
        addButton();
        addPasswordField();
        addLabel();
        addContainer();
        addAllComponents();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,200,800,800);
        setTitle("Register");
    } 
    private void addLabel(){

        lblRegister= new JLabel("REGISTER");
        lblRegister.setBounds(290 ,60,300,70);
        lblRegister.setForeground(Color.darkGray);
        lblRegister.setFont(font2);

        lblUserName= new JLabel("UserName");
        lblUserName.setBounds(300,150,200,40);
        lblUserName.setFont(font);
        lblUserName.setForeground(Color.BLACK);

        lblPassword= new JLabel("Password");
        lblPassword.setBounds(300,240,200,40);
        lblPassword.setFont(font);
        lblPassword.setForeground(Color.BLACK);

        lblConfirmPassword= new JLabel("Confirm Password");
        lblConfirmPassword.setBounds(300,320,200,40);
        lblConfirmPassword.setFont(font);
        lblConfirmPassword.setForeground(Color.BLACK);

        lblNumber= new JLabel("Phone Number");
        lblNumber.setBounds(300,410,200,40);
        lblNumber.setFont(font);
        lblNumber.setForeground(Color.BLACK);
    }
    private void addTextField(){
            txtUserName= new JTextField();
            txtUserName.setBounds(300,200,200,30);
            txtUserName.setBackground(Color.white);
            txtUserName.setFont(font);

            txtNumber= new JTextField();
            txtNumber.setBounds(300,460,200,30);
            txtNumber.setBackground(Color.white);
            txtNumber.setFont(font);
    }

    private void addPasswordField(){
        pfPassword= new JPasswordField();
        pfPassword.setBounds(300,290,200,30);
        pfPassword.setBackground(Color.white);
        pfPassword.setFont(font);

        pfConfirmPassword= new JPasswordField();
        pfConfirmPassword.setBounds(300,370,200,30);
        pfConfirmPassword.setBackground(Color.white);
        pfConfirmPassword.setFont(font);
    }
    private void addButton(){
        btnRegister= new JButton("Register");
        btnRegister.setBounds(340,520,110,40);
        btnRegister.setFont(font);
        btnRegister.setBackground(Color.cyan);
        btnRegister.addActionListener(new Listener(){
            public void actionPerformed(ActionEvent e)
            {
               String checkPassword= new String(pfPassword.getPassword());
                String checkConfirmPassword= new String(pfConfirmPassword.getPassword());
                if(txtUserName.getText().equals("")||txtNumber.getText().equals("")||checkPassword.equals("")||checkConfirmPassword.equals("")){
                    JOptionPane.showMessageDialog(null,"Please fill up all the fields");
                }else{
                    if(checkPassword.equals(checkConfirmPassword)){
                    try{
                    FileWriter fw =new FileWriter("User.txt",true);
                    FileWriter fw1 =new FileWriter("loginInfo.txt",true);
                    String password= new String(pfPassword.getPassword());
                    fw.write(txtUserName.getText()+"-"+txtNumber.getText()+"\n");
                    fw1.write(txtUserName.getText()+"-"+ password+"\n");
                    fw1.close();
                    fw.close();
                    JOptionPane.showMessageDialog(null,"Registration Successful");
                    dispose();
                    new Frame();
                    }catch(IOException ex){
                        System.out.println("Error");
                } 
            }       
            else {
                JOptionPane.showMessageDialog(null,"Password does not match");
            }
            
        }
    }
}
  );
    }
    private void addFont(){
            font = new Font("Arial",Font.BOLD,14);
            font2= new Font("Arial Black",Font.TRUETYPE_FONT,40);
    }
    private void addImage(){
        icon =  new ImageIcon(getClass().getResource("register.png"));
        this.setIconImage(icon.getImage());
    }
    private void addContainer(){
        contain=this.getContentPane();
        contain.setBackground(Color.LIGHT_GRAY);
        contain.setLayout(null);
    }
    private void addAllComponents(){

        contain.add(lblRegister);

        contain.add(lblUserName);
        contain.add(txtUserName);

        contain.add(lblPassword);
        contain.add(pfPassword);

        contain.add(lblConfirmPassword);
        contain.add(pfConfirmPassword);

        contain.add(lblNumber);
        contain.add(txtNumber);

        contain.add(btnRegister);
        
        
    }
    
    Listener handle = new Listener();
    class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e)
            {
            
        }
    }
    
    public static void main(String[] args) {
        Register register= new Register();
    }
}



