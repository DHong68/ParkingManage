package com.pms.command;

import java.util.HashMap;
import java.util.Map;

public class Action {
	private static Action instance = new Action();
	
	public static Action getInstance() {
		return instance;
	}

	private HashMap<String, Command> map = new HashMap<String, Command>();
	
	public Action() {
		// ������ �߰��� ���� �߰��ٶ�
		map.put("/stat/daily", new StatDailyCommand());
		map.put("/empty", new EmptyCommand());
      	map.put("/loglist",new LogListCommand());
      	map.put("/coupon/new_cp_dc",new CDCommand());
      	map.put("/coupon/addc_d",new AddC_DCommand());
      	map.put("/coupon/search_cp_dc",new CDCommand2());  	
      	map.put("/coupon/search_C_D",new Search_C_DCommand());  	
	}
	
	public Command getAction(String command) {
		Command action = null;
		action = map.get(command);
		if(action == null) {
			action = map.get("/empty");
		}
		return action;
	}
	
}
