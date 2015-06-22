package com.servicesform;

import java.awt.Button;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

import com.servicesform.SettingsInventory;

public class SettingsController extends SelectorComposer<Component>  {

	private static final long serialVersionUID = 1L;

	private SettingsInventory settingsInventory;
	
	private Integer userID = 0;
	
	public SettingsController(){
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		System.out.println("Controller : "+sess.getAttribute("assist_user_id"));
		if(this.getUserID() == null){
			Executions.sendRedirect("/welcome_user.zul");
		}else{
			settingsInventory = new SettingsInventory(this.getUserID());
		}
	}
	

	public SettingsInventory getSettingsInventory() {
        return settingsInventory;
    }

	@Wire
	private Window win;
	
	@Wire
	private Button submitButton;
	
	@Wire
	private Label interHeaderImageOne, interHeaderImageTwo, interHeaderImageThree, interFranchiseeImage;

	@Wire
	private Checkbox headerimageonechk, headerimagetwochk, headerimagethreechk, franchiseeimgchk; 

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
	
	@Listen("onClick =#submitButton")
	public void submitData(){
		try{
			String headerImageOne = "";
			
			if(headerimageonechk.isChecked()){
				headerImageOne = "blank.png";
			}else{
				headerImageOne = interHeaderImageOne.getValue();
			}	
			
			String headerImageTwo = "";
			
			if(headerimagetwochk.isChecked()){
				headerImageTwo = "blank.png";
			}else{
				headerImageTwo = interHeaderImageTwo.getValue();
			}
			
			String headerImageThree = "";
			
			if(headerimagethreechk.isChecked()){
				headerImageThree = "blank.png";
			}else{
				headerImageThree = interHeaderImageThree.getValue();
			}
			
			String franchiseeImage = "";
			
			if(franchiseeimgchk.isChecked()){
				franchiseeImage = "blank.png";
			}else{
				franchiseeImage = interFranchiseeImage.getValue();
			}
			
			settingsInventory.setHeaderImageOne(headerImageOne);
			settingsInventory.setHeaderImageTwo(headerImageTwo);
			settingsInventory.setHeaderImageThree(headerImageThree);
			settingsInventory.setFranchiseeImage(franchiseeImage);
		
			settingsInventory.store(settingsInventory);
	        showNotify("Settings Saved Successfully!", win);
	        Executions.sendRedirect("/SelectForm.zul");
			
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


	private void showNotify(String msg, Component ref){
		Clients.showNotification(msg); //, "info", ref, "end_center", 2000);
	}	

}
