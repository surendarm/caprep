package com.testsess.dev;

import java.awt.Button;
import java.util.Iterator;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class TestSessionController   extends SelectorComposer<Component>  {

	private static final long serialVersionUID = 1L;

	@Wire
	private Window win;
	
	@Wire
	private Button submitButton;
	
	@Wire
	private Textbox item1;
	
	public TestSessionController(){
		Session sess = Sessions.getCurrent();
		System.out.println("session getAttributes Info: "+ sess.getAttributes());
		System.out.println("First Call UserName Info: "+ sess.getAttribute("username"));
		System.out.println("First Call UserName Info: "+ sess.getAttribute("userid"));
		sess.setAttribute("innoppluser", "surendar");
		Map<String, Object> allAttributes = sess.getAttributes();
		Iterator iterator = allAttributes.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			System.out.println("The key is: " + mapEntry.getKey()
				+ ",value is :" + mapEntry.getValue());
		}
	}
	
	@Listen("onChange = #item1")
	public void changeTitle(){
			String title = item1.getValue();
			Session sess = Sessions.getCurrent();
			System.out.println("TextBox action trigerred");
			System.out.println("session getAttributes Info: "+ sess.getAttributes());
			System.out.println("session getNativeSession Info: "+ sess.getNativeSession());
			
			showNotify("Changed to: " + sess.getAttribute("username") + "" + title, item1);
	}
	
	@Listen("onClick =#submitButton")
	public void submitData(){
		
		Session sess = Sessions.getCurrent();
		System.out.println("Submit Button action trigerred");
		System.out.println("session getAttributes Info: "+ sess.getAttributes());
		System.out.println("UserName Info: "+ sess.getAttribute("username"));
		System.out.println("UserName Info: "+ sess.getAttribute("userid"));
		System.out.println("session getNativeSession Info: "+ sess.getNativeSession());
		
		showNotify("Session: " + sess.getAttribute("userid"), win);
		
	}
	
	private void showNotify(String msg, Component ref){
		Clients.showNotification(msg, "info", ref, "end_center", 2000);
	}
}
