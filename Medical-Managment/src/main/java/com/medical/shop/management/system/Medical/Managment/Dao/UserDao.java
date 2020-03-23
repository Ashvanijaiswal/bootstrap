package com.medical.shop.management.system.Medical.Managment.Dao;



import org.springframework.stereotype.Component;

import com.medical.shop.management.system.Medical.Managment.Model.User;


@Component
public interface UserDao {
	
	public boolean addUser(User user);
	
	public boolean userExist(String user_id);
	
	public User checkUser(String user_id, String password); 
	
	public User getUserByEmailId(String email_id);
	
	public User getUserByContact(String contact_number);
}
