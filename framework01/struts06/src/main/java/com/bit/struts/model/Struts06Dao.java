package com.bit.struts.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.struts.model.entity.Struts06Vo;

public class Struts06Dao {
	private Connection conn;
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="scott";
	private String password="tiger";
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Struts06Dao() {
		try {
			if(conn==null || conn.isClosed()){
				Class.forName(driver);
				conn=DriverManager.getConnection(url, user, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Struts06Vo> getList() {
		List<Struts06Vo> list = new ArrayList<Struts06Vo>();
		String sql="select num,name,sub,nalja from STRUTS06 ORDER BY NUM DESC";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new Struts06Vo(
					rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4)
					));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
		}
		return list;
	}

	public void insertOne(Struts06Vo bean) {
		String sql="insert into struts06 values (struts06_seq.nextval,?,?,?,sysdate)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getSub());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getContent());
			int result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {					
				e.printStackTrace();
			}
		}
		
	}

	public Struts06Vo listOne(int num) {
		Struts06Vo bean=new Struts06Vo();
		String sql="select * from struts06 where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setSub(rs.getString("sub"));
				bean.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
		}
		return bean;
	}

	
}
