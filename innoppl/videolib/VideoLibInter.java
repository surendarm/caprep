package com.innoppl.videolib;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;


public class VideoLibInter extends SelectorComposer<Component> {

	private static final long serialVersionUID = 1L;


	private Integer userID = 0;

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

	
	
	public VideoLibInter(){
		String sessID = "";
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		
		if(this.getUserID() == null){
			Executions.sendRedirect("/welcome_user.zul");
		}
		
		/*else{
			Connection conn = null;
			conn = singleConnect.connectToDatabaseOrDie();
			try{
				Statement st = conn.createStatement();
				ResultSet rs;
				rs = st.executeQuery("select sess_user_id from user_ifs where user_id = "+ this.getUserID());
				while(rs.next()){
					sessID = rs.getString("sess_user_id");
				}
				System.out.println(sessID);
				if(sessID.equals("101 form")){
					Executions.sendRedirect("/VideoLibList.zul");
				}else{
					Executions.sendRedirect("/VideoLibDenied.zul");
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}

		}
		*/
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

}
