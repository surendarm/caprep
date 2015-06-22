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
import org.zkoss.zul.Window;

import com.innoppl.dbconnect.SingleConnect;

public class VideoLibDel extends SelectorComposer<Component>  {

	private static final long serialVersionUID = 1L;

	private SingleConnect singleConnect = new SingleConnect();
	
	private VideoLibDelInventory videoLibDelInventory;

	private Integer userID = 0;
	private String videoID = "";
	private String mightyUserID = "";
	
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public VideoLibDel(){
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		String vid = Executions.getCurrent().getParameter("vid");
		System.out.println("Video ID "+ vid);
		this.setVideoID(vid);
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
					videoLibDelInventory = new VideoLibDelInventory(this.getUserID(), this.getVideoID());
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

	public VideoLibDelInventory getVideoLibDelInventory() {
		return videoLibDelInventory;
	}

	@Wire
	private Window win;

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
			
			//this.setVideoID(textFour.getValue());

			//videoLibDelInventory.setVideoID(this.getVideoID());
			
			videoLibDelInventory.store(videoLibDelInventory);

			showNotify("Video deleted successfully!", win);
			Executions.sendRedirect("/VideoLibraryList.zul");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Listen("onClick =#redirectButton")
	public void redirectButton(){
		try{
			Executions.sendRedirect("/VideoLibraryList.zul");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void showNotify(String msg, Component ref){
		Clients.showNotification(msg); //, "info", ref, "end_center", 2000);
	}

	public String getVideoID() {
		return videoID;
	}

	public void setVideoID(String vid) {
		this.videoID = vid;
	}

	public String getMightyUserID() {
		return mightyUserID;
	}

	public void setMightyUserID(String mightyUserID) {
		this.mightyUserID = mightyUserID;
	}


}
