package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener
{
	
	JButton login, clear, signup;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
    Login()
    {
    	setTitle("AUTOMATED TELLER MACHINE");
    	
    	setLayout(null);
    	
    	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpeg"));
    	Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i2); 
    	JLabel label = new JLabel(i3);
    	label.setBounds(70, 10, 150, 100);
    	add(label);
    	
    	JLabel text = new JLabel("Welcome to SBI ATM");
    	text.setFont(new Font("Osward", Font.BOLD, 38));
    	text.setBounds(200, 40, 400, 40);
    	add(text);
    	
    	JLabel CardNo = new JLabel("Card No. :");
    	CardNo.setFont(new Font("Raleway", Font.BOLD, 25));
    	CardNo.setBounds(120, 150, 150, 30);
    	add(CardNo);
    	
    	cardTextField = new JTextField();
    	cardTextField.setBounds(300, 150, 230, 30);
    	cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
    	add(cardTextField);
    	
    	JLabel Pin = new JLabel("PIN :");
    	Pin.setFont(new Font("Raleway", Font.BOLD, 25));
    	Pin.setBounds(120, 220, 250, 30);
    	add(Pin);
    	
    	pinTextField = new JPasswordField();
    	pinTextField.setBounds(300, 220, 230, 30);
    	cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
    	add(pinTextField);
    	
    	login = new JButton("SIGN IN");
    	login.setBounds(300, 300, 100, 30);
    	login.setBackground(new Color(71, 206, 255));
    	login.setForeground(Color.WHITE);
    	login.addActionListener(this);
    	add(login);
    	
    	clear = new JButton("CLEAR");
    	clear.setBounds(430, 300, 100, 30);
    	clear.setBackground(new Color(71, 206, 255));
    	clear.setForeground(Color.WHITE);
    	clear.addActionListener(this);
    	add(clear);
    	
    	signup = new JButton("SIGN UP");
    	signup.setBounds(300, 350, 230, 30);
    	signup.setBackground(new Color(71, 206, 255));
    	signup.setForeground(Color.WHITE);
    	signup.addActionListener(this);
    	add(signup);
    	
    	getContentPane().setBackground(Color.white);
    	
    	setSize(800, 480);
    	setVisible(true);
    	setLocation(250, 100);
    }
    
    public void actionPerformed(ActionEvent ae) 
	{
	   if(ae.getSource() == clear)
	   {
		   cardTextField.setText("");
		   pinTextField.setText("");
	   }
	   else if(ae.getSource() == login)
	   {
		   Conn conn = new Conn();
		   String cardnumber = cardTextField.getText();
		   String pinnumber = pinTextField.getText();
		   String query = "select * from login where cardnumber = '"+cardnumber+"'and pinnumber = '"+pinnumber+"'";
		   try {
			  ResultSet rs = conn.s.executeQuery(query);
			  if(rs.next()) {
				  setVisible(false);
				  new Transactions(pinnumber).setVisible(true);
			  }
			  else {
				  JOptionPane.showMessageDialog(null, "Incorrect Card Number or pin");
			  }
		   }
		   catch(Exception e){
			   System.out.println(e);
		   }
				 
	   }
	   else if(ae.getSource() == signup)
	   {
		  setVisible(false);
		  new SignupOne().setVisible(true);
	   }
	}
    
	public static void main(String[] args) 
	{
		new Login();

	}	
}
