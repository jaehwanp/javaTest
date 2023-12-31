package com.bit.day03.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.bit.day03.model.entity.Day02Vo;

public class Day02Dao1 extends JdbcDaoSupport implements Day02Dao {
	
	public List<Day02Vo> selectAll() throws SQLException{
		String sql="SELECT * FROM DAY02 ORDER BY NUM DESC";
		return getJdbcTemplate().query(sql, new RowMapper<Day02Vo>() {

			@Override
			public Day02Vo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Day02Vo(
						rs.getInt("num")
						,rs.getString("name")
						,rs.getString("sub")
						,rs.getString("content")
						,rs.getDate("nalja")
						);
			}
			
		});
	}

	@Override
	public void insertOne(Day02Vo day02Vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Day02Vo selectOne(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateOne(Day02Vo bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int num) {
		// TODO Auto-generated method stub
		return 0;
	}
}














