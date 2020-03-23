package com.medical.shop.management.system.Medical.Managment.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.medical.shop.management.system.Medical.Managment.Model.User;
import com.medical.shop.management.system.Medical.Managment.RowMapper.UserRowMapper;

@Component("userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean addUser(User user) {
		String sql = "insert into user values(?,?,?,?,?)";
		try {
			jdbcTemplate.update(sql, user.getUser_id(), user.getUser_name(),user.getPassword(), user.getEmail_id(),
					user.getContact_number());
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean userExist(String user_id) {
		String sql = "select * from user where user_id = ?";
		UserRowMapper userRowMapper = new UserRowMapper();
		try {
			jdbcTemplate.queryForObject(sql, userRowMapper, user_id);
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
		return true;
	}

	@Override
	public User checkUser(String user_id, String password) {
		String sql = "select * from user where user_id = ? AND password = ?";
		UserRowMapper userRowMapper = new UserRowMapper();
		User user = new User();
		try {
			user = jdbcTemplate.queryForObject(sql, userRowMapper, user_id , password);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return user;
	}

	@Override
	public User getUserByEmailId(String email_id) {
		// TODO Auto-generated method stub
		User user=new User();
		String sql="select * from user where email_id=?";
		try{
			user=jdbcTemplate.queryForObject(sql, new UserRowMapper(),email_id);
			System.out.println(user);
		}
		catch (Exception e) {
			System.out.println(e);
			user=null;
		}
		return user;
	}

	@Override
	public User getUserByContact(String contact) {
		String sql="select * from user where contact_number=?";
		User user=new User();
		try {
			user=jdbcTemplate.queryForObject(sql, new UserRowMapper(),contact);
		//user=(User)jdbcTemplate.queryForObject(sql, new Object[] {contact},new BeanPropertyRowMapper<User>(User.class));
		System.out.println(user);
		
		}
		catch(Exception e)
		{
		System.out.println(e);
			user=null;
		}
		return user;
	}
	
	
}
