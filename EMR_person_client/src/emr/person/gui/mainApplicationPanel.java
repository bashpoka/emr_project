package emr.person.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import java.awt.Cursor;

public class mainApplicationPanel extends JPanel {
	private JPanel navPanel;
	private JPanel centerPanel;
	private JTree tree;

	private void createTree() {
		tree = new JTree();
		tree.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tree.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		tree.getSelectionModel().setSelectionMode (TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if(node.toString().equals("View Profile")) {
					centerPanel.setVisible(false);
					createCenterPanel(Constants.viewProfile);
				}
				
				if(node.toString().equals("Edit Profile")) {
					centerPanel.setVisible(false);
					createCenterPanel(Constants.editProfile);
				}
			}
		});
		
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setLeafIcon(null);
		renderer.setClosedIcon(null);
		renderer.setOpenIcon(null);
		renderer.setBackground(SystemColor.control);
		renderer.setBackgroundNonSelectionColor(SystemColor.control);
		tree.setCellRenderer(renderer);

		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("EMR Client App") {
				{	DefaultMutableTreeNode profile_root;
						profile_root = new DefaultMutableTreeNode("User Profile");
						profile_root.add(new DefaultMutableTreeNode("View Profile"));
						profile_root.add(new DefaultMutableTreeNode("Edit Profile"));
					add(profile_root);
					
					DefaultMutableTreeNode doctor_root;
						doctor_root = new DefaultMutableTreeNode("Doctor");					
						doctor_root.add(new DefaultMutableTreeNode("View Doctor Profile"));
						doctor_root.add(new DefaultMutableTreeNode("List all Doctors"));
						doctor_root.add(new DefaultMutableTreeNode("Recent Doctors"));
						
					add(doctor_root);
					
					DefaultMutableTreeNode prescription_root;
						prescription_root = new DefaultMutableTreeNode("Prescription");
						prescription_root.add(new DefaultMutableTreeNode("Recent"));
					add(prescription_root);
				}
			}
		));
		tree.setBackground(SystemColor.control);
		
		navPanel.add(tree);
		for(int i=0;i<tree.getRowCount();i++) tree.expandRow(i); 
	}
	
	private void createNavPanel() {
		navPanel = new JPanel();
		navPanel.setBorder(new EmptyBorder(0, 5, 0, 50));
		navPanel.setBackground(SystemColor.control);
		
		add(navPanel, BorderLayout.WEST);
		navPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		createTree();
	}
	
	public void createCenterPanel(int choice) {
		if(choice==Constants.viewProfile) {
			centerPanel = new ViewProfilePanel();
		} else if (choice == Constants.editProfile) {
			centerPanel = new EditProfielPanel();
		}
		
		add(centerPanel, BorderLayout.CENTER);
	}
	
	
	public mainApplicationPanel(int choice) {
		setLayout(new BorderLayout(0, 0));
		setBackground(Color.WHITE);
		
		createNavPanel();
		createCenterPanel(choice);
	}
}
