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

import com.servicesform.ServiceMileageDescriptionInventory;

public class ServiceMileageDescriptionController extends SelectorComposer<Component>  {

	private static final long serialVersionUID = 1L;
	
	private ServiceMileageDescriptionInventory serviceMileageDescriptionInventory;
	
	private Integer userID = 0, serviceID =0;
	
	public ServiceMileageDescriptionController(){
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		if(this.getUserID() == null){
			Executions.sendRedirect("/welcome_user.zul");
		}else{
			this.setServiceID((Integer) sess.getAttribute("assist_service_id"));
			if(this.getServiceID() == null){
				Executions.sendRedirect("/ActiveServicesList.zul");
			}else{
				serviceMileageDescriptionInventory = new ServiceMileageDescriptionInventory(this.getServiceID());
			}
		}
	}
	
	public ServiceMileageDescriptionInventory getServiceMileageDescriptionInventory() {
        return serviceMileageDescriptionInventory;
    }
	
	@Wire
	private Window win;
	
	@Wire
	private Button submitButton;
	
	@Wire
	private Textbox item1;
	
	@Wire
	private Textbox blockPackageTitle1, blockPackageTitle2, blockPackageTitle3;
	
	@Wire
	private Textbox blockOneTitle, blockOneData1, blockOneData2, blockOneData3, blockOneData4, blockOneData5, blockOneData6, blockOneData7, blockOneData8, blockOneData9, blockOneData10, blockOneData11, blockOneData12, blockOneData13, blockOneData14, blockOneData15, blockOneData16, blockOneData17, blockOneData18, blockOneDataPrice;
	
	@Wire
	private Textbox blockTwoTitle, blockTwoData1, blockTwoData2, blockTwoData3, blockTwoData4, blockTwoData5, blockTwoData6, blockTwoData7, blockTwoData8, blockTwoData9, blockTwoData10, blockTwoData11, blockTwoData12, blockTwoData13, blockTwoData14, blockTwoData15, blockTwoData16, blockTwoData17, blockTwoData18, blockTwoDataPrice;
	
	@Wire
	private Textbox blockThreeTitle, blockThreeData1, blockThreeData2, blockThreeData3, blockThreeData4, blockThreeData5, blockThreeData6, blockThreeData7, blockThreeData8, blockThreeData9, blockThreeData10, blockThreeData11, blockThreeData12, blockThreeData13, blockThreeData14, blockThreeData15, blockThreeData16, blockThreeData17, blockThreeData18, blockThreeDataPrice;
	
	@Wire
	private Textbox blockFourTitle, blockFourData1, blockFourData2, blockFourData3, blockFourData4, blockFourData5, blockFourData6, blockFourData7, blockFourData8, blockFourData9, blockFourData10, blockFourData11, blockFourData12, blockFourData13, blockFourData14, blockFourData15, blockFourData16, blockFourData17, blockFourData18, blockFourDataPrice; 
	
	@Wire
	private Textbox blockFiveTitle, blockFiveData1, blockFiveData2, blockFiveData3, blockFiveData4, blockFiveData5, blockFiveData6, blockFiveData7, blockFiveData8, blockFiveData9, blockFiveData10, blockFiveData11, blockFiveData12, blockFiveData13, blockFiveData14, blockFiveData15, blockFiveData16, blockFiveData17, blockFiveData18, blockFiveDataPrice;
	
	@Wire
	private Textbox blockSixTitle, blockSixData1, blockSixData2, blockSixData3, blockSixData4, blockSixData5, blockSixData6, blockSixData7, blockSixData8, blockSixData9, blockSixData10, blockSixData11, blockSixData12, blockSixData13, blockSixData14, blockSixData15, blockSixData16, blockSixData17, blockSixData18, blockSixDataPrice;

	@Wire
	private Textbox blockSevenTitle, blockSevenData1, blockSevenData2, blockSevenData3, blockSevenData4, blockSevenData5, blockSevenData6, blockSevenData7, blockSevenData8, blockSevenData9, blockSevenData10, blockSevenData11, blockSevenData12, blockSevenData13, blockSevenData14, blockSevenData15, blockSevenData16, blockSevenData17, blockSevenData18, blockSevenDataPrice;

	@Wire
	private Textbox blockEightTitle, blockEightData1, blockEightData2, blockEightData3, blockEightData4, blockEightData5, blockEightData6, blockEightData7, blockEightData8, blockEightData9, blockEightData10, blockEightData11, blockEightData12, blockEightData13, blockEightData14, blockEightData15, blockEightData16, blockEightData17, blockEightData18, blockEightDataPrice;

	@Wire
	private Textbox blockNineTitle, blockNineData1, blockNineData2, blockNineData3, blockNineData4, blockNineData5, blockNineData6, blockNineData7, blockNineData8, blockNineData9, blockNineData10, blockNineData11, blockNineData12, blockNineData13, blockNineData14, blockNineData15, blockNineData16, blockNineData17, blockNineData18, blockNineDataPrice;
	
	@Wire
	private Label backText;
	

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
			String[] mainBlockPackageTitleData = new String[25];
			String[] mainBlockOneData = new String[25];
			String[] mainBlockTwoData = new String[25];
			String[] mainBlockThreeData = new String[25];
			String[] mainBlockFourData = new String[25];
			String[] mainBlockFiveData = new String[25];
			String[] mainBlockSixData = new String[25];
			String[] mainBlockSevenData = new String[25];
			String[] mainBlockEightData = new String[25];
			String[] mainBlockNineData = new String[25];
			
			
			/*
			 * Block Package
			 */
			
			mainBlockPackageTitleData[0] = blockPackageTitle1.getValue();
			mainBlockPackageTitleData[1] = blockPackageTitle2.getValue();
			mainBlockPackageTitleData[2] = blockPackageTitle3.getValue();
			
			
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
			mainBlockOneData[2] = blockOneDataPrice.getValue();
			
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
			mainBlockTwoData[2] = blockTwoDataPrice.getValue();
			
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
			mainBlockThreeData[2] = blockThreeDataPrice.getValue();
			
			
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
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData3 = null;
			}else if(blockFourData3.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData3.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData4 = null;
			}else if(blockFourData4.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData4.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData5 = null;
			}else if(blockFourData5.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData5.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData6 = null;
			}else if(blockFourData6.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData6.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData7 = null;
			}else if(blockFourData7.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData7.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData8 = null;
			}else if(blockFourData8.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData8.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData9 = null;
			}else if(blockFourData9.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData9.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData10 = null;
			}else if(blockFourData10.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData10.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData11 = null;
			}else if(blockFourData11.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData11.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData12 = null;
			}else if(blockFourData12.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData12.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData13 = null;
			}else if(blockFourData13.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData13.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData14 = null;
			}else if(blockFourData14.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData14.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData15 = null;
			}else if(blockFourData15.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData15.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData16 = null;
			}else if(blockFourData16.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData16.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData17 = null;
			}else if(blockFourData17.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData17.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFourData18 = null;
			}else if(blockFourData18.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFourData18.getValue();
			}
			mainBlockFourData[1] = tempDesc;
			mainBlockFourData[2] = blockFourDataPrice.getValue();

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
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData4 = null;
			}else if(blockFiveData4.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData4.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData5 = null;
			}else if(blockFiveData5.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData5.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData6 = null;
			}else if(blockFiveData6.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData6.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData7 = null;
			}else if(blockFiveData7.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData7.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData8 = null;
			}else if(blockFiveData8.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData8.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData9 = null;
			}else if(blockFiveData9.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData9.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData10 = null;
			}else if(blockFiveData10.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData10.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData11 = null;
			}else if(blockFiveData11.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData11.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData12 = null;
			}else if(blockFiveData12.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData12.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData13 = null;
			}else if(blockFiveData13.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData13.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData14 = null;
			}else if(blockFiveData14.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData14.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData15 = null;
			}else if(blockFiveData15.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData15.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData16 = null;
			}else if(blockFiveData16.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData16.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData17 = null;
			}else if(blockFiveData17.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData17.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockFiveData18 = null;
			}else if(blockFiveData18.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockFiveData18.getValue();
			}
			mainBlockFiveData[1] = tempDesc;
			mainBlockFiveData[2] = blockFiveDataPrice.getValue();
			
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
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData5 = null;
			}else if(blockSixData5.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData5.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData6 = null;
			}else if(blockSixData6.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData6.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData7 = null;
			}else if(blockSixData7.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData7.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData8 = null;
			}else if(blockSixData8.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData8.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData9 = null;
			}else if(blockSixData9.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData9.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData10 = null;
			}else if(blockSixData10.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData10.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData11 = null;
			}else if(blockSixData11.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData11.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData12 = null;
			}else if(blockSixData12.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData12.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData13 = null;
			}else if(blockSixData13.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData13.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData14 = null;
			}else if(blockSixData14.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData14.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData15 = null;
			}else if(blockSixData15.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData15.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData16 = null;
			}else if(blockSixData16.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData16.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData17 = null;
			}else if(blockSixData17.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData17.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSixData18 = null;
			}else if(blockSixData18.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSixData18.getValue();
			}
			mainBlockSixData[1] = tempDesc;
			mainBlockSixData[2] = blockSixDataPrice.getValue();
			

			/*
			 * Block Seven
			 */
			
			mainBlockSevenData[0] = blockSevenTitle.getValue();
			if(blockSevenData1.getValue() != "" && blockSevenData1.getValue().length() > 0){
				if(isEmptyOrWhitespace(blockSevenData1.getValue())){
					blockSevenData1 = null;
				}else if(blockSevenData1.getValue().length() > 0){
					tempDesc = blockSevenData1.getValue();
					tempBox = blockSevenData1.getValue();  
				}
			}else
			{
				tempBox = null;
				tempDesc = "";
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData2 = null;
			}else if(blockSevenData2.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData2.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData3 = null;
			}else if(blockSevenData3.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData3.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData4 = null;
			}else if(blockSevenData4.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData4.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData5 = null;
			}else if(blockSevenData5.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData5.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData6 = null;
			}else if(blockSevenData6.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData6.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData7 = null;
			}else if(blockSevenData7.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData7.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData8 = null;
			}else if(blockSevenData8.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData8.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData9 = null;
			}else if(blockSevenData9.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData9.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData10 = null;
			}else if(blockSevenData10.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData10.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData11 = null;
			}else if(blockSevenData11.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData11.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData12 = null;
			}else if(blockSevenData12.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData12.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData13 = null;
			}else if(blockSevenData13.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData13.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData14 = null;
			}else if(blockSevenData14.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData14.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData15 = null;
			}else if(blockSevenData15.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData15.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData16 = null;
			}else if(blockSevenData16.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData16.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData17 = null;
			}else if(blockSevenData17.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData17.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockSevenData18 = null;
			}else if(blockSevenData18.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockSevenData18.getValue();
			}
			mainBlockSevenData[1] = tempDesc;
			mainBlockSevenData[2] = blockSevenDataPrice.getValue();
			

			/*
			 * Block Eight
			 */
			
			mainBlockEightData[0] = blockEightTitle.getValue();
			if(blockEightData1.getValue() != "" && blockEightData1.getValue().length() > 0){
				if(isEmptyOrWhitespace(blockEightData1.getValue())){
					blockEightData1 = null;
				}else if(blockEightData1.getValue().length() > 0){
					tempDesc = blockEightData1.getValue();
					tempBox = blockEightData1.getValue();  
				}
			}else
			{
				tempBox = null;
				tempDesc = "";
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData2 = null;
			}else if(blockEightData2.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData2.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData3 = null;
			}else if(blockEightData3.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData3.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData4 = null;
			}else if(blockEightData4.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData4.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData5 = null;
			}else if(blockEightData5.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData5.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData6 = null;
			}else if(blockEightData6.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData6.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData7 = null;
			}else if(blockEightData7.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData7.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData8 = null;
			}else if(blockEightData8.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData8.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData9 = null;
			}else if(blockEightData9.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData9.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData10 = null;
			}else if(blockEightData10.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData10.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData11 = null;
			}else if(blockEightData11.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData11.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData12 = null;
			}else if(blockEightData12.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData12.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData13 = null;
			}else if(blockEightData13.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData13.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData14 = null;
			}else if(blockEightData14.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData14.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData15 = null;
			}else if(blockEightData15.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData15.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData16 = null;
			}else if(blockEightData16.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData16.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData17 = null;
			}else if(blockEightData17.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData17.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockEightData18 = null;
			}else if(blockEightData18.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockEightData18.getValue();
			}
			mainBlockEightData[1] = tempDesc;
			mainBlockEightData[2] = blockEightDataPrice.getValue();
			

			/*
			 * Block Nine
			 */
			
			mainBlockNineData[0] = blockNineTitle.getValue();
			if(blockNineData1.getValue() != "" && blockNineData1.getValue().length() > 0){
				if(isEmptyOrWhitespace(blockNineData1.getValue())){
					blockNineData1 = null;
				}else if(blockNineData1.getValue().length() > 0){
					tempDesc = blockNineData1.getValue();
					tempBox = blockNineData1.getValue();  
				}
			}else
			{
				tempBox = null;
				tempDesc = "";
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData2 = null;
			}else if(blockNineData2.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData2.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData3 = null;
			}else if(blockNineData3.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData3.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData4 = null;
			}else if(blockNineData4.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData4.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData5 = null;
			}else if(blockNineData5.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData5.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData6 = null;
			}else if(blockNineData6.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData6.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData7 = null;
			}else if(blockNineData7.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData7.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData8 = null;
			}else if(blockNineData8.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData8.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData9 = null;
			}else if(blockNineData9.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData9.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData10 = null;
			}else if(blockNineData10.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData10.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData11 = null;
			}else if(blockNineData11.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData11.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData12 = null;
			}else if(blockNineData12.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData12.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData13 = null;
			}else if(blockNineData13.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData13.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData14 = null;
			}else if(blockNineData14.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData14.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData15 = null;
			}else if(blockNineData15.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData15.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData16 = null;
			}else if(blockNineData16.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData16.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData17 = null;
			}else if(blockNineData17.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData17.getValue();
			}
			if(isEmptyOrWhitespace(tempBox)){
				blockNineData18 = null;
			}else if(blockNineData18.getValue().length() > 0){
				tempDesc  = tempDesc + "^" + blockNineData18.getValue();
			}
			mainBlockNineData[1] = tempDesc;
			mainBlockNineData[2] = blockNineDataPrice.getValue();
			
			serviceMileageDescriptionInventory.setTitle(title);
			
			
			serviceMileageDescriptionInventory.setMainBlockPackageTitleData(mainBlockPackageTitleData);
			serviceMileageDescriptionInventory.setMainBlockOneData(mainBlockOneData);
			serviceMileageDescriptionInventory.setMainBlockTwoData(mainBlockTwoData);
			serviceMileageDescriptionInventory.setMainBlockThreeData(mainBlockThreeData);
			serviceMileageDescriptionInventory.setMainBlockFourData(mainBlockFourData);
			serviceMileageDescriptionInventory.setMainBlockFiveData(mainBlockFiveData);
			serviceMileageDescriptionInventory.setMainBlockSixData(mainBlockSixData);
			serviceMileageDescriptionInventory.setMainBlockSevenData(mainBlockSevenData);
			serviceMileageDescriptionInventory.setMainBlockEightData(mainBlockEightData);
			serviceMileageDescriptionInventory.setMainBlockNineData(mainBlockNineData);
			
			serviceMileageDescriptionInventory.store(serviceMileageDescriptionInventory);
			
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
