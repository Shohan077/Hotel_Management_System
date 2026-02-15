import java.lang.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import myClasses.*;
import java.util.*;

public class DataEntry extends JFrame implements ActionListener {

	Customer c;

	Color color = new Color(155, 235, 205);
	Font font = new Font("cambria", Font.PLAIN, 16);
	JPanel panel;
	JLabel title;
	DefaultTableModel model;
	JTable table;

	JTextField accno, name, balance, rate;
	JButton addData, clrData, removeData, logOut;
	Login loggedIn;

	public DataEntry(Login loggedIn, Customer c) {
		super("My Data Entry Form");
		// Initialization
		this.c = c;
		this.loggedIn = loggedIn;

		this.setSize(410, 510);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 400, 500);
		panel.setBackground(color);
		this.add(panel);

		initializeForm();
		createTable();

		// this.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == addData) {
			
		if(!isAnyDataEmpty() && !isAllDataEmpty()){
			if (c.getAccountLeft() > 0) {
				
				SavingsAccount s = new SavingsAccount();
				s.setAccountNumber(Integer.parseInt(accno.getText()));
				s.setAccountHolderName(name.getText());
				s.setBalance(Double.parseDouble(balance.getText()));
				s.setInterestRate(Double.parseDouble(rate.getText()));
				
				c.addAccount(s);
				
				model.addRow(new Object[] { 
						s.getAccountNumber(), 
						s.getAccountHolderName(), 
						s.getBalance(),
						s.getInterestRate()
						});
				// Clear Input Boxes after insert
				clearAll();
			} else {
				JOptionPane.showMessageDialog(this, "Max Account Limit Reached.", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(this, "Please Provide All The necessary Information", "Warning",
						JOptionPane.WARNING_MESSAGE);
		}
			
			
		} else if (ae.getSource() == clrData) {
			clearAll();
		} else if (ae.getSource() == removeData) {
			
			int selectedRows[] = table.getSelectedRows();
			if(selectedRows.length >=1){
				Arrays.sort(selectedRows);
				
				for (int i = selectedRows.length - 1; i >= 0; i--) {
					
					int accountNumber = Integer.parseInt(  table.getModel().
											getValueAt(selectedRows[i], 0).
											toString()  );
											
					Account a = c.getAccbyAccNo(accountNumber);
					if (a != null) {
						model.removeRow(selectedRows[i]);
						c.removeAccount(a);
					}

					if (i == 0) {
						// Popup Dialog
						JOptionPane.showMessageDialog(this, "Successfully Deleted.");
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "Please Select Rows to Delete. ", "Warining",
						JOptionPane.WARNING_MESSAGE);
			}

		} else if (logOut == ae.getSource()) {
			loggedIn.setVisible(true);
			this.dispose();
		}

	}

	public boolean isAllDataEmpty(){
		return (accno.getText().isEmpty() && 
			name.getText().isEmpty() &&
			balance.getText().isEmpty() &&
			rate.getText().isEmpty() );
	}
	public boolean isAnyDataEmpty(){
		return (accno.getText().isEmpty() || 
			name.getText().isEmpty() ||
			balance.getText().isEmpty() ||
			rate.getText().isEmpty() );
	}
	
	
	public void clearAll() {
		if(!isAllDataEmpty()){
			accno.setText("");
			name.setText("");
			balance.setText("");
			rate.setText("");
		}else{
			JOptionPane.showMessageDialog(this,"Data is Already Cleared");
		}
	}

	public void initializeForm() {
		// Creating Title
		title = new JLabel("Data Entry Form");
		title.setBounds(10, 10, 380, 25);
		title.setFont(font);
		panel.add(title);

		// Savings Account Form

		// Account Number Lable
		JLabel accnoLable = new JLabel("Account Number");
		accnoLable.setFont(font);
		accnoLable.setBounds(20, 50, 150, 25);
		panel.add(accnoLable);
		// Account Number Input
		accno = new JTextField("111");
		accno.setFont(font);
		accno.setBounds(170, 50, 180, 25);
		panel.add(accno);

		// Account Name Lable
		JLabel accnoName = new JLabel("Account Name");
		accnoName.setFont(font);
		accnoName.setBounds(20, 80, 150, 25);
		panel.add(accnoName);
		// Account name Input
		name = new JTextField("RM");
		name.setFont(font);
		name.setBounds(170, 80, 180, 25);
		panel.add(name);

		/////////////////////////////
		// Account Balance Lable
		JLabel accBalance = new JLabel("Initial Deposit");
		accBalance.setFont(font);
		accBalance.setBounds(20, 110, 150, 25);
		panel.add(accBalance);
		// Account Balance Input
		balance = new JTextField("1000");
		balance.setFont(font);
		balance.setBounds(170, 110, 180, 25);
		panel.add(balance);

		/////////////////////////////
		// Account Rate Lable
		JLabel accRate = new JLabel("Interest Rate");
		accRate.setFont(font);
		accRate.setBounds(20, 140, 150, 25);
		panel.add(accRate);
		// Account Rate Input
		rate = new JTextField("1.23");
		rate.setFont(font);
		rate.setBounds(170, 140, 180, 25);
		panel.add(rate);

		// Add Account Button
		addData = new JButton("Add Account");
		addData.setFont(new Font("cambria", Font.BOLD, 15));
		addData.setBounds(20, 175, 150, 25);
		addData.setBackground(new Color(50, 130, 246));
		addData.setForeground(new Color(255, 255, 255));
		addData.addActionListener(this);
		panel.add(addData);

		// Clear Button
		clrData = new JButton("Clear");
		clrData.setFont(new Font("cambria", Font.BOLD, 15));
		clrData.setBounds(180, 175, 85, 25);
		clrData.setBackground(new Color(150, 0, 200));
		clrData.setForeground(new Color(255, 255, 255));
		clrData.addActionListener(this);
		panel.add(clrData);

		// Add Remove Button
		removeData = new JButton("Delete");
		removeData.setFont(new Font("cambria", Font.BOLD, 15));
		removeData.setBounds(280, 175, 90, 25);
		removeData.setBackground(new Color(200, 0, 0));
		removeData.setForeground(new Color(255, 255, 255));
		removeData.addActionListener(this);
		panel.add(removeData);

		// Log out Button
		logOut = new JButton("Logout");
		logOut.setFont(new Font("cambria", Font.BOLD, 15));
		logOut.setBounds(290, 420, 90, 25);
		logOut.setBackground(new Color(200, 0, 100));
		logOut.setForeground(new Color(255, 255, 255));
		logOut.addActionListener(this);
		panel.add(logOut);

	}

	public void createTable() {
		// TABLE
		model = new DefaultTableModel();
		
		table = new JTable(model);
		
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table.setBackground(new Color(255, 234, 10));
		//table.setShowGrid(true);
		table.setSelectionBackground(new Color(255, 153, 51));
		table.setBounds(20, 210, 360, 200);
		
		model.addColumn("Number");
		model.addColumn("Name");
		model.addColumn("Balance");
		model.addColumn("IRate");
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 210, 360, 200);
		panel.add(scrollPane);

	}

  
}