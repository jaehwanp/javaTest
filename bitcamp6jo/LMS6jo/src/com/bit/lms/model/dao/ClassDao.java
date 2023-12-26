package com.bit.lms.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.lms.db.conn.LmsOracle;
import com.bit.lms.model.dto.UserDto;

public class ClassDao {
	
	//반 매칭 왼쪽테이블 불러오기 (반 없는애들 불러옴)
	public ArrayList<UserDto> noClassList(){		
		
		ArrayList<UserDto> list= new ArrayList<UserDto>();
		
		String sql="SELECT * FROM USERS WHERE CLASSNO IS NULL OR CLASSNO=0";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=LmsOracle.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				UserDto udt=new UserDto();
				udt.setNum(rs.getInt("userno"));
				udt.setName(rs.getString("name"));
				udt.setSubject(rs.getInt("subno"));
				list.add(udt);
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
	
	//반 매칭 오른쪽테이블 불러오기 (각 반마다 불러와야함)
	public ArrayList<UserDto> yesClass(int num){
		ArrayList<UserDto> list=new ArrayList<UserDto>();


		String sql="SELECT * FROM USERS WHERE CLASSNO=?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=LmsOracle.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				UserDto udt=new UserDto();
				udt.setNum(rs.getInt("userno"));
				udt.setName(rs.getString("name"));
				udt.setSubject(rs.getInt("subno"));
				list.add(udt);
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
	
	//반없는애들 반 배정해주기 (왼쪽에서 오른쪽으로)
	public void giveClass(int classno, int userno){
		String sql="update users set classno=? where userno=?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=LmsOracle.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, classno);
			pstmt.setInt(2, userno);
			pstmt.executeUpdate();

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
	
	
	//반있는애들 반없애기 (오른쪽에서 왼쪽으로)
	public void deleteClass(int userno){
		String sql="update users set classno=0 where userno=?";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=LmsOracle.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userno);
			pstmt.executeUpdate();

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

	//userdto에서 반 추가하고 subject에서 반 빼야할듯...
}
