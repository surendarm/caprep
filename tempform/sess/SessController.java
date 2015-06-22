package com.tempform.sess;

import java.awt.Button;
import java.util.Iterator;
import java.util.Map;


import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Textbox;

public class SessController   extends SelectorComposer<Component>  {
	
	private static final long serialVersionUID = 1L;
	
	public SessController(){
		
		System.out.println("Hi");
		Session sess = Sessions.getCurrent();
		//sess.setAttribute("assist_user_id", 50634);
		Map<String, Object> allAttributes = sess.getAttributes();
		Iterator iterator = allAttributes.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			System.out.println("The key is: " + mapEntry.getKey()
				+ ",value is :" + mapEntry.getValue());
		}
		
	}
	

	@Wire
	private Button submitButton;
	
	@Wire
	private Textbox item1;
	
	@Listen("onChange = #item1")
	public void changeTitle(){
			String title = item1.getValue();
			Session sess = Sessions.getCurrent();
			System.out.println("TextBox action trigerred");
			System.out.println("session Info: "+ sess.getAttributes());
			System.out.println("session Info: "+ sess.getNativeSession());
			
			showNotify("Changed to: " + title, item1);
	}
	
	@Listen("onClick =#submitButton")
	public void submitData(){
		Executions.sendRedirect("/samp_form.zul");
		
	}
	
	private void showNotify(String msg, Component ref){
		//Clients.showNotification(msg, "info", ref, "end_center", 2000);
		Clients.showNotification(msg);
	}

	@Init // @Init annotates a initial method
    public void init(){
       System.out.println("TEST FROM INIT");
    }
	
}
