package com.bit.lms.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.lms.db.conn.LmsOracle;
import com.bit.lms.model.dto.AttendDto;

public class AttendDao {

	//출결관리목록
	public ArrayList<AttendDto> attendList(String month){
		ArrayList<AttendDto> list=new ArrayList<AttendDto>();
		//원하는 월 값을 받아 출력
		String sql="select A.userno,B.name,A.state,(select to_char(A.attdate,'MM-DD') from dual) as attdate from attend A,users B,subject C"
				+ " where A.userno=B.userno and C.classno=B.classno and A.attdate between to_date(?,'MM') and to_date(?,'MM')";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		System.out.println("ㅇㅋㅇㅋ1234");
		try {
			conn=LmsOracle.getConnection();
			System.out.println("ㅇㅋ1");
			pstmt=conn.prepareStatement(sql);
			System.out.println("ㅇㅋ2");
			pstmt.setString(1, month);
			System.out.println("ㅇㅋ3");
			pstmt.setString(2, month);
			System.out.println("ㅇㅋ4");
			rs=pstmt.executeQuery();
			System.out.println("ㅇㅋㅇㅋ123");
			while(rs.next()){
				AttendDto dto=new AttendDto();
				dto.setNum(rs.getInt("userno"));
				System.out.println("ㅇㅋㅇㅋ1"+dto.getNum());
				dto.setName(rs.getString("name"));
				System.out.println("ㅇㅋㅇㅋ2");
				dto.setState(rs.getInt("state"));
				System.out.println("ㅇㅋㅇㅋ3");
				dto.setAttDate(rs.getDate("attdate"));
				System.out.println("ㅇㅋㅇㅋ4");
				list.add(dto);
				System.out.println("zz:"+rs.getDate("attdate"));
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
	
	//출결입력
	public int attendInsert(){
		
		return 0;
	}
	
	//출결수정
	public int attendUpdate(){
		
		return 0;
	}
	
}
