package emr.person.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import emr.services.person.EmrPerson;
import emr.services.person.EmrPersonService;
import emr.services.person.PersonBean;
import emr.services.person.Session;

public class ViewProfilePanel extends JPanel {

	public ViewProfilePanel() {
		
		Session CurrentSession = PersonClient.getCurrentSession();
		
		EmrPersonService personService = new EmrPersonService();
		EmrPerson personServicePort = personService.getEmrPersonServicePort();
		
		PersonBean CurrentUser = personServicePort.getPersonById(CurrentSession.getUserId());
		
		setBorder(new EmptyBorder(20, 50, 0, 70));
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblAshikAowal = new JLabel(CurrentUser.getName());
		lblAshikAowal.setBorder(new EmptyBorder(0, 10, 0, 0));
		lblAshikAowal.setForeground(Color.DARK_GRAY);
		lblAshikAowal.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(lblAshikAowal);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(null);
		infoPanel.setBackground(Color.WHITE);
		add(infoPanel);
		infoPanel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 8, 627, 2);
		infoPanel.add(separator);

		JLabel userIdLabel = new JLabel("User Id:");
		userIdLabel.setForeground(Color.DARK_GRAY);
		userIdLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		userIdLabel.setBounds(11, 21, 159, 22);
		infoPanel.add(userIdLabel);
		
		JLabel userIdText = new JLabel(CurrentUser.getPersonId()+"");
		userIdText.setForeground(Color.DARK_GRAY);
		userIdText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userIdText.setBounds(179, 21, 282, 22);
		infoPanel.add(userIdText);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setForeground(Color.DARK_GRAY);
		nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		nameLabel.setBounds(11, 50, 50, 14);
		infoPanel.add(nameLabel);
		
		JLabel nameText = new JLabel(CurrentUser.getName());
		nameText.setForeground(Color.DARK_GRAY);
		nameText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameText.setBounds(179, 45, 282, 22);
		infoPanel.add(nameText);
		
		JLabel sexLabel = new JLabel("Sex:");
		sexLabel.setForeground(Color.DARK_GRAY);
		sexLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		sexLabel.setBounds(11, 74, 50, 14);
		infoPanel.add(sexLabel);
		
		String sex = CurrentUser.getSex() == 0 ? "Female" : "Male";
		
		JLabel sexText = new JLabel(sex);
		sexText.setForeground(Color.DARK_GRAY);
		sexText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sexText.setBounds(179, 74, 282, 14);
		infoPanel.add(sexText);
		
		JLabel birthdateLabel = new JLabel("Birthdate:");
		birthdateLabel.setForeground(Color.DARK_GRAY);
		birthdateLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		birthdateLabel.setBounds(11, 100, 82, 14);
		infoPanel.add(birthdateLabel);
						
		JLabel birthdateText = new JLabel(CurrentUser.getBirthDate());
		birthdateText.setForeground(Color.DARK_GRAY);
		birthdateText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		birthdateText.setBounds(179, 95, 282, 22);
		infoPanel.add(birthdateText);
		
		JLabel personType = new JLabel("Person Type:");
		personType.setForeground(Color.DARK_GRAY);
		personType.setFont(new Font("Segoe UI", Font.BOLD, 16));
		personType.setBounds(11, 122, 104, 22);
		infoPanel.add(personType);
		
		String person_type = "";
		switch (CurrentUser.getPersonType()) {
		case 2:
			person_type = "Doctor";
			break;
		case 3:
			person_type = "Medicine Dealer";
			break;
		case 4:
			person_type = "Test Operator";
			break;
		default:
			person_type = "Person";
			break;
		}
		
		JLabel personTypeText = new JLabel(person_type);
		personTypeText.setForeground(Color.DARK_GRAY);
		personTypeText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		personTypeText.setBounds(179, 126, 282, 14);
		infoPanel.add(personTypeText);
		
		JLabel currAddLabel = new JLabel("Current Address:");
		currAddLabel.setForeground(Color.DARK_GRAY);
		currAddLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		currAddLabel.setBounds(11, 147, 145, 22);
		infoPanel.add(currAddLabel);
		
		JLabel currAddText = new JLabel(CurrentUser.getCurrAdd());
		currAddText.setForeground(Color.DARK_GRAY);
		currAddText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		currAddText.setBounds(179, 147, 435, 22);
		infoPanel.add(currAddText);
		
		JLabel pmntAddressLabel = new JLabel("Permanent Address:");
		pmntAddressLabel.setForeground(Color.DARK_GRAY);
		pmntAddressLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		pmntAddressLabel.setBounds(11, 173, 159, 22);
		infoPanel.add(pmntAddressLabel);
		
		JLabel pmntAddressText = new JLabel(CurrentUser.getPmntAdd());
		pmntAddressText.setForeground(Color.DARK_GRAY);
		pmntAddressText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pmntAddressText.setBounds(179, 173, 435, 22);
		infoPanel.add(pmntAddressText);
		
		JLabel fatherNamelabel = new JLabel("Father Name:");
		fatherNamelabel.setForeground(Color.DARK_GRAY);
		fatherNamelabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		fatherNamelabel.setBounds(11, 199, 159, 22);
		infoPanel.add(fatherNamelabel);
		
		JLabel fatherNameText = new JLabel(CurrentUser.getFatherName());
		fatherNameText.setForeground(Color.DARK_GRAY);
		fatherNameText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fatherNameText.setBounds(179, 199, 282, 22);
		infoPanel.add(fatherNameText);
		
		JLabel motherNameLabel = new JLabel("Mother Name:");
		motherNameLabel.setForeground(Color.DARK_GRAY);
		motherNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		motherNameLabel.setBounds(11, 225, 159, 22);
		infoPanel.add(motherNameLabel);
		
		JLabel motherNameText = new JLabel(CurrentUser.getMotherName());
		motherNameText.setForeground(Color.DARK_GRAY);
		motherNameText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		motherNameText.setBounds(179, 225, 282, 22);
		infoPanel.add(motherNameText);
		
		JLabel maritalStatLabel = new JLabel("Marital Status:");
		maritalStatLabel.setForeground(Color.DARK_GRAY);
		maritalStatLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		maritalStatLabel.setBounds(11, 250, 159, 22);
		infoPanel.add(maritalStatLabel);
		
		String maritalStatus = CurrentUser.getMaritalStat() == 0 ? "Not Married" : "Married";
		
		JLabel maritalStatText = new JLabel(maritalStatus);
		maritalStatText.setForeground(Color.DARK_GRAY);
		maritalStatText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		maritalStatText.setBounds(179, 250, 282, 22);
		infoPanel.add(maritalStatText);
		
		JLabel spName = new JLabel("Spouse Name:");
		spName.setForeground(Color.DARK_GRAY);
		spName.setFont(new Font("Segoe UI", Font.BOLD, 16));
		spName.setBounds(11, 276, 159, 22);
		infoPanel.add(spName);
		
		JLabel spNameText = new JLabel(CurrentUser.getSpouseName());
		spNameText.setForeground(Color.DARK_GRAY);
		spNameText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spNameText.setBounds(179, 276, 282, 22);
		infoPanel.add(spNameText);
		
		JLabel phoneLabel = new JLabel("Phone No:");
		phoneLabel.setForeground(Color.DARK_GRAY);
		phoneLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		phoneLabel.setBounds(11, 302, 159, 22);
		infoPanel.add(phoneLabel);
		
		JLabel phoneText = new JLabel(CurrentUser.getPhoneNo());
		phoneText.setForeground(Color.DARK_GRAY);
		phoneText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phoneText.setBounds(179, 302, 282, 22);
		infoPanel.add(phoneText);
		
		JLabel emailLabel = new JLabel("Email Account:");
		emailLabel.setForeground(Color.DARK_GRAY);
		emailLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		emailLabel.setBounds(11, 328, 159, 22);
		infoPanel.add(emailLabel);
		
		JLabel emailText = new JLabel(CurrentUser.getEmail());
		emailText.setForeground(Color.DARK_GRAY);
		emailText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailText.setBounds(179, 328, 282, 22);
		infoPanel.add(emailText);
		
		JLabel natIdLabel = new JLabel("National ID No:");
		natIdLabel.setForeground(Color.DARK_GRAY);
		natIdLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		natIdLabel.setBounds(11, 355, 159, 22);
		infoPanel.add(natIdLabel);
		
		JLabel natIdText = new JLabel(CurrentUser.getNatIdNo());
		natIdText.setForeground(Color.DARK_GRAY);
		natIdText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		natIdText.setBounds(179, 355, 282, 22);
		infoPanel.add(natIdText);
		
			
	}

}
