package com.service;

import org.springframework.stereotype.Service;

import com.model.Ticket;;
@Service
public class TicketService {
	
	
	public double calculateTotalCost(Ticket ticket)
	{
		if(ticket.getCircleType().equals("Queen"))
		{
			return 250*ticket.getNoOfTickets();
		}
		else
		{
		return 150*ticket.getNoOfTickets();	
		}
		
	}

}
	 	  	    	    	     	      	 	
















