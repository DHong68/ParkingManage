package com.pms.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pms.dto.PmsDto;

public class StatDailyCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PmsDto pms = new PmsDto();
		
		
		return "stat/daily";
	}
	
}
