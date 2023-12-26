package com.bit.lms.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit.lms.db.conn.LmsOracle;
import com.bit.lms.model.dto.AdminDto;
import com.bit.lms.model.dto.UserDto;

//사용자
public class UserDao {
	
	private Connection 			conn;
	private PreparedStatement 	pstmt;
	private ResultSet			rs;
	
	public UserDao() {
		conn=LmsOracle.getConnection();
	}
	public Connection getConnection(){
		return this.conn;
	}
	
	//수강생 회원가입
	public int joinUs(UserDto user){
		String sql="insert into users (userno,id,name,pw1,pw2,cp,email,sex,regdate,pwa,jpath,pwfno,subno) "
				+ "values (users_seq.nextval,?,?,?,?,?,?,?,sysdate,?,?,?,?)";
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPw1());
			pstmt.setString(4, user.getPw2());
			pstmt.setString(5, user.getCp());
			pstmt.setString(6, user.getEmail());
			pstmt.setInt(7, user.getSex());
			pstmt.setString(8, user.getPwA());//비번 답
			pstmt.setInt(9, user.getJoinPath());//가입경로
			pstmt.setInt(10, user.getPwfno());//비번찾기 질문
			pstmt.setInt(11, user.getSubject());//강좌선택
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null){pstmt.close();}
				if(conn!=null){conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return result;
	}
	
	//강사 회원가입
	public int joinAdmin(AdminDto admin){
		int result = 0;
		String sql="insert into admins (adno,id,name,pw1,pw2,cp,email,sex,confirmno,pwa,pwfno,deptno) values(admins_seq.nextval,?,?,?,?,?,?,?,?,?,?,1)";
		
		try {			
			pstmt=conn.prepareStatement(sql);		
			pstmt.setString(1, admin.getId());				//강사아이디
			pstmt.setString(2, admin.getName());			//강사명
			pstmt.setString(3, admin.getPw1());				//비밀번호1
			pstmt.setString(4, admin.getPw2());				//비밀번호2
			pstmt.setString(5, admin.getHp());				//핸드폰번호
			pstmt.setString(6, admin.getEmail());			//이메일
			pstmt.setInt(7, admin.getSex());				//성별
			pstmt.setString(8, admin.getConfirmNum());		//확인번호
			pstmt.setString(9, admin.getPwA());				//비밀번호찾기 답변
			pstmt.setInt(10, admin.getPwfno());				//비밀번호찾기 질문번호
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null){pstmt.close();}
				if(conn!=null){conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return result;
	}
	
	//아이디 중복확인
	public int confirmId(String id){
		String sql="select id from users where id=?";
		int result=0;

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				result=1;
			}else{
				result=0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	//학생 로그인(로그아웃 session처리)
	public int login(String id, String pw){
		String sql="select * from users where id=? and pw1=?";
		int result=0;

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()){
				result=1;
			}else{
				result=0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				//if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	//user 이름받아옴
	public String loginname(String id){
		String sql="select name from users where id=?";
		String result="";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				result=rs.getString("name");
			}else{
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				//if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	public int loginno(String id){
		String sql="select userno from users where id=?";
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				result=rs.getInt("userno");
			}else{
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	//관리자 로그인(로그아웃 session처리)
	public int adminlogin(String id, String pw){
		String sql="select deptno from admins where id=? and pw1=?";
		int result=0;

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()){
				result=1;
			}else{
				result=0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				//if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	//admin 이름받아옴
		public String loginAdminname(String id){
			String sql="select name from admins where id=?";
			String result="";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				if(rs.next()){
					result=rs.getString("name");
				}else{
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					//if(conn!=null)conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return result;
		}
		//adno 받아옴
		public int loginAdmino(String adno){
			String sql="select adno from admins where id=?";
			int result=0;
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, adno);
				rs=pstmt.executeQuery();
				if(rs.next()){
					result=rs.getInt("adno");
				}else{
				}
			} catch (SQLException e) {
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
			
			return result;
		}
		
		
		//deptno 받아옴
				public int deptNo(String id){
					String sql="select deptno from admins where id=?";
					int result=0;
					try {
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, id);
						rs=pstmt.executeQuery();
						if(rs.next()){
							result=rs.getInt("deptno");
						}else{
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						try {
							if(rs!=null)rs.close();
							if(pstmt!=null)pstmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					return result;
				}
	
	//비밀번호찾기 - id
	public int findPw(String id, int pwq, String pwa){
		String sql="select pw1 from users where id=? and pwfno=? and pwa=?";
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, pwq);
			pstmt.setString(3, pwa);
			rs=pstmt.executeQuery();
			if(rs.next()){
				result=1;
			}else{
				result=0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	//비밀번호찾기
	public int updPw(String pw1, String pw2, String id){
		String sql="update users set pw1=?, pw2=? where id=?";
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pw1);
			pstmt.setString(2, pw2);
			pstmt.setString(3, id);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=0;
		}finally{
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	//회원탈퇴
	public int withDrawal(UserDto user){
		
		return 0;
	}
	
}
