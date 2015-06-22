package com.innoppl.analytics;

import java.awt.Button;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Datebox;


import com.innoppl.dbconnect.SingleConnect;

public class AnalyticsSearchReports  extends SelectorComposer<Component>  {

	private static final long serialVersionUID = 1L;

	@Wire
	private Button submitButtonDate;
	
	@Wire
	private Datebox startDate, endDate;

	
	private SingleConnect singleConnect = new SingleConnect();

	private Integer userID = 0;

	
	@Listen("onClick =#submitButtonDate")
	public void submitButtonDate(){
		String formName = "";
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		sess.setAttribute("analyticsSearchStartDate", startDate.getValue());
		sess.setAttribute("analyticsSearchEndDate", endDate.getValue());
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		try{
			Statement st = conn.createStatement();
			ResultSet rs;
			rs = st.executeQuery("select form_name from user_active_form where user_id = "+ this.getUserID());
			while(rs.next()){
				formName = rs.getString("form_name");
			}

			
			if(formName.equals("101 form") || formName.equals("101 Form")){
				Executions.sendRedirect("/AnalyticsOne.zul");
			}else if(formName.equals("102 form") || formName.equals("102 Form")){
				Executions.sendRedirect("/AnalyticsTwo.zul");
			}else if(formName.equals("103 form") || formName.equals("103 Form")){
				Executions.sendRedirect("/AnalyticsThree.zul");
			}else if(formName.equals("104 form") || formName.equals("104 Form")){
				Executions.sendRedirect("/AnalyticsFour.zul");
			}else{
				Executions.sendRedirect("/SelectForm.zul");
			}
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public Integer getUserID() {
		return userID;
	}


	public void setUserID(Integer userID) {
		this.userID = userID;
	}

}
