package com.medical.shop.management.system.Medical.Managment.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medical.shop.management.system.Medical.Managment.Model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet resultSet, int arg1) throws SQLException {
		User user = new User();
		user.setUser_id(resultSet.getString(1));
		user.setUser_name(resultSet.getString(2));
		user.setPassword(resultSet.getString(3));
		user.setEmail_id(resultSet.getString(4));
		user.setContact_number(resultSet.getString(5));
		return user;
	}

}
