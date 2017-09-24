package com.cnten.platform.dwr;

import java.util.Collection;
import java.util.Date;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;

import com.alibaba.fastjson.JSON;

public class DwrPushMessager {
	/**
     * 调用页面javascript函数
     * @param functionName
     * @param args
     */
    public static void invokeJavascriptFunction (String funcName, Object message){
    	final String _funcName = funcName;
    	final Object autoMessage = JSON.toJSONString(message);
    	Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
			@Override
			public boolean match(ScriptSession arg0) {
				return true;
			}
		}, new Runnable() {
			private ScriptBuffer script = new ScriptBuffer();
			@Override
			public void run() {
				script.appendCall(_funcName, autoMessage, new Date());
				Collection<ScriptSession> sessions = Browser.getTargetSessions(); 
				for(ScriptSession scriptSession : sessions){ 
					scriptSession.addScript(script); 
	            } 
			}
		});
    	 
    }
}
