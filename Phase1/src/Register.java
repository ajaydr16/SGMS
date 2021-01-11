import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.jdi.connect.spi.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Register extends JFrame {
	java.sql.Connection con=null;
	private JPanel contentPane;
	private JTextField nameregtf;
	private JLabel lblUsename;
	private JTextField usernameregtf;
	private JLabel lblPassword;
	private JPasswordField passwordFieldReg;
	private JButton buttonreg;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		try {
			con=Connector.dbConnector();
			}
			catch(Exception e2) {
				System.out.println("Frame co");
			}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 641);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRATION");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(81, 11, 319, 57);
		contentPane.add(lblNewLabel);
		
		JLabel rnamelabel = new JLabel("Name");
		rnamelabel.setForeground(Color.WHITE);
		rnamelabel.setHorizontalAlignment(SwingConstants.CENTER);
		rnamelabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rnamelabel.setBounds(33, 132, 127, 49);
		contentPane.add(rnamelabel);
		
		nameregtf = new JTextField();
		nameregtf.setBounds(181, 133, 186, 36);
		contentPane.add(nameregtf);
		nameregtf.setColumns(10);
		
		lblUsename = new JLabel("Usename");
		lblUsename.setForeground(Color.WHITE);
		lblUsename.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsename.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsename.setBounds(33, 192, 127, 49);
		contentPane.add(lblUsename);
		
		usernameregtf = new JTextField();
		usernameregtf.setColumns(10);
		usernameregtf.setBounds(181, 193, 186, 36);
		contentPane.add(usernameregtf);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(33, 257, 127, 49);
		contentPane.add(lblPassword);
		
		passwordFieldReg = new JPasswordField();
		passwordFieldReg.setBounds(179, 258, 188, 36);
		contentPane.add(passwordFieldReg);
		
		buttonreg = new JButton("REGISTER");
		buttonreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement st=con.prepareStatement("insert into reg values(?,?,?)");
					st.setString(1, nameregtf.getText());
					st.setString(2, usernameregtf.getText());
					st.setString(3, passwordFieldReg.getText());
					st.execute();
					JOptionPane.showMessageDialog(null,"Registered Succefully");
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			}
		});
		buttonreg.setBounds(157, 346, 116, 23);
		contentPane.add(buttonreg);
		
		lblNewLabel_1 = new JLabel("Have Account? Login Here");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Login lgf = new Login();
			        lgf.setVisible(true);
			        //lgf.pack();
			        lgf.setLocationRelativeTo(null);
			        lgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        dispose();
			
			}
		});
		lblNewLabel_1.setBounds(131, 380, 186, 23);
		contentPane.add(lblNewLabel_1);
		
		label = new JLabel("-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			
			}
			
			
		});
		label.setForeground(SystemColor.inactiveCaptionBorder);
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label.setBounds(430, 0, 12, 41);
		contentPane.add(label);
		
		label_1 = new JLabel("X");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(458, 0, 12, 41);
		contentPane.add(label_1);
		setUndecorated(true);
	}
}
