package com.bit.lms.db.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LmsOracle {

	private static Connection conn;
	
	private LmsOracle() {
		
	}
	
	//DB연결정보
	public static Connection getConnection(){
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "bit";
		String password = "1234";
		try{
			if(conn == null || conn.isClosed()){
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return conn;
	}
	
	
}
