package com.cnten.platform.dwr;

import javax.servlet.ServletException;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;

public class MessagePush
{
    public void onPageLoad() {
        //  ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
        DwrScriptSessionManagerUtil dwrScriptSessionManagerUtil = new DwrScriptSessionManagerUtil();
        try {
           dwrScriptSessionManagerUtil.init();
        } catch (ServletException e) {
               e.printStackTrace();
        }

    }
}