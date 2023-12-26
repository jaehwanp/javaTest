package com.bit.lms.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.lms.db.conn.LmsOracle;
import com.bit.lms.model.dto.NoticeDto;

//공지사항
public class NoticeDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public NoticeDao() {
		conn=LmsOracle.getConnection();
	}
	public Connection getConnection(){
		return this.conn;
	}
	


	//목록불러오기!!
	public ArrayList<NoticeDto> list(String keyword){
		if(keyword==null)keyword="";
		ArrayList<NoticeDto> list=new ArrayList<NoticeDto>();
		String sql="select * from(select rownum as rn,nno,nsub,ncontent,regdate,topstate,adno from(select * from notice where nsub like '%"+keyword+"%' order by topstate desc, nno desc))";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				NoticeDto dto=new NoticeDto();
				dto.setNum(rs.getInt("nno"));
				dto.setSubject(rs.getString("nsub"));
				dto.setContent(rs.getString("ncontent"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setTopstate(rs.getInt("topstate"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
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
	
	
	//상세보기
	public NoticeDto detailOne(int num){
		String sql="select * from notice where nno=?";
		NoticeDto dto=new NoticeDto();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				dto.setNum(rs.getInt("nno"));
				dto.setSubject(rs.getString("nsub"));
				dto.setContent(rs.getString("ncontent"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setTopstate(rs.getInt("topstate"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(conn!=null){conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return dto;
		
	}
	
	//추가 (nextval로 num, sysdate로 regdate)
	public void addList(String subject, String content, int topstate){
		String sql="insert into notice (nno,nsub,ncontent,topstate,regdate,adno) values (notice_seq.nextval,?,?,?,sysdate,2)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, topstate);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null){pstmt.close();}
				if(conn!=null){conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
	}
	
	//수정
	public void editOne(int num, String sub, String content, int topstate){
		String sql ="update notice set nsub=?,ncontent=?,topstate=? where nno=?";
	
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, sub);
				pstmt.setString(2, content);
				pstmt.setInt(3, topstate);
				pstmt.setInt(4, num);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	//삭제
	public void deleteOne(int num){
		String sql="delete from notice where nno=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	
	
}
