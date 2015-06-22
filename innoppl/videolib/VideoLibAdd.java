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
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.innoppl.dbconnect.SingleConnect;



public class VideoLibAdd extends SelectorComposer<Component>  {

	private static final long serialVersionUID = 1L;

	private SingleConnect singleConnect = new SingleConnect();
	
	private VideoLibAddInventory videoLibAddInventory;

	private String mightyUserID = "";
	
	private Integer userID = 0;

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public VideoLibAdd(){
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
					videoLibAddInventory = new VideoLibAddInventory(this.getUserID());
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

	public VideoLibAddInventory getVideoLibAddInventory() {
		return videoLibAddInventory;
	}

	@Wire
	private Window win;

	@Wire
	private Textbox textOne, textTwo, textThree;

	@Wire
	private Button submitButton; 
	
	
	@Listen("onClick =#menuTemplate")
	public void menuSelectFormRedir(){
		try{
			Executions.sendRedirect("/SelectForm.zul");
		}catch(Exception e){
			
		}
	}



	@Listen("onClick =#menuVidLibrary")
	public void menuVidLibraryRedir(){
		try{
			Executions.sendRedirect("/VideoLibraryList.zul");
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

	@Listen("onClick =#menuServices")
	public void menuServicesRedir(){
		try{
			Executions.sendRedirect("/ServiceSelection.zul");
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


	@Listen("onClick =#menuReports")
	public void menuReportsRedir(){
		try{
			Executions.sendRedirect("/reports.zul");
		}catch(Exception e){

		}
	}

	@Listen("onClick =#tempOne")
	public void activeFormRedir(){
		try{
			Executions.sendRedirect("/TemplateOne.zul");
		}catch(Exception e){

		}
	}

	@Listen("onClick =#tempTwo")
	public void tempTwoRedir(){
		try{
			Executions.sendRedirect("/TemplateTwo.zul");
		}catch(Exception e){

		}
	}

	@Listen("onClick =#tempThree")
	public void tempThreeRedir(){
		try{
			Executions.sendRedirect("/TemplateThree.zul");
		}catch(Exception e){

		}
	}

	@Listen("onClick =#tempFour")
	public void tempFourRedir(){
		try{
			Executions.sendRedirect("/TemplateFour.zul");
		}catch(Exception e){

		}
	}

	@Listen("onClick =#submitButton")
	public void submitData(){
		try{
			String videoTitle = "";
			String videoURL = "";
			String videoDescription = "";

			videoTitle = textOne.getValue();
			videoURL = textTwo.getValue();
			videoDescription = textThree.getValue();

			videoLibAddInventory.setVideoTitle(videoTitle);
			videoLibAddInventory.setVideoURL(videoURL);
			videoLibAddInventory.setVideoDescription(videoDescription);

			videoLibAddInventory.store(videoLibAddInventory);
			
			showNotify("Video added successfully!", win);
			Executions.sendRedirect("/VideoLibraryList.zul");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private void showNotify(String msg, Component ref){
		Clients.showNotification(msg); //, "info", ref, "end_center", 2000);
	}

	public String getMightyUserID() {
		return mightyUserID;
	}

	public void setMightyUserID(String mightyUserID) {
		this.mightyUserID = mightyUserID;
	}


	
}
