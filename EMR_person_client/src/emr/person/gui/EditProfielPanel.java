package emr.person.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import emr.services.person.EmrPerson;
import emr.services.person.EmrPersonService;
import emr.services.person.PersonBean;
import emr.services.person.Session;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditProfielPanel extends JPanel {
	private JTextField nameText;
	private JTextField currAddText;
	private JTextField pmntText;
	private JTextField fatherText;
	private JTextField motherText;
	private JTextField spouseNameText;
	private JTextField phoneText;
	private JTextField emailText;
	
	private final int constDay = 10;
	private final int constMonth = 11;
	private final int constYear = 12;
	
	private PersonBean CurrentUser;
	private Session CurrentSession;
	private EmrPersonService personService;
	private EmrPerson personServicePort;
	
	public EditProfielPanel() {
		
		CurrentSession = PersonClient.getCurrentSession();
		
		personService = new EmrPersonService();
		personServicePort = personService.getEmrPersonServicePort();
				
		CurrentUser = personServicePort.getPersonById(CurrentSession.getUserId());
		
		
		setBorder(new EmptyBorder(20, 50, 0, 70));
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblAshikAowal = new JLabel("Edit User - " + CurrentUser.getName());
		lblAshikAowal.setBorder(new EmptyBorder(0, 10, 0, 0));
		lblAshikAowal.setForeground(Color.DARK_GRAY);
		lblAshikAowal.setFont(new Font("Tahoma", Font.BOLD, 24));
		add(lblAshikAowal);		
		
		JPanel editProfilePanel = new JPanel();
		editProfilePanel.setBackground(Color.WHITE);
		add(editProfilePanel);
		editProfilePanel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 8, 588, 2);
		editProfilePanel.add(separator);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameLabel.setBounds(30, 33, 40, 20);
		editProfilePanel.add(nameLabel);
		
		nameText = new JTextField(CurrentUser.getName());
		nameText.setBounds(80, 33, 227, 20);
		editProfilePanel.add(nameText);
		nameText.setColumns(10);
		
		JLabel sexLabel = new JLabel("Sex:");
		sexLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sexLabel.setBounds(30, 62, 40, 20);
		editProfilePanel.add(sexLabel);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(Color.WHITE);
		rdbtnFemale.setBounds(80, 62, 66, 23);
		editProfilePanel.add(rdbtnFemale);		
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(Color.WHITE);
		rdbtnMale.setBounds(143, 62, 66, 23);
		editProfilePanel.add(rdbtnMale);
		
		if(CurrentUser.getSex()==0) 
			rdbtnFemale.setSelected(true);
		else 
			rdbtnMale.setSelected(true);
		
		//sex radio button group
		final ButtonGroup sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(rdbtnMale);
		sexButtonGroup.add(rdbtnFemale);
		
		JLabel personTypeLabel = new JLabel("Person Type:");
		personTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		personTypeLabel.setBounds(30, 91, 79, 20);
		editProfilePanel.add(personTypeLabel);
		
		final JComboBox personTypeCombo = new JComboBox();
		personTypeCombo.setModel(new DefaultComboBoxModel(new String[] {"Person", "Doctor", "Medicine Dealer", "Test Operator"}));
		personTypeCombo.setBounds(118, 92, 91, 20);
		editProfilePanel.add(personTypeCombo);
		
		personTypeCombo.setSelectedIndex(CurrentUser.getPersonType() - 1);
		
		JLabel birthDateLabel = new JLabel("Birthdate:");
		birthDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		birthDateLabel.setBounds(30, 122, 66, 20);
		editProfilePanel.add(birthDateLabel);
		
		final JComboBox dateCombo = new JComboBox();
		dateCombo.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dateCombo.setBounds(94, 123, 40, 20);
		editProfilePanel.add(dateCombo);
		
		dateCombo.setSelectedItem(returnDateMonthYear(CurrentUser.getBirthDate(), constDay));
		
		final JComboBox monthCombo = new JComboBox();
		monthCombo.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		monthCombo.setBounds(143, 123, 79, 20);
		editProfilePanel.add(monthCombo);
		
		monthCombo.setSelectedItem(returnDateMonthYear(CurrentUser.getBirthDate(), constMonth));
		
		String year[] = new String[100];
		int start_year = 1970;
		for(int i=0; i<100; i++) {
			year[i] = start_year + "";
			start_year++;
		}
		
		final JComboBox yearCombo = new JComboBox();
		yearCombo.setModel(new DefaultComboBoxModel(year));
		yearCombo.setBounds(232, 123, 75, 20);
		editProfilePanel.add(yearCombo);
		
		yearCombo.setSelectedItem(returnDateMonthYear(CurrentUser.getBirthDate(), constYear));
		
		JLabel currAddLabel = new JLabel("Current Address:");
		currAddLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		currAddLabel.setBounds(30, 156, 104, 20);
		editProfilePanel.add(currAddLabel);
		
		currAddText = new JTextField(CurrentUser.getCurrAdd());
		currAddText.setColumns(10);
		currAddText.setBounds(133, 157, 258, 20);
		editProfilePanel.add(currAddText);
		
		JLabel pmntLabel = new JLabel("Parmanent Address:");
		pmntLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pmntLabel.setBounds(30, 187, 116, 20);
		editProfilePanel.add(pmntLabel);
		
		pmntText = new JTextField(CurrentUser.getPmntAdd());
		pmntText.setColumns(10);
		pmntText.setBounds(154, 188, 269, 20);
		editProfilePanel.add(pmntText);
		
		JLabel fatherLabel = new JLabel("Father Name:");
		fatherLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fatherLabel.setBounds(30, 218, 79, 20);
		editProfilePanel.add(fatherLabel);
		
		fatherText = new JTextField(CurrentUser.getFatherName());
		fatherText.setColumns(10);
		fatherText.setBounds(118, 218, 227, 20);
		editProfilePanel.add(fatherText);
		
		JLabel motherLabel = new JLabel("Mother Name:");
		motherLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		motherLabel.setBounds(30, 249, 79, 20);
		editProfilePanel.add(motherLabel);
		
		motherText = new JTextField(CurrentUser.getMotherName());
		motherText.setColumns(10);
		motherText.setBounds(118, 249, 227, 20);
		editProfilePanel.add(motherText);
		
		JLabel martStatLabel = new JLabel("Marital Status:");
		martStatLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		martStatLabel.setBounds(30, 282, 79, 20);
		editProfilePanel.add(martStatLabel);
		
		JRadioButton rdbtnMarried = new JRadioButton("Married");
		rdbtnMarried.setBackground(Color.WHITE);
		rdbtnMarried.setBounds(118, 282, 66, 23);
		editProfilePanel.add(rdbtnMarried);
		
		JRadioButton rdbtnNotMarried = new JRadioButton("Not Married");
		rdbtnNotMarried.setBackground(Color.WHITE);
		rdbtnNotMarried.setBounds(181, 282, 91, 23);
		editProfilePanel.add(rdbtnNotMarried);
		
		if(CurrentUser.getMaritalStat()==0) 
			rdbtnNotMarried.setSelected(true);
		else 
			rdbtnMarried.setSelected(true);
		
		final ButtonGroup maritalButtonGroup = new ButtonGroup();
		maritalButtonGroup.add(rdbtnMarried);
		maritalButtonGroup.add(rdbtnNotMarried);
		
		JLabel spouseLabel = new JLabel("Spouse Name(if any):");
		spouseLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spouseLabel.setBounds(30, 310, 124, 20);
		editProfilePanel.add(spouseLabel);
		
		spouseNameText = new JTextField(CurrentUser.getSpouseName());
		spouseNameText.setColumns(10);
		spouseNameText.setBounds(164, 311, 227, 20);
		editProfilePanel.add(spouseNameText);
		
		JLabel phoneLabel = new JLabel("Phone No:");
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		phoneLabel.setBounds(30, 341, 79, 20);
		editProfilePanel.add(phoneLabel);
		
		phoneText = new JTextField(CurrentUser.getPhoneNo());
		phoneText.setColumns(10);
		phoneText.setBounds(105, 342, 227, 20);
		editProfilePanel.add(phoneText);
		
		JLabel emailLabel = new JLabel("Email No:");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		emailLabel.setBounds(30, 372, 79, 20);
		editProfilePanel.add(emailLabel);
		
		emailText = new JTextField(CurrentUser.getEmail());
		emailText.setColumns(10);
		emailText.setBounds(105, 373, 227, 20);
		editProfilePanel.add(emailText);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 425, 588, 2);
		editProfilePanel.add(separator_1);
		
		final JLabel resultLabel = new JLabel("");
		resultLabel.setBounds(27, 438, 364, 20);
		editProfilePanel.add(resultLabel);
		
		JButton submit_button = new JButton("Submit");
		submit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CurrentUser.setName(nameText.getText());
				CurrentUser.setSex(getSexButtonIndex(Utility.getSelectedButtonText(sexButtonGroup)));
				CurrentUser.setPersonType(personTypeCombo.getSelectedIndex() + 1);
				CurrentUser.setBirthDate(
										createDateString( dateCombo.getSelectedItem().toString(),
														  monthCombo.getSelectedItem().toString(),
														  yearCombo.getSelectedItem().toString()
														 )
										);
				CurrentUser.setCurrAdd(currAddText.getText());
				CurrentUser.setPmntAdd(pmntText.getText());
				CurrentUser.setFatherName(fatherText.getText());
				CurrentUser.setMotherName(motherText.getText());
				CurrentUser.setMaritalStat(getMartialButtonIndex(Utility.getSelectedButtonText(maritalButtonGroup)));
				CurrentUser.setSpouseName(spouseNameText.getText());
				CurrentUser.setPhoneNo(phoneText.getText());
				CurrentUser.setEmail(emailText.getText());
				
				int result = personServicePort.updatePerson(CurrentUser, CurrentSession);
				
				if(result != Constants.databaseError || result != Constants.error || result != Constants.errorDuplicateUser) {
					resultLabel.setText("** Profile Updated Successfully!");
				}
					
			}
		});
		submit_button.setBounds(471, 437, 89, 23);
		editProfilePanel.add(submit_button);
		
		
	}
	
	
	private int getSexButtonIndex(String input) {
		return input=="Female" ? 0 : 1;
	}
	
	private int getMartialButtonIndex(String input) {
		return input=="Married" ? 1 : 0;
	}
	
	private String createDateString(String day, String month, String year) {
		return day + "-" + month.substring(0, 3) + "-" + year.substring(2, 4);
	}
	
	private String returnDateMonthYear(String dateString, int choice) {
		switch (choice) {
		case constDay:
			return dateString.substring(0, 2);
		case constMonth:
			String month = dateString.substring(3, 6).toLowerCase();
			switch (month) {
			case "jan":
				month = "January";
				break;
			case "feb":
				month = "February";
				break;
			case "mar":
				month = "March";
				break;
			case "apr":
				month = "April";
				break;
			case "may":
				month = "May";
				break;
			case "jun":
				month = "June";
				break;
			case "jul":
				month = "July";
				break;
			case "aug":
				month = "August";
				break;
			case "sep":
				month = "September";
				break;
			case "oct":
				month = "October";
				break;
			case "nov":
				month = "November";
				break;
			case "dec":
				month = "December";
				break;
			default:
				break;
			}
			return month;
		case constYear:
			int year = Integer.parseInt(dateString.substring(9, 11));
			return year>=70 ? "19"+dateString.substring(9, 11) : "20"+dateString.substring(9, 11);		
		}
		
		return null;
	}
}

