package com.innoppl;

import java.awt.Button;

// Lines commited for Git Session

//import org.zkoss.zk.ui.Component;
//import org.zkoss.zk.ui.Executions;
//import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Textbox;

// Added comment for git  test

public class SearchReports extends SelectorComposer<Component>  {

	private static final long serialVersionUID = 1L;
	
	@Wire
	private Button submitButtonVin, submitButtonDate;
	
	@Wire
	private Textbox vinSearch;
	
	@Wire
	private Textbox tagSearch;
	
	@Wire
	private Datebox startDate, endDate;
	
	@Listen("onClick =#submitButtonVin")
	public void submitData(){
		try{
			Session sess = Sessions.getCurrent();
			sess.setAttribute("searchVinVal", vinSearch.getValue());
			System.out.println(sess.getAttribute("searchVinVal"));
			
			Executions.sendRedirect("/reports.zul");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	@Listen("onClick =#submitButtonTag")
	public void submitTagData(){
		try{
			Session sess = Sessions.getCurrent();
			sess.setAttribute("searchTagVal", tagSearch.getValue());
			System.out.println(sess.getAttribute("searchTagVal"));
			
			Executions.sendRedirect("/reports.zul");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Listen("onClick =#submitButtonDate")
	public void submitButtonDate(){
		try{
			
			Session sess = Sessions.getCurrent();
			sess.setAttribute("searchStartDate", startDate.getValue());
			System.out.println(sess.getAttribute("searchStartDate"));
			sess.setAttribute("searchEndDate", endDate.getValue());
			System.out.println(sess.getAttribute("searchEndDate"));
			
			Executions.sendRedirect("/reports.zul");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
