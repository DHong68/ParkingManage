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
