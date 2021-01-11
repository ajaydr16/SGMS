import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class Welcome extends JFrame {

	private JPanel contentPane;
	private JTextField addText;
	private JTextField textField_1;
	private int i=0;
	java.sql.Connection con=null;
	String uname=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		try {
			con=Connector.dbConnector();
			}
			catch(Exception e2) {
				System.out.println("Frame co");
			}
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String[] data=new String[10];
		
		
		JPanel panel = new JPanel();
		JPanel panel_3 = new JPanel();
		JPanel panel_2 = new JPanel();
		JList list = new JList(data);
		JList list_1 = new JList();
		DefaultListModel dm=new DefaultListModel();
		DefaultListModel dm_1=new DefaultListModel();
		
	    
		
		
		//JList list = new JList();
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(30, 28, 798, 421);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton buttonshortterm = new JButton("Short-Term Goals");
		buttonshortterm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				panel.add(panel_2);
				panel.repaint();
				panel.revalidate();
				
				try {
					//Statement st=con.createStatement();
					PreparedStatement p=con.prepareStatement("select * from adder");
					
					ResultSet rs=p.executeQuery();
					dm.removeAllElements();
					while(rs.next()) {
						
						String a=rs.getString(1);
						list.setModel(dm);
						dm.addElement(a);
						
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		buttonshortterm.setFont(new Font("Tahoma", Font.PLAIN, 17));
		buttonshortterm.setBounds(10, 224, 269, 81);
		panel_1.add(buttonshortterm);
		
		JButton btnLongtermGoals = new JButton("Long-Term Goals");
		btnLongtermGoals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				panel.add(panel_3);
				panel.repaint();
				panel.revalidate();
				
			}
		});
		btnLongtermGoals.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLongtermGoals.setBounds(10, 329, 269, 81);
		panel_1.add(btnLongtermGoals);
		
		JLabel lblNewLabel = new JLabel("WELCOME"+Login.uname());
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setBounds(38, 39,8205, 116);
		panel_1.add(lblNewLabel);
		
		
		panel.setBounds(318, 23, 452, 374);
		panel_1.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		
		panel.add(panel_2, "name_204432349881900");///////
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Short- Term Goals");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(117, 25, 182, 32);
		panel_2.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ADD +");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				list.setModel(dm);
				dm.addElement(addText.getText());
				
				try {
				PreparedStatement st=con.prepareStatement("insert into adder values(?,?)");
				st.setString(1, addText.getText());
				st.setString(2, "");
				
				st.execute();
				}
				catch(Exception e2) {System.out.println("ADD ERROR");}
				addText.setText("");
			
			}
		});
		btnNewButton.setBounds(55, 301, 89, 23);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REMOVE-");	
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=list.getSelectedIndex();
				
				
				String val=(String) dm.getElementAt(index);
				PreparedStatement pst;
				try {
					String s="delete from adder where task="+"'"+val+"'";
					Statement st=con.createStatement();
					st.executeQuery(s);
					//pst.setString(1, val);
					//pst.setString(2, "");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dm.removeElementAt(index);
				
				//PreparedStatement st=con.prepareStatement("	insert into adder values(?,?)");
				
			}
		});
		btnNewButton_1.setBounds(272, 301, 89, 23);
		panel_2.add(btnNewButton_1);
		
		addText = new JTextField();
		addText.setBounds(77, 335, 284, 20);
		panel_2.add(addText);
		addText.setColumns(10);
		
		
		list.setBounds(77, 68, 265, 184);
		panel_2.add(list);
		
		
		panel_3.setLayout(null);
		panel.add(panel_3, "name_204639078398200");////////
		
		JLabel lblLongTermGoals = new JLabel("Long- Term Goals");
		lblLongTermGoals.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLongTermGoals.setHorizontalAlignment(SwingConstants.CENTER);
		lblLongTermGoals.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLongTermGoals.setBounds(117, 25, 182, 32);
		panel_3.add(lblLongTermGoals);
		
		JButton button = new JButton("ADD +");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list_1.setModel(dm_1);
				dm_1.addElement(textField_1.getText());
				textField_1.setText("");
			
			}
		});
		button.setBounds(55, 301, 89, 23);
		panel_3.add(button);
		
		JButton button_1 = new JButton("REMOVE-");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=list_1.getSelectedIndex();
				dm_1.removeElementAt(index);
			
			}
		});
		button_1.setBounds(259, 301, 102, 23);
		panel_3.add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(77, 335, 284, 20);
		panel_3.add(textField_1);
		
		
		list_1.setBounds(55, 84, 306, 195);
		panel_3.add(list_1);
		
		//JList list = new JList();
		//list.setBounds(20, 23, 248, 38);
		//panel.add(list);
		
		
		
		
		
	}
}
