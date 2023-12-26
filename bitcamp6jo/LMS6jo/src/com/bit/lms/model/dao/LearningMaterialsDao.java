package com.bit.lms.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.lms.db.conn.LmsOracle;
import com.bit.lms.model.dto.LearningMaterialsDto;


public class LearningMaterialsDao {
	
	private Connection 			conn;
	private PreparedStatement 	pstmt;
	private ResultSet			rs;
	
	public LearningMaterialsDao() {
		conn = LmsOracle.getConnection();
	}
	
	public Connection getConnection(){
		return this.conn;
	}
	
	//학습자료목록(로그인한 강사가 자기가 작성한 글은 볼 수 있으나 자신의 반학생들이 볼만한 키값이 없음 - 키값 필요 admins에서 classno를 추가하여 
	//users테이블과 조인하여 admins의 classno와 users의 classno와 같을 때 보여주게 한다. 만약 모든 강사의 학습자료라면 상관없음!)
	public ArrayList<LearningMaterialsDto> list(){
		ArrayList<LearningMaterialsDto> list=new ArrayList<LearningMaterialsDto>();
		String sql = "select a.lmno as lmno, a.lmnm as lmnm, b.name as name, a.regdate as regdate, a.filenm as filenm, a.filepath as filepath "
				+ "from learningmaterials a, admins b where a.adno=b.adno and b.deptno=1 order by lmno desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				LearningMaterialsDto bean = new LearningMaterialsDto();
				bean.setNum(rs.getInt("lmno"));
				bean.setName(rs.getString("lmnm"));
				bean.setAname(rs.getString("name"));
				bean.setRegdate(rs.getDate("regdate"));
				bean.setFileName(rs.getString("filenm"));
				bean.setFilePath(rs.getString("filepath"));
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
	
	//세션의 관리자아이디를 통해서 관리자번호를 가지고 온다.
	public int getAdno(String aId){
		String sql = "select adno from admins where id=?";
		int adno = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				adno = rs.getInt("adno");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}		
		
		return adno;
	}
	
	//추가 (nextval로 num, sysdate로 regdate) 
	public int addList(String lmnm, String fileName, String filePath, int adno){
		int result = 0;
		String sql = "insert into LearningMaterials(lmno, lmnm, regdate, filenm, filepath, adno) "
				+ "values(LearningMaterials_seq.nextval, ?,sysdate,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lmnm);
			pstmt.setString(2, fileName);
			pstmt.setString(3, filePath);
			pstmt.setInt(4, adno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {				
				if(pstmt!=null){pstmt.close();}
				if(conn!=null){conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}		
		
		return result;
	}
	
	//수정
	public void editOne(int num, String name){
		
	}
	
	//삭제 1
	public void deleteOne(int num){   
		
	}
	
	/*	private int 	num;		//학습자료번호
	private String 	name;		//학습자료이름
	private Date	regdate;	//학습자료등록일자
	private String	fileName;	//파일명
	private String 	filePath;	//파일경로*/
}
