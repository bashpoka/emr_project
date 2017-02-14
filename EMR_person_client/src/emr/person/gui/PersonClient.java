package emr.person.gui;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.UIManager;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;

import emr.services.person.EmrPerson;
import emr.services.person.EmrPersonService;
import emr.services.person.PersonBean;
import emr.services.person.Session;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Insets;

import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;


public class PersonClient {

	private static Session currentSession;
	
	private JFrame mainFrame;
	
	private EmrPersonService personService;
	private EmrPerson personServicePort;
	
	
	private JPanel loginPanel;
	private JPanel signupPanel;
	private JPanel mainAppPanel;
	private JMenuBar menuBar;
	
	private final int signuploginWindowWidth = 587;
	private final int signuploginWindowHeight = 445;
	private JTextField natIdNoTextField;
	

	public static Session getCurrentSession() {
		return currentSession;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonClient window = new PersonClient();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	public PersonClient() {
		mainFrame = new JFrame();
		mainFrame.setResizable(false);
		
		loginPanelHandler(100, 100);
		
		mainFrame.addWindowListener(new java.awt.event.WindowAdapter() {
	        public void windowClosing(WindowEvent winEvt) {
	        	if(currentSession != null) {
	        		setServiceVariables();
	        		personServicePort.deleteSession(currentSession);
	        	}
	            System.exit(0);
	        }
	    });
		
		mainFrame.setBounds(100, 100, signuploginWindowWidth,signuploginWindowHeight);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	private void createMainApplicationPanel(int x, int y, int choice) {
		mainAppPanel = new mainApplicationPanel(choice);		
		
		mainFrame.getContentPane().add(mainAppPanel);
		mainFrame.setBounds(x, y, 900, 600);		
		
		createMenubar();
	}
	
	private void setServiceVariables() {
		try {
			personService = new EmrPersonService();
			personServicePort = personService.getEmrPersonServicePort();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(mainFrame,
				    "Sorry, there are some connection problems.",
				    "Connection error",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void createMenubar() {
		menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 2, 0, 2));
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mainFrame.setJMenuBar(menuBar);
		
		JMenu mnUser = new JMenu("User");
		mnUser.setBorder(new EmptyBorder(0, 2, 0, 2));
		menuBar.add(mnUser);
		
		JMenuItem mntmViewProfile = new JMenuItem("View Profile");
		mnUser.add(mntmViewProfile);
		
		JMenuItem mntmEditProfile = new JMenuItem("Edit Profile");
		mnUser.add(mntmEditProfile);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mnUser.add(mntmLogOut);
		
		JMenu mnDoctors = new JMenu("Doctors");
		mnDoctors.setBorder(new EmptyBorder(0, 2, 0, 2));
		menuBar.add(mnDoctors);
		
		JMenuItem mntmListDoctors = new JMenuItem("List Doctors");
		mnDoctors.add(mntmListDoctors);
		
		JMenu mnPrescription = new JMenu("Prescription");
		mnPrescription.setBorder(new EmptyBorder(0, 2, 0, 2));
		menuBar.add(mnPrescription);
		
		JMenuItem mntmAllPrescriptions = new JMenuItem("All Prescriptions");
		mnPrescription.add(mntmAllPrescriptions);
		
		JMenuItem mntmRecentPrescriptions = new JMenuItem("Recent Prescriptions");
		mnPrescription.add(mntmRecentPrescriptions);
		
		JMenu mnMedicines = new JMenu("Medicines");
		mnMedicines.setBorder(new EmptyBorder(0, 2, 0, 2));
		menuBar.add(mnMedicines);
		
		JMenuItem mntmAllMedicines = new JMenuItem("All Medicines");
		mnMedicines.add(mntmAllMedicines);
		
		JMenuItem mntmUesdMedicines = new JMenuItem("Uesd Medicines");
		mnMedicines.add(mntmUesdMedicines);
		
		JMenu mnTests = new JMenu("Tests");
		mnTests.setBorder(new EmptyBorder(0, 2, 0, 2));
		menuBar.add(mnTests);
		
		JMenuItem mntmAvailableTests = new JMenuItem("Available Tests");
		mnTests.add(mntmAvailableTests);
		
		JMenuItem mntmFindTests = new JMenuItem("Find Tests");
		mnTests.add(mntmFindTests);
		
		JMenu mnSearch = new JMenu("Search");
		mnSearch.setBorder(new EmptyBorder(0, 2, 0, 2));
		menuBar.add(mnSearch);
	}
	
	private void loginPanelHandler(int x, int y) {
		loginPanel = new JPanel();
		loginPanel.setBackground(Color.WHITE);
				
		loginPanel.setLayout(null);
		
		JLabel emrBoldLabel = new JLabel("Electronic Medical Records");
		emrBoldLabel.setForeground(new Color(52, 73, 94));
		emrBoldLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		emrBoldLabel.setBounds(101, 39, 378, 65);
		
		loginPanel.add(emrBoldLabel);
		
		JLabel pcaLabel = new JLabel("Person Client Application");
		pcaLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		pcaLabel.setBounds(171, 88, 238, 38);
		
		loginPanel.add(pcaLabel);
		
		JLabel personIdLabel = new JLabel("Person id:");
		personIdLabel.setForeground(Color.DARK_GRAY);
		personIdLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		personIdLabel.setBounds(159, 169, 65, 20);
		
		loginPanel.add(personIdLabel);
		
		final JTextField personIdTextField = new JTextField();
		personIdTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		personIdTextField.setBounds(240, 166, 191, 25);
		loginPanel.add(personIdTextField);
		personIdTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(Color.DARK_GRAY);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordLabel.setBounds(157, 214, 72, 20);
		loginPanel.add(passwordLabel);
		
		final JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(240, 212, 191, 25);
		loginPanel.add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(62, 137, 457, 2);
		loginPanel.add(separator);
		
		JButton signUpButton = new JButton("Sign Up");
		signUpButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		signUpButton.setBounds(254, 257, 81, 23);
		loginPanel.add(signUpButton);
		
		JButton signInButton = new JButton("Sign in");
		signInButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		signInButton.setBounds(359, 257, 72, 23);
		loginPanel.add(signInButton);
		
		JLabel orLabel = new JLabel("or");
		orLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		orLabel.setBounds(341, 257, 12, 23);
		loginPanel.add(orLabel);
				
		final JLabel errorLabel = new JLabel("");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		errorLabel.setBounds(122, 322, 346, 20);
		loginPanel.add(errorLabel);
		
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String person_id = personIdTextField.getText();
				String password = new String(passwordField.getPassword());
				
				
				if(person_id.equals("") && password.equals("")) {
					errorLabel.setText("** Please enter your person id and password first.");
				} else if(person_id.equals("")) {
					errorLabel.setText("** Please enter your person id first.");
				} else if(password.equals("")) {
					errorLabel.setText("** Please enter your password first.");
				} else {
					errorLabel.setText("");
					setServiceVariables();
					
					int person_id_int;
					try {
						person_id_int = Integer.parseInt(personIdTextField.getText());

						currentSession = personServicePort.createSession(person_id_int, password);
						if (currentSession == null) {
							errorLabel.setText("Sorry the person id and password doesn't match.");
						} else {
							loginPanel.setVisible(false);
							
							Point p = mainFrame.getLocation();
							int x = p.x; 
							int y = p.y;
							
							createMainApplicationPanel(x, y, Constants.viewProfile);
						}
					} catch (NumberFormatException e1) {
						errorLabel.setText("** Please enter a valid person id.");
					}
					
				}
			}
		});
		
		signUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(false);
				Point p = mainFrame.getLocation();
				int x = p.x; 
				int y = p.y;
				signupPanelHandler(x, y);
			}
		});
		
		mainFrame.getContentPane().add(loginPanel, BorderLayout.CENTER);
		mainFrame.setBounds(x, y, signuploginWindowWidth, signuploginWindowHeight);
		

	}
	
	
	private void signupPanelHandler(int x, int y) {
		signupPanel = new JPanel();
		signupPanel.setBackground(Color.WHITE);
				
		signupPanel.setLayout(null);
		
		JLabel emrBoldLabel = new JLabel("Electronic Medical Records");
		emrBoldLabel.setForeground(new Color(52, 73, 94));
		emrBoldLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		emrBoldLabel.setBounds(101, 30, 378, 65);
		
		signupPanel.add(emrBoldLabel);
		
		JLabel pcaLabel = new JLabel("Person Client Application");
		pcaLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		pcaLabel.setBounds(171, 79, 238, 38);
		
		signupPanel.add(pcaLabel);
		
		JLabel personNameLabel = new JLabel("Name:");
		personNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		personNameLabel.setForeground(Color.DARK_GRAY);
		personNameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		personNameLabel.setBounds(162, 160, 65, 20);
		
		signupPanel.add(personNameLabel);
		
		final JTextField personNameTextField = new JTextField();
		personNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		personNameTextField.setBounds(242, 158, 191, 25);
		signupPanel.add(personNameTextField);
		personNameTextField.setColumns(10);
		
		JLabel natIdNoLabel = new JLabel("National Id No:");
		natIdNoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		natIdNoLabel.setForeground(Color.DARK_GRAY);
		natIdNoLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		natIdNoLabel.setBounds(122, 198, 105, 20);
		signupPanel.add(natIdNoLabel);
		
		natIdNoTextField = new JTextField();
		natIdNoTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		natIdNoTextField.setColumns(10);
		natIdNoTextField.setBounds(242, 196, 191, 25);
		signupPanel.add(natIdNoTextField);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setForeground(Color.DARK_GRAY);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordLabel.setBounds(159, 233, 68, 20);
		signupPanel.add(passwordLabel);
		
		final JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(242, 233, 191, 25);
		signupPanel.add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(62, 128, 457, 2);
		signupPanel.add(separator);
		
		JButton signUpButton = new JButton("Sign Up");
		signUpButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		signUpButton.setBounds(254, 273, 81, 23);
		signupPanel.add(signUpButton);
		
		JButton signInButton = new JButton("Sign in");
		signInButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		signInButton.setBounds(361, 273, 72, 23);
		signupPanel.add(signInButton);
		
		JLabel orLabel = new JLabel("or");
		orLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		orLabel.setBounds(343, 273, 12, 23);
		signupPanel.add(orLabel);
				
		final JLabel errorLabel = new JLabel("");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		errorLabel.setBounds(122, 336, 346, 20);
		signupPanel.add(errorLabel);
		
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String person_name = personNameTextField.getText();
				String nat_id_no = natIdNoTextField.getText();
				String password = new String(passwordField.getPassword());
				
				if(person_name.equals("") || nat_id_no.equals("") || password.equals("")) {
					errorLabel.setText("** Please fill out the form.");
				} else {
					errorLabel.setText("");
					setServiceVariables();
					
					PersonBean new_person = new PersonBean();
					new_person.setName(person_name);
					new_person.setNatIdNo(nat_id_no);
					new_person.setPassword(password);
					new_person.setSex(1);
					new_person.setPersonType(1);
					new_person.setMaritalStat(0);
					
					try {
						int return_value = personServicePort.insertNewPerson(new_person);
						
						if(return_value == Constants.errorDuplicateUser) {
							errorLabel.setText("** Sorry! Enter an unique national id no.");
						} else {
							currentSession = personServicePort.createSession(return_value, password);
							signupPanel.setVisible(false);
							
							Point p = mainFrame.getLocation();
							int x = p.x;
							int y = p.y;
							createMainApplicationPanel(x,y,Constants.editProfile);
						}

					} catch (Exception e3) {
						e3.printStackTrace();
						errorLabel.setText("Sorry, there was a connection error.");
					}
					
				}
			}
		});
		
		signInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signupPanel.setVisible(false);				
				
				Point p = mainFrame.getLocation();
				int x = p.x;
				int y = p.y;
				loginPanelHandler(x,y);				
			}
		});
		
		mainFrame.getContentPane().add(signupPanel, BorderLayout.CENTER);
		mainFrame.setBounds(x, y, signuploginWindowWidth, signuploginWindowHeight);

	}
}
