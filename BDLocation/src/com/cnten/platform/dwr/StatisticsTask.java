package com.cnten.platform.dwr;

import java.util.TimerTask;

import javax.servlet.ServletContext;

public class StatisticsTask extends TimerTask{
	public StatisticsTask(ServletContext context){
		
    }
	
	@Override
	public void run() {
		System.out.println("-----------运行中-----------");
        Entity entity = new Entity();
		entity.setEntityId("234324dfsdfs");
		entity.setEntityName("测试姓名");
		try {
			DwrPushMessager.invokeJavascriptFunction("showMessage",entity);
		} catch (Exception e) {}
        
	}

}
