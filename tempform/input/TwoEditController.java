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
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.tempform.TwoInventoryItem;

public class TwoEditController extends SelectorComposer<Component>  {

	private static final long serialVersionUID = 1L;

	private TwoInventoryItem twoInventoryItem;
	
	private Integer userID = 0;
	
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	
	public TwoEditController(){
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		if(this.getUserID() == null){
			Executions.sendRedirect("/welcome_user.zul");
		}else{
			twoInventoryItem = new TwoInventoryItem(this.getUserID());
		}
	}
	
	public TwoInventoryItem getTwoInventoryItem() {
        return twoInventoryItem;
    }
	
	@Wire
	private Window win;
	
	@Wire
	private Button submitButton;
	
	@Wire
	private Textbox nameBox;

	@Wire
	private Textbox blockLegendData0, blockLegendData1, blockLegendData2;
	
	@Wire
	private Textbox blockOneData0, blockOneData1, blockOneData2, blockOneData3, blockOneData4, blockOneData5, blockOneData6, blockOneData7, blockOneData8, blockOneData9, blockOneData10, blockOneData11, blockOneData12, blockOneData13, blockOneData14, blockOneData15; 
	
	@Wire
	private Textbox blockTwoData0, blockTwoData1, blockTwoData2, blockTwoData3, blockTwoData4, blockTwoData5, blockTwoData6, blockTwoData7, blockTwoData8, blockTwoData9, blockTwoData10, blockTwoData11, blockTwoData12, blockTwoData13, blockTwoData14, blockTwoData15; 
	

	@Wire
	private Button menuTemplate, menuServices, menuReports, activeForm, tempOne, tempTwo, tempThree, tempFour; 
	
	@Listen("onClick =#menuVidLibrary")
	public void menuVidLibraryRedir(){
		try{
			Executions.sendRedirect("/VideoLibraryList.zul");
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
	
	
	@Listen("onClick =#menuReports")
	public void menuReportsRedir(){
		try{
			Executions.sendRedirect("/reports.zul");
		}catch(Exception e){
			
		}
	}
	
	@Listen("onClick =#activeForm")
	public void activeFormRedir(){
		try{
			Executions.sendRedirect("/SelectForm.zul");
		}catch(Exception e){
			
		}
	}
	
	@Listen("onClick =#tempOne")
	public void tempTwoRedir(){
		try{
			Executions.sendRedirect("/TemplateOne.zul");
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
	
	
	@Listen("onChange = #nameBox")
	public void changeTitle(){
			String title = nameBox.getValue();
			twoInventoryItem.setTitle(title);
			System.out.println("TextBox action trigerred");
			showNotify("Changed to: " + title, nameBox);
	}
	
	@Listen("onClick =#submitButton")
	public void submitData(){
		try{
			String[] blockLegendData = new String[3];
			String[] blockOneData = new String[28];
			String[] blockTwoData = new String[28];
			
			blockLegendData[0] = blockLegendData0.getValue();
			blockLegendData[1] = blockLegendData1.getValue();
			blockLegendData[2] = blockLegendData2.getValue();
			
			blockOneData[0] = blockOneData0.getValue();
			blockOneData[1] = blockOneData1.getValue();
			blockOneData[2] = blockOneData2.getValue();
			blockOneData[3] = blockOneData3.getValue();
			blockOneData[4] = blockOneData4.getValue();
			blockOneData[5] = blockOneData5.getValue();
			blockOneData[6] = blockOneData6.getValue();
			blockOneData[7] = blockOneData7.getValue();
			blockOneData[8] = blockOneData8.getValue();
			blockOneData[9] = blockOneData9.getValue();
			blockOneData[10] = blockOneData10.getValue();
			blockOneData[11] = blockOneData11.getValue();
			blockOneData[12] = blockOneData12.getValue();
			blockOneData[13] = blockOneData13.getValue();
			blockOneData[14] = blockOneData14.getValue();
			blockOneData[15] = blockOneData15.getValue();
			
			blockTwoData[0] = blockTwoData0.getValue();
			blockTwoData[1] = blockTwoData1.getValue();
			blockTwoData[2] = blockTwoData2.getValue();
			blockTwoData[3] = blockTwoData3.getValue();
			blockTwoData[4] = blockTwoData4.getValue();
			blockTwoData[5] = blockTwoData5.getValue();
			blockTwoData[6] = blockTwoData6.getValue();
			blockTwoData[7] = blockTwoData7.getValue();
			blockTwoData[8] = blockTwoData8.getValue();
			blockTwoData[9] = blockTwoData9.getValue();
			blockTwoData[10] = blockTwoData10.getValue();
			blockTwoData[11] = blockTwoData11.getValue();
			blockTwoData[12] = blockTwoData12.getValue();
			blockTwoData[13] = blockTwoData13.getValue();
			blockTwoData[14] = blockTwoData14.getValue();
			blockTwoData[15] = blockTwoData15.getValue();
						
				
			twoInventoryItem.setBlockLegendData(blockLegendData);
			twoInventoryItem.setBlockOneData(blockOneData);
			twoInventoryItem.setBlockTwoData(blockTwoData);
			twoInventoryItem.setUserID(this.getUserID());
			
			twoInventoryItem.store(twoInventoryItem);
	        showNotify("Template Two Saved Successfully!", win);
	        Executions.sendRedirect("/SelectForm.zul");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void showNotify(String msg, Component ref){
		Clients.showNotification(msg); //, "info", ref, "end_center", 2000);
	}

}
