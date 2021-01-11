import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.CompoundBorder;

public class Login extends JFrame {
	Connection con=null;
	private JPanel contentPane;
	private static JTextField tf1;
	private JPasswordField tf2;
	private final JLabel X = new JLabel("X");
	private JLabel minimise;
	private JLabel lcreateaccount;
	static int count=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static  String uname() {
		if(count==1)
		return tf1.getText();
		else
		return null;
		
		
	}
	
	/**
	 * Create the frame.
	 */
	public Login() {
		try {
			con=Connector.dbConnector();
			
			
		}
		catch(Exception e) {}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionText);
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jl1 = new JLabel("USERNAME");
		jl1.setForeground(SystemColor.inactiveCaptionBorder);
		jl1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jl1.setBounds(177, 162, 88, 48);
		contentPane.add(jl1);
		
		JLabel jl2 = new JLabel("PASSWORD");
		jl2.setForeground(SystemColor.inactiveCaptionBorder);
		jl2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jl2.setBounds(175, 226, 88, 48);
		contentPane.add(jl2);
		
		tf1 = new JTextField();
		tf1.setBounds(290, 170, 236, 32);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JPasswordField();
		tf2.setBounds(290, 236, 236, 32);
		contentPane.add(tf2);
		
		//public static
		
		JButton lgb = new JButton("LOGIN");
		lgb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					PreparedStatement st=con.prepareStatement("select * from reg where username = ? and password= ?");
					st.setString(1,tf1.getText());
					st.setString(2,tf2.getText());
					ResultSet rs=st.executeQuery();
					count=0;
					//System.out.println(rs);
					while(rs.next())
						count+=1;
					if(count==1) {
						JOptionPane.showMessageDialog(null, "Welcome valid credentials");
						
						
						
					}
					else
						JOptionPane.showMessageDialog(null, "Invalid credentials");
					if(count==1) {
						
						Welcome w = new Welcome();
				        w.setVisible(true);
				        //rgf.pack();
				        w.setLocationRelativeTo(null);
				        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        dispose();
						
						
					}
				
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		lgb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lgb.setBounds(342, 302, 139, 39);
		contentPane.add(lgb);
		X.setForeground(SystemColor.window);
		X.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			
			}
		});
		X.setFont(new Font("Tahoma", Font.PLAIN, 18));
		X.setBounds(734, -2, 12, 41);
		contentPane.add(X);
		
		minimise = new JLabel("-");
		minimise.setForeground(SystemColor.inactiveCaptionBorder);
		minimise.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			 setState(JFrame.ICONIFIED);
			
			}
		});
		minimise.setFont(new Font("Tahoma", Font.PLAIN, 22));
		minimise.setBounds(706, -2, 12, 41);
		contentPane.add(minimise);
		
		lcreateaccount = new JLabel("Create New Account");
		lcreateaccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Register rgf = new Register();
		        rgf.setVisible(true);
		        //rgf.pack();
		        rgf.setLocationRelativeTo(null);
		        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        dispose();
			}
		});
		lcreateaccount.setForeground(SystemColor.inactiveCaptionBorder);
		lcreateaccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lcreateaccount.setBounds(342, 352, 139, 32);
		contentPane.add(lcreateaccount);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLogin.setBounds(241, 87, 319, 57);
		contentPane.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\AJAY\\Downloads\\login2.png"));
		lblNewLabel.setBounds(444, 87, 58, 56);
		contentPane.add(lblNewLabel);
		setUndecorated(true);
		//JFrame.setDefaultLookAndFeelDecorated((Boolean) null);
	}
}
