import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Handler;

public class Frame extends JFrame {
    private ImageIcon icon,icon2;
    private Container contain;
    private JLabel username,pass,lblUserType,lblLogin;
    private Font font,font2,font3;
    private JTextField txtUsername;
    private JPasswordField pfPass;
    private JButton btnLogin,btnRegister;
    private Cursor cursor;
    private JScrollPane scroll;
    private JRadioButton rdbUser,rdbAdmin;
    private ButtonGroup rdbGroup;
    Frame(){

        addCursor();
        addFontForAll();
        addPasswordField();
        addTextField();
        addButton();
        addRadioButton();

        addContainer();

        setImage();

        setLabel();

        addAllComponents();



        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setBounds(500,200,500,600);
        //setResizable(false);
    }
    private void setImage(){
      icon = new ImageIcon(getClass().getResource("login.jpg"));
      this.setIconImage(icon.getImage());

      //icon2= new ImageIcon(getClass().getResource("messi.jpeg"));
    }
    private void addContainer(){
        contain=this.getContentPane();
        contain.setBackground(Color.LIGHT_GRAY);
        contain.setLayout(null);
    }
    private void setLabel(){

        lblLogin= new JLabel("LOGIN");
        lblLogin.setBounds(170 ,30,300,60);
        lblLogin.setForeground(Color.darkGray);
        lblLogin.setFont(font3);

        username= new JLabel("UserName");
        username.setBounds(150,100,100,50);
        username.setFont(font);
        username.setForeground(Color.BLACK);

        pass= new JLabel("Password");
        pass.setBounds(150,200,100,50);
        pass.setFont(font);
        pass.setForeground(Color.BLACK);

        lblUserType= new JLabel("Role : ");
        lblUserType.setBounds(150,300,100,50);
        lblUserType.setFont(font);
        lblUserType.setForeground(Color.BLACK);
        //imgIcon= new JLabel(icon2);
        //imgIcon.setBounds(150,20,icon2.getIconWidth(),icon2.getIconHeight());

    }
    private void addFontForAll(){
        font= new Font("Arial",Font.BOLD ,16);
        font2= new Font("Arial Black",Font.TRUETYPE_FONT,14);
        font3= new Font("Arial Black",Font.TRUETYPE_FONT,40);
    }
    private void addCursor(){
        cursor= new Cursor(Cursor.HAND_CURSOR);
    }
    private void addTextField(){
       txtUsername = new JTextField();
       txtUsername.setBounds(150,160,180,30);
        txtUsername.setFont(font);
        txtUsername.setForeground(Color.black);
        txtUsername.setBackground(Color.WHITE);
        //txtUsername.addActionListener(handle);

        //txtPassword.addActionListener(handle);
    }
    private void addPasswordField(){
        pfPass= new JPasswordField();
        pfPass.setBounds(150,260,180,30);
        pfPass.setBackground(Color.white);
        pfPass.setFont(font);
    }
    private void addRadioButton(){
        rdbUser = new JRadioButton("User");
        rdbUser.setBounds(220,310,100,30);
        rdbUser.setFont(font2);

        rdbAdmin = new JRadioButton("Admin");
        rdbAdmin.setBounds(220,350,100,30);
        rdbAdmin.setFont(font2);
        rdbGroup= new ButtonGroup();
        rdbGroup.add(rdbUser);
        rdbGroup.add(rdbAdmin);

    }
    private void addAllComponents(){

        contain.add(lblLogin);

        contain.add(username);
        contain.add(pass);
       //contain.add(imgIcon);
        contain.add(txtUsername);
        contain.add(pfPass);
        contain.add(btnLogin);
        contain.add(btnRegister);

        contain.add(lblUserType);
        contain.add(rdbUser);
        contain.add(rdbAdmin);

        //contain.add(scroll);

    }
    private void addButton(){
        btnLogin= new JButton("Login");
        btnLogin.setBounds(150,400,90,30);
        btnLogin.setFont(font2);
        btnLogin.setForeground(Color.DARK_GRAY);
        btnLogin.setBackground(Color.cyan);
        btnLogin.setCursor(cursor);
        btnLogin.addActionListener(handle);

        btnRegister= new JButton("Register");
        btnRegister.setBounds(250,400,100,30);
        btnRegister.setFont(font2);
        btnRegister.setForeground(Color.DARK_GRAY);
        btnRegister.setBackground(Color.cyan);
        btnRegister.setCursor(cursor);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Register();
            }
        });

    }
    Listener handle= new Listener();
    class Listener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            if(e.getSource()==btnLogin){
                Boolean passMatched= false;
                String username= txtUsername.getText().toString();
                String password= new String(pfPass.getPassword());
                
                
                if(rdbUser.isSelected()){
                try{
                FileReader fr= new FileReader("loginInfo.txt");
                BufferedReader br= new BufferedReader(fr);
                String line;

                while((line=br.readLine())!=null){
                    if(line.equals(username+"-"+password)){
                        passMatched= true;
                        break;
                         
                    
                    }
                        
                }
                if(passMatched){
                    new UserFrame();
                        dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Wrong username or password");
                }
                fr.close();
                
            }catch(Exception ex){
                System.out.println(ex);
            }
        }else if (rdbAdmin.isSelected()){
            try{
                FileReader fr= new FileReader("adminLoginInfo.txt");
                BufferedReader br= new BufferedReader(fr);
                String line;

                while((line=br.readLine())!=null){
                    if(line.equals(username+" "+password)){
                        passMatched= true;
                        break;
                         
                    
                    }
                        
                }
                if(passMatched){
                    new AdminFrame();
                        dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Wrong username or password");
                }
                fr.close();
                
            }catch(Exception ex){
            }
        }
        
                
                
                else{
                    JOptionPane.showMessageDialog(null,"Please select a role");
                }
            }


        }
    }

    public static void main(String[] args) {
        new Frame();

    }
}
