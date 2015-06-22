package com.tempform.input;

import java.awt.Button;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;
import org.zkoss.zul.Radiogroup;

import com.tempform.ActiveFormInventory;

public class ActiveFormController extends SelectorComposer<Component>  {

			private static final long serialVersionUID = 1L;
			
			private Integer userID = 0;
			
			public Integer getUserID() {
				return userID;
			}

			public void setUserID(Integer userID) {
				this.userID = userID;
			}
			private ActiveFormInventory activeFormInventory;

			public ActiveFormController(){
				Session sess = Sessions.getCurrent();
				this.setUserID((Integer) sess.getAttribute("assist_user_id"));
				if(this.getUserID() == null){
					Executions.sendRedirect("/welcome_user.zul");
				}else{
					activeFormInventory = new ActiveFormInventory(this.getUserID());
				}
			}
			
			public ActiveFormInventory getActiveFormInventory() {
		        return activeFormInventory;
		    }
			
			@Wire
			private Window win;
			
			@Wire
			private Button submitButton;
			
			@Wire
			private Radiogroup rg; 
			

			@Wire
			private Button menuTemplate, menuServices, menuReports, activeForm, tempOne, tempTwo, tempThree, tempFour; 
			
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
					String selectedItem = "";
					switch(rg.getSelectedIndex()){
					case 0:
						selectedItem = "101 Form";
						activeFormInventory.setSelectedItem(selectedItem);
						activeFormInventory.store(activeFormInventory);
						Clients.showNotification("Saved");
						break;
					case 1:
						selectedItem = "102 Form";
						activeFormInventory.setSelectedItem(selectedItem);
						activeFormInventory.store(activeFormInventory);
						Clients.showNotification("Saved");
						break;
					case 2:	
						selectedItem = "103 Form";
						activeFormInventory.setSelectedItem(selectedItem);
						activeFormInventory.store(activeFormInventory);
						Clients.showNotification("Saved");
						break;
					case 3:	
						selectedItem = "104 Form";
						activeFormInventory.setSelectedItem(selectedItem);
						activeFormInventory.store(activeFormInventory);
						Clients.showNotification("Saved");
						break;	
					default:
						Clients.showNotification("No Form Selected");
						break;
					}
					System.out.println(rg.getSelectedIndex());
				}catch(Exception e){
					e.printStackTrace();
				}
			}	
}
