package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener
{
	
	
	JTextField pan, aadhar;
	JButton next;
	JRadioButton syes, sno, eyes, eno;
	JComboBox religion1, category1, occupation1, education1, income1;
	String formno;
	
	SignupTwo(String formno)
	{
		this.formno = formno;
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD, 22));
		additionalDetails.setBounds(290, 80, 400, 30);
		add(additionalDetails);
		
		JLabel religion = new JLabel("Religion:");
		religion.setFont(new Font("Raleway",Font.BOLD, 20));
		religion.setBounds(100, 140, 100, 30);
		add(religion);
		
		String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
		religion1 = new JComboBox(valReligion);
		religion1.setBounds(300, 140, 400, 30);
		religion1.setBackground(Color.WHITE);
		add(religion1);
		
		JLabel category = new JLabel("Category:");
		category.setFont(new Font("Raleway",Font.BOLD, 20));
		category.setBounds(100, 190, 200, 30);
		add(category);
		
		String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
		category1 = new JComboBox(valcategory);
		category1.setBounds(300, 190, 400, 30);
		category1.setBackground(Color.WHITE);
		add(category1);
		
		JLabel income = new JLabel("Income:");
		income.setFont(new Font("Raleway",Font.BOLD, 20));
		income.setBounds(100, 240, 200, 30);
		add(income);
		
		String incomecategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
		income1 = new JComboBox(incomecategory);
		income1.setBounds(300, 240, 400, 30);
		income1.setBackground(Color.WHITE);
		add(income1);
		
		JLabel education = new JLabel("Educational");
		education.setFont(new Font("Raleway",Font.BOLD, 20));
		education.setBounds(100, 290, 200, 30);
		add(education);
		
		JLabel qualification = new JLabel("Qualification:");
		qualification.setFont(new Font("Raleway",Font.BOLD, 20));
		qualification.setBounds(100, 315, 200, 30);
		add(qualification);
		
		String EducationValues[] = {"Non-Gradution", "Graduate", "Post-Graduation", "Doctrate", "Others"};
		education1 = new JComboBox(EducationValues);
		education1.setBounds(300, 315, 400, 30);
		education1.setBackground(Color.WHITE);
		add(education1);
		
		JLabel occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway",Font.BOLD, 20));
		occupation.setBounds(100, 390, 200, 30);
		add(occupation);
		
		String occupationValues[] = {"Salaried", "Self Employed", "Bussiness", "Student", "Retired", "Others"};
		occupation1 = new JComboBox(occupationValues);
		occupation1.setBounds(300, 390, 400, 30);
		occupation1.setBackground(Color.WHITE);
		add(occupation1);
		
		JLabel pan1 = new JLabel("PAN Number:");
		pan1.setFont(new Font("Raleway",Font.BOLD, 20));
		pan1.setBounds(100, 440, 200, 30);
		add(pan1);
		
		pan = new JTextField();
		pan.setFont(new Font("Raleway", Font.BOLD, 14));
		pan.setBounds(300, 440, 400, 30);
		add(pan);
		
		JLabel aadhar1 = new JLabel("Aadhar Number:");
		aadhar1.setFont(new Font("Raleway",Font.BOLD, 20));
		aadhar1.setBounds(100, 490, 200, 30);
		add(aadhar1);
		
		aadhar = new JTextField();
		aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
		aadhar.setBounds(300, 490, 400, 30);
		add(aadhar);
		
		JLabel state = new JLabel("Senior Citizen:");
		state.setFont(new Font("Raleway",Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(300,540,100,30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(450,540,100,30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup seniorgroup = new ButtonGroup();
		seniorgroup.add(syes);
		seniorgroup.add(sno);
		
		JLabel exist = new JLabel("Existing Account:");
		exist.setFont(new Font("Raleway",Font.BOLD, 20));
		exist.setBounds(100, 590, 200, 30);
		add(exist);
		
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300,590,100,30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(450,590,100,30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup existinggroup = new ButtonGroup();
		existinggroup.add(eyes);
		existinggroup.add(eno);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 630, 80, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(750, 700);
		setLocation(350, 10);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String sreligion = (String) religion1.getSelectedItem();
		String scategory = (String) category1.getSelectedItem();
		String sincome = (String) income1.getSelectedItem();
		String seducation = (String) education1.getSelectedItem();
		String soccupation = (String) occupation1.getSelectedItem();
		String seniorcitizen = null;
		if(syes.isSelected()) {
			seniorcitizen = "Yes";
		}
		else if(sno.isSelected()){
			seniorcitizen = "No";
		}
		
		String exisitingaccount = null;
		if(eyes.isSelected()) {
			exisitingaccount = "Yes";
		}
		else if(eno.isSelected()){
			exisitingaccount = "No";
		}
		
		
		String span = pan.getText();
		String saadhar = aadhar.getText();
		
		
		try {
			if(sreligion.equals("") || scategory.equals("") || sincome.equals("") || seducation.equals("") || soccupation.equals("") || span.equals("") || saadhar.equals("") || seniorcitizen == null || exisitingaccount == null) 
			{
			   JOptionPane.showMessageDialog(null, "Fill all the required fields");
			}
			else {
				Conn c = new Conn();
				String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+exisitingaccount+"')";
			    c.s.executeUpdate(query);
			}
			    setVisible(false);
				new SignupThree(formno).setVisible(true);
			    
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) 
	{
		new SignupTwo("");

	}

}



