package com.tempform.input;

import java.util.Iterator;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;

import com.innoppl.config.Configuration;
import com.tempform.WelcomeNewUserInventory;

public class WelcomeNewUserController  extends SelectorComposer<Component>  {
	
	private static final long serialVersionUID = 1L;
	
	private String sessID ="";
	
	private WelcomeNewUserInventory welcomeNewUserInventory;
	
	public WelcomeNewUserController(){
		Session sess = Sessions.getCurrent();
		
		sess.setAttribute("userid", "119109"); //119109 -149565  - 113948 - 101895 - 149565 - 1321935 - 2047271100 - 204747 - 204727 - 1321938 - 11910900 - 1321938008
		sess.setAttribute("fname", "Adam");
		sess.setAttribute("lname", "Potter");
		
		Map<String, Object> allAttributes = sess.getAttributes();
		Iterator iterator = allAttributes.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			System.out.println("The key is: " + mapEntry.getKey()
				+ ",value is :" + mapEntry.getValue());
		}
		
		this.setSessID((String) sess.getAttribute("userid"));
		if(this.getSessID() == null){
			Executions.sendRedirect(Configuration.APPLICATION_URL+"/test.jsp");
		}else{
			int sessionUserID = Integer.parseInt(this.getSessID());
			welcomeNewUserInventory = new WelcomeNewUserInventory(sessionUserID);
			Executions.sendRedirect("/SelectForm.zul");
		}
		
	}
	
	public WelcomeNewUserInventory getWelcomeNewUserInventory() {
        return welcomeNewUserInventory;
    }
	
	public String getSessID() {
		return sessID;
	}

	public void setSessID(String sessID) {
		this.sessID = sessID;
	}
}
