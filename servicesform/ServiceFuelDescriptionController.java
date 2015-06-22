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
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.servicesform.ServiceFuelDescriptionInventory;

public class ServiceFuelDescriptionController extends SelectorComposer<Component>  {

	private static final long serialVersionUID = 1L;
	
	private ServiceFuelDescriptionInventory serviceFuelDescriptionInventory;
	
	private Integer userID = 0, serviceID =0;
	
	public ServiceFuelDescriptionController(){
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		if(this.getUserID() == null){
			Executions.sendRedirect("/welcome_user.zul");
		}else{
			this.setServiceID((Integer) sess.getAttribute("assist_service_id"));
			if(this.getServiceID() == null){
				Executions.sendRedirect("/ActiveServicesList.zul");
			}else{
				serviceFuelDescriptionInventory = new ServiceFuelDescriptionInventory(this.getServiceID());
			}
		}
	}
	
	public ServiceFuelDescriptionInventory getServiceFuelDescriptionInventory() {
        return serviceFuelDescriptionInventory;
    }
	
	@Wire
	private Window win;
	
	@Wire
	private Button submitButton;
	
	@Wire
	private Textbox item1;
	
	@Wire
	private Textbox blockOneTitle, blockOneData1, blockOneData2, blockOneData3, blockOneData4, blockOneData5, blockOneData6, blockOneData7, blockOneData8, blockOneData9, blockOneData10, blockOneData11, blockOneData12, blockOneData13, blockOneData14, blockOneData15, blockOneData16, blockOneData17, blockOneData18;
	
	@Wire
	private Textbox blockTwoTitle, blockTwoData1, blockTwoData2, blockTwoData3, blockTwoData4, blockTwoData5, blockTwoData6, blockTwoData7, blockTwoData8, blockTwoData9, blockTwoData10, blockTwoData11, blockTwoData12, blockTwoData13, blockTwoData14, blockTwoData15, blockTwoData16, blockTwoData17, blockTwoData18;
	
	@Wire
	private Textbox blockFuelThreeTitle, blockFuelThreeData1, blockFuelThreeData2, blockFuelThreeData3, blockFuelThreeData4, blockFuelThreeData5, blockFuelThreeData6, blockFuelThreeData7, blockFuelThreeData8, blockFuelThreeData9, blockFuelThreeData10, blockFuelThreeData11, blockFuelThreeData12, blockFuelThreeData13, blockFuelThreeData14, blockFuelThreeData15, blockFuelThreeData16, blockFuelThreeData17, blockFuelThreeData18;
	
	@Wire
	private Textbox blockThreeTitle, blockThreeData1, blockThreeData2, blockThreeData3, blockThreeData4, blockThreeData5, blockThreeData6, blockThreeData7, blockThreeData8, blockThreeData9, blockThreeData10, blockThreeData11, blockThreeData12, blockThreeData13, blockThreeData14, blockThreeData15, blockThreeData16, blockThreeData17, blockThreeData18;
	
	@Wire
	private Textbox blockFourTitle, blockFourSubTitle, blockFourData1, blockFourData2, blockFourData3, blockFourData4, blockFourData5, blockFourData6, blockFourData7, blockFourData8, blockFourData9, blockFourData10, blockFourData11, blockFourData12, blockFourData13, blockFourData14, blockFourData15, blockFourData16, blockFourData17, blockFourData18, blockFourDataPrice; 
	
	@Wire
	private Textbox blockFiveTitle, blockFiveSubTitle, blockFiveData1, blockFiveData2, blockFiveData3, blockFiveData4, blockFiveData5, blockFiveData6, blockFiveData7, blockFiveData8, blockFiveData9, blockFiveData10, blockFiveData11, blockFiveData12, blockFiveData13, blockFiveData14, blockFiveData15, blockFiveData16, blockFiveData17, blockFiveData18, blockFiveDataPrice;
	
	@Wire
	private Textbox blockSixTitle, blockSixSubTitle, blockSixData1, blockSixData2, blockSixData3, blockSixData4, blockSixData5, blockSixData6, blockSixData7, blockSixData8, blockSixData9, blockSixData10, blockSixData11, blockSixData12, blockSixData13, blockSixData14, blockSixData15, blockSixData16, blockSixData17, blockSixData18, blockSixDataPrice;
	
	@Wire
	private Label blockOneDataImg, blockTwoDataImg, blockFuelThreeDataImg, blockFourDataImg, blockFiveDataImg, blockSixDataImg;
	

	@Wire
	private Label backText;

	@Listen("onClick =#menuVidLibrary")
	public void menuVidLibraryRedir(){
		try{
			Executions.sendRedirect("/VideoLibraryList.zul");
		}catch(Exception e){
			
		}
	}
	

	@Wire
	private Button menuTemplate, menuServices, menuReports, activeService, editService; 
	
	@Listen("onClick =#menuTemplate")
	public void menuServicesRedir(){
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
	
	
	@Listen("onClick =#menuReports")
	public void menuReportsRedir(){
		try{
			Executions.sendRedirect("/reports.zul");
		}catch(Exception e){
			
		}
	}

	@Listen("onClick =#activeService")
	public void activeServiceRedir(){
		try{
			Executions.sendRedirect("/ServiceSelection.zul");
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
	
	
	@Listen("onClick =#backText")
	public void backToMainScree(){
		try{
			Executions.sendRedirect("/welcome_user.zul");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Listen("onClick =#submitButton")
	public void submitData(){
		try{
			String title= null;
			String tempDesc = null, tempBox = null;
			String[] mainBlockOneData = new String[25];
			String[] mainBlockTwoData = new String[25];
			String[] mainBlockFuelThreeData = new String[25];
			String[] mainBlockThreeData = new String[25];
			String[] mainBlockFourData = new String[25];
			String[] mainBlockFiveData = new String[25];
			String[] mainBlockSixData = new String[25];
			
			/*
			 * Block One
			 */
			
			mainBlockOneData[0] = blockOneTitle.getValue();
			if(blockOneData1.getValue() != "" && blockOneData1.getValue().length() > 0){
				if(isEmptyOrWhitespace(blockOneData1.getValue())){
					blockOneData1 = null;
				}else if(blockOneData1.getValue().length() > 0){
					tempDesc = blockOneData1.getValue();
					tempBox = blockOneData1.getValue();  
				}
			}else
			{
				tempBox = null;
				tempDesc = "";
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData2 = null;
			}else if(blockOneData2.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData2.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData3 = null;
			}else if(blockOneData3.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData3.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData4 = null;
			}else if(blockOneData4.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData4.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData5 = null;
			}else if(blockOneData5.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData5.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData6 = null;
			}else if(blockOneData6.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData6.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData7 = null;
			}else if(blockOneData7.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData7.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData8 = null;
			}else if(blockOneData8.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData8.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData9 = null;
			}else if(blockOneData9.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData9.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData10 = null;
			}else if(blockOneData10.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData10.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData11 = null;
			}else if(blockOneData11.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData11.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData12 = null;
			}else if(blockOneData12.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData12.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData13 = null;
			}else if(blockOneData13.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData13.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData14 = null;
			}else if(blockOneData14.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData14.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData15 = null;
			}else if(blockOneData15.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData15.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData16 = null;
			}else if(blockOneData16.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData16.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData17 = null;
			}else if(blockOneData17.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData17.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockOneData18 = null;
			}else if(blockOneData18.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockOneData18.getValue();
			}	
			mainBlockOneData[1] = tempDesc;
			mainBlockOneData[2] = blockOneDataImg.getValue();
			
			/*
			 * Block TWO
			 */
			
			mainBlockTwoData[0] = blockTwoTitle.getValue();
			if(blockTwoData1.getValue() != "" && blockTwoData1.getValue().length() > 0){
				if(isEmptyOrWhitespace(blockTwoData1.getValue())){
					blockTwoData1 = null;
				}else if(blockTwoData1.getValue().length() > 0){
					tempDesc = blockTwoData1.getValue();
					tempBox = blockTwoData1.getValue();  
				}
			}else
			{
				tempBox = null;
				tempDesc = "";
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData2 = null;
			}else if(blockTwoData2.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData2.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData3 = null;
			}else if(blockTwoData3.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData3.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData4 = null;
			}else if(blockTwoData4.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData4.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData5 = null;
			}else if(blockTwoData5.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData5.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData6 = null;
			}else if(blockTwoData6.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData6.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData7 = null;
			}else if(blockTwoData7.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData7.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData8 = null;
			}else if(blockTwoData8.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData8.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData9 = null;
			}else if(blockTwoData9.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData9.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData10 = null;
			}else if(blockTwoData10.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData10.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData11 = null;
			}else if(blockTwoData11.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData11.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData12 = null;
			}else if(blockTwoData12.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData12.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData13 = null;
			}else if(blockTwoData13.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData13.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData14 = null;
			}else if(blockTwoData14.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData14.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData15 = null;
			}else if(blockTwoData15.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData15.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData16 = null;
			}else if(blockTwoData16.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData16.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData17 = null;
			}else if(blockTwoData17.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData17.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockTwoData18 = null;
			}else if(blockTwoData18.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockTwoData18.getValue();
			}
			mainBlockTwoData[1] = tempDesc;
			mainBlockTwoData[2] = blockTwoDataImg.getValue();
			
			
			/*
			 * Block FuelThree
			 */
			
			mainBlockFuelThreeData[0] = blockFuelThreeTitle.getValue();
			if(blockFuelThreeData1.getValue() != "" && blockThreeData1.getValue().length() > 0){
				if(isEmptyOrWhitespace(blockFuelThreeData1.getValue())){
					blockFuelThreeData1 = null;
				}else if(blockFuelThreeData1.getValue().length() > 0){
					tempDesc = blockFuelThreeData1.getValue();
					tempBox = blockFuelThreeData1.getValue();  
				}
			}else
			{
				tempBox = null;
				tempDesc = "";
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData2 = null;
			}else if(blockFuelThreeData2.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData2.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData3 = null;
			}else if(blockFuelThreeData3.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData3.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData4 = null;
			}else if(blockFuelThreeData4.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData4.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData5 = null;
			}else if(blockFuelThreeData5.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData5.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData6 = null;
			}else if(blockFuelThreeData6.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData6.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData7 = null;
			}else if(blockFuelThreeData7.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData7.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData8 = null;
			}else if(blockFuelThreeData8.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData8.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData9 = null;
			}else if(blockFuelThreeData9.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData9.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData10 = null;
			}else if(blockFuelThreeData10.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData10.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData11 = null;
			}else if(blockFuelThreeData11.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData11.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData12 = null;
			}else if(blockFuelThreeData12.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData12.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData13 = null;
			}else if(blockFuelThreeData13.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData13.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData14 = null;
			}else if(blockFuelThreeData14.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData14.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData15 = null;
			}else if(blockFuelThreeData15.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData15.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData16 = null;
			}else if(blockFuelThreeData16.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData16.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData17 = null;
			}else if(blockFuelThreeData17.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData17.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFuelThreeData18 = null;
			}else if(blockFuelThreeData18.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFuelThreeData18.getValue();
			}
			mainBlockFuelThreeData[1] = tempDesc;
			mainBlockFuelThreeData[2] = blockFuelThreeDataImg.getValue();
			
			/*
			 * Block Three
			 */
			
			mainBlockThreeData[0] = blockThreeTitle.getValue();
			if(blockThreeData1.getValue() != "" && blockThreeData1.getValue().length() > 0){
				if(isEmptyOrWhitespace(blockThreeData1.getValue())){
					blockThreeData1 = null;
				}else if(blockThreeData1.getValue().length() > 0){
					tempDesc = blockThreeData1.getValue();
					tempBox = blockThreeData1.getValue();  
				}
			}else
			{
				tempBox = null;
				tempDesc = "";
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData2 = null;
			}else if(blockThreeData2.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData2.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData3 = null;
			}else if(blockThreeData3.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData3.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData4 = null;
			}else if(blockThreeData4.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData4.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData5 = null;
			}else if(blockThreeData5.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData5.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData6 = null;
			}else if(blockThreeData6.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData6.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData7 = null;
			}else if(blockThreeData7.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData7.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData8 = null;
			}else if(blockThreeData8.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData8.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData9 = null;
			}else if(blockThreeData9.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData9.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData10 = null;
			}else if(blockThreeData10.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData10.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData11 = null;
			}else if(blockThreeData11.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData11.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData12 = null;
			}else if(blockThreeData12.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData12.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData13 = null;
			}else if(blockThreeData13.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData13.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData14 = null;
			}else if(blockThreeData14.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData14.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData15 = null;
			}else if(blockThreeData15.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData15.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData16 = null;
			}else if(blockThreeData16.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData16.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData17 = null;
			}else if(blockThreeData17.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData17.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockThreeData18 = null;
			}else if(blockThreeData18.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockThreeData18.getValue();
			}
			mainBlockThreeData[1] = tempDesc;
			
			
			/*
			 * Block Four
			 */
			
			mainBlockFourData[0] = blockFourTitle.getValue();
			if(blockFourData1.getValue() != "" && blockFourData1.getValue().length() > 0){
				if(isEmptyOrWhitespace(blockFourData1.getValue())){
					blockFourData1 = null;
				}else if(blockFourData1.getValue().length() > 0){
					tempDesc = blockFourData1.getValue();
					tempBox = blockFourData1.getValue();  
				}
			}else
			{
				tempBox = null;
				tempDesc = "";
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData2 = null;
			}else if(blockFourData2.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData2.getValue();
			}
			
			mainBlockFourData[1] = tempDesc;
			mainBlockFourData[2] = blockFourDataImg.getValue();
			mainBlockFourData[3] = blockFourDataPrice.getValue();
			mainBlockFourData[4] = blockFourSubTitle.getValue();

			/*
			 * Block Five
			 */
			
			mainBlockFiveData[0] = blockFiveTitle.getValue();
			if(blockFiveData1.getValue() != "" && blockFiveData1.getValue().length() > 0){
				if(isEmptyOrWhitespace(blockFiveData1.getValue())){
					blockFiveData1 = null;
				}else if(blockFiveData1.getValue().length() > 0){
					tempDesc = blockFiveData1.getValue();
					tempBox = blockFiveData1.getValue();  
				}
			}else
			{
				tempBox = null;
				tempDesc = "";
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData2 = null;
			}else if(blockFiveData2.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData2.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData3 = null;
			}else if(blockFiveData3.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData3.getValue();
			}
			
			mainBlockFiveData[1] = tempDesc;
			mainBlockFiveData[2] = blockFiveDataImg.getValue();
			mainBlockFiveData[3] = blockFiveDataPrice.getValue();
			mainBlockFiveData[4] = blockFiveSubTitle.getValue();
			
			/*
			 * Block Six
			 */
			
			mainBlockSixData[0] = blockSixTitle.getValue();
			if(blockSixData1.getValue() != "" && blockSixData1.getValue().length() > 0){
				if(isEmptyOrWhitespace(blockSixData1.getValue())){
					blockSixData1 = null;
				}else if(blockSixData1.getValue().length() > 0){
					tempDesc = blockSixData1.getValue();
					tempBox = blockSixData1.getValue();  
				}
			}else
			{
				tempBox = null;
				tempDesc = "";
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData2 = null;
			}else if(blockSixData2.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData2.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData3 = null;
			}else if(blockSixData3.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData3.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData4 = null;
			}else if(blockSixData4.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData4.getValue();
			}
			
			mainBlockSixData[1] = tempDesc;
			mainBlockSixData[2] = blockSixDataImg.getValue();
			mainBlockSixData[3] = blockSixDataPrice.getValue();
			mainBlockSixData[4] = blockSixSubTitle.getValue();
			
			
			serviceFuelDescriptionInventory.setTitle(title);
			
			serviceFuelDescriptionInventory.setMainBlockOneData(mainBlockOneData);
			serviceFuelDescriptionInventory.setMainBlockTwoData(mainBlockTwoData);
			serviceFuelDescriptionInventory.setMainBlockThreeData(mainBlockThreeData);
			serviceFuelDescriptionInventory.setMainBlockFuelThreeData(mainBlockFuelThreeData);
			serviceFuelDescriptionInventory.setMainBlockFourData(mainBlockFourData);
			serviceFuelDescriptionInventory.setMainBlockFiveData(mainBlockFiveData);
			serviceFuelDescriptionInventory.setMainBlockSixData(mainBlockSixData);
			
			serviceFuelDescriptionInventory.store(serviceFuelDescriptionInventory);
			
	        showNotify("Saved", win);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String makeSafe(String s) {
	    return (s == null) ? "" : s;
	  }
	
	public static boolean isEmptyOrWhitespace(String s) {
	    s = makeSafe(s);
	    for (int i = 0, n = s.length(); i < n; i++) {
	      if (!Character.isWhitespace(s.charAt(i))) {
	        return false;
	      }
	    }
	    return true;
	  }

	private void showNotify(String msg, Component ref){
		Clients.showNotification(msg, "info", ref, "end_center", 2000);
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getServiceID() {
		return serviceID;
	}

	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}
}
