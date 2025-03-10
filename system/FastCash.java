package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash  extends JFrame implements ActionListener
{
	JButton first, second, third, fourth, fifth, sixth, back;
	String pinnumber;
	FastCash(String pinnumber)
	{
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Select Withdrawl Amount");
		text.setBounds(220, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		first = new JButton("Rs. 100");
		first.setBounds(170, 415, 150, 30);
		first.addActionListener(this);
		image.add(first);
		
		second = new JButton("Rs. 500");
		second.setBounds(355, 415, 150, 30);
		second.addActionListener(this);
		image.add(second);
		
		third = new JButton("Rs. 1000");
		third.setBounds(170, 450, 150, 30);
		third.addActionListener(this);
		image.add(third);
		
		fourth = new JButton("Rs. 2000");
		fourth.setBounds(355, 450, 150, 30);
		fourth.addActionListener(this);
		image.add(fourth);
		
		fifth = new JButton("Rs. 5000");
		fifth.setBounds(170, 485, 150, 30);
		fifth.addActionListener(this);
		image.add(fifth);
		
		sixth = new JButton("Rs. 10000");
		sixth.setBounds(355, 485, 150, 30);
		sixth.addActionListener(this);
		image.add(sixth);
		
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == back) 
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		else
		{
			String amount = ((JButton)ae.getSource()).getText().substring(4);
			Conn c = new Conn();
			try
			{
				ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
				int balance = 0;
				while(rs.next())
				{
					if(rs.getString("type").equals("deposit"))
					{
						balance += Integer.parseInt(rs.getString("amount"));
					}
					else
					{
						balance -=Integer.parseInt(rs.getString("amount"));
					}
				}
				
				if(ae.getSource() != back && balance < Integer.parseInt(amount))
				{
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				
				Date date = new Date();
				String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs. "+amount+" Withdraw Successfully");
				
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
	}

	public static void main(String[] args) 
	{
		new FastCash("");

	}

}
