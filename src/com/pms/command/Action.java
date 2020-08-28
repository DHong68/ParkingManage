package com.pms.command;

import java.util.HashMap;
import java.util.Map;

public class Action {
	private static Action instance = new Action();
	
	public static Action getInstance() {
		return instance;
	}

	private HashMap<String, Command> map = new HashMap<String, Command>();
	
	private Action() {
		// ������ �߰��� ���� �߰��ٶ�
		map.put("/daily", new StatDailyCommand());
		map.put("/empty", new EmptyCommand());
      	map.put("/loglist",new LogListCommand());		
      	map.put("/stat/test",new TestCommand());	
      	map.put("/loglist",new LogListCommand());
      	map.put("/imgupdate",new LoglmgModifyAction());
      	map.put("/index",new IndexCommand());
      	map.put("/detail",new LogDetailCommand());
      	map.put("/member",new MemberManageCommand());
      	map.put("/memberInsert",new MemberInsertCommand());
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
