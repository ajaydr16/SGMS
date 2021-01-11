import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Connector {
	public static Connection dbConnector(){
		// TODO Auto-generated method stub
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uname="ajay";
		String pwd="ajay";
		Connection con=DriverManager.getConnection(url,uname,pwd);
		//JOptionPane.showMessageDialog(null, "Connection established.");
		return con;
		}
		catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Connection Problem.");
			
			return null;
		}

	}
	
	
	
}
