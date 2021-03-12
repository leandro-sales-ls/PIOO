package factory;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  

public class ConnectionFactory {

	//"com.microsoft.sqlserver";
	//"net.sourceforge.jtds.jdbc.Driver";
	//"com.microsoft.sqlserver";
	//"com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	private String driver = "com.mysql.jdbc.Driver";
	private String connectionStr = "jdbc:mysql://localhost:3306/pioopublicity";  
	private String username = "aplicacao";
	private String password = "123456";
	
	private static ConnectionFactory connectionFactory = null;  

	private ConnectionFactory(){  
		try{  
			Class.forName(driver);  
		}catch(ClassNotFoundException e){  
			e.printStackTrace();  
		}  
	}  

	public Connection getConnection() throws SQLException{  
		Connection conn = null;  
		try{  
			conn = DriverManager.getConnection(connectionStr, username, password);  
		}catch(SQLException e){  
			e.printStackTrace();  
		}  
		return conn;  
	}  

	public static ConnectionFactory getInstance(){  
		if(connectionFactory == null)  
			connectionFactory = new ConnectionFactory();  

		return connectionFactory;  
	}  
}
