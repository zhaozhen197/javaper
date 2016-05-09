package javapro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class mysqlConnection {

	public static final String  driver = "com.mysql.jdbc.Driver";
	public static final String dburl = "jdbc:mysql://localhost/javaper";
	public static final String user = "root";
	public static final String password = "zzlzzl";

	Connection conn = null;

		public Connection mysqlconnecion() throws Exception{

		Class.forName(driver);
		
		conn=DriverManager.getConnection(dburl,user,password);
		
		return conn;
		}
		public void close() throws SQLException {
			this.conn.close();
		}

	}
