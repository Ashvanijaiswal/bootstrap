package com.controller;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Ticket;
import com.service.TicketService;
@Controller
public class TicketController {
	@Autowired
	private TicketService Service;
	@RequestMapping(value="/showpage",method=RequestMethod.GET)
	public String showPage(@ModelAttribute("ticket") Ticket ticket)
	{
		return "/showpage";
	}
	@RequestMapping(value="/calculateCost", method=RequestMethod.POST)
	public String calculateTotalCost(@ModelAttribute("ticket") @Valid Ticket ticket,ModelMap model,BindingResult result) {
		if(result.hasErrors())
		{
			return "/showpage";
		}
		double totalCost=Service.calculateTotalCost(ticket);
		model.put("cost", totalCost);
		return "redirect:result";
	}
	@ModelAttribute("circleList")
	public Map<String,String> builtState()
	{
		Map<String,String> model=new HashMap<>();
		model.put("Queen", "Queen");
		model.put("king", "king");
		return model;
	}



}
