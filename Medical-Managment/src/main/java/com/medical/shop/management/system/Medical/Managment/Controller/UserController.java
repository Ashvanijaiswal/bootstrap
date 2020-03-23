package com.medical.shop.management.system.Medical.Managment.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.medical.mail.server.SimpleMailManager;
import com.medical.shop.management.system.Medical.Managment.Dao.UserDaoImpl;
import com.medical.shop.management.system.Medical.Managment.Model.User;
import com.medical.sms.getway.SMSManager;

@Controller
@SessionAttributes("admin")
public class UserController {
	@Autowired
	UserDaoImpl userDaoImpl;
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String userRegistrationDisplay(@ModelAttribute("user") User user) {
		return "Registration_page";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String userRegistration(@ModelAttribute("user") @Valid User user, BindingResult result, ModelMap model) {
		// System.out.println(userDaoImpl.userExist(user.getUser_id()));
		if (result.hasErrors()) {
			return "Registration_page";
		}
		if (userDaoImpl.addUser(user)) {
			model.put("status", "Registeration done Successfully");
		} else {
			model.put("status", "User Id is already used");
		}
		System.out.println();
		return "Registration_page";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String userLoginDisplay(@ModelAttribute("user") User user) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute("user") User user, ModelMap model) {
		if (user.getUser_id().isEmpty()) {
			model.put("userIdError", "User Id is mandatory");
		}
		if (user.getPassword().isEmpty()) {
			model.put("passwordError", "Password is mandatory");
		}
		User admin = userDaoImpl.checkUser(user.getUser_id(), user.getPassword());
		if (admin == null) {
			model.put("error", "Wrong Credentials");
			return "login";
		} else {
			model.put("error", "Login Success");
			model.put("admin", admin);
		}
		return "login";
	}
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String forgetPassword(@ModelAttribute("user") User user) {
		return "forgotPassword";
	}
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public String sendEmailOrMsg(@ModelAttribute("user") User user,ModelMap model) {
      System.out.println(user.getContact_number());
       if(user.getContact_number().equals("")) {
    	   SimpleMailManager mail=new SimpleMailManager();  
		user=userDaoImpl.getUserByEmailId(user.getEmail_id());
		System.out.println(user);
		if(mail.sendMessage(user)){
			model.put("msg","your email id and password has succesfully sent to your email address");
		}
		else{
			model.put("msg","server Error!\n try after some time1");
		}
       }
       else 
       {   SMSManager sms=new SMSManager();
    	   user=userDaoImpl.getUserByContact(user.getContact_number());
    	   if(sms.sendSMS(user))
    	   {
    		   model.put("msg","your contact and password has succesfully sent to your mobile number");
    	   }
    	   else
    	   {
    		   model.put("msg","server Error!\n try after some time");
    	   }
       }
		return "forgotPassword";
	}
}
