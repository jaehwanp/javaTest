package com.bit.lms.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.lms.db.conn.LmsOracle;
import com.bit.lms.model.dto.SubjectDto;

public class SubjectDao {
/*
 * 	private int 		num;			// 강좌번호
	private String		name;			// 강좌명
	private String		content;		// 강좌설명
	private int			limitNum;		// 강좌제한인원
	private String		limitEnd;		// 수강마감일
	private String		eduStart;		// 개강일자
	private String		eduEnd;			// 종강일자
	private Date		regdate;		// 강좌작성일자
	private int			classNum;		// 반번호
	private String		className;		// 반명
 */
	private Connection 			conn;
	private PreparedStatement 	pstmt;
	private ResultSet			rs;
	
	public SubjectDao() {
		conn = LmsOracle.getConnection();
	}
	
	public Connection getConnection(){
		return this.conn;
	}
	
	//강좌목록
	public ArrayList<SubjectDto> subjectList(){
		ArrayList<SubjectDto> list=new ArrayList<SubjectDto>();
		String sql = "select a.subno as num, a.subnm as subname, a.limitno as limitNum, a.limitEnd as limitEnd, b.name "
				+ "from subject a, admins b where a.adno=b.adno order by a.subno desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SubjectDto bean = new SubjectDto();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("subname"));
				bean.setAdminName(rs.getString("name"));
				bean.setLimitNum(rs.getInt("limitNum"));
				bean.setLimitEnd(rs.getString("limitEnd"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(conn!=null){conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}

		return list;
	}
	
	//강좌 추가
	public void subjectAdd(String name, String content, int limitNum, String limitEnd, String eduStart, String eduEnd){
		String sql="INSERT INTO SUBJECT VALUES (?,SUBJECT_SEQ.NEXTVAL,?,?,?,?,?, SYSDATE, 1,'aa반',1)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=LmsOracle.getConnection();			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, content);
			pstmt.setInt(3, limitNum);
			pstmt.setString(4, limitEnd);
			pstmt.setString(5, eduStart);
			pstmt.setString(6, eduEnd);
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	//강좌 수정
	public void subjectEdit(String name, String content, int limitNum, String limitEnd, String eduStart, String eduEnd, Date regdate) {
		
	}
	//강좌 삭제
	public void subjectDelete(int num) {
		String sql="delete from subject where subno=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=LmsOracle.getConnection();			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	//강좌 상세
	public SubjectDto subjectDetail(int num){
		String sql="select a.subno as num, a.subnm as subname, a.limitno as limitNum, a.limitEnd as limitEnd, a.subcontent as content, b.name from subject a, admins b where a.adno=b.adno and a.subno=?";
		SubjectDto bean = new SubjectDto();
		
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("subname"));
				bean.setContent(rs.getString("content"));
				bean.setLimitEnd(rs.getString("limitEnd"));
				bean.setAdminName(rs.getString("name"));
				bean.setLimitNum(rs.getInt("limitNum"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
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
