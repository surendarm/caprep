package com.innoppl.videolib;

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
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import com.innoppl.dbconnect.SingleConnect;

public class VideoLibList extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	
	private SingleConnect singleConnect = new SingleConnect();
	
	private Integer userID = 0;
	
	ListModel<VideoList> reports;
	

	@Wire
	private Button menuTemplate, menuServices; 
	
	@Listen("onClick =#menuTemplate")
	public void menuSelectFormRedir(){
		try{
			Executions.sendRedirect("/SelectForm.zul");
		}catch(Exception e){
			
		}
	}

	
	@Listen("onClick =#menuAnalytics")
	public void menuAnalyticsRedir(){
		try{
			Executions.sendRedirect("/AnalyticsMain.zul");
		}catch(Exception e){
			
		}
	}
	
	@Listen("onClick =#menuSettings")
	public void menuSettingsRedir(){
		try{
			Executions.sendRedirect("/Settings.zul");
		}catch(Exception e){
			
		}
	}
	
	@Listen("onClick =#menuServices")
	public void menuServicesRedir(){
		try{
			Executions.sendRedirect("/ServiceSelection.zul");
		}catch(Exception e){
			
		}
	}
	
	@Listen("onClick =#menuTemplate")
	public void menuTemplateRedir(){
		try{
			Executions.sendRedirect("/SelectForm.zul");
		}catch(Exception e){
			
		}
	}
	
	@Listen("onClick =#menuReports")
	public void menuReportsRedir(){
		try{
			Executions.sendRedirect("/reports.zul");
		}catch(Exception e){

		}
	}
	
	private String mightyUserID = "";
	
	public VideoLibList(){
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		if(this.getUserID() == null){
			Executions.sendRedirect("/welcome_user.zul");
		}else{
			Connection conn = null;
			conn = singleConnect.connectToDatabaseOrDie();
			try{
				Statement st = conn.createStatement();
				ResultSet rs;
				rs = st.executeQuery("select sess_user_id from user_ifs where user_id = "+ this.getUserID());
				while(rs.next()){
					this.setMightyUserID(rs.getString("sess_user_id"));
				}
				
				if(this.getMightyUserID().equals("149565")){
					System.out.println("Mighty Session ID:" + this.getMightyUserID());
					System.out.println("Permitted for Video Library Access");
					reports = new ListModelList<VideoList>(new VideoLibListData().getSubmissionReports());
				}else{
					System.out.println("Mighty Session ID:" + this.getMightyUserID());
					System.out.println("Denied for Video Library Access");
					Executions.sendRedirect("/VideoLibDenied.zul");
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public ListModel<VideoList> getSubmissionReports() {
		return reports;
	}


	public Integer getUserID() {
		return userID;
	}


	public void setUserID(Integer userID) {
		this.userID = userID;
	}


	public String getMightyUserID() {
		return mightyUserID;
	}


	public void setMightyUserID(String mightyUserID) {
		this.mightyUserID = mightyUserID;
	}


}
