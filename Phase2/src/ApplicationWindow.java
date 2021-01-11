import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.toedter.calendar.JDateChooser;

//import sun.util.calendar.LocalGregorianCalendar.Date;

//import net.proteanit.sql.DbUtils;

import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.JTextArea;

public class ApplicationWindow {

	private JFrame frame;
	private JPasswordField tf2;
	private JTextField tf1;
	private JTextField nameregtf;
	private JTextField usernameregtf;
	private JPasswordField passwordFieldReg;
	private JTextField tf3;
	private JTextField tf4;
	JLayeredPane layeredPane = new JLayeredPane();
	JPanel Register = new JPanel();
	JPanel Welcome = new JPanel();
	JLayeredPane layeredPane_1 = new JLayeredPane();
	static Connection con=null;
	JLabel lblClock = new JLabel("New label");
	int day,month,year,second,minute,hour;
	JDateChooser dateChooser_1 = new JDateChooser();
	JDateChooser dateChooser = new JDateChooser();
	private String s="",s2="user";
	DefaultListModel dm=new DefaultListModel();
	DefaultListModel dm_1=new DefaultListModel();
	DefaultListModel dm_2=new DefaultListModel();
	DefaultListModel dm_3=new DefaultListModel();
	DefaultListModel dm_4=new DefaultListModel();
	JList list_4 = new JList();
	JList list_2 = new JList();
	JPanel Admin = new JPanel();
	String uname="";
	JList list_1 = new JList();
	private JTextField auser;
	private JPasswordField apwd;
	JPanel admin_panel = new JPanel();
	JLabel lblNewLabel_9;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frame.setVisible(true);
					con=Connector.dbConnector();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public  void panelShift(JPanel panel)
	{
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	public void panelShift2(JPanel panel) {
		layeredPane_1.removeAll();
		layeredPane_1.add(panel);
		layeredPane_1.repaint();
		layeredPane_1.revalidate();
	}
	
	public void clock(){
		Thread clock=new Thread(){
			public void run(){
				try{
					while(true){
						Calendar cal=new GregorianCalendar();
						day=cal.get(Calendar.DAY_OF_MONTH);
						month=cal.get(Calendar.MONTH);
						year=cal.get(Calendar.YEAR);
						
						second=cal.get(Calendar.SECOND);
						minute=cal.get(Calendar.MINUTE);
						hour=cal.get(Calendar.HOUR);
						lblClock.setText("Time  "+hour+":"+minute+":"+second+"  Date "+day+"/"+String.valueOf(month+1)+"/"+year);
						sleep(1000);
						}
				}
						catch(Exception e){}
					}
				};
				clock.start();
	}
	public void checkDate() {
		int d=0;
		String s2="MAR";
		switch(month+1) {
		case 1:s2="JAN";break;
		case 2:s2="FEB";break;
		case 3:s2="MAR";break;
		case 4:s2="APR";break;
		case 5:s2="MAY";break;
		case 6:s2="JUN";break;
		case 7:s2="JUL";break;
		case 8:s2="AUG";break;
		case 9:s2="SEP";break;
		case 10:s2="OCT";break;
		case 11:s2="NOV";break;
		case 12:s2="DEC";break;
			
		}
		s=day+"-"+s2+"-"+year;
		//System.out.println(s);
		
		
	}
	public String uname(String u){
		try {
			PreparedStatement ps=con.prepareStatement("select * from reg where username="+"'"+u+"'");
			//ps.setString(1, "'"+u+"'");
			ResultSet rs=ps.executeQuery();
			//rs.next();
			return rs.getString(1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "user";
			
		}
		
	
	}
						
						
						
						
		

					
	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
		clock();
		//checkTime();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setForeground(Color.WHITE);
		frame.getContentPane().setBackground(SystemColor.desktop);
		frame.setType(Type.POPUP);
		frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frame.setBounds(100, 100, 1135, 518);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		layeredPane.setForeground(Color.WHITE);
		
		
		layeredPane.setBounds(55, 71, 1056, 386);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel Login = new JPanel();
		Login.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.activeCaption));
		Login.setForeground(Color.WHITE);
		Login.setBackground(SystemColor.activeCaption);
		layeredPane.add(Login, "name_716113750523300");
		Login.setLayout(null);
		
		JLabel label = new JLabel("PASSWORD");
		label.setBounds(349, 180, 88, 48);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Login.add(label);
		
		tf2 = new JPasswordField();
		tf2.setBounds(464, 190, 236, 32);
		tf2.setForeground(SystemColor.inactiveCaptionText);
		Login.add(tf2);
		
		JButton button = new JButton("LOGIN");
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(421, 255, 139, 39);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					s2=tf1.getText();
					PreparedStatement st=con.prepareStatement("select * from reg where username ='"+tf1.getText()+ "' and password='"+tf2.getText()+"'");
					//st.setString(1,tf1.getText());
					//st.setString(2,tf2.getText());
					ResultSet rs=st.executeQuery();
					int count1=0;
					//System.out.println(rs);
					while(rs.next())
						count1+=1;
					
					System.out.println(count1);
					if(count1==1) {
						panelShift(Welcome);
						
						
						
					}
					else
						JOptionPane.showMessageDialog(null, "Invalid credentials");
						
					}
					
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tf1.setText("");
				tf2.setText("");
				
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Login.add(button);
		
		JLabel label_1 = new JLabel("Create New Account");
		label_1.setBounds(421, 303, 139, 32);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelShift(Register);
			}
		});
		
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Login.add(label_1);
		
		JLabel label_2 = new JLabel("USERNAME");
		label_2.setBounds(351, 116, 88, 48);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Login.add(label_2);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(306, 56, 319, 57);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Login.add(lblLogin);
		
		tf1 = new JTextField();
		tf1.setBounds(464, 124, 236, 32);
		tf1.setForeground(SystemColor.inactiveCaptionText);
		tf1.setColumns(10);
		Login.add(tf1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\AJAY\\Downloads\\user.png"));
		lblNewLabel_4.setBounds(507, 63, 39, 48);
		Login.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("ADMIN");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelShift(admin_panel);
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\AJAY\\Downloads\\seo-and-web (1).png"));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(886, 11, 102, 26);
		Login.add(lblNewLabel_3);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(1);
			}
		});
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\AJAY\\Downloads\\exit (3).png"));
		lblNewLabel_11.setBounds(1001, 0, 50, 39);
		Login.add(lblNewLabel_11);
		Register.setBackground(SystemColor.activeCaption);
		
		
		layeredPane.add(Register, "name_716118036740900");
		Register.setLayout(null);
		
		nameregtf = new JTextField();
		nameregtf.setForeground(Color.BLACK);
		nameregtf.setColumns(10);
		nameregtf.setBounds(479, 105, 186, 36);
		Register.add(nameregtf);
		
		JLabel label_4 = new JLabel("Usename");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(331, 164, 127, 49);
		Register.add(label_4);
		
		JLabel label_5 = new JLabel("Name");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(331, 104, 127, 49);
		Register.add(label_5);
		
		JLabel label_6 = new JLabel("REGISTRATION");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_6.setBounds(346, 40, 319, 57);
		Register.add(label_6);
		
		usernameregtf = new JTextField();
		usernameregtf.setForeground(Color.BLACK);
		usernameregtf.setColumns(10);
		usernameregtf.setBounds(479, 165, 186, 36);
		Register.add(usernameregtf);
		
		passwordFieldReg = new JPasswordField();
		passwordFieldReg.setForeground(Color.BLACK);
		passwordFieldReg.setBounds(477, 230, 188, 36);
		Register.add(passwordFieldReg);
		
		JLabel label_7 = new JLabel("Password");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(331, 229, 127, 49);
		Register.add(label_7);
		
		JButton button_1 = new JButton("REGISTER");
		button_1.setBackground(SystemColor.textHighlight);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement st=con.prepareStatement("insert into reg values(?,?,?)");
					st.setString(1, nameregtf.getText());
					st.setString(2, usernameregtf.getText());
					st.setString(3, passwordFieldReg.getText());
					st.execute();
					
					
					PreparedStatement ps2=con.prepareStatement("insert into mark values(?,?)");
					ps2.setString(1, usernameregtf.getText());
					ps2.setString(2, String.valueOf(0));
					ps2.execute();
					
					PreparedStatement ps3=con.prepareStatement("insert into marklong values(?,?)");
					ps3.setString(1, usernameregtf.getText());
					ps3.setString(2, String.valueOf(0));
					ps3.execute();
					panelShift(Login);
					
				}
				catch(Exception e2) {
					e2.printStackTrace();
				}
				nameregtf.setText("");
				usernameregtf.setText("");
				passwordFieldReg.setText("");
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBounds(455, 318, 116, 23);
		Register.add(button_1);
		
		JLabel label_8 = new JLabel("Have Account? Login Here");
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelShift(Login);
			}
		});
		
		label_8.setForeground(Color.WHITE);
		label_8.setBounds(442, 352, 186, 23);
		Register.add(label_8);
		Welcome.setBackground(SystemColor.activeCaption);
		
		
		layeredPane.add(Welcome, "name_716121075438100");
		Welcome.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lblNewLabel.setBounds(27, 16, 181, 82);
		Welcome.add(lblNewLabel);
		
		
		layeredPane_1.setBounds(314, 28, 706, 324);
		Welcome.add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));
		
		JPanel s_panel = new JPanel();
		s_panel.setBackground(SystemColor.inactiveCaption);
		layeredPane_1.add(s_panel, "name_721778689191400");
		s_panel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-y");
		        String theDate = dateFormat.format(dateChooser_1.getDate());
		        
		        try {
					PreparedStatement p=con.prepareStatement("insert into addshort values(?,?,?,?,?)");

					p.setString(1, s2);
					p.setString(2, tf3.getText());
					p.setString(3, theDate);
					p.setString(4, "N");
					p.setString(5, String.valueOf(0));
					ResultSet rs=p.executeQuery();
					list_4.setModel(dm_1);
					dm_1.addElement(tf3.getText());
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        tf3.setText("");
		        
			}
		});
				/*
				try {
					PreparedStatement p=con.prepareStatement("select * from adder3");
					ResultSet rs=p.executeQuery();
					while(rs.next()) {
						table.getModel().setValueAt(rs.getString("TASK"),1,0);
						table.getModel().setValueAt(rs.getString("TASK"),1,1);
						
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
				
		
		btnNewButton_2.setBounds(10, 247, 89, 23);
		s_panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("REMOVE");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(SystemColor.textHighlight);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=list_4.getSelectedIndex();
				
				
				String val=(String) dm_1.getElementAt(index);
				PreparedStatement pst;
				try {
					String s="delete from addshort where task="+"'"+val+"'"+"and username='"+s2+"'";
					Statement st=con.createStatement();
					st.executeQuery(s);
					//pst.setString(1, val);
					//pst.setString(2, "");
					dm_1.removeElementAt(index);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
			}
		});
		btnNewButton_3.setBounds(361, 247, 89, 23);
		s_panel.add(btnNewButton_3);
		
		tf3 = new JTextField();
		tf3.setBackground(UIManager.getColor("menu"));
		tf3.setBounds(74, 290, 341, 23);
		s_panel.add(tf3);
		tf3.setColumns(10);
		
		
		dateChooser_1.setBounds(109, 250, 121, 20);
		s_panel.add(dateChooser_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(502, 235, 194, 78);
		s_panel.add(scrollPane_2);
		
		JList list = new JList();
		list.setBackground(UIManager.getColor("menu"));
		scrollPane_2.setViewportView(list);
		list.setForeground(Color.RED);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(74, 57, 336, 186);
		s_panel.add(scrollPane_1);
		list_4.setBackground(UIManager.getColor("menu"));
		scrollPane_1.setViewportView(list_4);
		
		JButton btnNewButton_6 = new JButton("COMPLETED");
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBackground(SystemColor.textHighlight);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=list_4.getSelectedIndex();
				
				
				String val=(String) dm_1.getElementAt(index);
				PreparedStatement pst,ps2,ps3,ps4,ps5;
				try {
					String q="update addshort set status='Y' where task="+"'"+val+"'"+"and username='"+s2+"'";
					Statement st=con.createStatement();
					st.executeQuery(q);
					pst=con.prepareStatement("update addshort set mark=1 where task="+"'"+val+"'"+"and username='"+s2+"' and deadline>='"+s+"'");
					ResultSet rs=pst.executeQuery();
					ps2=con.prepareStatement("update addshort set mark=0 where task="+"'"+val+"'"+"and username='"+s2+"' and deadline<'"+s+"'");
					ResultSet rs2=ps2.executeQuery();
					
					int count=0;
					ps3=con.prepareStatement("select * from addshort where username='"+s2+"'");
					ResultSet rs3=ps3.executeQuery();
					while(rs3.next()) {
						count=count+1;
					}
					//System.out.println(count);
					ps4=con.prepareStatement("update mark set goal=? where username='"+s2+"'");
					
					ps5=con.prepareStatement("select sum(mark) from addshort where username='"+s2+"'");
					//Statement st=con.createStatement();
					//float sum=ps5.executeUpdate();
					ResultSet rs4=ps5.executeQuery();
					String sum="";
					if(rs4.next())
						sum=rs4.getString("sum(mark)");
					float sum2=(Integer.parseInt(sum)/Float.parseFloat(String.valueOf(count)))*100;
					
					//System.out.println((Integer.parseInt(sum)/Float.parseFloat(String.valueOf(count)))*100);
					ps4.setString(1, String.valueOf(sum2));
					ps4.execute();
					
					//pst.setString(1, val);
					//pst.setString(2, "");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
		});
		btnNewButton_6.setBounds(240, 247, 117, 23);
		s_panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("NOTIFICATIONS\r\n");
		
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setBackground(SystemColor.textHighlight);
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_7.setBounds(502, 192, 165, 39);
		s_panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("SHORT-TERM GOALS");
		btnNewButton_8.setForeground(Color.WHITE);
		btnNewButton_8.setBackground(SystemColor.textHighlight);
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_8.setBounds(74, 3, 336, 46);
		s_panel.add(btnNewButton_8);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					checkDate();
					PreparedStatement ps=con.prepareStatement("select * from addshort where deadline<=? and username='"+s2+"' and status='N'");
					ps.setString(1, s);
					//ps.setString(2, s2);
					ResultSet rs=ps.executeQuery();
					dm_2.removeAllElements();
					while(rs.next()) {
						
						String a=rs.getString(2);
						list.setModel(dm_2);
						String b=rs.getString(3);
						dm_2.addElement(a+b);
						
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\AJAY\\Downloads\\reload.png"));
		lblNewLabel_5.setBounds(673, 192, 23, 39);
		s_panel.add(lblNewLabel_5);
		
		
		
		JPanel l_panel = new JPanel();
		l_panel.setBackground(SystemColor.inactiveCaption);
		layeredPane_1.add(l_panel, "name_721785288016400");
		l_panel.setLayout(null);
		JButton btnNewButton_4 = new JButton("ADD");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(SystemColor.textHighlight);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-y");
		        String theDate = dateFormat.format(dateChooser.getDate());
		        
		        try {
					PreparedStatement p=con.prepareStatement("insert into addlong values(?,?,?,?,?)");
					p.setString(1, s2);
					p.setString(2, tf4.getText());
					p.setString(3, theDate);
					p.setString(4, "N");
					p.setString(5, String.valueOf(0));
					ResultSet rs=p.executeQuery();
					list_2.setModel(dm);
					dm.addElement(tf4.getText());
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        tf4.setText("");
		        //dateChooser.setDate(s);
			}
		});
		btnNewButton_4.setBounds(24, 246, 89, 23);
		l_panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("REMOVE");
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(SystemColor.textHighlight);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=list_2.getSelectedIndex();
				
				
				String val=(String) dm.getElementAt(index);
				PreparedStatement pst;
				try {
					String s="delete from addlong where task="+"'"+val+"'"+"and username='"+s2+"'";
					Statement st=con.createStatement();
					st.executeQuery(s);
					//pst.setString(1, val);
					//pst.setString(2, "");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dm.removeElementAt(index);
				
							}
		});
		btnNewButton_5.setBounds(352, 246, 89, 23);
		l_panel.add(btnNewButton_5);
		
		tf4 = new JTextField();
		tf4.setBackground(SystemColor.menu);
		tf4.setBounds(49, 281, 378, 23);
		l_panel.add(tf4);
		tf4.setColumns(10);
		
		
		dateChooser.setBounds(115, 249, 115, 20);
		l_panel.add(dateChooser);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 65, 378, 167);
		l_panel.add(scrollPane);
		list_2.setBackground(SystemColor.menu);
		scrollPane.setViewportView(list_2);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(410, 65, 17, 167);
		l_panel.add(scrollBar);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(492, 226, 191, 87);
		l_panel.add(scrollPane_3);
		
		JList list_3 = new JList();
		list_3.setBackground(SystemColor.menu);
		list_3.setForeground(Color.RED);
		scrollPane_3.setViewportView(list_3);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(666, 226, 17, 87);
		l_panel.add(scrollBar_1);
		
		JButton complete = new JButton("COMPLETED");
		complete.setForeground(Color.WHITE);
		complete.setBackground(SystemColor.textHighlight);
		complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=list_2.getSelectedIndex();
				
				
				String val=(String) dm.getElementAt(index);
				PreparedStatement pst,ps2,ps3,ps4,ps5;
				try {
					String q="update addlong set status='Y' where task="+"'"+val+"'"+"and username='"+s2+"'";
					Statement st=con.createStatement();
					st.executeQuery(q);
					pst=con.prepareStatement("update addlong set mark=1 where task="+"'"+val+"'"+"and username='"+s2+"' and deadline>='"+s+"'");
					ResultSet rs=pst.executeQuery();
					ps2=con.prepareStatement("update addlong set mark=0 where task="+"'"+val+"'"+"and username='"+s2+"' and deadline<'"+s+"'");
					ResultSet rs2=ps2.executeQuery();
					
					int count=0;
					ps3=con.prepareStatement("select * from addlong where username='"+s2+"'");
					ResultSet rs3=ps3.executeQuery();
					while(rs3.next()) {
						count=count+1;
					}
					//System.out.println(count);
					ps4=con.prepareStatement("update marklong set goal=? where username='"+s2+"'");
					
					ps5=con.prepareStatement("select sum(mark) from addlong where username='"+s2+"'");
					//Statement st=con.createStatement();
					//float sum=ps5.executeUpdate();
					ResultSet rs4=ps5.executeQuery();
					String sum="";
					if(rs4.next())
						sum=rs4.getString("sum(mark)");
					float sum2=(Integer.parseInt(sum)/Float.parseFloat(String.valueOf(count)))*100;
					
					//System.out.println((Integer.parseInt(sum)/Float.parseFloat(String.valueOf(count)))*100);
					ps4.setString(1, String.valueOf(sum2));
					ps4.execute();
					
					//pst.setString(1, val);
					//pst.setString(2, "");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
		});
		complete.setBounds(234, 245, 115, 24);
		l_panel.add(complete);
		
		JButton btnNewButton_9 = new JButton("LONG-TERM GOALS");
		btnNewButton_9.setForeground(Color.WHITE);
		btnNewButton_9.setBackground(SystemColor.textHighlight);
		btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_9.setBounds(49, 11, 378, 51);
		l_panel.add(btnNewButton_9);
		
		JButton button_2 = new JButton("NOTIFICATIONS\r\n");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.setBackground(SystemColor.textHighlight);
		button_2.setBounds(492, 184, 165, 39);
		l_panel.add(button_2);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					checkDate();
					PreparedStatement ps=con.prepareStatement("select * from addlong where deadline<=? and username='"+s2+"' and status='N'");
					//ps.setString(2, s2);
					ps.setString(1, s);
					ResultSet rs=ps.executeQuery();
					dm_3.removeAllElements();
					while(rs.next()) {
						
						String a=rs.getString(2);
						list_3.setModel(dm_3);
						String b=rs.getString(3);
						dm_3.addElement(a+b);
						
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		label_3.setIcon(new ImageIcon("C:\\Users\\AJAY\\Downloads\\reload.png"));
		label_3.setBounds(660, 184, 23, 39);
		l_panel.add(label_3);
		
		JButton btnNewButton = new JButton("SHORT-TERM GOAL");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(s2);
				
				try {
					PreparedStatement p=con.prepareStatement("select * from addshort where username='"+s2+"'");
					//p.setString(1, s2);
					ResultSet rs;
					rs = p.executeQuery();
					list_4.setModel(dm_1);
					dm_1.removeAllElements();
					while(rs.next()) {
						
						String a=rs.getString(2);
						String b=rs.getString(3);
						
						dm_1.addElement(a);
				} }catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				panelShift2(s_panel);
				try {
					
					checkDate();
					PreparedStatement ps=con.prepareStatement("select * from addshort where deadline<=? and username='"+s2+"' and status='N'");
					ps.setString(1, s);
					//ps.setString(2, s2);
					ResultSet rs=ps.executeQuery();
					dm_2.removeAllElements();
					while(rs.next()) {
						
						String a=rs.getString(2);
						list.setModel(dm_2);
						String b=rs.getString(3);
						dm_2.addElement(a+b);
						
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		btnNewButton.setBounds(27, 199, 214, 69);
		Welcome.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LONG-TERM GOAL\r\n\r\n");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement p=con.prepareStatement("select * from addlong where username='"+s2+"'");
					//p.setString(1, s2);
					ResultSet rs;
					rs = p.executeQuery();
					dm.removeAllElements();
					while(rs.next()) {
						
						String a=rs.getString(2);
						list_2.setModel(dm);
						String b=rs.getString(3);
						dm.addElement(a);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				panelShift2(l_panel);
				try {
					
					checkDate();
					PreparedStatement ps=con.prepareStatement("select * from addlong where deadline<=? and username='"+s2+"' and status='N'");
					//ps.setString(2, s2);
					ps.setString(1, s);
					ResultSet rs=ps.executeQuery();
					dm_3.removeAllElements();
					while(rs.next()) {
						
						String a=rs.getString(2);
						list_3.setModel(dm_3);
						String b=rs.getString(3);
						dm_3.addElement(a+b);
						
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(27, 279, 214, 73);
		Welcome.add(btnNewButton_1);
		
		JLabel label_11 = new JLabel("LOGOUT");
		label_11.setForeground(Color.WHITE);
		label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelShift(Login);
			
			}
			
		});
		label_11.setIcon(new ImageIcon("C:\\Users\\AJAY\\Downloads\\exit (1).png"));
		label_11.setBounds(954, -8, 128, 46);
		Welcome.add(label_11);
		
		JLabel lblNewLabel_8 = new JLabel("TO WORLD OF VISION");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(10, 47, 214, 82);
		Welcome.add(lblNewLabel_8);
		Admin.setBackground(SystemColor.activeCaption);
		
		
		layeredPane.add(Admin, "name_818240058268100");
		Admin.setLayout(null);
		
		JButton btnNewButton_10 = new JButton("FETCH");
		btnNewButton_10.setForeground(Color.WHITE);
		btnNewButton_10.setBackground(SystemColor.textHighlight);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement p=con.prepareStatement("select * from mark ");
					//p.setString(1, s2);
					ResultSet rs,rs2;
					rs = p.executeQuery();
					PreparedStatement p2=con.prepareStatement("select * from marklong");
					rs2=p2.executeQuery();
					list_1.setModel(dm_4);
					dm_4.removeAllElements();
					while(rs.next() && rs2.next()) {
						
						String a=rs.getString(1);
						String b1=rs.getString(2);
						String b2=rs2.getString(2);
						String c=String.valueOf(((Integer.parseInt(b1)+Integer.parseInt(b1))/2.0));
						
						dm_4.addElement(a+b1+"   "+b2);
					
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_10.setBounds(169, 343, 148, 38);
		Admin.add(btnNewButton_10);
		
		JLabel lblNewLabel_1 = new JLabel("LOGOUT");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelShift(Login);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\AJAY\\Downloads\\exit (1).png"));
		lblNewLabel_1.setBounds(943, 11, 103, 46);
		Admin.add(lblNewLabel_1);
		
		JButton btnNewButton_11 = new JButton("STUDENT GOAL INDEX");
		btnNewButton_11.setForeground(SystemColor.window);
		btnNewButton_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_11.setBackground(SystemColor.textHighlight);
		btnNewButton_11.setBounds(61, 16, 410, 23);
		Admin.add(btnNewButton_11);
		list_1.setBounds(33, 76, 463, 262);
		Admin.add(list_1);
		
		JLabel lblNewLabel_10 = new JLabel("USER");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setBounds(38, 56, 49, 14);
		Admin.add(lblNewLabel_10);
		
		JLabel lblScore = new JLabel("SCORE1 & 2(in %)");
		lblScore.setForeground(Color.WHITE);
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblScore.setBounds(99, 55, 133, 14);
		Admin.add(lblScore);
		
		
		admin_panel.setBackground(SystemColor.activeCaption);
		layeredPane.add(admin_panel, "name_1122245261669199");
		admin_panel.setLayout(null);
		
		auser = new JTextField();
		auser.setForeground(Color.BLACK);
		auser.setColumns(10);
		auser.setBounds(425, 119, 236, 32);
		admin_panel.add(auser);
		
		JLabel label_12 = new JLabel("USERNAME");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_12.setBounds(312, 111, 88, 48);
		admin_panel.add(label_12);
		
		JLabel label_13 = new JLabel("PASSWORD");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_13.setBounds(310, 175, 88, 48);
		admin_panel.add(label_13);
		
		apwd = new JPasswordField();
		apwd.setForeground(Color.BLACK);
		apwd.setBounds(425, 185, 236, 32);
		admin_panel.add(apwd);
		
		JButton button_3 = new JButton("LOGIN");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=auser.getText();
				String b=apwd.getText();
				System.out.println(a+b);
				if(a.compareTo("ajaydr")==0 && (b.compareTo("ajay")==0)) {
					
					panelShift(Admin);
					auser.setText("");
					apwd.setText("");
					
				}
				else
					JOptionPane.showMessageDialog(null, "INVALID CREDENTIALS");
			}
			
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_3.setBackground(SystemColor.textHighlight);
		button_3.setBounds(382, 250, 139, 39);
		admin_panel.add(button_3);
		
		JLabel lblNewLabel_2 = new JLabel("ADMIN LOGIN");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\AJAY\\Downloads\\man.png"));
		lblNewLabel_2.setForeground(SystemColor.window);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(303, 59, 310, 53);
		admin_panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_7 = new JLabel("BACK");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelShift(Login);
				
			}
		});
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\AJAY\\Downloads\\back (1).png"));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(954, 11, 92, 32);
		admin_panel.add(lblNewLabel_7);
		lblClock.setForeground(Color.WHITE);
		
		
		lblClock.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClock.setBounds(919, 43, 192, 23);
		frame.getContentPane().add(lblClock);
		
		JLabel lblNewLabel_6 = new JLabel("STUDENT GOAL MANAGEMENT SYSTEM");
		lblNewLabel_6.setBackground(new Color(0, 0, 205));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Monospaced", Font.BOLD, 30));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(242, 15, 659, 45);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel label_9 = new JLabel("-");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_9.setBounds(1074, -5, 23, 41);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("X");
		label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(1);
			}
		});
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_10.setBounds(1113, -2, 12, 41);
		frame.getContentPane().add(label_10);
		frame.setUndecorated(true);
			}
}

	
	

