package maijiayunTips.Dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Repository;

import maijiayunTips.Dao.UserDao;
import maijiayunTips.Dao.model.User;
@Repository
public class UserDaoImpl implements UserDao {
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<User> select(int id) {
		String sql="select *from user where id=?";		
		List<User> list=jdbcTemplate.query(sql,new Object[]{id}, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setRemarks(rs.getString("remarks"));
				u.setStatus(rs.getString("status"));
				u.setCreateDate(javaDate(rs.getTimestamp("create_date")));
				System.out.println(u.getCreateDate());
				u.setEndDate(javaDate(rs.getTimestamp("end_date")));
				System.out.println(u.getCreateDate());
				u.setVip(rs.getInt("vip"));
				return u;
			}
		});
		return list;
	}

	@Override
	public List<User> select(String name) {
		String sql="select * from user where name=?";
		List<User> list=jdbcTemplate.query(sql,new Object[]{name}, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setRemarks(rs.getString("remarks"));
				u.setStatus(rs.getString("status"));
				u.setCreateDate(javaDate(rs.getTimestamp("create_date")));
				System.out.println(u.getCreateDate());
				u.setEndDate(javaDate(rs.getTimestamp("end_date")));
				System.out.println(u.getCreateDate());
				u.setVip(rs.getInt("vip"));
				return u;
			}
		});		
		return list;
	}

	@Override
	public List<User> select(Date date) {
		String sql="select * from user where date=?";
		List<User> list=jdbcTemplate.query(sql,new Object[]{date},new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setRemarks(rs.getString("remarks"));
				u.setStatus(rs.getString("status"));
				u.setCreateDate(javaDate(rs.getTimestamp("create_date")));
				System.out.println(u.getCreateDate());
				u.setEndDate(javaDate(rs.getTimestamp("end_date")));
				System.out.println(u.getCreateDate());
				u.setVip(rs.getInt("vip"));
				return u;
			}
		});
		return list;
	}

	@Override
	public List<User> selectByVip(int id) {
		String sql="select * from user where id=?";
		List<User> list=jdbcTemplate.query(sql,new Object[]{id}, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setRemarks(rs.getString("remarks"));
				u.setStatus(rs.getString("status"));
				u.setCreateDate(javaDate(rs.getTimestamp("create_date")));
				System.out.println(u.getCreateDate());
				u.setEndDate(javaDate(rs.getTimestamp("end_date")));
				System.out.println(u.getCreateDate());
				u.setVip(rs.getInt("vip"));
				return u;
			}
		});	
		return list;
	}

	@Override
	public void insert(User u) {
		String sql="insert into user(id,name,remarks,status,create_date,end_date,vip) values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{u.getId(),u.getName(),u.getRemarks(),u.getStatus(),sqlDate(u.getCreateDate()),sqlDate(u.getEndDate()),u.getVip()});
	}

	@Override
	public void delete(User u) {
		String sql="delete * from user where id=?";
		jdbcTemplate.update(sql,new Object[]{u.getId()});
	}

	@Override
	public void modify(User u) {
		String sql="update user set vip=? where id=?";
		jdbcTemplate.update(sql,new Object[]{u.getVip(),u.getId()});

	}

	
	@Override
	public List<User> select() {
		return jdbcTemplate.query("select*from user",new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setRemarks(rs.getString("remarks"));
				u.setStatus(rs.getString("status"));
				u.setCreateDate(javaDate(rs.getTimestamp("create_date")));
				System.out.println(u.getCreateDate());
				u.setEndDate(javaDate(rs.getTimestamp("end_date")));
				System.out.println(u.getCreateDate());
				u.setVip(rs.getInt("vip"));
				return u;
			}
			
		});
	}
	public static Date javaDate(java.sql.Timestamp date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = null;
		Date date2=null;
		try {
			date1 =sdf.format(date);
			date2=sdf.parse(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date2;	
	}
	public static java.sql.Timestamp sqlDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = null;
		java.sql.Timestamp date2=null;
		try {
			date1 =sdf.format(date);
			date2=(Timestamp) sdf.parse(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date2;	
	}
}
