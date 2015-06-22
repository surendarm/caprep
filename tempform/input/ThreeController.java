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
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.tempform.ThreeInventoryItem;

public class ThreeController extends SelectorComposer<Component>  {

	private static final long serialVersionUID = 1L;

	private ThreeInventoryItem threeInventoryItem;
	
	private Integer userID = 0;
	
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public ThreeController(){
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		if(this.getUserID() == null){
			Executions.sendRedirect("/welcome_user.zul");
		}else{
			threeInventoryItem = new ThreeInventoryItem(this.getUserID());
		}
	}
	
	public ThreeInventoryItem getThreeInventoryItem() {
        return threeInventoryItem;
    }
	
	@Wire
	private Window win;
	
	@Wire
	private Button submitButton;
	
	@Wire
	private Textbox blockLegendData0, blockLegendData1, blockLegendData2;
	
	@Wire
	private Textbox blockOneTitle, blockOneData1, blockOneData2, blockOneData3, blockOneData4, blockOneData5, blockOneData6, blockOneData7, blockOneData8;
	
	@Wire
	private Textbox blockTwoTitle, blockTwoData1, blockTwoData2, blockTwoData3, blockTwoData4,blockTwoData5, blockTwoData6, blockTwoData7, blockTwoData8, blockTwoData9, blockTwoData10, blockTwoData11;
	
	@Wire
	private Textbox blockThreeTitle, blockThreeData1, blockThreeData2, blockThreeData3, blockThreeData4, blockThreeData5, blockThreeData6, blockThreeData7, blockThreeData8;
	
	@Wire
	private Textbox blockBatteryData1, blockBatteryData2, blockBatteryData3;
	
	@Wire
	private Textbox blockFourZeroTitle, blockFourZeroSubTitle, blockFourZeroData2, blockFourZeroData3,  blockFourZeroData4,  blockFourZeroData5, blockFourZeroData6, blockFourZeroData7, blockFourZeroData8, blockFourZeroData9, blockFourZeroData10, blockFourZeroData11, blockFourZeroData12;
	
	@Wire
	private Textbox blockFourOneTitle, blockFourOneData1, blockFourOneData2, blockFourOneData3, blockFourOneData4;
	
	@Wire
	private Textbox blockFourTwoTitle, blockFourTwoSubTitle, blockFourTwoData2, blockFourTwoData3, blockFourTwoData4, blockFourTwoData5, blockFourTwoData6, blockFourTwoData7; 
	
	@Wire
	private Textbox blockFourThreeTitle, blockFourThreeData1, blockFourThreeData2, blockFourThreeData3, blockFourThreeData4;
	
	@Wire
	private Label blockImageData1, blockImageData2; 
	

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
	
	@Listen("onClick =#tempTwo")
	public void tempTwoRedir(){
		try{
			Executions.sendRedirect("/TemplateTwo.zul");
		}catch(Exception e){
			
		}
	}
	
	@Listen("onClick =#tempOne")
	public void tempThreeRedir(){
		try{
			Executions.sendRedirect("/TemplateOne.zul");
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
			String [] blockLegendData = new String[3];
			String [] blockOneData = new String[25];
			String [] blockTwoData = new String[25];
			String [] blockThreeData = new String[25];
			String [] blockFourZeroData = new String[25];
			String [] blockFourOneData = new String[25];
			String [] blockFourTwoData = new String[25];
			String [] blockFourThreeData = new String[25];
			String [] blockBatteryData = new String[25];
			String [] blockImageData = new String[25];

			blockLegendData[0] = blockLegendData0.getValue();
			blockLegendData[1] = blockLegendData1.getValue();
			blockLegendData[2] = blockLegendData2.getValue();
			
			blockOneData[0] = blockOneTitle.getValue();
			blockOneData[1] = blockOneData1.getValue();
			blockOneData[2] = blockOneData2.getValue();
			blockOneData[3] = blockOneData3.getValue();
			blockOneData[4] = blockOneData4.getValue();
			blockOneData[5] = blockOneData5.getValue();
			blockOneData[6] = blockOneData6.getValue();
			blockOneData[7] = blockOneData7.getValue();
			blockOneData[8] = blockOneData8.getValue();
			
			blockTwoData[0] = blockTwoTitle.getValue();
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
			
			blockThreeData[0] = blockThreeTitle.getValue();
			blockThreeData[1] = blockThreeData1.getValue();
			blockThreeData[2] = blockThreeData2.getValue();
			blockThreeData[3] = blockThreeData3.getValue();
			blockThreeData[4] = blockThreeData4.getValue();
			blockThreeData[5] = blockThreeData5.getValue();
			blockThreeData[6] = blockThreeData6.getValue();
			blockThreeData[7] = blockThreeData7.getValue();
			blockThreeData[8] = blockThreeData8.getValue();
			
			blockBatteryData[0] = blockBatteryData1.getValue();
			blockBatteryData[1] = blockBatteryData2.getValue();
			blockBatteryData[2] = blockBatteryData3.getValue();
			
			blockFourZeroData[0] = blockFourZeroTitle.getValue();
			blockFourZeroData[1] = blockFourZeroSubTitle.getValue();
			blockFourZeroData[2] = blockFourZeroData2.getValue();
			blockFourZeroData[3] = blockFourZeroData3.getValue();
			blockFourZeroData[4] = blockFourZeroData4.getValue();
			blockFourZeroData[5] = blockFourZeroData5.getValue();
			blockFourZeroData[6] = blockFourZeroData6.getValue();
			blockFourZeroData[7] = blockFourZeroData7.getValue();
			blockFourZeroData[8] = blockFourZeroData8.getValue();
			blockFourZeroData[9] = blockFourZeroData9.getValue();
			blockFourZeroData[10] = blockFourZeroData10.getValue();
			blockFourZeroData[11] = blockFourZeroData11.getValue();
			blockFourZeroData[12] = blockFourZeroData12.getValue();
			
			
			blockFourOneData[0] = blockFourOneTitle.getValue();
			blockFourOneData[1] = blockFourOneData1.getValue();
			blockFourOneData[2] = blockFourOneData2.getValue();
			blockFourOneData[3] = blockFourOneData3.getValue();
			blockFourOneData[4] = blockFourOneData4.getValue();
			
			blockFourTwoData[0] = blockFourTwoTitle.getValue();
			blockFourTwoData[1] = blockFourTwoSubTitle.getValue();
			blockFourTwoData[2] = blockFourTwoData2.getValue();
			blockFourTwoData[3] = blockFourTwoData3.getValue();
			blockFourTwoData[4] = blockFourTwoData4.getValue();
			blockFourTwoData[5] = blockFourTwoData5.getValue();
			blockFourTwoData[6] = blockFourTwoData6.getValue();
			blockFourTwoData[7] = blockFourTwoData7.getValue();
			
			blockFourThreeData[0] = blockFourThreeTitle.getValue();
			blockFourThreeData[1] = blockFourThreeData1.getValue();
			blockFourThreeData[2] = blockFourThreeData2.getValue();
			blockFourThreeData[3] = blockFourThreeData3.getValue();
			blockFourThreeData[4] = blockFourThreeData4.getValue();

			blockImageData[0] = blockImageData1.getValue();
			blockImageData[1] = blockImageData2.getValue();
			
			threeInventoryItem.setBlockLegendData(blockLegendData);
			threeInventoryItem.setBlockOneData(blockOneData);
			threeInventoryItem.setBlockTwoData(blockTwoData);
			threeInventoryItem.setBlockThreeData(blockThreeData);
			threeInventoryItem.setBlockFourZeroData(blockFourZeroData);
			threeInventoryItem.setBlockFourOneData(blockFourOneData);
			threeInventoryItem.setBlockFourTwoData(blockFourTwoData);
			threeInventoryItem.setBlockFourThreeData(blockFourThreeData);
			threeInventoryItem.setBlockBatteryData(blockBatteryData);
			threeInventoryItem.setBlockImageData(blockImageData);
			threeInventoryItem.setUserID(this.getUserID());
			
			threeInventoryItem.store(threeInventoryItem);
			
			showNotify("Template Three Saved Successfully!", win);
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
