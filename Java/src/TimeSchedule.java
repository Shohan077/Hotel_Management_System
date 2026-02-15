import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TimeSchedule extends JFrame {
    private JLabel lblTitle,lblName,lblFrom,lblTo,lblDeparture,lblArrival,lblSeatType;
    private JTextField txtName,txtFrom,txtTo,txtDeparture,txtarrival,txtSeatType;
    private Font font,font2;
    private Container contain;
    private JButton btnAddFlight;
    private ImageIcon icon,image;
    TimeSchedule(){

        addFont();
        addTextField();
        addButton();
        addImage();
        addLabel();
        addContainer();
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

            lblDeparture= new JLabel("Departure :");
            lblDeparture.setBounds(70,310,200,20);
            lblDeparture.setFont(font);
            lblDeparture.setForeground(Color.BLACK);

            lblArrival= new JLabel("ARRIVAL :");
            lblArrival.setBounds(70,380,200,20);
            lblArrival.setFont(font);
            lblArrival.setForeground(Color.BLACK);

            lblSeatType= new JLabel("SEAT TYPE :");
            lblSeatType.setBounds(70,450,200,20);
            lblSeatType.setFont(font);
            lblSeatType.setForeground(Color.BLACK);
           

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

        txtDeparture= new JTextField();
        txtDeparture.setBounds(70,340,220,30);
        txtDeparture.setBackground(Color.white);

        txtarrival= new JTextField();
        txtarrival.setBounds(70,410,220,30);
        txtarrival.setBackground(Color.white);
        
        txtSeatType= new JTextField();
        txtSeatType.setBounds(70,480,220,30);
        txtSeatType.setBackground(Color.white);
    }
    private void addButton(){

        btnAddFlight= new JButton("Book Tickets");
        btnAddFlight.setBounds(200,550,150,30);
        btnAddFlight.setFont(font2);
        btnAddFlight.setBackground(Color.pink);
        btnAddFlight.setForeground(Color.white);
        btnAddFlight.addActionListener(new Listener());

    }
    private void addAllComponents(){
        contain.add(lblName);
        contain.add(lblFrom);
        contain.add(lblTo);
        contain.add(lblDeparture);
        contain.add(lblArrival);
        contain.add(lblSeatType);
        contain.add(lblTitle);

        contain.add(txtName);
        contain.add(txtFrom);
        contain.add(txtTo);
        contain.add(txtDeparture);
        contain.add(txtarrival);
        contain.add(txtSeatType);


        contain.add(btnAddFlight);

    }
    class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnAddFlight){
                String name=txtName.getText();
                String from=txtFrom.getText();
                String to=txtTo.getText();
                String departure=txtDeparture.getText();
                String arrival=txtarrival.getText();
                String seatType=txtSeatType.getText();
                String route= from+" to "+to+".txt";
                if(from==null || to==null || departure==null || arrival==null || seatType==null){
                    JOptionPane.showMessageDialog(null,"Please Fill Up All The Information");
                }else{
                try {
                    FileWriter fw= new FileWriter("FlightList.txt",true);
                    FileWriter fw2= new FileWriter(route,true);
                    fw.write(from+" "+to+" "+departure+" "+arrival+" "+seatType+" "+"\n");
                    fw2.write("Flight: "+name+"\n"+" From: "+from+"\n"+" To: "+to+"\n"+" Departure: "+departure+"\n"+" Arrival: "+arrival+"\n"+" Seat Type: "+seatType+"\n");
                    fw.close();
                    fw2.close();
                    }catch(Exception ex){
                   
                  
                }
                JOptionPane.showMessageDialog(null,"Flight Added Successfully");
            }
        }
          
            
        }
    }

    public static void main(String[] args) {
        new TimeSchedule();
    }
}