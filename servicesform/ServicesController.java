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
import org.zkoss.zul.Window;

import com.servicesform.ServicesInventory;

public class ServicesController  extends SelectorComposer<Component>  {

	private static final long serialVersionUID = 1L;

	
	private ServicesInventory servicesInventory;
	
	
	private Integer userID = 0;
	
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public ServicesController(){
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		if(this.getUserID() == null){
			Executions.sendRedirect("/welcome_user.zul");
		}else{
			servicesInventory = new ServicesInventory(this.getUserID());
		}
	}
	
	public ServicesInventory getServicesInventory() {
        return servicesInventory;
    }

	@Wire
	private Window win;
	
	@Wire
	private Button submitButton;
	
	@Wire
	private Checkbox transmission, oil, fuel, coolant, power, brake, mileage, additional;
	

	@Wire
	private Button menuTemplate, menuServices, menuReports, activeService, editService; 
	
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
	
	
	@Listen("onClick =#menuTemplate")
	public void menuServicesRedir(){
		try{
			Executions.sendRedirect("/SelectForm.zul");
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
	
	@Listen("onClick =#editService")
	public void activeFormRedir(){
		try{
			Executions.sendRedirect("/ActiveServicesList.zul");
		}catch(Exception e){
			
		}
	}
	
	
	@Listen("onClick =#submitButton")
	public void submitData(){
		try{
			
			String item[] = new String[8];
			/*		
			if(iorange.isChecked()){
				System.out.println("Checked");
			}else{
				System.out.println("NO");
			}
			 */	
			
			if(transmission.isChecked()){
				item[0] = "true";
			}else{
				item[0] = "false";
			}
			
			if(oil.isChecked()){
				item[1] = "true";
			}else{
				item[1] = "false";
			}
			
			if(fuel.isChecked()){
				item[2] = "true";
			}else{
				item[2] = "false";
			}
			
			if(coolant.isChecked()){
				item[3] = "true";
			}else{
				item[3] = "false";
			}
			
			if(power.isChecked()){
				item[4] = "true";
			}else{
				item[4] = "false";
			}
			
			if(brake.isChecked()){
				item[5] = "true";
			}else{
				item[5] = "false";
			}
			
			if(mileage.isChecked()){
				item[6] = "true";
			}else{
				item[6] = "false";
			}
			
			if(additional.isChecked()){
				item[7] = "true";
			}else{
				item[7] = "false";
			}

			servicesInventory.setItem(item);
			
			servicesInventory.store(servicesInventory);
			
			System.out.println("TEST");
			showNotify("Saved", win);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void showNotify(String msg, Component ref){
		Clients.showNotification(msg, "info", ref, "end_center", 2000);
	}
	
}
