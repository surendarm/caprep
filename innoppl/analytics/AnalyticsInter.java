package com.innoppl.analytics;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;


import com.innoppl.dbconnect.SingleConnect;

public class AnalyticsInter extends SelectorComposer<Component> {

	private static final long serialVersionUID = 1L;

	private SingleConnect singleConnect = new SingleConnect();

	private Integer userID = 0;

	public AnalyticsInter(){
		String formName = "";
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		sess.setAttribute("analyticsSearchStartDate", null);
		sess.setAttribute("analyticsSearchEndDate", null);
		if(this.getUserID() == null){
			Executions.sendRedirect("/welcome_user.zul");
		}else{
			Connection conn = null;
			conn = singleConnect.connectToDatabaseOrDie();
			try{
				Statement st = conn.createStatement();
				ResultSet rs;
				rs = st.executeQuery("select form_name from user_active_form where user_id = "+ this.getUserID());
				while(rs.next()){
					formName = rs.getString("form_name");
				}
				System.out.println(formName);
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
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

}
