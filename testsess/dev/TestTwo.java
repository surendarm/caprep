package com.testsess.dev;

import java.util.Iterator;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;

public class TestTwo extends SelectorComposer<Component>  {

	private static final long serialVersionUID = 1L;


	public TestTwo(){
		System.out.println("--------------- TEST TWO ---------------");
		Session sess = Sessions.getCurrent();
		System.out.println("session getAttributes Info: "+ sess.getAttributes());
		System.out.println("First Call UserName Info: "+ sess.getAttribute("username"));
		System.out.println("First Call UserName Info: "+ sess.getAttribute("userid"));
		//sess.setAttribute("innoppluser", "surendar");
		Map<String, Object> allAttributes = sess.getAttributes();
		Iterator iterator = allAttributes.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			System.out.println("The key is: " + mapEntry.getKey()
				+ ",value is :" + mapEntry.getValue());
		}
	}
}
