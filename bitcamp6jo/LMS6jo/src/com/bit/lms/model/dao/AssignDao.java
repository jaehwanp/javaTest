package com.bit.lms.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.lms.db.conn.LmsOracle;
import com.bit.lms.model.dto.AssignDto;

/*
    //과제관리
	private int 	num;		// 과제번호
	private String	name;		// 과제제목
	private String	content;	// 과제내용
	private Date	regdate;	// 과제등록일자
	private String	fileName;	// 파일명
	private String	firlPath;	// 파일경로
	
	//사용자
	private UserDto user;		// 사용자번호(user.num)
*/


public class AssignDao {
	
	private Connection 			conn;
	private PreparedStatement 	pstmt;
	private ResultSet			rs;
	
	public AssignDao() {
		conn = LmsOracle.getConnection();
	}
	
	public Connection getConnection(){
		return this.conn;
	}
	
	//과제목록 - 강사
	public ArrayList<AssignDto> assignList(){
		ArrayList<AssignDto> list = new ArrayList<AssignDto>();
		//학생은 반번호가 있고 강사는 강좌번호와 자신의 반번호와 자신의 강좌번호를 갖는다. (현재는 임시 테스트용 쿼리) 
		String sql = "select A.assno as assno, A.assnm as assnm, A.asscontent as asscontent, "
				+ "A.regdate as regdate, A.filenm as filenm, A.filepath as filepath, B.name as uname from assign A, users B where A.userno=B.userno";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				AssignDto bean = new AssignDto();
				bean.setNum(rs.getInt("assno"));				//과제번호
				bean.setName(rs.getString("assnm"));			//과제명
				bean.setContent(rs.getString("asscontent"));	//과제내용
				bean.setRegdate(rs.getDate("regdate"));			//과제등록일자
				bean.setFileName(rs.getString("fileNm"));		//파일명
				bean.setFilePath(rs.getString("filePath"));		//파일경로
				bean.setUname(rs.getString("uname"));			//수강생이름
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
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
	
	//과제상세목록 - 강사
	public AssignDto assignDetail(int num){
		AssignDto bean = new AssignDto();
		String sql = "SELECT A.ASSNO AS ASSNO, (SELECT B.NAME FROM USERS B WHERE B.userno=A.userno and A.assno=?) AS NAME, "
				+ "A.ASSNM AS ASSNM, A.REGDATE AS REGDATE, A.ASSCONTENT AS ASSCONTENT, A.FILENM AS FILENM, A.FILEPATH AS FILEPATH "
				+ "FROM ASSIGN A WHERE A.ASSNO=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean.setNum(rs.getInt("assno"));
				bean.setUname(rs.getString("name"));
				bean.setName(rs.getString("assnm"));
				bean.setContent(rs.getString("asscontent"));
				bean.setRegdate(rs.getDate("regdate"));
				bean.setFileName(rs.getString("filenm"));
				bean.setFilePath(rs.getString("filepath"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	//파일명가져오기
	public String getFileName(int num){
		AssignDto bean = new AssignDto();
		String sql = "SELECT A.FILENM FROM ASSIGN A WHERE A.ASSNO=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean.setFileName(rs.getString("filenm"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bean.getFileName();
	}
	
	//과제등록 - 수강생
	public int assignInsert(){
		
		return 0;
	}
	
	//과제수정 - 수강생
	public int assignUpdate(){
		
		return 0;
	}
	
	//과제삭제 - 수강생
	public int assignDel(){
		
		return 0;
	}
}
